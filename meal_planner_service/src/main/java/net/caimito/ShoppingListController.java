package net.caimito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoppingList")
public class ShoppingListController {
	private Logger logger = LoggerFactory.getLogger(ShoppingListController.class) ;
	
	@Autowired
	private FakeHolder fakeHolder ;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<ShoppingList> getShoppingList() {
		ShoppingListWorker worker = new ShoppingListWorker(fakeHolder) ;
		ShoppingList shoppingList = new ShoppingList("this week") ;
		shoppingList.getItems().addAll(worker.compileItems(fakeHolder.getMealPlan())) ;
		return new ResponseEntity<ShoppingList>(shoppingList, HttpStatus.OK) ;
	}

}
