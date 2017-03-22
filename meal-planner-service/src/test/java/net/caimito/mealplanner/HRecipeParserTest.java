package net.caimito.mealplanner;

import java.nio.charset.Charset;
import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StreamUtils;

public class HRecipeParserTest {

	/*
	 * - find hrecipe
	 * - parse elements of hrecipe
	 */
	
	@Test @Ignore
	public void parse() throws Exception {
		HRecipeParser parser = new HRecipeParser() ;
		
		Resource resource = new ClassPathResource("/net/caimito/mealplanner/frenchFries.html") ;
		Collection<Recipe> recipes = parser.parse(resource) ;
		for (Recipe recipe : recipes) {
			System.out.println(recipe.toString());
		}
	}

	@Test
	public void parseFromUrl() throws Exception {
		HRecipeParser parser = new HRecipeParser() ;
		
		Resource resource = new UrlResource("http://cleverdevil.io/2015/kentucky-maid-cocktail") ;
		Collection<Recipe> recipes = parser.parse(resource) ;
		for (Recipe recipe : recipes) {
			System.out.println(recipe.toString());
		}
	}

}
