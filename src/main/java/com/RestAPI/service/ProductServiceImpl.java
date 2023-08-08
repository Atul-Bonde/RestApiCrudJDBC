package com.RestAPI.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.model.Product;
import com.RestAPI.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public String save(Product p) throws ClassNotFoundException, SQLException {

		boolean save = productRepository.save(p);

		if (save) {

			return "product not save ";
		} else {

			return "product is save Successfully";
		}

	}

	@Override
	public Product findbyid(int id) throws ClassNotFoundException, SQLException {

		Product findbyid = productRepository.findbyid(id);

		if (findbyid == null) {

			return null;
		}

		else {

			return findbyid;
		}
	}

	@Override
	public Product findbyname(String name) throws ClassNotFoundException, SQLException {

		Product findbyname = productRepository.findbyname(name);

		if (findbyname == null) {

			return null;
		} else {
			return findbyname;

		}
	}

	@Override
	public String updateprice(String name, Double price) throws ClassNotFoundException, SQLException {

		Integer updateprice = productRepository.updateprice(name, price);

		if (updateprice.equals(0)) {

			return "Product not Updated";
		} else {

			return "Product Updated Successfully";
		}

	}

	@Override
	public String deleteproduct(String name) throws ClassNotFoundException, SQLException {

		Integer delete = productRepository.delete(name);

		if (delete.equals(0)) {

			return "Product not Deleted";
		} else {

			return "Product Deleted Successfully";
		}
	}

	@Override
	public ArrayList<Product> getall() throws ClassNotFoundException, SQLException {

		ArrayList<Product> getallproduct = productRepository.getallproduct();

		return getallproduct;
	}

}
