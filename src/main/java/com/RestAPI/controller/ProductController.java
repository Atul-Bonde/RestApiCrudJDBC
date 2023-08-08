package com.RestAPI.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	
	@GetMapping("/getbyname")
	public ResponseEntity<Product> getbyname(@RequestParam String name) throws ClassNotFoundException, SQLException{
		
		
		return new ResponseEntity<Product>(productService.findbyname(name),HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updateprice")
	public ResponseEntity<String> updateprice(@RequestParam String name, @RequestParam double price) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<String>(productService.updateprice(name,price),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletebyname/{name}")
	public ResponseEntity<String> deleteproduct(@PathVariable String name) throws ClassNotFoundException, SQLException{
		
		return new ResponseEntity<String>(productService.deleteproduct(name),HttpStatus.OK);
		
	}
	
	@GetMapping("/getall")
	public ArrayList<Product> getall() throws ClassNotFoundException, SQLException{
		
		return productService.getall() ;
		
	}
	
}
