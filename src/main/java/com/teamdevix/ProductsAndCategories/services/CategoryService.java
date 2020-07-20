package com.teamdevix.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamdevix.ProductsAndCategories.models.Category;
import com.teamdevix.ProductsAndCategories.repositories.CategoryRepository;
@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category create(Category category) {
		return categoryRepository.save(category);		
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isPresent()) {
			return category.get();
		}else {
			return null;
		}
	}

	public Category save(Category category) {
		return categoryRepository.save(category);		
	}
	
	
}
