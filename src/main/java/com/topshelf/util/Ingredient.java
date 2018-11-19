package com.topshelf.util;

public class Ingredient {
	private String quantity;
	private String unit;
	private String ingredientName;
	public Ingredient() {
		super();
	}
	public Ingredient(String quantity, String unit, String ingredientName) {
		super();
		this.quantity = quantity;
		this.unit = unit;
		this.ingredientName = ingredientName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (ingredientName == null) {
			if (other.ingredientName != null)
				return false;
		} else if (!ingredientName.equals(other.ingredientName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ingredient [quantity=" + quantity + ", unit=" + unit + ", ingredientName=" + ingredientName + "]";
	}
	
	
	
}
