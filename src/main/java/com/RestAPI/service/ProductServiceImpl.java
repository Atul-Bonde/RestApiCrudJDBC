package com.RestAPI.service;

import java.sql.SQLException;

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

}
