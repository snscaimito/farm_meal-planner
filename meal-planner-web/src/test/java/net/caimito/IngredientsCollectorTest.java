package net.caimito;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IngredientsCollectorTest {
	
	@Test
	public void collectIngredients() {
		List<Ingredient> ingredientList = new ArrayList<>() ;
		ingredientList.add(new Ingredient(1, "pcs", "Egg")) ;
		ingredientList.add(new Ingredient(1, "pcs", "Egg")) ;
		
		IngredientsCollector collector = new IngredientsCollector() ;
		assertThat(collector.collect(ingredientList), hasItem(new Ingredient(2, "pcs", "Egg"))) ;
	}

}
