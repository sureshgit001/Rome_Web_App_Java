package com.restaurent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.models.Categories;
import com.restaurent.models.Ingredients;
import com.restaurent.models.UserInfo;
import com.restaurent.repos.IngredientsRepo;

@Service
public class IngredientsService {
	
	@Autowired
	private IngredientsRepo ingredientsrepo;

	
	//SAVE INGREDIENTS
	public  Ingredients saveItemsIngredients(Ingredients ItemsIngredients ){
	   return ingredientsrepo.save(ItemsIngredients);
		
	}
	
	
	//Get INGREDIENTS BY ID
	public Optional<Ingredients> getItemsIngredients(Long ingredientsId  ) {
    return ingredientsrepo.findById(ingredientsId);
		
	}
	
	//GET INGREDIENTS
	public List<Ingredients> getIngredients( ) {
		
		return ingredientsrepo.findAll();
	}
	
	
	//UPDATE INGREDIENTS
	@SuppressWarnings("deprecation")
	public boolean updateItemsIngredients(Ingredients ItemsIngredients, Long ingredientsId) {

		Optional<Ingredients> findById = ingredientsrepo.findById(ingredientsId);
		if (findById.isPresent()) {
			ItemsIngredients.setIngredientsId(ingredientsId);
			ItemsIngredients = ingredientsrepo.save(ItemsIngredients);
			return true;
		} else {
			return false;
		}	
	}
	
	
	//DELETE INGREDIENTS
	public String deleteItemsIngredients(Long ingredientsId) {
		String deleteIngredients;
		Optional<Ingredients> findById = ingredientsrepo.findById(ingredientsId);
		if (findById.isPresent()) {
			ingredientsrepo.deleteById(ingredientsId);
			deleteIngredients = "ingredients deleted successfully";
		} else {
			deleteIngredients = "ingredients doesn't exist";
		}
		deleteIngredients.toUpperCase();
		return deleteIngredients;
	}
	
	
	
	

}
