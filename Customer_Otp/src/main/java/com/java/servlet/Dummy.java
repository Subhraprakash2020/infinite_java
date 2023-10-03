package com.java.servlet;

import java.sql.SQLException;

public class Dummy {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setFirstName("satya");
		customer.setLastName("prakash");
		customer.setUserName("satya");
		customer.setPassword("tttt");
		customer.setEmail("arizkhan20001@gmail.com");
		customer.setPhoneNo("848482234");
		CustomerDAO dao = new CustomerDAOImpl();
		try {
			System.out.println(dao.addCustomer(customer));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
