package com.java.servlet;

import java.sql.SQLException;

public interface CustomerDAO {

	String addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	Customer searchByUserName(String userName) throws ClassNotFoundException, SQLException;
	String validateOtp(String user, int otpCode) throws ClassNotFoundException, SQLException;
}
