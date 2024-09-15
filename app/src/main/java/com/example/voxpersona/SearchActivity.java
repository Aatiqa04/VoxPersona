package com.example.voxpersona;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> bookList; // Assuming you have a Book class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize BookAdapter and set it to RecyclerView
        bookList = new ArrayList<>(); // Initialize your book list here
        bookAdapter = new BookAdapter(bookList);
        recyclerView.setAdapter(bookAdapter);

        // Load books or search results here
        loadBooks();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    return true;
                } else if (item.getItemId() == R.id.navigation_search) {

                    return true;
                } else if (item.getItemId() == R.id.navigation_library) {
                    startActivity(new Intent(SearchActivity.this, LibraryActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.navigation_notifications) {
                    startActivity(new Intent(SearchActivity.this, NotificationsActivity.class));
                    return true;
                } else {
                    return false;
                }


            }
        });
    }

    // Method to load books or search results
    private void loadBooks() {
        // For demo purposes, adding some hardcoded books
        bookList.add(new Book("Book Title 1", "Author 1", R.drawable.book_cover));
        bookList.add(new Book("Book Title 2", "Author 2", R.drawable.book_cover));
        bookList.add(new Book("Book Title 3", "Author 3", R.drawable.book_cover));
        bookAdapter.notifyDataSetChanged(); // Notify adapter of data changes
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu to add search functionality
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // Set up the SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission
                searchBooks(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle search text changes
                searchBooks(newText);
                return true;
            }
        });

        return true;
    }

    private void searchBooks(String query) {
        // Implement search functionality here
        // For demo purposes, just filtering the hardcoded list
        List<Book> filteredList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(book);
            }
        }
        bookAdapter = new BookAdapter(filteredList);
        recyclerView.setAdapter(bookAdapter);
    }
}
