package net.caimito;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {
	private String name ;
	private int beginningCycleNumber ;  // aka day of the year
	private int lengthInCycles ; // aka length in day
	private List<MealCycle> mealCycles = new ArrayList<>() ; // what to eat on every day
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBeginningCycleNumber() {
		return beginningCycleNumber;
	}

	public void setBeginningCycleNumber(int beginningCycleNumber) {
		this.beginningCycleNumber = beginningCycleNumber;
	}

	public int getLengthInCycles() {
		return lengthInCycles;
	}

	public void setLengthInCycles(int cycleLength) {
		this.lengthInCycles = cycleLength;
	}

	public List<MealCycle> getMealCycles() {
		return mealCycles;
	}
	
}
