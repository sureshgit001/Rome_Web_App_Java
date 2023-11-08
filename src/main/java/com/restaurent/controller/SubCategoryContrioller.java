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
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.models.SubCategory;
import com.restaurent.models.UserInfo;
import com.restaurent.service.SubCategoryServices;

@RestController
public class SubCategoryContrioller {
	@Autowired
	private SubCategoryServices subCategoryServices;

	// GET ALL SUBCATEGIRIEBY CATEGORY ID
	@GetMapping("/v1/users/get-subcat-by-cat/{catId}")
	public ResponseEntity<List<SubCategory>> getAllSubCatByCatId(@PathVariable(name = "catId") Integer catId)
			throws Exception {

		List<SubCategory> subCatByCatId = subCategoryServices.getSubCatByCatId(catId);

		if (subCatByCatId == null || subCatByCatId.isEmpty()) {
			throw new Exception("Sub category Not found By cat Id");
		}

		return ResponseEntity.ok(subCatByCatId);
	}

	// GET ALL SUBCATEGORIES
	@GetMapping("/v1/users/sub-categories")
	public ResponseEntity<List<SubCategory>> getAllSubCatDetails() {

		List<SubCategory> subCatDetails = subCategoryServices.getAllSubCat();

		return new ResponseEntity<List<SubCategory>>(subCatDetails, HttpStatus.CREATED);
	}

	// GET SUBCATEGORY BYID
	@GetMapping("/v1/users/sub-categories/{subCatId}")
	public ResponseEntity<Optional<SubCategory>> getSubCatDetails(@PathVariable Integer subCatId) {
		Optional<SubCategory>subCatById = subCategoryServices.getSubCatById(subCatId);

		return new ResponseEntity<Optional<SubCategory>>(subCatById, HttpStatus.CREATED);

	}

	// SAVE SUBCATEGORY DETAILS
	@PostMapping("/v1/users/sub-categories/add")
	public ResponseEntity<Boolean> saveSubCat(@RequestBody SubCategory subcat) {

		Boolean saveSubCat = subCategoryServices.saveSubCat(subcat);

		return new ResponseEntity<Boolean>(saveSubCat, HttpStatus.CREATED);
	}

	// UPDATE SUBCATEGORY DETAILS
	@PutMapping("/v1/users/sub-categories/{subCatId}")
	public ResponseEntity<String> updateSubCat(@RequestBody SubCategory SubCategory, @PathVariable Integer subCatId) {

		boolean saveSubCat = subCategoryServices.updateSubCat(SubCategory, subCatId);
		String subCatUpdate = ((saveSubCat) ? "User details updated successfully" : "user doesn't exist").toUpperCase();
		return new ResponseEntity<String>(subCatUpdate, HttpStatus.CREATED);
	}

	// DELETE SUBCATEGORY
	@DeleteMapping("/v1/users/sub-categories/{subCatId}")
	public ResponseEntity<String> deleteSubCatDetails(@PathVariable Integer subCatId) {
		String deleteSubCat= (subCategoryServices.deleteSubCat(subCatId)).toUpperCase();
		return new ResponseEntity<String>(deleteSubCat, HttpStatus.CREATED);
	}

}
