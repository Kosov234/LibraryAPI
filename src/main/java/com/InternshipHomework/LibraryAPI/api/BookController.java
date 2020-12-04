package com.InternshipHomework.LibraryAPI.api;

import com.InternshipHomework.LibraryAPI.exception.Exception404;
import com.InternshipHomework.LibraryAPI.model.Book;
import com.InternshipHomework.LibraryAPI.model.BookJSON;
import com.InternshipHomework.LibraryAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/Books")
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

    @GetMapping(path = "{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) throws IOException {
        return bookService.getBookByIsbn(isbn)
                .orElseThrow(() -> new Exception404(" "));
    }

    @GetMapping(path = "/category/{category}")
    public ArrayList<Book> getBooksByCategory(@PathVariable String category) throws IOException {
        return bookService.getBooksByCategory(category);

    }
}
