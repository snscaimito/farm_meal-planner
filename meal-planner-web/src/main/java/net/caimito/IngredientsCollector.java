package net.caimito;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IngredientsCollector {

	public List<Ingredient> collect(List<Ingredient> ingredientList) {
		List<Ingredient> collectedIngredients = new ArrayList<>() ;
		
		for (Ingredient ingredient : ingredientList) {
			
			if (collectedIngredients.isEmpty()) {
				collectedIngredients.add(ingredient) ;
			} else {
				String ingredientName = ingredient.getName() ;
				String unitName = ingredient.getUnit() ;
				int ingredientQuantity = ingredient.getQuantity() ;

				for (Ingredient collectedIngredient : collectedIngredients) {
					if (ingredientName.equals(collectedIngredient.getName()) && unitName.equals(collectedIngredient.getUnit())) {
						collectedIngredient.setQuantity(collectedIngredient.getQuantity() + ingredientQuantity);
					}
				}
			}
		}
		
		return collectedIngredients ;
	}

}
