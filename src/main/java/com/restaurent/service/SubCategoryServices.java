package com.restaurent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.models.SubCategory;

import com.restaurent.repos.SubcategoryRepo;

@Service
public class SubCategoryServices {

	@Autowired
	private SubcategoryRepo subCatRepo;

	// GET SubCat BY ID
	public Optional<SubCategory> getSubCatById(Integer subCatId) {
		return subCatRepo.findById(subCatId);

	}
	
	// GET ALL SUBCATS
	public List<SubCategory> getAllSubCat( ) {
		return subCatRepo.findAll();
		
	}

	// GET ALL SUBCATBYCATID
	public List<SubCategory> getSubCatByCatId(Integer catId) {

		return subCatRepo.findByCategoryCatId(catId);

	}
	// SAVE SubCat
		public Boolean saveSubCat(SubCategory subCat) {
			
			
				subCatRepo.save(subCat);
				return true;
			}


		

		// UPDATE SubCat DETAILS
		@SuppressWarnings("deprecation")
		public boolean updateSubCat(SubCategory subCat, Integer subcatId) {

			Optional<SubCategory> findById = subCatRepo.findById(subcatId);
			if (findById.isPresent()) {
				subCat.setSubId(subcatId);
				subCat = subCatRepo.save(subCat);
				return true;
			} else {
				return false;
			}
		}
		

		// DELETE SubCat
		public String deleteSubCat(Integer subcatId) {
			String deleteSubCat;
			Optional<SubCategory> findById = subCatRepo.findById(subcatId);
			if (findById.isPresent()) {
				subCatRepo.deleteById(subcatId);
				deleteSubCat = "SubCat deleted successfully";
			} else {
				deleteSubCat = "SubCat doesn't exist";
			}
			deleteSubCat.toUpperCase();
			return deleteSubCat;
		}

	

}