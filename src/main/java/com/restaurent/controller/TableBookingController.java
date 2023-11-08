package com.restaurent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.restaurent.models.TableBooking;
import com.restaurent.repos.TableBookingRepo;
import com.restaurent.service.TableBookingService;


@Controller
@RequestMapping("/v1")
public class TableBookingController {
	
	@Autowired
	private TableBookingService tbs;
	@Autowired
	private TableBookingRepo tbr;

	// GET ALL TABLEBOOKINS
	@GetMapping("/users/tableBooking")
	public ResponseEntity<List<TableBooking>> getUserDetails() {
		List<TableBooking> userTableBooking = tbs.getTableBookingDetails();

		return new ResponseEntity<List<TableBooking>>(userTableBooking, HttpStatus.CREATED);
	}

	// GET TABLEBOOKIN BYID
	@GetMapping("/users/tableBooking/{tableBookingId}")
	public ResponseEntity<Optional<TableBooking>> getUserDetails(@PathVariable Integer tableBookingId) {
		Optional<TableBooking> userTableBooking = tbs.getTableBookingById(tableBookingId);

		return new ResponseEntity<Optional<TableBooking>>(userTableBooking, HttpStatus.CREATED);

	}

	// SAVE TABLEBOOKIN DETAILS
	@PostMapping("/users/tableBooking")
	public ResponseEntity<TableBooking> saveUser(@RequestBody TableBooking tb) {

		TableBooking saveTableBooking = tbs.saveTableBooking(tb);

		return new ResponseEntity<TableBooking>(saveTableBooking, HttpStatus.CREATED);
	}

	// UPDATE TABLEBOOKIN DETAILS
	@PutMapping("/users/tableBooking/{tableBookingId}")
	public ResponseEntity<String> saveUser(@RequestBody TableBooking tb, @PathVariable Integer  tableBookingId) {

		boolean updateTableBooking = tbs.updateTableBooking(tb, tableBookingId);
		String tableBookingUpdate = ((updateTableBooking) ? "TableBooking details updated successfully" : "TableBooking doesn't exist").toUpperCase();
		return new ResponseEntity<String>(tableBookingUpdate, HttpStatus.CREATED);
	}

	// DELETE TABLEBOOKIN
	@DeleteMapping("/users/tableBooking/{tableBookingId}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable Integer tableBookingId) {
		String deleteTableBooking = tbs.deleteTableBooking(tableBookingId).toString();
		
		return new ResponseEntity<String>(deleteTableBooking, HttpStatus.CREATED);
	}
	
	@PostMapping("/users/tableBooking/isBooked")
	public ResponseEntity<?>tableBookingIsAvailable (@RequestBody TableBooking tab){
		HashMap<?, ?> availTableBookingDetails = tbs.getAvailTableBookingDetails(tab);
		
		return ResponseEntity.ok(availTableBookingDetails);

		
	}

}

