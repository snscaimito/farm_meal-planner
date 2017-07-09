package net.caimito;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

	private List<Ingredient> items = new ArrayList<>();

	public List<Ingredient> getItems() {
		return items;
	}

	public void setItems(List<Ingredient> items) {
		this.items = items;
	}
}
