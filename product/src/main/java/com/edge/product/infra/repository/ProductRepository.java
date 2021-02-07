package com.edge.product.infra.repository;

import com.edge.product.domain.model.Product;
import com.edge.product.domain.model.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
    @Query("select p from Product p where p.deleted = false order by p.name")
    List<Product> findActive();
}
