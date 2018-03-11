package net.caimito.mealplanner.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Recipe {

	private UUID id = UUID.randomUUID() ;
	private String name ;
	private String description ;
	private String yield ;
	private List<Ingredient> ingredients = new ArrayList<>() ;
	private String instructions ;
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
