package com.restaurent.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.models.TableBooking;
import com.restaurent.repos.TableBookingRepo;

@Service
public class TableBookingService {
	@Autowired
	private TableBookingRepo tbr;
	private Object put;

	// GET TABLEBOOKING BY ID
	public Optional<TableBooking> getTableBookingById(Integer tableBookingId) {
		return tbr.findById(tableBookingId);

	}

	// GET ALL TABLEBOOKINGS
	public List<TableBooking> getTableBookingDetails() {

		return tbr.findAll();

	}

	// GET ALL ISBOOKEDTABLEBOOKINGS
	public HashMap<?, ?> getAvailTableBookingDetails(TableBooking tba) {

		HashMap<String, Object> result = new HashMap<>();
		Boolean isBooked = tba.getIsBooked();
		if (isBooked == null) {

			result.put("message", "enter valid");

		} else {

			List<TableBooking> findByIsBooked = tbr.findByIsBooked(isBooked);
			System.out.println(findByIsBooked);

			result.put("isAvailable", findByIsBooked);
			
		}
		return result;
	}

	// SAVE TABLEBOOKING
	public TableBooking saveTableBooking(TableBooking tableBookingId) {
		return tbr.save(tableBookingId);

	}

	// UPDATE TABLEBOOKING DETAILS
	@SuppressWarnings("deprecation")
	public boolean updateTableBooking(TableBooking tableBooking, Integer tableBookingId) {

		Optional<TableBooking> findById = tbr.findById(tableBookingId);
		if (findById.isPresent()) {
			tableBooking.setTableId(tableBookingId);
			tableBooking = tbr.save(tableBooking);
			return true;
		} else {
			return false;
		}
	}

	// DELETE TABLEBOOKING
	public String deleteTableBooking(Integer tableBookingId) {
		String deleteTableBooking;
		Optional<TableBooking> findById = tbr.findById(tableBookingId);
		if (findById.isPresent()) {
			tbr.deleteById(tableBookingId);
			deleteTableBooking = "tableBooking deleted successfully";
		} else {
			deleteTableBooking = "tableBooking doesn't exist";
		}

		deleteTableBooking.toUpperCase();
		return deleteTableBooking;

	}

}
