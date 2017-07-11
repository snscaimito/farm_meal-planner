package integration;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
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
import net.caimito.ShoppingList;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class ShoppingListControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	
	@Test
	public void getShoppingList() {
		String requestURL = String.format("http://localhost:%d/api/shoppingList", port) ;
		
		ResponseEntity<ShoppingList> entity = testRestTemplate.getForEntity(requestURL, ShoppingList.class) ;
		assertThat(entity.getStatusCode(), is(HttpStatus.OK)) ;
		assertThat(entity.getBody(), is(not(nullValue()))) ;
	}
	
}
