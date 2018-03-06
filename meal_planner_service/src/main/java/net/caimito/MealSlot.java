package net.caimito;

import java.util.ArrayList;
import java.util.List;

import net.caimito.recipe.RecipeOut;

public class MealSlot {

	private String slotName ;
	private List<RecipeOut> recipes = new ArrayList<>() ;
	
	public List<RecipeOut> getRecipes() {
		return recipes;
	}
	
	public String getSlotName() {
		return slotName;
	}
	
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
}
