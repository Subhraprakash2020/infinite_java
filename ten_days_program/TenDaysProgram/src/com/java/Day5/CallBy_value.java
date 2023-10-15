package com.java.Day5;

public class CallBy_value {
	int data = 50;

	void change(int data) {
		data = data + 100;// changes will be in the local variable only
	}
	 public static void main(String args[]){  
		 CallBy_value op=new CallBy_value();  
		  
		   System.out.println("before change "+op.data);  
		   op.change(500);  
		   System.out.println("after change "+op.data);  
		  
		 }  
}
