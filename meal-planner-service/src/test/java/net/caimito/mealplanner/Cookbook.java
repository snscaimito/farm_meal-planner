package net.caimito.mealplanner;

public class Cookbook {

	public static final String FRENCH_FRIES = "French Fries";

	public static Recipe getRecipe(String recipeName) {
		if (FRENCH_FRIES.equals(recipeName)) {
			Recipe recipe = new Recipe(FRENCH_FRIES) ;
			recipe.addIngredient(new Ingredient("Potatoes")) ;
			recipe.addIngredient(new Ingredient("Vegetable Oil")) ;
			
			return recipe ;
		}
		
		return null;
	}


}
