package com.InternshipHomework.LibraryAPI.model;

import com.fasterxml.jackson.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    @JsonProperty
    private String isbn;
    @JsonProperty
    private String title;
    @JsonProperty
    private String subtitle;
    @JsonProperty
    private String publisher;

    @JsonProperty
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



    @JsonProperty("volumeInfo")
    public void getNearestFields(Map<String,Object> volumeInfo) throws ParseException {




        Map<String,Object> imageLinks = (Map<String, Object>) volumeInfo.get("imageLinks");
        this.thumbnailUrl = (String)imageLinks.get("thumbnail");


//        if(volumeInfo.containsKey("industryIdentifiers")){
//            ArrayList<String> industryIdentifiers = (ArrayList<String>) volumeInfo.get("industryIdentifiers");
//            industryIdentifiers.get(0);
//        }


        this.title = (String)volumeInfo.get("title");
        this.subtitle = (String)volumeInfo.get("subtitle");
        this.publisher = (String)volumeInfo.get("publisher");

        if(volumeInfo.containsKey("publishedDate")) {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendValue(ChronoField.YEAR,4)
                    .optionalStart()
                    .appendPattern("-MM[-dd]")
                    .optionalEnd()
                    .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                    .parseDefaulting(ChronoField.DAY_OF_MONTH,1)
                    .toFormatter();

            String buffer = formatter.parse((String)volumeInfo.get("publishedDate"), LocalDate::from).toString();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(buffer);

            this.publishedDate =(long) date.getTime()/1000 ;
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
