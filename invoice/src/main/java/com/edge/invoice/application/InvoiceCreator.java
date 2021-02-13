package com.edge.invoice.application;

import com.edge.invoice.infra.repository.InvoiceRepository;
import com.edge.invoice.integration.OrderProcessedEvent;
import com.edge.invoice.rest.client.OrderClient;

import java.time.Clock;

public class InvoiceCreator {
    private static final int DEFAULT_TERMS = 14;
    private final InvoiceRepository invoiceRepository;
    private final OrderClient orderClient;
    private final Clock clock;

    public InvoiceCreator(InvoiceRepository invoiceRepository, OrderClient orderClient, Clock clock) {
        this.invoiceRepository = invoiceRepository;
        this.orderClient = orderClient;
        this.clock = clock;
    }

    public void onOrderProcessedEvent(OrderProcessedEvent orderProcessedEvent){

    }
}
