package com.bakos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GamingstoreApplicationTests {

//	@LocalServerPort
//	private int port;
//
//	private URL base;
//
//	@Autowired
//	private TestRestTemplate template;
//public void setUp()throws Exception{
//	this.base = new URL("http://localhost:" + 8080 + "/greeting");
//}

	@Autowired
	private MockMvc mvc;




	@Test
	public void contextLoads() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));

//		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
//		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	}

}
