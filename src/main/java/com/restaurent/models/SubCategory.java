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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@JsonIgnoreProperties({"category","items"})
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subId;

	private String subCatName;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_id")
	private Categories category;

	@OneToMany(mappedBy = "subCat", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Items> items;

//	public Integer getSubId() {
//		return subId;
//	}
//
//	public void setSubId(Integer subId) {
//		this.subId = subId;
//	}
//
//	public String getSubCatName() {
//		return subCatName;
//	}
//
//	public void setSubCatName(String subCatName) {
//		this.subCatName = subCatName;
//	}
////
////	public Categories getCategory() {
////		return category;
////	}
////
////	public void setCategory(Categories category) {
////		this.category = category;
////	}
//
//	public SubCategory(Integer subId, String subCatName) {
//		super();
//		this.subId = subId;
//		this.subCatName = subCatName;
//
//	}
//
//	public Categories getCategory() {
//		return category;
//	}
//
//	public void setCategory(Categories category) {
//		this.category = category;
//	}
//
//	public List<Items> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Items> items) {
//		this.items = items;
//	}
//
//	public SubCategory() {
//
//	}

}
