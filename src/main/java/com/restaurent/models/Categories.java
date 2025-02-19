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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"subCatList","items"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "subCatList", "items"})

public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	@Column
	private String categoryName;
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<SubCategory> subCatList;

	@OneToMany(mappedBy = "categoriesItems", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Items> items;

	
}