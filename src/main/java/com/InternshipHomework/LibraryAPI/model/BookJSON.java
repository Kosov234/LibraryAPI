package com.InternshipHomework.LibraryAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookJSON {
    @JsonProperty("items")
    public ArrayList<Book> Books = new ArrayList<Book>();
}
