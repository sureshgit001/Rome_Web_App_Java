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

import com.restaurent.models.Categories;
import com.restaurent.models.UserInfo;
import com.restaurent.service.CategoryService;

@RestController
@RequestMapping("/v1")
public class CategoriesController {
	@Autowired
	private CategoryService CategorysService;

	// SAVE CATEGORIES
	@PostMapping("/users/categories")
	public ResponseEntity<Categories> saveItemsCategories(@RequestBody Categories Categories) {
		Categories saveCategories = CategorysService.saveCategories(Categories);
		return new ResponseEntity<Categories>(saveCategories, HttpStatus.CREATED);
	}

	// GET ALL CATEGORIES
	@GetMapping("/users/categories")
	public ResponseEntity<List<Categories>> getItemsCategories() {
		List<Categories> categories = CategorysService.getCategories();

		return new ResponseEntity<List<Categories>>(categories, HttpStatus.CREATED);
	}

	// GET CATEGORIES BY ID
	@GetMapping("/users/categories/{categoryId}")
	public ResponseEntity<Optional<Categories>> getItemsCategories(@PathVariable Integer categoryId) {
		Optional<Categories> categoriesById = CategorysService.getCategoriesById(categoryId);

		return new ResponseEntity<Optional<Categories>>(categoriesById, HttpStatus.CREATED);

	}

	// UPDATE CATEGORIES
	@PutMapping("/users/categories/{categoryId}")
	public ResponseEntity<String> updateItemsCategories(@RequestBody Categories Categories,
			@PathVariable Integer categoryId) {

		boolean updateCategories = CategorysService.updateCategories(Categories, categoryId);
		String categoriesUpdate = ((updateCategories) ? "Categories details updated successfully"
				: "Categories doesn't exist").toUpperCase();
		return new ResponseEntity<String>(categoriesUpdate, HttpStatus.CREATED);
	}

	// DELETE CATEGORIES
	@DeleteMapping("/users/categories/{categoryId}")
	public ResponseEntity<String> deleteCategoriesDetails(@PathVariable Integer categoryId) {
		String deletecategories = (CategorysService.deleteCategories(categoryId)).toUpperCase();
		return new ResponseEntity<String>(deletecategories, HttpStatus.CREATED);
	}

}
