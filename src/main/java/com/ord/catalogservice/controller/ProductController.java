package com.ord.catalogservice.controller;

import com.ord.catalogservice.jpa.Product;
import com.ord.catalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    private List<Product> getAllProducts() {
        System.out.println("getAllProducts proudct --->");
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
    private Product saveProduct(@RequestBody Product product) {
        System.out.println("Save proudct --->");
        productService.saveOrUpdate(product);
        return product;
    }
}
