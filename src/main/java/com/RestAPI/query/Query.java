package com.RestAPI.query;

import org.springframework.stereotype.Component;

@Component
public class Query {
	
	public static String  save="insert into product values(?,?,?,?)";

	public static String byid="select * from product where id=?";
	
	public static String byname="select * from product where name=?";
	
	public static String updateprice ="update product set price=?  where name=? ";
	
	public static String deletebyname="delete from product where name=?";
	
	public static String getall="select * from product";
	
}
