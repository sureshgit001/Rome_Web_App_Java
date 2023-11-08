package com.restaurent.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"subCatList","items"})
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	@Column
	private String categoryName;
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category")
	private List<SubCategory> subCatList;

	@OneToMany(mappedBy = "categoriesItems", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Items> items;

	/*
	 * public String getCategoryDescription() { return categoryDescription; }
	 * 
	 * public void setCategoryDescription(String categoryDescription) {
	 * this.categoryDescription = categoryDescription; }
	 * 
	 * public Integer getCategoryId() { return categoryId; }
	 * 
	 * public void setCategoryId(Integer categoryId) { this.categoryId = categoryId;
	 * }
	 * 
	 * public String getCategoryName() { return categoryName; }
	 * 
	 * public void setCategoryName(String categoryName) { this.categoryName =
	 * categoryName; }
	 * 
	 * public List<Items> getItems() { return items; }
	 * 
	 * public void setItems(List<Items> items) { this.items = items; }
	 * 
	 * @Override public String toString() { return "Categories [items=" + items +
	 * "]"; }
	 * 
	 * public Categories(Integer categoryId, String categoryName, String
	 * categoryDescription) {
	 * 
	 * this.categoryId = categoryId; this.categoryName = categoryName;
	 * this.categoryDescription = categoryDescription; }
	 * 
	 * public Categories() {
	 * 
	 * }
	 */
}