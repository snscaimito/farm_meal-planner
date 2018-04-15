package net.caimito.mealplanner.main;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.collection.IsEmptyCollection.* ;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.* ;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.* ;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebMvcTest(MainPageController.class)
public class MainPageControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private RestTemplate restTemplate ;

	@Test
	public void getFeaturedRecipes() throws Exception {
		when(restTemplate.getForObject("http://recipes:8080/recipes/api/recipes/", Collection.class)).thenThrow(ResourceAccessException.class) ;

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(model().attribute("recipes", is(empty()))) ;
	}
}
