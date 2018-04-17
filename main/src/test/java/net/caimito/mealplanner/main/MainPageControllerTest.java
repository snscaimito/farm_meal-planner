package net.caimito.mealplanner.main;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import net.caimito.mealplanner.recipes.Recipe;

@RunWith(SpringRunner.class)
@WebMvcTest(MainPageController.class)
public class MainPageControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private RestTemplate restTemplate ;

	@Test
	public void featuredRecipesConnectionTrouble() throws Exception {
		when(restTemplate.getForObject("http://recipes:8080/recipes/api/recipes/", Collection.class)).thenThrow(ResourceAccessException.class) ;

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(model().attribute("recipes", is(empty()))) ;
	}

	@Test
	public void featuredRecipes() throws Exception {
		when(restTemplate.getForObject("http://recipes:8080/recipes/api/recipes/", Collection.class)).thenReturn(new ArrayList<Recipe>()) ;

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(model().attribute("recipes", is(empty()))) ;
	}
}
