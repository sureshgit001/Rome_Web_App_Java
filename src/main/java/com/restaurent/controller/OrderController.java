package com.restaurent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.models.Orders;
import com.restaurent.service.OrderService;

@RestController
@RequestMapping("/v1")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	// GET ALL ORDERS
	@GetMapping("/users/orders")
	public ResponseEntity<List<Orders>> getOrderDetails(){
		List<Orders> orderDetails = orderservice.getOrderDetails();
		
		return new ResponseEntity<List<Orders>>(orderDetails, HttpStatus.CREATED);
	}
	
	//GET ORDER BYID
	@GetMapping("/users/orders/{ordersid}")
	public ResponseEntity<Optional<Orders>>getOrderDetails(@PathVariable Integer OrderId){
		Optional<Orders> OrderById = orderservice.getOrderById(OrderId);
		
		return new ResponseEntity<Optional<Orders>>(OrderById, HttpStatus.CREATED);
	}
	
	//SAVE ORDER DETAILS
	@PostMapping("/users/orders")
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
	   Orders saveOrder = orderservice.saveOrder(order);
	
	   return new ResponseEntity<Orders>(saveOrder,HttpStatus.CREATED);
	}
	
	//UPDATE ORDER DETAILS
	@PutMapping("/users/orders/{orderid}")
	public ResponseEntity<String> saveOrder(@RequestBody Orders orders,@PathVariable Long orderId){
		
		boolean saveOrder =orderservice.updateorder(orders, orderId);
		String orderupdate = ((saveOrder) ? "Order details updated successfully" :"order doesn't exist").toUpperCase();
		return new ResponseEntity<String>(orderupdate,HttpStatus.CREATED);
	}
	
	//DELETE ORDER
	@DeleteMapping("/users/orders/{orderid}")
	public ResponseEntity<String> deleteOrderDetils(@PathVariable Long orderId){
		String deleteOrder = ((String) orderservice.deleteorder(orderId)).toUpperCase();
		return new ResponseEntity<String>(deleteOrder,HttpStatus.CREATED);
	}
	
 

}
