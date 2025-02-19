package com.restaurent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.models.Categories;
@Repository
public  interface  CategoryRepo extends JpaRepository<Categories, Integer>{



}
