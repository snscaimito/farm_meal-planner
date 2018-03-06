package net.caimito;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

	private String shoppingForWeek = "" ;
	private List<String> items = new ArrayList<>() ;
	
	public ShoppingList() {
	}
	
	public ShoppingList(String shoppingForWeek) {
		this.shoppingForWeek = shoppingForWeek ;
	}
	
	public List<String> getItems() {
		return items;
	}
	
	public String getShoppingForWeek() {
		return shoppingForWeek;
	}
}
