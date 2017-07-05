package fr.hackathon.server.ws.web.controller;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.hackathon.server.ws.config.WebMvcConfig;
import fr.hackathon.server.ws.dao.HelloWorldDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { fr.hackathon.server.ws.config.ContextConfiguration.class, WebMvcConfig.class })
@WebAppConfiguration
public class HelloWorldControllerTest {

	@Resource
	private WebApplicationContext wac;

	@Resource
	private HelloWorldDAO dao;

	private MockMvc mockMvc;

	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void checkGetHelloWorldByIdUrl() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/helloWorld/1")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void checkGetHelloWorldsUrl() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/helloWorlds")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void getHelloWorlds() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/helloWorlds")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
	}
	
}