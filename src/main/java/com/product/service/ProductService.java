package com.product.service;

import com.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product save(Product product);
    public Product update(Product product);
    public Product getProductById(String id);
    public List<Product> getAllProducts();
    public void deleteProductById(String id);
}
