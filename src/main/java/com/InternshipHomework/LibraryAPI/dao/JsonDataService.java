package com.InternshipHomework.LibraryAPI.dao;

import com.InternshipHomework.LibraryAPI.model.Book;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

public class JsonDataService implements BookDao{

    private static List<Book> BooksList;

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

}
