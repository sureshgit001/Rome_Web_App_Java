package com.restaurent.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.models.Orders;

@Repository
public interface OrderinfoRepo extends JpaRepository<Orders, Long>{

}
