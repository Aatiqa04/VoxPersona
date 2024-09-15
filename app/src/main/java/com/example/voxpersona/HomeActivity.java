package com.example.voxpersona;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvPopularBooks, rvListeningHistory, rvRecommendations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvPopularBooks = findViewById(R.id.rv_popular_books);
        rvListeningHistory = findViewById(R.id.rv_listening_history);
        rvRecommendations = findViewById(R.id.rv_recommendations);

        rvPopularBooks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvPopularBooks.setAdapter(new BookAdapter(getPopularBooks()));

        rvListeningHistory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvListeningHistory.setAdapter(new BookAdapter(getListeningHistory()));

        rvRecommendations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvRecommendations.setAdapter(new BookAdapter(getRecommendations()));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    return true;
                } else if (item.getItemId() == R.id.navigation_search) {
                    startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_library) {
                    startActivity(new Intent(HomeActivity.this, LibraryActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_notifications) {
                    startActivity(new Intent(HomeActivity.this, NotificationsActivity.class));
                    return true;
                } else {
                    return false;
                }


            }
        });
    }

    private List<Book> getPopularBooks() {
        List<Book> popularBooks = new ArrayList<>();
        // Example hardcoded books
        popularBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", R.drawable.great_gatsby_cover));
        popularBooks.add(new Book("1984", "George Orwell", R.drawable.nineteen_eighty_four_cover));
        popularBooks.add(new Book("To Kill a Mockingbird", "Harper Lee", R.drawable.to_kill_a_mockingbird_cover));
        return popularBooks;
    }

    private List<Book> getListeningHistory() {
        List<Book> listeningHistory = new ArrayList<>();
        // Example hardcoded books
        listeningHistory.add(new Book("The Catcher in the Rye", "J.D. Salinger", R.drawable.catcher_in_the_rye_cover));
        listeningHistory.add(new Book("Brave New World", "Aldous Huxley", R.drawable.brave_new_world_cover));
        return listeningHistory;
    }

    private List<Book> getRecommendations() {
        List<Book> recommendations = new ArrayList<>();
        // Example hardcoded recommendations
        recommendations.add(new Book("Moby Dick", "Herman Melville", R.drawable.moby_dick_cover));
        recommendations.add(new Book("Pride and Prejudice", "Jane Austen", R.drawable.pride_and_prejudice_cover));
        recommendations.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", R.drawable.lord_of_the_rings_cover));
        return recommendations;
    }
}
