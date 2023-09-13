package com.java.leave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class App {
	private static final Logger log = Logger.getLogger("com.java.agent.AgentBAL");

	
	 static LeaveBAL bal;
	  static Scanner sc;
	  
	  static {
		  bal = new LeaveBAL();
		  sc = new Scanner(System.in);
	  }
	  

  public static void main(String[] args) {
    System.out.println("Hello World!"); 
    
    int choice;
    do {
    	System.out.println("1. Add leave application");
    	System.out.println("2. Show leave application");
    	System.out.println("3. Search leave application");
    	System.out.println("4. Delete leave application");
    	System.out.println("5. Update leave application");
    	
    	choice = sc.nextInt();
    	
    	switch(choice){
    	case 1:
    		try {
				addLeaveMain();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e.getMessage());
			}
    	    break;
    	case 2:
    	    showLeaveApplication();
    	    break;
    	case 3:
    		searcLeaveIdMain();
    		break;
    	case 4:
    		deleteLeaveIdMain();
    		break;
    	case 5:
    		try {
				updateLeaveMain();
			} catch (LeaveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		break;
    	}
    }while(choice !=6);
  }
  
  public static void showLeaveApplication() {
//	  List<LeaveDetails> leaveList = bal.showLeaveBal();
//	  for (LeaveDetails leave_details : leaveList) {
//		System.out.println(leave_details);
//	}
	  List<LeaveDetails> leaveList = bal.showLeaveBal();

	    if (leaveList.isEmpty()) {
	        System.out.println("No leave applications to show.");
	    } else {
	        for (LeaveDetails leaveDetails : leaveList) {
	            System.out.println(leaveDetails);
	        }
	    }
  }
  
  public static void addLeaveMain() throws LeaveException {
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  LeaveDetails leave_details = new LeaveDetails();
	  System.out.println("Enter employ no ::");
	  leave_details.setEmpno(sc.nextInt());
	  
	  System.out.println("Enter employ name :: ");
	  leave_details.setName(sc.next());
	  
	  System.out.println("Enter leave start date (yyyy-MM-dd): ");
      try {
          Date leaveStartDate = sdf.parse(sc.next());
          leave_details.setLeaveStartDate(leaveStartDate);
      } catch (ParseException e) {
          System.err.println("Invalid date format. Please use yyyy-MM-dd.");
          return; // Abort the operation if the date format is invalid
      }
	  
      System.out.println("Enter leave end date (yyyy-MM-dd): ");
      try {
          Date leaveEndDate = sdf.parse(sc.next());
          leave_details.setLeaveEndDate(leaveEndDate);
      } catch (ParseException e) {
          System.err.println("Invalid date format. Please use yyyy-MM-dd.");
          return; // Abort the operation if the date format is invalid
      }
      
      System.out.println("Enter the leavetype:::");
      
      Date currentDate = new Date();
      leave_details.setLeaveAppliedOn(currentDate);
      
      
      Date startDate = new Date();
      startDate = leave_details.getLeaveStartDate();
      
      Date endDate = new Date();
      endDate = leave_details.getLeaveEndDate();
      int  totalDays = (int) calculateDateDifference(startDate, endDate);
      leave_details.setNoOfDays(totalDays);
      
      leave_details.setLeaveType(LeaveType.valueOf(sc.next()));
      
      leave_details.setLeaveStatus(LeaveStatus.valueOf("PENDING"));
      
      leave_details.setManagerComments("Hello");
      
      System.out.println(bal.addLeaveBal(leave_details));
      
  }
  private static long calculateDateDifference(Date leaveStartDate, Date leaveEndDate) {
      long differenceInMillis = leaveEndDate.getTime()-leaveStartDate.getTime();
      return differenceInMillis / (24 * 60 * 60 * 1000);
  }
  
  
   public static void searcLeaveIdMain() {
	   int empno;
	   System.out.println("Enter employ no ::");
	   empno = sc.nextInt();
	   LeaveDetails leave_details = bal.seatchLeaveId(empno);
	   if(leave_details != null) {
		   System.out.println("Employ application number not found");
	   }
	   else {
		   System.out.println(leave_details);
	   }
   }
   
   public static void deleteLeaveIdMain() {
	   int empno;
	   System.out.println("Enter employno to deleted ::");
	   empno = sc.nextInt();
	   System.out.println(bal.deleteLeaveId(empno));
   }
   
   public static void updateLeaveMain() throws LeaveException {
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  LeaveDetails leave_details = new LeaveDetails();
		  System.out.println("Enter employ no ::");
		  leave_details.setEmpno(sc.nextInt());
		  
		  System.out.println("Enter employ name :: ");
		  leave_details.setName(sc.next());
		  
		  System.out.println("Enter leave start date (yyyy-MM-dd): ");
	      try {
	          Date leaveStartDate = sdf.parse(sc.next());
	          leave_details.setLeaveStartDate(leaveStartDate);
	      } catch (ParseException e) {
	          System.err.println("Invalid date format. Please use yyyy-MM-dd.");
	          return; // Abort the operation if the date format is invalid
	      }
		  
	      System.out.println("Enter leave end date (yyyy-MM-dd): ");
	      try {
	          Date leaveEndDate = sdf.parse(sc.next());
	          leave_details.setLeaveEndDate(leaveEndDate);
	      } catch (ParseException e) {
	          System.err.println("Invalid date format. Please use yyyy-MM-dd.");
	          return; // Abort the operation if the date format is invalid
	      }
	      
	      System.out.println("Enter the leavetype:::");
	      
	      Date currentDate = new Date();
	      leave_details.setLeaveAppliedOn(currentDate);
	      
	      
	      Date startDate = new Date();
	      startDate = leave_details.getLeaveStartDate();
	      
	      Date endDate = new Date();
	      endDate = leave_details.getLeaveEndDate();
	      int  totalDays = (int) calculateDateDifference(startDate, endDate);
	      leave_details.setNoOfDays(totalDays);
	      
	      leave_details.setLeaveType(LeaveType.valueOf(sc.next()));
	      
	      leave_details.setLeaveStatus(LeaveStatus.valueOf("PENDING"));
	      
	      leave_details.setManagerComments("Hello");
	      
	      System.out.println(bal.updateLeaveId(leave_details));
   }
 

}
