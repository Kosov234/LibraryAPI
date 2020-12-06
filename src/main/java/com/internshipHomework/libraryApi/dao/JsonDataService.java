package com.internshipHomework.libraryApi.dao;

import com.internshipHomework.libraryApi.model.Author;
import com.internshipHomework.libraryApi.model.Book;

import com.internshipHomework.libraryApi.model.BookJSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

@Repository("JSON")
public class JsonDataService implements BookDao{

    BookJSON listOfBooks;

    public static final ResourceLoader resourceLoader = new DefaultResourceLoader();
    private static Resource resource;

    public static void setResource(Resource resource) {
        JsonDataService.resource = resource;
    }

    public JsonDataService(){
        try{
            this.listOfBooks = getAllBooks();
        }
        catch (IOException ex) {System.out.println("File Not Found!");}
    }

    @Override
    public BookJSON getAllBooks() throws IOException {
        if(resource == null) {
            resource = resourceLoader.getResource("classpath:books.json");
        }
        Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8);
        var test = FileCopyUtils.copyToString(reader);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDefaultPropertyInclusion(
                JsonInclude.Value.construct(JsonInclude.Include.ALWAYS, JsonInclude.Include.NON_NULL));

        return objectMapper.readValue(test,BookJSON.class);
    }

    @Override
    @ResponseBody
    public Optional<Book> getBookByIsbn(String isbn){
        return listOfBooks.Books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }

    @Override
    public ArrayList<Book> getBooksByCategory(String category) {

        ArrayList<Book> returnList = new ArrayList<>();

        for(Book book : listOfBooks.Books)
        {
            if(book.getCategories() != null && Arrays.asList(book.getCategories()).contains(category)){
                    returnList.add(book);
            }
        }

        return returnList;
    }

    @Override
    public List<Author> getRating(){
        Map<String,Author> buffer = new HashMap<>();

        for(Book book : listOfBooks.Books){
            if(book.getAverageRating() != null && book.getAuthors() != null) {
                for(String author : book.getAuthors()){
                    if (buffer.containsKey(author)) {
                        buffer.get(author).addRating(book.getAverageRating());
                        buffer.get(author).calculateAverageRating();
                    } else {
                        buffer.put(author, new Author(author, book.getAverageRating()));
                    }
                }
            }
        }
        List<Author> returnList = buffer.values().stream().sorted(Comparator.comparingDouble(value -> value.getAverageRating())).collect(Collectors.toList());
        Collections.reverse(returnList);

        return returnList;
    }

}
