package com.InternshipHomework.LibraryAPI.api;

import com.InternshipHomework.LibraryAPI.model.Book;
import com.InternshipHomework.LibraryAPI.model.BookJSON;
import com.InternshipHomework.LibraryAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/getBooks")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public BookJSON getAllBooks() throws IOException {
        return bookService.getAllBooks();
    }
}
