package com.ors.productservice.controller;

import com.ors.productservice.entity.Product;
import com.ors.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ors/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/getProductById/{productId}")
    public Product getProduct(@PathVariable("productId") UUID productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/deleteProductById/{productId}")
    public String deleteProduct(@PathVariable("productId") UUID productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping("/updateProductById/{productId}")
    public Product updateProduct(@PathVariable("productId") UUID productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }
}
