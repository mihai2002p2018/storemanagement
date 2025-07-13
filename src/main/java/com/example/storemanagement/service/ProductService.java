package com.example.storemanagement.service;


import com.example.storemanagement.model.Product;
import com.example.storemanagement.repository.ProductRepository;
import com.example.storemanagement.exception.ProductNotFoundException;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public Product addProduct(Product p) {
		Product result = productRepository.save(p);
		logger.info("Product added: {}", result);
		return result;
	}
    
    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product findProduct(Long id) {
    	return productRepository.findById(id)
    		.orElseThrow(() -> {
    			logger.warn("Product with id={} not found", id);
    				return new ProductNotFoundException("Product with id=" + id + " not found");
                });
    }

    public Product changePrice(Long id, double newPrice) {
        Product p = findProduct(id);
        double oldPrice = p.getPrice();
        p.setPrice(newPrice);
        Product updated = productRepository.save(p);
        logger.info("Price changed for product id={}, oldPrice={}, newPrice={}", id, oldPrice, newPrice);
        return updated;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
