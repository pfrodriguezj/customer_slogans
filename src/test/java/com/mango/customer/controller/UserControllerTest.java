package com.mango.customer.controller;

import com.mango.customer.config.ContextConfigurationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(ContextConfigurationTest.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;


	@Test
	public void postUserTest() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders
				.post("/v1/user")
				.content("{\"name\":\"Felipe\",\n" +
					"    \"lastName\":\"Ximenez\",\n" +
					"    \"address\":\"Dante\",\n" +
					"    \"city\":\"Barcelona\",\n" +
					"    \"email\":\"pfrodriguezj@gmail.com\"}")
				.accept(MediaType.APPLICATION_JSON.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void putUserTest() throws Exception
	{
		postUserTest();

		mvc.perform(MockMvcRequestBuilders
				.put("/v1/user")
				.content("{\"name\":\"Felipe\",\n" +
					"    \"lastName\":\"Ximenez\",\n" +
					"    \"address\":\"Dante\",\n" +
					"    \"city\":\"Barcelona\",\n" +
					"    \"email\":\"pfrodriguezj@gmail.com\"}")
				.accept(MediaType.APPLICATION_JSON.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk());
	}

}
