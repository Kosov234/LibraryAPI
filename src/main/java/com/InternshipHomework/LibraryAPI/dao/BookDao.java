package com.InternshipHomework.LibraryAPI.dao;

import com.InternshipHomework.LibraryAPI.model.Book;
import com.InternshipHomework.LibraryAPI.model.BookJSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public interface BookDao {
    BookJSON getAllBooks() throws IOException;
    Optional<Book> getBookByIsbn(String isbn) throws IOException;
    ArrayList<Book> getBooksByCategory(String category) throws IOException;
}
