package net.caimito.mealplanner;

import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

public class HRecipeParserTest {

	@Test
	public void parse() throws Exception {
		Resource resource = new ClassPathResource("/net/caimito/mealplanner/frenchFries.html") ;
		Document document = Jsoup.parseBodyFragment(StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset())) ;
		
		Elements hRecipes = document.select("div.hrecipe") ;
		for (Element hRecipe : hRecipes) {
			String recipeName = hRecipe.select("*.fn").first().text() ;
			System.out.println(recipeName);
			
			for (Element ingredient : hRecipe.select("*.ingredient")) {
				System.out.println(parseIngredient(ingredient));
			}
		}
	}

	private String parseIngredient(Element element) {
		Ingredient ingredient = new Ingredient(element.text()) ;

		Element valueElement = element.select("*.value").first() ;
		if (valueElement != null) {
			ingredient.setValue(valueElement.text()) ;
		}
		
		Element typeElement = element.select("*.type").first() ;
		if (typeElement != null) {
			ingredient.setType(typeElement.text()) ;
		}
		
		return ingredient.toString();
	}
	
}
