package net.caimito.recipe;

import java.util.UUID;

public class RecipeOut extends RecipeIn {
	private String id = "";

	public RecipeOut() {
		this.id = UUID.randomUUID().toString() ;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
}
