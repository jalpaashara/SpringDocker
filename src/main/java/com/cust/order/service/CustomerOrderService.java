package com.cust.order.service;

import java.util.List;
import com.cust.order.model.*;


public interface CustomerOrderService {
	public List<Customer> findAllCustomers();
	public Customer findCustomerById(int id);
	public List<Order> getAllCustomerOrders(int id);
	public Order getCustomerOrderById(int id, int orderId);
}
