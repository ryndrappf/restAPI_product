package ryndrappf.apiproduct.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ryndrappf.apiproduct.models.entities.Product;
import ryndrappf.apiproduct.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.findOne(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        productService.removedOne(id);
    }

}
