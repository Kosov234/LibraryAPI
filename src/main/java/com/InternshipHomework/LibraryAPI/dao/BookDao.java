package com.InternshipHomework.LibraryAPI.dao;

import com.InternshipHomework.LibraryAPI.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
}
