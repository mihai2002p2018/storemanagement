package com.example.storemanagement;


import com.example.storemanagement.model.Product;
import com.example.storemanagement.service.ProductService;
import com.example.storemanagement.repository.ProductRepository;
import com.example.storemanagement.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    @Test
    void testFindProduct_ProductExists() {
        ProductRepository repo = mock(ProductRepository.class);
        ProductService service = new ProductService(repo);
        Product p = new Product(1L, "Apple", 2.0, 100);
        when(repo.findById(1L)).thenReturn(Optional.of(p));
        assertEquals("Apple", service.findProduct(1L).getName());
    }
    @Test
    void testFindProduct_NotFound() {
        ProductRepository repo = mock(ProductRepository.class);
        ProductService service = new ProductService(repo);
        when(repo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> service.findProduct(1L));
    }
}