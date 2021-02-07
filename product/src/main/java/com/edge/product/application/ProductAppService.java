package com.edge.product.application;

import com.edge.product.domain.model.Product;
import com.edge.product.domain.model.ProductId;
import com.edge.product.infra.repository.ProductRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class ProductAppService {
    private final ProductRepository productRepository;

    ProductAppService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @NonNull
    public Optional<Product> findById(@NonNull ProductId productId){
        Objects.requireNonNull(productId, "productId is required");
        return productRepository.findById(productId);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findActive(){
        return productRepository.findActive();
    }
}
