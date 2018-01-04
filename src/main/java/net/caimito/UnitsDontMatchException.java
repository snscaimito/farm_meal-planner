package net.caimito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnitsDontMatchException extends RuntimeException {
	private Logger logger = LoggerFactory.getLogger(UnitsDontMatchException.class) ;

	private static final long serialVersionUID = 741489938120751527L;

	public UnitsDontMatchException(Ingredient collectedIngredient, Ingredient ingredient) {
		logger.error(String.format("Mismatching units when trying to collect ingredients. Collected ingredient = %s, ingredient = %s", collectedIngredient, ingredient));
	}

}
