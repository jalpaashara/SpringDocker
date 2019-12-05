package com.cust.order.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;

import com.cust.order.model.*;

public class ReadCustomerJSON {
	public List<Customer> read() throws JsonParseException {
		Logger logger = LoggerFactory.getLogger(getClass());
		// this is the key object to convert JSON to Java
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> custList = new ArrayList<>();
        
        try {
        	File json = new ClassPathResource("data.json").getFile();
        	custList = Arrays.asList(mapper.readValue(json, Customer[].class));
            return custList;
        } catch(JsonParseException ex) {
        	logger.error("JsonParseException", ex);
        } catch (JsonMappingException e) {
        	logger.error("JsonMappingException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
		return custList;
	}
}