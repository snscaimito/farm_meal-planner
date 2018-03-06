package net.caimito;

import java.util.ArrayList;
import java.util.List;

public class MealCycle {

	private int cycleNumber ;  // aka day of the year
	private List<MealSlot> mealSlots = new ArrayList<>() ;

	public int getCycleNumber() {
		return cycleNumber;
	}
	public void setCycleNumber(int cycleNumber) {
		this.cycleNumber = cycleNumber;
	}
	public List<MealSlot> getMealSlots() {
		return mealSlots;
	}
	
}
