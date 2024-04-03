package com.simul.wisdompet.web.rest;


import com.simul.wisdompet.web.errors.BadRequestException;
import com.simul.wisdompet.web.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.simul.wisdompet.data.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> getAll(){
        return this.productService.getAllProducts();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return this.productService.createOrUpdateProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return this.productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product){
        if(id!=product.getProductId()){
            throw new BadRequestException("Id in path and body do not match!");
        }
        return this.productService.createOrUpdateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        this.productService.deleteProduct(id);
    }


}
