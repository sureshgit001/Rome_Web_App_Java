package com.restaurent.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@JsonIgnoreProperties({ "orders", "subCat", "categoriesItems" })
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String itemName;
	private String itemDescription;
	private Integer itemPrice;
	private Boolean isActive;
	private Boolean isAvailable;
	private String itemUrl;

	@ManyToOne()
	@JoinColumn(name = "categoryId")
	private Categories categoriesItems;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "item_order", joinColumns = @JoinColumn(name = "items_id"), inverseJoinColumns = @JoinColumn(name = "orders_id"))
	private List<Orders> orders = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_cat_id")
	private SubCategory subCat;

//	public Long getItemId() {
//		return itemId;
//	}
//
//	public void setItemId(Long itemId) {
//		this.itemId = itemId;
//	}
//
//	public String getItemName() {
//		return itemName;
//	}
//
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}
//
//	public String getItemDescription() {
//		return itemDescription;
//	}
//
//	public void setItemDescription(String itemDescription) {
//		this.itemDescription = itemDescription;
//	}
//
//	public Integer getItemPrice() {
//		return itemPrice;
//	}
//
//	public void setItemPrice(Integer itemPrice) {
//		this.itemPrice = itemPrice;
//	}
//
//	public Boolean getIsActive() {
//		return isActive;
//	}
//
//	public void setIsActive(Boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	public Boolean getIsAvailable() {
//		return isAvailable;
//	}
//
//	public void setIsAvailable(Boolean isAvailable) {
//		this.isAvailable = isAvailable;
//	}
//
//	public Categories getCategoriesItems() {
//		return categoriesItems;
//	}
//
//	public void setCategoriesItems(Categories categoriesItems) {
//		this.categoriesItems = categoriesItems;
//	}
//
//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}
//
//
//
//	public Items(Long itemId, String itemName, String itemDescription, Integer itemPrice, Boolean isActive,
//			Boolean isAvailable, Categories categoriesItems, List<Orders> orders, SubCategory subCat) {
//		super();
//		this.itemId = itemId;
//		this.itemName = itemName;
//		this.itemDescription = itemDescription;
//		this.itemPrice = itemPrice;
//		this.isActive = isActive;
//		this.isAvailable = isAvailable;
//		this.categoriesItems = categoriesItems;
//		this.orders = orders;
//		this.subCat = subCat;
//	}
//
//	public Items() {
//
//	}
//
//	public SubCategory getSubCat() {
//		return subCat;
//	}
//
//	public void setSubCat(SubCategory subCat) {
//		this.subCat = subCat;
//	}

}
