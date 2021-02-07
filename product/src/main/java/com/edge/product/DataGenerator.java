package com.edge.product;

import com.edge.product.domain.model.Product;
import com.edge.product.infra.repository.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class DataGenerator {
    private final ProductRepository productRepository;

    DataGenerator(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void generateData(){
        var products = new ArrayList<Product>();
        products.add(createProduct("iPad", "Apple iPad", 100L));
        products.add(createProduct("iPhone", "Apple iPhone", 1000L));
        products.add(createProduct("MacBook", "Apple MacBook", 1200L));
        // productRepository.saveAll(products);
    }

    private Product createProduct(String name, String description, Long price){
        return new Product(name, description, price);
    }
}
