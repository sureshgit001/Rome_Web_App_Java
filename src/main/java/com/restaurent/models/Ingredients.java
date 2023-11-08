package com.restaurent.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ingredients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ingredientsId;
	@Column
	private String ingredientsName;
	
	

	public Long getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(Long ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public String getIngredientsName() {
		return ingredientsName;
	}

	public void setIngredientsName(String ingredientsName) {
		this.ingredientsName = ingredientsName;
	}

	public Ingredients(Long ingredientsId, String ingredientsName) {
		super();
		this.ingredientsId = ingredientsId;
		this.ingredientsName = ingredientsName;
	}

	public Ingredients() {

	}

	@Override
	public String toString() {
		return "Ingredients [ingredientsId=" + ingredientsId + ", ingredientsName=" + ingredientsName + "]";
	}

}
