package com.edge.orders.rest;

import com.edge.orders.application.OrderAppService;
import com.edge.orders.domain.model.Order;
import com.edge.orders.domain.model.OrderId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final OrderAppService orderAppService;

    public OrderController(OrderAppService orderAppService) {
        this.orderAppService = orderAppService;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderAppService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") UUID orderId) {
        return orderAppService.findById(new OrderId(orderId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/startProcessing")
    public void startProcessing(@PathVariable("id") String orderId) {
        orderAppService.startProcessing(new OrderId(UUID.fromString(orderId)));
    }

    @PutMapping("/{id}/finishProcessing")
    public void finishProcessing(@PathVariable("id") String orderId) {
        orderAppService.finishProcessing(new OrderId(UUID.fromString(orderId)));
    }
}
