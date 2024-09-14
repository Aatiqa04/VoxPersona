package com.example.voxpersona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> books;

    // Constructor
    public BookAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        // Get the book at the current position
        Book book = books.get(position);

        // Bind book data to the view holder
        holder.titleTextView.setText(book.getTitle());
        holder.authorTextView.setText(book.getAuthor());
        // Load image using a library like Glide or Picasso
        // Glide.with(holder.itemView.getContext()).load(book.getCoverImageId()).into(holder.coverImageView);
        holder.coverImageView.setImageResource(book.getCoverImageId());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView authorTextView;
        ImageView coverImageView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize view components
            titleTextView = itemView.findViewById(R.id.book_title);
            authorTextView = itemView.findViewById(R.id.book_author);
            coverImageView = itemView.findViewById(R.id.book_cover);
        }
    }
}
