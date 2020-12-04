package com.InternshipHomework.LibraryAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book not found")
public class Exception404 extends RuntimeException{
    public Exception404(String message){
        super(message);
    }
}
