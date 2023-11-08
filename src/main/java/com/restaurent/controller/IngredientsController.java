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

import com.restaurent.models.Ingredients;
import com.restaurent.models.UserInfo;
import com.restaurent.service.IngredientsService;

@RestController
@RequestMapping("/v1")
public class IngredientsController {

	@Autowired
	private IngredientsService ingredientsservice;

	// SAVE INGREDIENTS
	@PostMapping("/users/ingredients/add")
	public ResponseEntity<Ingredients> saveIngredients(@RequestBody Ingredients ingredients) {
		Ingredients saveItemsIngredients = ingredientsservice.saveItemsIngredients(ingredients);
		return new ResponseEntity<Ingredients>(saveItemsIngredients, HttpStatus.CREATED);
	}

	// GET INGREDIENTS
	@GetMapping("/users/ingredients")
	public ResponseEntity<List<Ingredients>> getIngredients() {
		List<Ingredients> ingredients = ingredientsservice.getIngredients();

		return new ResponseEntity<List<Ingredients>>(ingredients, HttpStatus.CREATED);

	}

	// GET INGREDIENTS BY ID
	@GetMapping("/users/ingredients/{ingredientsId}")
	public ResponseEntity<Optional<Ingredients>> getIngredientsDetails(@PathVariable Long ingredientsId) {
		 Optional<Ingredients> itemsIngredients = ingredientsservice.getItemsIngredients(ingredientsId);

		return new ResponseEntity<Optional<Ingredients>>(itemsIngredients, HttpStatus.CREATED);

	}

	// UPDATE INGREDIENTS DETAILS
	@PutMapping("/users/ingredients/{ingredientsId}")
	public ResponseEntity<String> saveIngredien(@RequestBody Ingredients ingredients,
			@PathVariable long ingredientsId ) {

		boolean updateItemsIngredients = ingredientsservice.updateItemsIngredients(ingredients, ingredientsId);
		String itemsingredients = ((updateItemsIngredients) ? "Ingredients details updated successfully"
				: "Ingredients doesn't exist").toUpperCase();
		return new ResponseEntity<String>(itemsingredients, HttpStatus.CREATED);
	}

	// DELETE INGREDIENTS
	@DeleteMapping("/users/ingredients/{ingredientsId}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable Long ingredientsId) {
		String deleteitems = (ingredientsservice.deleteItemsIngredients(ingredientsId)).toUpperCase();
		return new ResponseEntity<String>(deleteitems, HttpStatus.CREATED);
	}

}
