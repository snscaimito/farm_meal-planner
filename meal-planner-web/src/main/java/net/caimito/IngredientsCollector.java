package net.caimito;

import java.util.ArrayList;
import java.util.List;

public class IngredientsCollector {

	private List<Ingredient> collectedIngredients = new ArrayList<>() ;
	
	public List<Ingredient> collect(List<Ingredient> ingredientList) {
		for (Ingredient ingredient : ingredientList) {
			String ingredientName = ingredient.getName() ;
			String unitName = ingredient.getUnit() ;
			int ingredientQuantity = ingredient.getQuantity() ;
			
			if (collectedIngredients.isEmpty()) {
				collectedIngredients.add(ingredient) ;
			} else {
				for (Ingredient collectedIngredient : collectedIngredients) {
					if (ingredientName.equals(collectedIngredient.getName()) && unitName.equals(collectedIngredient.getUnit())) {
						collectedIngredient.setQuantity(collectedIngredient.getQuantity() + ingredientQuantity);
					} else {
						collectedIngredients.add(ingredient) ;
					}
				}
			}
		}
		
		return collectedIngredients ;
	}

}
