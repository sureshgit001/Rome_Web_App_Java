package com.restaurent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.restaurent.models.TableBooking;
import com.restaurent.models.UserInfo;

@Repository
public interface TableBookingRepo extends JpaRepository<TableBooking, Integer> {

	public List<TableBooking> findByIsBooked(Boolean IsBooked);
	
}
