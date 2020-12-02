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
}
