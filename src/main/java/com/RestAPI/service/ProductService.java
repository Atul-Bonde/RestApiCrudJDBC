package com.RestAPI.service;

import java.sql.SQLException;

import com.RestAPI.model.Product;

public interface ProductService {

	
	public String save(Product p) throws ClassNotFoundException, SQLException;
	
	
	public Product findbyid(int id) throws ClassNotFoundException, SQLException;
	
}
