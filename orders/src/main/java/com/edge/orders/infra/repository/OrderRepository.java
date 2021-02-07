package com.edge.orders.infra.repository;

import com.edge.orders.domain.model.Order;
import com.edge.orders.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
