package com.example.finder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class StarWarsFinderApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shoulGetResponse() throws Exception
	{
		this.mockMvc.perform(post("/api/starwars/characters")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"searchValue\": \"dar\"\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[\n" +
						"    {\n" +
						"        \"name\": \"Darth Vader\",\n" +
						"        \"height\": \"202\",\n" +
						"        \"mass\": \"136\",\n" +
						"        \"hair_color\": \"none\",\n" +
						"        \"skin_color\": \"white\",\n" +
						"        \"eye_color\": \"yellow\",\n" +
						"        \"birth_year\": \"41.9BBY\",\n" +
						"        \"gender\": \"male\",\n" +
						"        \"homeworld\": \"Tatooine\",\n" +
						"        \"species\": \"Human\"\n" +
						"    },\n" +
						"    {\n" +
						"        \"name\": \"Biggs Darklighter\",\n" +
						"        \"height\": \"183\",\n" +
						"        \"mass\": \"84\",\n" +
						"        \"hair_color\": \"black\",\n" +
						"        \"skin_color\": \"light\",\n" +
						"        \"eye_color\": \"brown\",\n" +
						"        \"birth_year\": \"24BBY\",\n" +
						"        \"gender\": \"male\",\n" +
						"        \"homeworld\": \"Tatooine\",\n" +
						"        \"species\": \"Human\"\n" +
						"    },\n" +
						"    {\n" +
						"        \"name\": \"Darth Maul\",\n" +
						"        \"height\": \"175\",\n" +
						"        \"mass\": \"80\",\n" +
						"        \"hair_color\": \"none\",\n" +
						"        \"skin_color\": \"red\",\n" +
						"        \"eye_color\": \"yellow\",\n" +
						"        \"birth_year\": \"54BBY\",\n" +
						"        \"gender\": \"male\",\n" +
						"        \"homeworld\": \"Dathomir\",\n" +
						"        \"species\": \"Zabrak\"\n" +
						"    }\n" +
						"]"));
	}

}
