package com.java.library;
import java.util.List;


import java.sql.SQLException;

import java.util.Scanner;

public class MainUPdate {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        try {
            LibraryDAOImpl dao = new LibraryDAOImpl();
            
            System.out.print("Enter username: ");
            String userName = scanner.nextLine();

            List<LibUser> bookList = dao.showHistory(userName);

            if (bookList.isEmpty()) {
                System.out.println("No borrowing history found for user: " + userName);
            } else {
                System.out.println("Borrowing history for user: " + userName);
                for (LibUser book : bookList) {
                    System.out.println("Book ID: " + book.getBookId());
                    System.out.println("From Date: " + book.getFromDate());
                    System.out.println("-------------------------");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
		
	}
}
