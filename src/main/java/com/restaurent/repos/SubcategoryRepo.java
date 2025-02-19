package com.restaurent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurent.models.SubCategory;
import com.restaurent.models.UserInfo;

@Repository
public interface SubcategoryRepo extends JpaRepository<SubCategory, Integer> {
	@Query("SELECT s FROM SubCategory s WHERE s.category.categoryId = :catId")
	public List<SubCategory> findByCategoryCatId(Integer catId);
	
	//public List<SubCategory> findByCategoryCategoryId(Integer categoryId);

	

}
