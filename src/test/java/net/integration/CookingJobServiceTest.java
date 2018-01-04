package net.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import net.caimito.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class CookingJobServiceTest {
	
	@LocalServerPort
	private int port;

	@Autowired
    private WebApplicationContext context;
	
	@Test
	public void postCookingJob() {
		RestAssuredMockMvc.webAppContextSetup(context);
		
		RestAssuredMockMvc.
		given().
			body("{ \"recipeID\": \"some ID\", \"schedule\": { \"monday\": [ \"breakfast\" ] } }").
			contentType(ContentType.JSON).
		when().
			post("/api/cookingJob").
		then().
			statusCode(200) ;
	}

	@Test
	public void getAllCookingJobs() {
		RestAssuredMockMvc.webAppContextSetup(context);
		
		RestAssuredMockMvc.
		when().
			get("/api/cookingJob").
		then().
			statusCode(200).
			contentType(ContentType.JSON).
			body("[0].recipeID", equalTo("some ID")).
			body("[0].schedule.monday", hasItem("breakfast"));
	}

}
