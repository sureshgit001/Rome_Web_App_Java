package com.restaurent.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Restaurent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurentId;
	private String restaurentName;

	public Integer getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(Integer restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getRestaurentName() {
		return restaurentName;
	}

	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}

	public Restaurent(Integer restaurentId, String restaurentName) {
		super();
		this.restaurentId = restaurentId;
		this.restaurentName = restaurentName;
	}

	@Override
	public String toString() {
		return "Restaurent [restaurentId=" + restaurentId + ", restaurentName=" + restaurentName + "]";
	}
}
