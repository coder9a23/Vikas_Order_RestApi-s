package com.glearning.order.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.glearning.order.model.Order;
import com.glearning.order.repository.OrderRepository;

@Service
/*
 * Build a crud Api -Create -Read -Update -Delete
 */

public class OrderService {

	// in memory set of orders
	// private Set<Order> orders = new HashSet<>();

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	// save order
	public Order saveOrder(Order order) {

		return this.orderRepository.save(order);
	}

	// fetcing all the orders
	public Set<Order> fetchAllOrders() {
		return new HashSet<>(this.orderRepository.findAll());

	}

	// find the order based on in
	public Order findOrderByOrderId(long orderId) {
		return this.orderRepository.findAll().stream().filter(order -> order.getId() == orderId).findAny()
				.orElseThrow(() -> new IllegalArgumentException("Invalid Order Id passed"));
	}

	public void deleteOrderByOrderId(long orderId) {
		this.orderRepository.deleteById(orderId);
	}
	
	public Order updateOrder(long orderId, Order updatedOrder) {
		Order savedOrder = this.findOrderByOrderId(orderId);
		savedOrder.setName(updatedOrder.getName());
		savedOrder.setEmail(updatedOrder.getEmail());
		savedOrder.setPrice(updatedOrder.getPrice());
		savedOrder.setOderDate(updatedOrder.getOderDate());
		return this.orderRepository.save(savedOrder);
		
	}

}
