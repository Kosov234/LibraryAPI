package com.internshipHomework.libraryApi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookJSON {
    @JsonProperty("items")
    public List<Book> Books = new ArrayList<>();
}
