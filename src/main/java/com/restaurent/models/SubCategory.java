package com.restaurent.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
//@JsonIgnoreProperties({"category","items"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "category", "items"})

public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subId;

	private String subCatName;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_id")
	@JsonBackReference
	private Categories category;


	@OneToMany(mappedBy = "subCat", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Items> items;



}
