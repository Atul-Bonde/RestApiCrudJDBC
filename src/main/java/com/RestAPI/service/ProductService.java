package com.RestAPI.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.RestAPI.model.Product;

public interface ProductService {

	
	public String save(Product p) throws ClassNotFoundException, SQLException;
	
	
	public Product findbyid(int id) throws ClassNotFoundException, SQLException;
	
	
	public Product findbyname(String name) throws ClassNotFoundException, SQLException;
	
	
	public String updateprice(String name,Double price) throws ClassNotFoundException, SQLException;
	
	
	public String deleteproduct(String name) throws ClassNotFoundException, SQLException;
	
	
	public ArrayList<Product> getall() throws ClassNotFoundException, SQLException;
	
}
