package com.java.servlet;

import java.sql.SQLException;

public class Demo {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setFirstName("ariz");
		customer.setLastName("khan");
		customer.setUserName("eee");
		customer.setPassword("sss");
		customer.setEmail("subhra.techy@gmail.com");
		customer.setPhoneNo("848482234");
		CustomerDAO dao = new CustomerDAOImpl();
		try {
			System.out.println(dao.addCustomer(customer));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
