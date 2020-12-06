package com.internshipHomework.libraryApi.dao;

import com.internshipHomework.libraryApi.model.Author;
import com.internshipHomework.libraryApi.model.Book;
import com.internshipHomework.libraryApi.model.BookJSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BookDao {
    BookJSON getAllBooks() throws IOException;
    Optional<Book> getBookByIsbn(String isbn) throws IOException;
    ArrayList<Book> getBooksByCategory(String category) throws IOException;
    List<Author> getRating();
}
