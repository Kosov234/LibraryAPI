package com.InternshipHomework.LibraryAPI.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Book {
    private final String isbn;
    private final String title;
    private final String subtitle;
    private final String publisher;
    private final long publishedDate;
    private final String description;
    private final int pageCount;
    private final String thumbnailUrl;
    private final String language;
    private final String previewLink;
    private final double averageRating;
    private final String[] authors;
    private final String[] categories;

    public Book(String isbn, String title, String subtitle, String publisher,
                long publishedDate, String description, int pageCount,
                String thumbnailUrl, String language, String previewLink,
                double averageRating, String[] authors, String[] categories) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pageCount = pageCount;
        this.thumbnailUrl = thumbnailUrl;
        this.language = language;
        this.previewLink = previewLink;
        this.averageRating = averageRating;
        this.authors = authors;
        this.categories = categories;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public long getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String[] getCategories() {
        return categories;
    }


}
