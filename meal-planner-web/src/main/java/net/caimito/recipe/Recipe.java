package net.caimito.recipe;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Recipe {
	private String name = "";
	private String description = "";
	private String yield = "";
	private List<String> ingredients = new ArrayList<>();
	private List<String> instructions = new ArrayList<>();

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getYield() {
		return yield;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}
}
