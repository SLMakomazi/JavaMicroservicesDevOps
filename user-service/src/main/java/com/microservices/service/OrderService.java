package com.microservices.orderservice.service;

import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setCreatedAt(new Date());
        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    public List<Order> getUserOrders(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order updateOrderStatus(String orderId, OrderStatus status) {
        Optional<Order> order = orderRepository.findByOrderId(orderId);
        if (order.isPresent()) {
            order.get().setStatus(status);
            return orderRepository.save(order.get());
        }
        return null;
    }
}
