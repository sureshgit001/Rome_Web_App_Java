package com.restaurent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurent.models.Categories;
//import com.restaurent.models.UserInfo;
import com.restaurent.repos.CategoryRepo;
@Service
public class CategoryService {
   
	
	@Autowired
	private CategoryRepo categorysrepo;
	
	//SAVE CATEGOIRES
	public Categories saveCategories(Categories categories) {
		return categorysrepo.save(categories);
	}
	
	//GET ALL CATEGORIES
	public List<Categories>  getCategories() {
	return categorysrepo.findAll();
	}
	
	//GET CATEGORIES BY ID
	public Optional<Categories> getCategoriesById(Integer categoryId ){
		return categorysrepo.findById(categoryId);
	}
	
	
	//UPDATE CATEGORIES
	public boolean updateCategories(Categories categories,Integer categoryId ) {
		Optional<Categories> findById = categorysrepo.findById(categoryId);
		if (findById.isPresent()) {
			categories.setCategoryId(categoryId);
			categories = categorysrepo.save(categories);
			return true;
		} else {
			return false;
		}
	}
	
	// DELETE CATEGORIES
		public String deleteCategories(Integer categoryId) {
			String deleteCategories;
			Optional<Categories> findById = categorysrepo.findById(categoryId);
			if (findById.isPresent()) {
				categorysrepo.deleteById(categoryId);
				deleteCategories = "user deleted successfully";
			} else {
				deleteCategories = "user doesn't exist";
			}
			deleteCategories.toUpperCase();
			return deleteCategories;
		}
	
	
	
	
	
}
