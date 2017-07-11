package net.caimito;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.caimito.recipe.Recipe;

@RestController
@RequestMapping("/api/shoppingList")
public class ShoppingListController {
	private Logger logger = LoggerFactory.getLogger(ShoppingListController.class) ;
	
	@Autowired
	private FakeHolder fakeHolder ;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<ShoppingList> getShoppingList() {
		List<Ingredient> items = new ArrayList<>();
		
		String recipeID = fakeHolder.getCookingJob().getRecipeID() ;
		logger.info(recipeID);
		logger.info(fakeHolder.getRecipes().toString());
		Recipe recipe = fakeHolder.getRecipes().get(recipeID) ;
		
		if (recipe != null) {
			logger.info(recipe.toString());
			for (Ingredient ingredient : recipe.getIngredients()) {
				items.add(ingredient);
			}
		} else {
			logger.info("Recipe not found");
			logger.info(fakeHolder.getRecipes().keySet().toString()) ;
		}
		
		ShoppingList list = new ShoppingList() ;
		list.setItems(items); ;
		
		return new ResponseEntity<ShoppingList>(list, HttpStatus.OK) ;
	}

}
