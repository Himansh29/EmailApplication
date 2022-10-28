package com.email.application.email.application.UserControllerTest;

import com.email.application.email.application.controller.UserController;
import com.email.application.email.application.entity.User;
import com.email.application.email.application.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = UserController.class)
class UserRestControllerMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void testCreateUser () throws  Exception{
		User mockUser = new User();
		mockUser.setUserId(21);
		mockUser.setFirstName("Vick");
		mockUser.setLastname("star");
		mockUser.setEmail("vickstar@gmail.com");
		mockUser.setPhoneNumber(1234567);

		String inputJson = this.mapToJson(mockUser);

		String URL = "/users/";

		Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URL)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(inputJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void testGetUserById() throws Exception{
		User mockUser = new User();
		mockUser.setUserId(21);
		mockUser.setFirstName("Vick");
		mockUser.setLastname("star");
		mockUser.setEmail("vickstar@gmail.com");
		mockUser.setPhoneNumber(1234567);

		Mockito.when(userService.getUser(Mockito.anyInt())).thenReturn(mockUser);

		String URI = "/users/21";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(mockUser);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
