package com.microservices.orderservice.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private double totalAmount;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<OrderItem> items;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private OrderStatus status;
}

@Data
class OrderItem {
    private String productId;
    private int quantity;
    private double price;
}

public enum OrderStatus {
    PENDING, PROCESSING, COMPLETED, CANCELLED
}
