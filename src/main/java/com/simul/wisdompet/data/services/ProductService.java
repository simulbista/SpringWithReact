package com.simul.wisdompet.data.services;

import com.simul.wisdompet.data.entities.ProductEntity;
import com.simul.wisdompet.data.repositories.ProductRepository;
import com.simul.wisdompet.web.errors.NotFoundException;
import com.simul.wisdompet.web.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){

        List<Product> products = new ArrayList<>();
        Iterable<ProductEntity> entities = this.productRepository.findAll();

        entities.forEach(entity ->{
            products.add(translateDBToWeb(entity));
        });

        return products;
    }

    public Product getProduct(long id){
        Optional<ProductEntity> optional = this.productRepository.findById(id);
        if(optional.isEmpty()) {
            throw new NotFoundException("Product with id " + id + " not found!");
        }else{
            return this.translateDBToWeb(optional.get());
        }
    }

    public Product createOrUpdateProduct(Product product) {
        ProductEntity entity = translateWebToDB(product);
        entity = this.productRepository.save(entity);
        return this.translateDBToWeb(entity);
    }

    public void deleteProduct(long id){
        this.productRepository.deleteById(id);
    }



    private Product translateDBToWeb(ProductEntity entity) {
        return new Product(entity.getProductId(), entity.getName(), entity.getPrice(),
                entity.getVendorId());
    }

    private ProductEntity translateWebToDB(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setProductId(product.getProductId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setVendorId(product.getVendorId());
        return entity;
    }
}
