package com.ord.catalogservice.controller;

import com.ord.catalogservice.jpa.Product;
import com.ord.catalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    private List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    private Product getProduct(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    private void deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    private int saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getId();
    }
}
