package com.example.voxpersona;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> bookList; // Assuming you have a Book class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liabrary);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view_library);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize BookAdapter and set it to RecyclerView
        bookList = new ArrayList<>(); // Initialize your book list here
        bookAdapter = new BookAdapter(bookList);
        recyclerView.setAdapter(bookAdapter);

        // Load books for the library
        loadBooks();

        // Set up Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    // Go to Home Activity
                    startActivity(new Intent(LibraryActivity.this, HomeActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_search) {
                    // Go to Search Activity
                    startActivity(new Intent(LibraryActivity.this, SearchActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_library) {
                    // Already on Library
                    return true;
                } else if (item.getItemId() == R.id.navigation_notifications) {
                    // Go to Notifications Activity
                    startActivity(new Intent(LibraryActivity.this, NotificationsActivity.class));
                    return true;
                }
                return false;

            }
        });
    }

    // Method to load books into the RecyclerView
    private void loadBooks() {
        // Example hardcoded books
        bookList.add(new Book("The Catcher in the Rye", "J.D. Salinger", R.drawable.catcher_in_the_rye_cover));
        bookList.add(new Book("Brave New World", "Aldous Huxley", R.drawable.brave_new_world_cover));
        bookList.add(new Book("Fahrenheit 451", "Ray Bradbury", R.drawable.fahrenheit_451_cover));
        // Add more books here

        bookAdapter.notifyDataSetChanged(); // Notify adapter of data changes
    }
}
