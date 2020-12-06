package com.internshipHomework.libraryApi;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class LibraryApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@SpringBootTest
	@AutoConfigureMockMvc
	public static class LibraryApiApplicationTest {

		String bookInJson = "{\"name\":\"ABC\"}";

		@Autowired
		private MockMvc mockMvc;

		@Test
		public void ShouldReturnSpecificBook() throws Exception {
			MvcResult mvcResult = this.mockMvc.perform(get("/api/Books/9788324677610")).andDo(print()).andExpect(status().isOk())
					.andExpect(jsonPath("$",is(notNullValue())))
					.andExpect(jsonPath("$.title").value("Java. Podstawy. Wydanie IX"))
					.andExpect(jsonPath("$.publisher").value("Helion")).andReturn();

			Assert.assertEquals("application/json",
					mvcResult.getResponse().getContentType());
		}

		@Test
		public void ShouldReturnNotFound() throws Exception {
			MvcResult mvcResult = this.mockMvc.perform(get("/api/Books/978832467"))
					.andDo(print()).andExpect(status().isNotFound()).andReturn();

			Assert.assertEquals(null,
					mvcResult.getResponse().getContentType());
		}

		@Test
		public void ShouldReturnListOfBooks() throws Exception {
			MvcResult mvcResult = this.mockMvc.perform(get("/api/Books/category/Computers")
					.content(bookInJson)
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(jsonPath("$[0].categories", hasItem("Computers")))
					.andReturn();

			Assert.assertEquals("application/json",
					mvcResult.getResponse().getContentType());
		}

		@Test
		public void ShouldReturnRatings() throws Exception {
			MvcResult mvcResult = this.mockMvc.perform(get("/api/Books/rating")
			.content(bookInJson)
			.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
			.andDo(print())
					.andExpect(jsonPath("$",is(notNullValue())))
					.andReturn();

			Assert.assertEquals("application/json",
					mvcResult.getResponse().getContentType());

		}

		@Test void ShouldReturnRatingsWithNeededFields() throws Exception {
			MvcResult mvcResult = this.mockMvc.perform(get("/api/Books/rating")
					.content(bookInJson)
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(jsonPath("$[0].fullName",is(notNullValue())))
					.andExpect(jsonPath("$[0].averageRating",is(notNullValue())))
					.andReturn();

			Assert.assertEquals("application/json",
					mvcResult.getResponse().getContentType());
		}
	}
}
