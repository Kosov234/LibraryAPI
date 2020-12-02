package com.InternshipHomework.LibraryAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookJSON {
    @JsonProperty("items")
    List<Book> Books;
}
