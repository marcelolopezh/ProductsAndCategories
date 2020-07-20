package com.teamdevix.ProductsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.teamdevix.ProductsAndCategories.models.Category;
import com.teamdevix.ProductsAndCategories.models.Product;
import com.teamdevix.ProductsAndCategories.services.CategoryService;
import com.teamdevix.ProductsAndCategories.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoryController(CategoryService categoryService,ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	/* New Category */
	@RequestMapping("/categories/new")
	public String createCategory(@ModelAttribute("category") Category category) {
		return "category/createcategory.jsp";
	}
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String _createCategory_(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category/createcategory.jsp";
		}else {
			categoryService.create(category);
			return "redirect:/categories/"+ category.getId();
		}
	}
	/* -------------------------------------------------------------------------------------------------------- */
	
	/* Show Categories */
	@RequestMapping("/categories/{id}")
	public String showCategory(@ModelAttribute("product") Product product, Model model, @PathVariable("id") Long id) {
		Category category = categoryService.findById(id);
		List<Product> productsInCategory = category.getProducts();
		List<Product> allProducts = productService.findAll();
		for(int i = 0; i<productsInCategory.size(); i++) {
			if(allProducts.contains(productsInCategory.get(i))) {
				allProducts.remove(productsInCategory.get(i));
			}
		}
		model.addAttribute("category", category);
		model.addAttribute("productsInCategory", productsInCategory);
		model.addAttribute("allProducts", allProducts);
		return "category/showcategory.jsp";
	}
	/* -----------------------------------------------------------------------------------------------------------*/
	
	@RequestMapping(value="/category/add/{id}", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("product") Product product, @PathVariable("id") Long id) {
		Category category = categoryService.findById(id);
		List<Product> productList = category.getProducts();
		if(productList.contains(product)) {
			return "redirect:/category/add/"+id;
		}else {
			productList.add(product);
			category.setProducts(productList);
			categoryService.save(category);
			return "redirect:/categories/"+id;
		}
		
	}
	
	
}
