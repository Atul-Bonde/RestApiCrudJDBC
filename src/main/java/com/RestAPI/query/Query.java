package com.RestAPI.query;

import org.springframework.stereotype.Component;

@Component
public class Query {
	
	public static String  save="insert into product values(?,?,?,?)";

	public static String byid="select * from product where id=?";
}
