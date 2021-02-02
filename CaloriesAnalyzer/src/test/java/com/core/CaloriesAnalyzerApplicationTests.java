package com.core;

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
class CaloriesAnalyzerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldGetOneResponse() throws Exception
	{
		this.mockMvc.perform(post("/api/food")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"name\": \"Tarta de acelga\",\n" +
						"    \"ingredients\": [\n" +
						"        {\n" +
						"            \"name\": \"Acelgas\",\n" +
						"            \"weight\": 500\n" +
						"        },\n" +
						"        {\n" +
						"            \"name\": \"Queso crema\",\n" +
						"            \"weight\": 50\n" +
						"        },\n" +
						"         {\n" +
						"            \"name\": \"Cebolla\",\n" +
						"            \"weight\": 100\n" +
						"        },\n" +
						"         {\n" +
						"            \"name\": \"Huevo duro\",\n" +
						"            \"weight\": 100\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"name\": \"Tarta de acelga\",\n" +
						"    \"totalCalories\": 481.5,\n" +
						"    \"ingredients\": [\n" +
						"        {\n" +
						"            \"name\": \"Acelgas\",\n" +
						"            \"calories\": 165.0\n" +
						"        },\n" +
						"        {\n" +
						"            \"name\": \"Queso crema\",\n" +
						"            \"calories\": 122.5\n" +
						"        },\n" +
						"        {\n" +
						"            \"name\": \"Cebolla\",\n" +
						"            \"calories\": 47.0\n" +
						"        },\n" +
						"        {\n" +
						"            \"name\": \"Huevo duro\",\n" +
						"            \"calories\": 147.0\n" +
						"        }\n" +
						"    ],\n" +
						"    \"moreCaloricIngredient\": {\n" +
						"        \"name\": \"Queso crema\",\n" +
						"        \"calories\": 245.0\n" +
						"    }\n" +
						"}"));
	}


	@Test
	void shouldGetSeveralResponse() throws Exception
	{
		this.mockMvc.perform(post("/api/foods")
				.contentType(MediaType.APPLICATION_JSON)
				.content("[\n" +
						"    {\n" +
						"        \"name\": \"Tarta de acelga\",\n" +
						"        \"ingredients\": [\n" +
						"            {\n" +
						"                \"name\": \"Acelgas\",\n" +
						"                \"weight\": 500\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Queso crema\",\n" +
						"                \"weight\": 50\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Cebolla\",\n" +
						"                \"weight\": 100\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Huevo duro\",\n" +
						"                \"weight\": 100\n" +
						"            }\n" +
						"        ]\n" +
						"    },\n" +
						"        {\n" +
						"        \"name\": \"Desayuno\",\n" +
						"        \"ingredients\": [\n" +
						"            {\n" +
						"                \"name\": \"Bacon (Panceta ahumada)\",\n" +
						"                \"weight\": 100\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Yogur desnatado con frutas\",\n" +
						"                \"weight\": 100\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Galletas saladas\",\n" +
						"                \"weight\": 150\n" +
						"            }\n" +
						"        ]\n" +
						"    }\n" +
						"]"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("[\n" +
						"    {\n" +
						"        \"name\": \"Tarta de acelga\",\n" +
						"        \"totalCalories\": 481.5,\n" +
						"        \"ingredients\": [\n" +
						"            {\n" +
						"                \"name\": \"Acelgas\",\n" +
						"                \"calories\": 165.0\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Queso crema\",\n" +
						"                \"calories\": 122.5\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Cebolla\",\n" +
						"                \"calories\": 47.0\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Huevo duro\",\n" +
						"                \"calories\": 147.0\n" +
						"            }\n" +
						"        ],\n" +
						"        \"moreCaloricIngredient\": {\n" +
						"            \"name\": \"Queso crema\",\n" +
						"            \"calories\": 245.0\n" +
						"        }\n" +
						"    },\n" +
						"    {\n" +
						"        \"name\": \"Desayuno\",\n" +
						"        \"totalCalories\": 1443.0,\n" +
						"        \"ingredients\": [\n" +
						"            {\n" +
						"                \"name\": \"Bacon (Panceta ahumada)\",\n" +
						"                \"calories\": 665.0\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Yogur desnatado con frutas\",\n" +
						"                \"calories\": 82.0\n" +
						"            },\n" +
						"            {\n" +
						"                \"name\": \"Galletas saladas\",\n" +
						"                \"calories\": 696.0\n" +
						"            }\n" +
						"        ],\n" +
						"        \"moreCaloricIngredient\": {\n" +
						"            \"name\": \"Bacon (Panceta ahumada)\",\n" +
						"            \"calories\": 665.0\n" +
						"        }\n" +
						"    }\n" +
						"]"));
	}

}
