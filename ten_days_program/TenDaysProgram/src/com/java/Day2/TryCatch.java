package com.java.Day2;

public class TryCatch {
	 public static void main(String args[]){  
		   try{  
		      //code that may raise exception  
			   //AtithmeticException
		      int data=100/0;  
		   }catch(ArithmeticException e){System.out.println(e);}  
		   //rest code of the program   
		   System.out.println("rest of the code...");  
		  }  	
}
