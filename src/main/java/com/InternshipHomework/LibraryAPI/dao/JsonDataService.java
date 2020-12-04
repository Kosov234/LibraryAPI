package com.InternshipHomework.LibraryAPI.dao;

import com.InternshipHomework.LibraryAPI.model.Book;

import com.InternshipHomework.LibraryAPI.model.BookJSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Repository("JSON")
public class JsonDataService implements BookDao{

    @Override
    public BookJSON getAllBooks() throws IOException {
        File jsonFile = new File("src/main/resources/static/books.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDefaultPropertyInclusion(
                JsonInclude.Value.construct(JsonInclude.Include.ALWAYS, JsonInclude.Include.NON_NULL));
        BookJSON listOfBooks = objectMapper.readValue(jsonFile,BookJSON.class);

        return listOfBooks;
    }

    @Override
    public Optional<Book> getBookByIsbn(String isbn) throws IOException {
        BookJSON listOfBooks = getAllBooks();
        return listOfBooks.Books.stream()
                .filter(Book -> Book.getIsbn().equals(isbn))
                .findFirst();
    }

    @Override
    public ArrayList<Book> getBooksByCategory(String category) throws IOException {
        BookJSON listOfBooks = getAllBooks();

        ArrayList<Book> returnList = new ArrayList<Book>();

        for(Book book : listOfBooks.Books)
        {
            if(book.getCategories() != null){
                if(Arrays.asList(book.getCategories()).contains(category))
                    returnList.add(book);
            }
        }

        System.out.println(returnList);
        return returnList;
    }


}
