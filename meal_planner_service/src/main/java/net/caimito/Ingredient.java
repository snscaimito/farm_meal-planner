package net.caimito;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Ingredient {

	private String name;
	private int quantity;
	private String unit;
	
	public Ingredient(int quantity, String unit, String name) {
		this.quantity = quantity ;
		this.unit = unit ;
		this.name = name ;
	}
	
	public Ingredient(String name) {
		this.name = name ;
	}
	
	public Ingredient() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj) ;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this) ;
	}

}
