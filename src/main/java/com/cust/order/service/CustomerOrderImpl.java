package com.cust.order.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.cust.order.model.*;

@Service
public class CustomerOrderImpl implements CustomerOrderService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public List<Customer> findAllCustomers() {
		ReadCustomerJSON custListJSON = new ReadCustomerJSON();
		List<Customer> custList = new ArrayList<>();
		try {
			custList = custListJSON.read();
			logger.info("All Customers List:");
			logger.info(custList.toString());
			return custList;
		} catch (JsonParseException e) {
			logger.error("JsonParseException", e);
		}
		return custList;
	}

	@Override
	public Customer findCustomerById(int id) {
		Customer cust = new Customer();
		List<Customer> custList = findAllCustomers();
		try {
			for (Customer br: custList) {
				if (br.getId() == id) {
					return br;
				}
			}
		} catch (NullPointerException e) {
			logger.error("NullPointerException");
			logger.error( "Something's wrong with findAllCustomer()");
		} 
		
		if (cust.getId() == 0) {
			logger.warn("Please check customer id. Your provided id is " + id );
		}
		
		return cust;
	}

	@Override
	public List<Order> getAllCustomerOrders(int id) {
		return findCustomerById(id).getOrder();
	}

	@Override
	public Order getCustomerOrderById(int id, int orderId) {
		List<Order> orders = getAllCustomerOrders(id);
		Order custOrder = new Order();
		try {
			if (!orders.isEmpty()) {
				for (Order order: orders) {
					if (order.getOrderId() == orderId) {
						return order;
					}
				}
			}
			
			if (custOrder.getOrderId() == 0) {
				logger.warn("Please check order id. Your provided id is " + orderId );
			}
			
		} catch(NullPointerException ex) {
			logger.error("NullPointerException");
			logger.error( "Either customer id or order id is not correct.");
		}
		
		return custOrder;
	}
}
