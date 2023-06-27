package com.mango.customer.controller;

import com.mango.customer.config.ContextConfigurationTest;
import com.mango.customer.dto.SloganDto;
import com.mango.customer.model.Slogan;
import com.mango.customer.service.SloganService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SloganController.class)
@Import(ContextConfigurationTest.class)
public class SloganControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private SloganService sloganService;

	@Test
	public void postSloganTest() throws Exception
	{
		Slogan slogan = new Slogan();
		slogan.setSlogan("slogan");
		slogan.setEmail("email");
		when(sloganService.save(any(SloganDto.class))).thenReturn(slogan);

		mvc.perform(MockMvcRequestBuilders
				.post("/v1/slogan")
				.content("{" +
					"	\"email\":\"pfrodriguezj@gmail.com\",\n" +
					"    \"slogan\":\"mi slogan8\"" +
					"}")
				.accept(MediaType.APPLICATION_JSON.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk());
	}


}
