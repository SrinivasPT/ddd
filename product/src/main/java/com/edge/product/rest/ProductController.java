package com.edge.product.rest;

import com.edge.product.application.ProductAppService;
import com.edge.product.domain.model.Product;
import com.edge.product.domain.model.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductAppService productAppService;

    ProductController(ProductAppService productAppService) {
        this.productAppService = productAppService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productAppService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") UUID productId) {
        return productAppService.findById(new ProductId(productId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public List<Product> findActive() {
        return productAppService.findActive();
    }
}
