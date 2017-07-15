package net.integration;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import net.caimito.Application;
import net.caimito.CookingJob;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class MealPlanningControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;


//	{"recipeID":"ede2a6eb-c707-498e-ac17-f10aa2bc82b9","recipeName":"Egg-Asparagus",
//	"monday":["breakfast"],"tuesday":[],"wednesday":[],"thursday":[],"friday":[],"saturday":[],"sunday":[]}

	@Test
	public void assignRecipeToMealEvent() {
		String requestURL = String.format("http://localhost:%d/api/cookingJob", port) ;

		CookingJob cookingJob = new CookingJob() ;
		cookingJob.setRecipeID("ede2a6eb-c707-498e-ac17-f10aa2bc82b9") ;
		cookingJob.setMonday(new String[]{"breakfast"}) ;
		
		ResponseEntity<CookingJob> entity = testRestTemplate.postForEntity(requestURL, cookingJob, CookingJob.class) ;
		assertThat(entity.getStatusCode(), is(HttpStatus.OK)) ;
	}
	
}
