package net.caimito;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngredientsCollector {

	public Collection<Ingredient> collect(List<Ingredient> ingredientList) {
		Map<String, Ingredient> collectedIngredients = new HashMap<>() ;
		
		for (Ingredient ingredient : ingredientList) {
			
			if (collectedIngredients.isEmpty() || !collectedIngredients.containsKey(ingredient.getName())) {
				collectedIngredients.put(ingredient.getName(), ingredient) ;
			} else {
				String ingredientName = ingredient.getName() ;
				String unitName = ingredient.getUnit() ;
				int ingredientQuantity = ingredient.getQuantity() ;

				Ingredient collectedIngredient = collectedIngredients.get(ingredientName) ;
				if (unitName.equals(collectedIngredient.getUnit())) {
					collectedIngredient.setQuantity(collectedIngredient.getQuantity() + ingredientQuantity);
				}
			}
		}
		
		return collectedIngredients.values() ;
	}

}
