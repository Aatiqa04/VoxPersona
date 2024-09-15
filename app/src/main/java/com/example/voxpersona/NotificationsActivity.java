package com.example.voxpersona;

import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;
import java.util.List;


public class NotificationsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notificationList; // Assuming you have a Notification class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view_notifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize NotificationAdapter and set it to RecyclerView
        notificationList = new ArrayList<>(); // Initialize your notification list here
        notificationAdapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(notificationAdapter);

        // Load notifications
        loadNotifications();

        // Set up Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    // Go to Home Activity
                    startActivity(new Intent(NotificationsActivity.this, HomeActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_search) {
                    // Go to Search Activity
                    startActivity(new Intent(NotificationsActivity.this, SearchActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_library) {
                    // Go to Library Activity
                    startActivity(new Intent(NotificationsActivity.this, LibraryActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_notifications) {
                    // Already on Notifications
                    return true;
                }
                return false;

            }
        });
    }

    // Method to load notifications into the RecyclerView
    private void loadNotifications() {
        // Example hardcoded notifications
        notificationList.add(new Notification("New book available: 'The Great Gatsby'"));
        notificationList.add(new Notification("Reminder: Your audiobook '1984' is about to expire"));
        notificationList.add(new Notification("Special offer: 20% off on all audiobooks this weekend"));
        // Add more notifications here

        notificationAdapter.notifyDataSetChanged(); // Notify adapter of data changes
    }
}
