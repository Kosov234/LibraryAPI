package com.internshipHomework.libraryApi.service;

import com.internshipHomework.libraryApi.dao.BookDao;
import com.internshipHomework.libraryApi.model.Author;
import com.internshipHomework.libraryApi.model.Book;
import com.internshipHomework.libraryApi.model.BookJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    public List<Book> getBooksByCategory(String category) throws IOException {
        return  bookDao.getBooksByCategory(category);
    }

    public List<Author> getRating(){
        return bookDao.getRating();
    }
}
