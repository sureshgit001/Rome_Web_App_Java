package com.restaurent.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long OrderId;
	private String OrderItem;
	private Integer TotalAmount;

	@ManyToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	private List<Items> items = new ArrayList<>();

	@ManyToOne()
	@JoinColumn(name = "userIdF")
	private UserInfo userInfoToOrder;

	// s
	@ManyToOne()
	@JoinColumn(name = "tableBookingIdF")
	private TableBooking tableBookingToOrder;

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public String getOrderItem() {
		return OrderItem;
	}

	public void setOrderItem(String orderItem) {
		OrderItem = orderItem;
	}

	public Integer getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		TotalAmount = totalAmount;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public UserInfo getUserInfoToOrder() {
		return userInfoToOrder;
	}

	public void setUserInfoToOrder(UserInfo userInfoToOrder) {
		this.userInfoToOrder = userInfoToOrder;
	}

	public TableBooking getTableBookingToOrder() {
		return tableBookingToOrder;
	}

	public void setTableBookingToOrder(TableBooking tableBookingToOrder) {
		this.tableBookingToOrder = tableBookingToOrder;
	}

	public Orders(Long orderId, String orderItem, Integer totalAmount, List<Items> items, UserInfo userInfoToOrder,
			TableBooking tableBookingToOrder) {
		super();
		OrderId = orderId;
		OrderItem = orderItem;
		TotalAmount = totalAmount;
		this.items = items;
		this.userInfoToOrder = userInfoToOrder;
		this.tableBookingToOrder = tableBookingToOrder;
	}

	public Orders() {

	}

	@Override
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", OrderItem=" + OrderItem + ", TotalAmount=" + TotalAmount + ", items="
				+ items + ", userInfoToOrder=" + userInfoToOrder + ", tableBookingToOrder=" + tableBookingToOrder + "]";
	}

	public Orders(Long orderId) {
		super();
		OrderId = orderId;
	}

}
