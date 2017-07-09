package net.caimito;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoppingList")
public class ShoppingListController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<ShoppingList> getShoppingList() {
		Ingredient ingredient = new Ingredient() ;
		ingredient.setName("Flour");
		ingredient.setUnit("gram");
		ingredient.setQuantity("400");
		
		List<Ingredient> items = new ArrayList<>();
		items.add(ingredient);
		ShoppingList list = new ShoppingList() ;
		list.setItems(items); ;
		
		return new ResponseEntity<ShoppingList>(list, HttpStatus.OK) ;
	}
}
