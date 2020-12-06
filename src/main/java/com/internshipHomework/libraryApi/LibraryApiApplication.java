package com.internshipHomework.libraryApi;

import com.internshipHomework.libraryApi.dao.JsonDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApiApplication {

	public static void main(String[] args) {
		if(args.length > 0) {
			JsonDataService.setResource(JsonDataService.resourceLoader.getResource("classpath:"+args[0]));
		}
		SpringApplication.run(LibraryApiApplication.class, args);


	}

}
