package com.restaurent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.models.Items;
import com.restaurent.models.UserInfo;
import com.restaurent.repos.ItemsRepo;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsRepo itemsrepo; 
	
	//SAVE ITEMS
	public Items saveItems(Items items) {
		return itemsrepo.save(items);

}
	//GET ITEMS BY ID
	public Optional<Items> getItemsById(long itemId) {
		return itemsrepo.findById(itemId);
		
	}
	
	//GET ALL ITEMS
	public List<Items> getAllItems() {
		return itemsrepo.findAll();
		
		
	}
	
	//UPDATE ITEMS
	@SuppressWarnings("deprecation")
	public boolean updateitems(Items items, Long itemId) {
		Optional<Items> findById = itemsrepo.findById(itemId);
		if (findById.isPresent()) {
			items.setItemId(itemId);
			items = itemsrepo.save(items);
			return true;
		} else {
			return false;
		}
		
	}
	
	//DELETE ITEMS
	public String deleteItem(long itemId) {
		String deleteItem;
		Optional<Items> findById = itemsrepo.findById(itemId);
		if (findById.isPresent()) {
			itemsrepo.deleteById(itemId);
			deleteItem = "Item deleted successfully";
		} else {
			deleteItem = "Item doesn't exist";
		}
		deleteItem.toUpperCase();
		return deleteItem;
	
		
	}
	public List<Items> getItemsBySubCatId(Integer subCatId) {
		List<Items> items=itemsrepo.findBySubCatSubId(subCatId);
		return items;
	}
	
	public List<Items> getItemsByCatId(Integer categoryId) {
		List<Items> items=itemsrepo.findByCategoriesItemsCategoryId(categoryId);
		return items;
	}
}
