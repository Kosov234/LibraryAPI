package com.InternshipHomework.LibraryAPI.model;

import com.InternshipHomework.LibraryAPI.util.DateUtil;
import com.fasterxml.jackson.annotation.*;


import java.text.ParseException;

import java.util.ArrayList;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    @JsonProperty
    @JsonAlias({"id"})
    private String isbn;
    @JsonProperty
    private String title;
    @JsonProperty
    private String subtitle;
    @JsonProperty
    private String publisher;

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long publishedDate;
    @JsonProperty
    private String description;
    @JsonProperty
    private Integer pageCount;
    @JsonProperty
    private String thumbnailUrl;
    @JsonProperty
    private String language;
    @JsonProperty
    private String previewLink;
    @JsonProperty
    private Double averageRating;
    @JsonProperty
    private String[] authors;
    @JsonProperty
    private String[] categories;

    public String[] getCategories() {
        return categories;
    }

    public String getIsbn() {
        return isbn;
    }

    @JsonProperty("volumeInfo")
    public void getNearestFields(Map<String,Object> volumeInfo) throws ParseException {
        Map<String,Object> imageLinks = (Map<String, Object>) volumeInfo.get("imageLinks");
        this.thumbnailUrl = (String)imageLinks.get("thumbnail");

        if(volumeInfo.containsKey("industryIdentifiers")){
            ArrayList<Map<String, String>> industryIdentifiers = (ArrayList<Map<String, String>>) volumeInfo.get("industryIdentifiers");

            for(Map<String,String> map : industryIdentifiers)
            {
                if(map.containsValue("ISBN_13"))
                    this.isbn = map.get("identifier");
            }
        }

        this.title = (String)volumeInfo.get("title");
        this.subtitle = (String)volumeInfo.get("subtitle");
        this.publisher = (String)volumeInfo.get("publisher");

        if(volumeInfo.containsKey("publishedDate")) {

                DateUtil dateUtil = new DateUtil();
                this.publishedDate = dateUtil.transformDateStringToUnixLong(volumeInfo);
        }

        this.description = (String)volumeInfo.get("description");
        this.pageCount = (Integer) volumeInfo.get("pageCount");
        this.language = (String)volumeInfo.get("language");
        this.previewLink = (String)volumeInfo.get("previewLink");
        this.averageRating =(Double)volumeInfo.get("averageRating");

        if(volumeInfo.containsKey("authors")) {
            ArrayList<String> buffer = (ArrayList<String>) volumeInfo.get("authors");
            this.authors = new String[buffer.size()];
            for (int i = 0; i < buffer.size(); i++) {
                this.authors[i] = buffer.get(i);
            }
        }

        if(volumeInfo.containsKey("categories")) {
            ArrayList<String> buffer = (ArrayList<String>) volumeInfo.get("categories");
            this.categories = new String[buffer.size()];
            for (int i = 0; i < buffer.size(); i++) {
                this.categories[i] = buffer.get(i);
            }
        }
    }






}
