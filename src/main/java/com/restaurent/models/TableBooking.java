package com.restaurent.models;

import java.util.ArrayList;
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

@Entity
@Table
@JsonIgnoreProperties("orderList")
public class TableBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tableId;
	@Column
	private  Integer tableNo;
	private Boolean isBooked;
	private Boolean isAvailable;
	
	//s
	@OneToMany(mappedBy = "tableBookingToOrder",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Orders> orderList=new ArrayList<>();
	
	
	
	public Integer getTableNo() {
		return tableNo;
	}
	public void setTableNo(Integer tableNo) {
		this.tableNo = tableNo;
	}
	public List<Orders> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public Boolean getIsBooked() {
		return isBooked;
	}
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public TableBooking(Integer tableId, Integer tableNo, Boolean isBooked, Boolean isAvailable) {
		super();
		this.tableId = tableId;
		this.tableNo = tableNo;
		this.isBooked = isBooked;
		this.isAvailable = isAvailable;
	}
	public TableBooking() {
		
	}
	
}
