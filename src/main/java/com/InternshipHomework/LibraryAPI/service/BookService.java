package com.InternshipHomework.LibraryAPI.service;

import com.InternshipHomework.LibraryAPI.dao.BookDao;
import com.InternshipHomework.LibraryAPI.model.Book;
import com.InternshipHomework.LibraryAPI.model.BookJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("JSON") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookJSON getAllBooks() throws IOException {
        return bookDao.getAllBooks();
    }

    public Optional<Book> getBookByIsbn(String isbn) throws IOException {
        return bookDao.getBookByIsbn(isbn);
    }

    public ArrayList<Book> getBooksByCategory(String category) throws IOException {
        return  bookDao.getBooksByCategory(category);
    }
}
