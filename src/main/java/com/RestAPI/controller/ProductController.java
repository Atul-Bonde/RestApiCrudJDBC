package com.RestAPI.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.model.Product;
import com.RestAPI.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public String save(@RequestBody Product p) throws ClassNotFoundException, SQLException {
		
		return productService.save(p);
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Product> getbyid(@PathVariable int id) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<>(productService.findbyid(id),HttpStatus.OK);
	}
	
}
