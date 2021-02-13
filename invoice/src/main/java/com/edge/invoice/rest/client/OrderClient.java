package com.edge.invoice.rest.client;

import com.edge.invoice.domain.model.OrderId;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class OrderClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public OrderClient(String serverUrl, int connectTimeOut, int readTimeOut) {
        this.restTemplate = new RestTemplate();
        this.serverUrl = serverUrl;
        var requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeOut);
        requestFactory.setReadTimeout(readTimeOut);
        restTemplate.setRequestFactory(requestFactory);
    }

    public Optional<Order> findById(OrderId orderId) {
        var uri = UriComponentsBuilder.fromUriString(serverUrl).path("/api/orders/{id}");

        try {
            ResponseEntity<Order> response = restTemplate.getForEntity(uri.build(orderId.toUUID()), Order.class);
            return Optional.ofNullable(response.getBody());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
