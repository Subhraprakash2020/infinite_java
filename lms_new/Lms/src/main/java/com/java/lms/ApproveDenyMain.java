package com.java.lms;

import java.sql.SQLException;
import java.util.Scanner;

public class ApproveDenyMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter LeaveID ");
		int leaveid = sc.nextInt();
		System.out.println("Enter ManagerID ");
		int managerid = sc.nextInt();
		System.out.println("Enter Status(YES/NO) ");
		String status = sc.next();
		System.out.println("Enter Manager Comment ");
		String mgcmt = sc.next();
		
		LeaveDetailsDAO dao = new LeaveDAOImpl();
		try {
			System.out.println(dao.approveDeny(leaveid, managerid, status, mgcmt));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
