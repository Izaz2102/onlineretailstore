package com.ors.productservice.service;

import com.ors.productservice.entity.Product;
import com.ors.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(UUID productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(UUID productId) {
        return productRepository.findById(productId).map(product -> {
            productRepository.delete(product);
            return "Deleted Successfully!";
        }).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    @Override
    public Product updateProduct(UUID productId, Product product) {
        return productRepository.findById(productId).map(product1 -> {
            product1.setProductName(product.getProductName());
            product1.setProductDescription(product.getProductDescription());
            product1.setProductPrice(product.getProductPrice());
            return productRepository.save(product1);
        }).orElseThrow(() -> new RuntimeException("Product not found!"));
    }
}
