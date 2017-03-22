package net.caimito.mealplanner;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

public class HRecipeParser {
	private static final Logger logger = LoggerFactory.getLogger(HRecipeParser.class) ;

	public Collection<Recipe> parse(Resource resource) {
		Collection<Recipe> recipes = new ArrayList<Recipe>() ;
		
		try {
		Document document = Jsoup.parseBodyFragment(StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset())) ;
		
		Elements hRecipes = document.select("div.hrecipe") ;
		
		for (Element hRecipe : hRecipes) {
			String recipeName = hRecipe.select("*.fn").first().text() ;
			Recipe recipe = new Recipe(recipeName) ;
			
			for (Element ingredientElement : hRecipe.select("*.ingredient")) {
				Ingredient ingredient = parseIngredient(ingredientElement);
				recipe.addIngredient(ingredient);
			}
			
			for (Element instructionsElement : hRecipe.select("*.instructions")) {
				for (Element singleInstructionElement : instructionsElement.children()) {
					recipe.addInstruction(singleInstructionElement.text()) ;
				}
			}
			
			recipe.setYield(hRecipe.select("*.yield").text()) ;
			recipe.setDuration(hRecipe.select("*.duration").text()) ;
			
			recipes.add(recipe) ;
		}
		} catch (IOException e) {
			logger.error(String.format("Cannot parse document at", resource.toString()), e) ;
		}
		
		return recipes ;
	}

	private Ingredient parseIngredient(Element element) {
		Ingredient ingredient = new Ingredient(element.text()) ;

		Element valueElement = element.select("*.value").first() ;
		if (valueElement != null) {
			ingredient.setValue(valueElement.text()) ;
		}
		
		Element typeElement = element.select("*.type").first() ;
		if (typeElement != null) {
			ingredient.setType(typeElement.text()) ;
		}
		
		return ingredient;
	}

}
