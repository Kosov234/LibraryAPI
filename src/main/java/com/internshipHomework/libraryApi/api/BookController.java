package com.internshipHomework.libraryApi.api;

import com.internshipHomework.libraryApi.exception.Exception404;
import com.internshipHomework.libraryApi.model.Author;
import com.internshipHomework.libraryApi.model.Book;
import com.internshipHomework.libraryApi.model.BookJSON;
import com.internshipHomework.libraryApi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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

    public @ResponseBody Book getBookByIsbn(@PathVariable String isbn) throws IOException {
        return bookService.getBookByIsbn(isbn)
                .orElseThrow(() -> new Exception404(" "));
    }

    @GetMapping(path = "/category/{category}")
    public List<Book> getBooksByCategory(@PathVariable String category) throws IOException {
        return bookService.getBooksByCategory(category);
    }

    @GetMapping(path = "/rating")
    public List<Author> getRating(){
        return bookService.getRating();
    }
}
