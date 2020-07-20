package com.teamdevix.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamdevix.ProductsAndCategories.models.Product;
import com.teamdevix.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product create(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}
}
