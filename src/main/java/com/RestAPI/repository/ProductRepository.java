package com.RestAPI.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.RestAPI.configuration.Configuration1;
import com.RestAPI.model.Product;
import com.RestAPI.query.Query;

@Repository
public class ProductRepository {

	@Autowired
	private Query query;

	@Autowired
	private Configuration1 configuration1;

	public boolean save(Product p) throws ClassNotFoundException, SQLException {

		Connection con = configuration1.getconfi();

		String query = Query.save;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, p.getId());
		ps.setString(2, p.getName());
		ps.setInt(3, p.getQuantity());
		ps.setDouble(4, p.getPrice());

		boolean execute = ps.execute();

		con.close();

		return execute;

	}

	public Product findbyid(int id) throws ClassNotFoundException, SQLException {

		Connection con = configuration1.getconfi();

		String query = Query.byid;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		Product p = new Product();

		while (rs.next()) {

			p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));

		}

		return p;
	}

	public Product findbyname(String name) throws ClassNotFoundException, SQLException {

		Connection con = configuration1.getconfi();

		String query = Query.byname;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		Product p = new Product();

		while (rs.next()) {

			p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));

		}

		con.close();

		return p;

	}

	public Integer updateprice(String name, double price) throws ClassNotFoundException, SQLException {

		Connection con = configuration1.getconfi();

		String query = Query.updateprice;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setDouble(1, price);
		ps.setString(2, name);

		int executeUpdate = ps.executeUpdate();

		con.close();

		return executeUpdate;

	}

	public Integer delete(String name) throws ClassNotFoundException, SQLException {

		Connection con = configuration1.getconfi();

		String query = Query.deletebyname;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, name);

		int delete = ps.executeUpdate();

		return delete;

	}

	public ArrayList<Product> getallproduct() throws ClassNotFoundException, SQLException {

		Connection con = configuration1.getconfi();

		String query = Query.getall;

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		ArrayList<Product> al = new ArrayList<>();

		Product p = new Product();

		while (rs.next()) {

			p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));

			al.add(p);

		}

		return al;

	}

}
