package com.edge.invoice.infra.repository;

import com.edge.invoice.domain.model.Invoice;
import com.edge.invoice.domain.model.InvoiceId;
import com.edge.invoice.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface InvoiceRepository extends JpaRepository<Invoice, InvoiceId> {
    Stream<Invoice> findOrderById(OrderId orderId);
}
