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
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	/* NEW PRODUCT */
	@RequestMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		return "product/createproduct.jsp";
	}
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String _createProduct_(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "product/createproduct.jsp";
		}
		else {
			productService.create(product);
			return "redirect:/products/"+product.getId();
		}
	}
	/* --------------------------------------------------------------------- */
	
	
	/* Show Product */
	@RequestMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id, @ModelAttribute("category") Category category) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		
		List<Category> categoryInList = product.getCategories();
		List<Category> categoryList = categoryService.findAll();
		for(int i = 0; i < categoryInList.size(); i++) {
			if(categoryList.contains(categoryInList.get(i))) categoryList.remove(categoryInList.get(i));
		}
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryInList", categoryInList);
		return "product/showproduct.jsp";
	}
	
	/* Añadir Categoria a un Product(id) */
	@RequestMapping(value="/product/add/{id}", method=RequestMethod.POST)
	public String addCategoryToProduct(@Valid @ModelAttribute("category") Category category, @PathVariable("id") Long id) {
		Product product = productService.findById(id);
		List<Category> categoryList = product.getCategories();
		if(categoryList.contains(category)) {
			System.out.println("entre al if");
			return "redirect:/product/add/"+id;
		}else {
			System.out.println("entre al else");
			categoryList.add(category);
			product.setCategories(categoryList);
			productService.save(product);
			return "redirect:/products/"+id;
		}
	}
}
