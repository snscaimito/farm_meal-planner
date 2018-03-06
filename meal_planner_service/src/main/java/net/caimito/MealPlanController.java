package net.caimito;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.caimito.recipe.RecipeOut;

@RestController
@RequestMapping("/api/mealPlan")
public class MealPlanController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<MealPlan> getMealPlan() {
		MealPlan mealPlan = new MealPlan() ;
		
		mealPlan.setName("First week of January");
		mealPlan.setBeginningCycleNumber(8);
		mealPlan.setLengthInCycles(7);
		
		RecipeOut recipe = new RecipeOut() ;
		recipe.setDescription("Pancake base recipe");
		recipe.setName("Pancakes");
		recipe.setYield("4 people");
		
		recipe.getIngredients().add(new Ingredient(3, "pcs", "Eggs")) ;
		recipe.getIngredients().add(new Ingredient(400, "gram", "Flour")) ;
		recipe.getIngredients().add(new Ingredient(700, "ml", "Milk")) ;
		
		recipe.getInstructions().add("Mix all together") ;
		
		MealSlot mealSlot = new MealSlot() ;
		mealSlot.setSlotName("breakfast");
		mealSlot.getRecipes().add(recipe) ;
		
		MealCycle mealCycle = new MealCycle() ;
		mealCycle.setCycleNumber(8);
		mealCycle.getMealSlots().add(mealSlot) ;
		mealPlan.getMealCycles().add(mealCycle) ;
		
		return new ResponseEntity<>(mealPlan, HttpStatus.OK) ;
	}

	@RequestMapping(method=RequestMethod.POST)
	public void postMealPlan(@RequestBody MealPlan mealPlanPosted) {
		
	}

}
