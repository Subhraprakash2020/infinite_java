package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAgentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int agentId;
		System.out.println("Enter project agentId");
		agentId = sc.nextInt();
		AgentDAO dao = new AgentDaoImpl();
		
		try {
			Agent agent  = dao.searchAgentDao(agentId);
			if(agent != null) {
				System.out.println(agent);
			}
			else {
				System.out.println("Record not fount");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
