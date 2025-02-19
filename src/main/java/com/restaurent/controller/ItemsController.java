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

import com.restaurent.models.Items;
import com.restaurent.service.ItemsService;

@RestController
@RequestMapping("/v1")
public class ItemsController {

	@Autowired
	private ItemsService itemsservice;

	// SAVE ITEMS
	@PostMapping("/users/items/add")
	public ResponseEntity<Items> saveItems(@RequestBody Items item) {

		Items saveItems = itemsservice.saveItems(item);

		return new ResponseEntity<Items>(saveItems, HttpStatus.CREATED);

	}

	// GET ITEMS BY ID
	@GetMapping("/users/items/{itemId}")
	public ResponseEntity<Optional<Items>> getItems(@PathVariable Long itemId) {
		Optional<Items> itemsById = itemsservice.getItemsById(itemId);
		return new ResponseEntity<Optional<Items>>(itemsById, HttpStatus.CREATED);
	}

	// GET ALL ITEMS
	@GetMapping("/users/items")
	public ResponseEntity<List<Items>> getItems() {
		List<Items> allItems = itemsservice.getAllItems();
		return new ResponseEntity<List<Items>>(allItems, HttpStatus.CREATED);
	}

	// UPDATE ITEMS
	@PutMapping("/users/items/{itemId}")
	public ResponseEntity<String> saveItems(@RequestBody Items items, @PathVariable Long itemId) {
		boolean updateitems = itemsservice.updateitems(items, itemId);
		String itemsUpdate = ((updateitems) ? "Items details updated successfully" : "Items doesn't exist")
				.toUpperCase();

		return new ResponseEntity<String>(itemsUpdate, HttpStatus.CREATED);

	}

	// DELETE ITEMS
	@DeleteMapping("/users/items/{itemId}")
	public ResponseEntity<String> deleteItemsDetails(@PathVariable Long itemId) {
		String deleteItem = (itemsservice.deleteItem(itemId)).toUpperCase();
		return new ResponseEntity<String>(deleteItem, HttpStatus.CREATED);
	}

	@GetMapping("/users/items/bySubCat/{subCatId}")
	public ResponseEntity<List<Items>> getItemsBySubCatId(@PathVariable Integer subCatId) {
		List<Items> items = itemsservice.getItemsBySubCatId(subCatId);
		return ResponseEntity.ok(items);
	}
	@GetMapping("/users/items/byCat/{catId}")
	public ResponseEntity<List<Items>> getItemsByCatId(@PathVariable Integer catId) {
		List<Items> items = itemsservice.getItemsByCatId(catId);
		return ResponseEntity.ok(items);
	}

}
