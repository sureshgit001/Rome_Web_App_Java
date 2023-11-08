package com.restaurent.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.models.Items;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Long> {

	public List<Items> findBySubCatSubId(Integer subCatId);

}
