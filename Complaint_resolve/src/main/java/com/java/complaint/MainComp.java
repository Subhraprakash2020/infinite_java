package com.java.complaint;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class MainComp {
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);

         // Initialize the ComplaintDAO implementation
         ComplaintDAO complaintDAO = new ComplaintDAOImpl();

         System.out.println("Resolve Complaint");

         // Assuming you have the Complaint ID available
         System.out.print("Enter Complaint ID to resolve: ");
         String complaintIdToResolve = scanner.nextLine();

         System.out.print("Enter Resolved By: ");
         String resolvedBy = scanner.nextLine();

         System.out.print("Enter Comments: ");
         String comments = scanner.nextLine();

         // Create a new Resolve object
         Resolve resolve = new Resolve();
         resolve.setResolveBy(resolvedBy);
         resolve.setComments(comments);

         try {
             String status = "Resolved"; // Set the status here
             Date complaintDate = new Date(); // Set the complaintDate here

             String result = complaintDAO.addResolve(resolve, complaintIdToResolve, status, complaintDate);
             System.out.println(result);
         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }
//    	    Complaint complaint = new Complaint();
     
//            Scanner sc = new Scanner(System.in);
//            
//            String complaintId;
//            System.out.println("Enter complaintId");
//            complaintId = sc.next();
//            ComplaintDAO dao = new ComplaintDAOImpl();
//            try {
//				Complaint complaint = dao.searchComplaint(complaintId);
//				if(complaint != null) {
//					System.out.println(complaint);
//				}
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            

            
//
//            System.out.print("Enter Complaint Type: ");
//            complaint.setComplaintType(sc.next()); 
//
//            System.out.print("Enter Complaint Description: ");
//            complaint.setcDescription(sc.next());
//            System.out.print("Enter Severity: ");
//            complaint.setSeverity(sc.next());
//            ComplaintDAO dao = new ComplaintDAOImpl();
//            try {
//				System.out.println(dao.addComplaint(complaint));
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}


       
    }
}
