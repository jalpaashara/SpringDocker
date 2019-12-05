package com.cust.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cust.order.service.CustomerOrderService;

import com.cust.order.model.*;

@RestController
public class MainController {
	@Autowired
	CustomerOrderService customerOrderService;
	
	@RequestMapping("/")
	public List<Customer> getAllCustomers(){
		return customerOrderService.findAllCustomers();
	}
	
	@GetMapping(value= "/{id}")
	public Customer getByCustomerId(@PathVariable int id) {
		return customerOrderService.findCustomerById(id);
	}
	
	@GetMapping(value= "/{id}/orders")
	public List<Order> getAllCustomerOrders(@PathVariable int id) {
		return customerOrderService.getAllCustomerOrders(id);
	}
	
	@GetMapping(value = "/{id}/orders/{orderId}")
	public Order getCustomerOrderById(@PathVariable("id") int id, @PathVariable("orderId") int orderID) {
		return customerOrderService.getCustomerOrderById(id, orderID);
	}
}
