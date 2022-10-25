package com.glearning.order.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.order.model.Order;
import com.glearning.order.service.OrderService;

@RestController
@RequestMapping("api/v1/orders")
public class OrderRestController {

	private final OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	

	@GetMapping // Fetch or get all the records
	public Set<Order> fetchAllOrders() {	// this is to save the data in an array form 
		return this.orderService.fetchAllOrders();
	}
	
	
			// Here the @PathVariable and @RequestBody is converted JSON into java or java into jason
	@GetMapping("/{id}") // Fatch or get the mentioned record
	public Order fectchOrderById(@PathVariable("id") long orderId) {
		return this.orderService.findOrderByOrderId(orderId);
	}
	
	
	@PutMapping("/{id}") // Fatch or get the mentioned record
	public Order updateOrderById(@PathVariable("id") long orderId, @RequestBody Order updatedOrder) {
		return this.orderService.updateOrder(orderId,updatedOrder);
	}
	

	@PostMapping // Save and create the order
	@ResponseStatus(HttpStatus.CREATED)
	public Order saveOrder(@RequestBody Order order) {
		return this.orderService.saveOrder(order);
	}
	
	

	@DeleteMapping("/{id}") // Delete the selected order
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrderById(@PathVariable("id") long orderId) {
		this.orderService.deleteOrderByOrderId(orderId);
	}

}
