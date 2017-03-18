package net.caimito.mealplanner;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Recipe {

	private Collection<Ingredient> ingredients = new ArrayList<Ingredient>() ;
	
	public Recipe(String recipeName) {
	}

	public Collection<Ingredient> getIngredients() {
		return ingredients ;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient) ;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj) ;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this) ;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}

}
