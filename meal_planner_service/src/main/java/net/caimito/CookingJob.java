package net.caimito;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CookingJob {
	private String recipeID;
	private Map<String, List<String>> schedule ;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}
	
	public void setRecipeID(String recipeID) {
		this.recipeID = recipeID;
	}
	
	public String getRecipeID() {
		return recipeID;
	}
	
	public Map<String, List<String>> getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Map<String, List<String>> schedule) {
		this.schedule = schedule;
	}
}
