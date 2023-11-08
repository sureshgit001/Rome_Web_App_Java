package com.restaurent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.models.Orders;
import com.restaurent.repos.OrderinfoRepo;

@Service
public class OrderService {

	@Autowired
	private OrderinfoRepo orderrepo;

	// GET ALL USERS
	public List<Orders> getOrderDetails() {
		// TODO Auto-generated method stub
		return orderrepo.findAll();
	}

	// GET USER BY ID
	public Optional<Orders> getOrderById(long orderId) {
		// TODO Auto-generated method stub
		return orderrepo.findById(orderId);
	}

	// SAVE ORDER
	public Orders saveOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderrepo.save(order);
	}

	// UPDATE ORDER DETAILS
	@SuppressWarnings("deprecation")
	public boolean updateorder(Orders orders, Long orderId) {

		Optional<Orders> findById = orderrepo.findById(orderId);
		if (findById.isPresent()) {
			orders.setOrderId(orderId);
			orders = orderrepo.save(orders);
			return true;
		} else {

			return false;
		}
	}

	// DELETE ORDER
	public Object deleteorder(Long orderId) {
		String deleteorder;
		Optional<Orders> findById = orderrepo.findById(orderId);
		if (findById.isPresent()) {
			orderrepo.deleteById(orderId);
			deleteorder = "order deleted successfully";
		} else {
			deleteorder = "order doesn't exist";
		}
		deleteorder.toUpperCase();
		return deleteorder;
	}

}
