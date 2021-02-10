package com.edge.orders;

import com.edge.kernel.domain.geo.CityName;
import com.edge.kernel.domain.geo.Country;
import com.edge.kernel.domain.geo.PIN;
import com.edge.orders.domain.model.*;
import com.edge.orders.infra.repository.OrderRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.UUID;

@Component
public class DataGenerator {
    private final OrderRepository orderRepository;

    public DataGenerator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void generateData() {
        Order order = new Order(Instant.now(), "USD",
                new RecipientAddress("Srinivas", "J 708 - Address Line 1", "Address Line 2",
                        new CityName("Hyderabad"), Country.India, new PIN(123456L)),
                new RecipientAddress("Ramadasu", "35 - Address Line 1", "Address Line 2",
                        new CityName("Hyderabad"), Country.India, new PIN(567890L)));

        order.addItem(new OrderItem(new OrderItemId(UUID.randomUUID()),
                new ProductId(UUID.randomUUID().toString()),
                "IPAD", "INR", 50000L, 10));

        order.addItem(new OrderItem(new OrderItemId(UUID.randomUUID()),
                new ProductId(UUID.randomUUID().toString()),
                "MacBook", "INR", 120000L, 10));

        // orderRepository.save(order);
    }
}
