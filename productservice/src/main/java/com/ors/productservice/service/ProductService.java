package com.ors.productservice.service;

import com.ors.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {
    Product saveProduct(Product product);

    Product getProduct(UUID productId);

    List<Product> getAllProducts();

    String deleteProduct(UUID productId);

    Product updateProduct(UUID productId, Product product);
}
