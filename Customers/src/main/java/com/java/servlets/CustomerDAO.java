package com.java.servlets;

import java.sql.SQLException;

public interface CustomerDAO {

	String addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	Customer searchByUserName(String userName) throws ClassNotFoundException, SQLException;
}
