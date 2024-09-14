package com.example.voxpersona;

public class Book {
    private String title;
    private String author;
    private int coverImageId;

    // Constructor
    public Book(String title, String author, int coverImageId) {
        this.title = title;
        this.author = author;
        this.coverImageId = coverImageId;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for cover image resource ID
    public int getCoverImageId() {
        return coverImageId;
    }
}
