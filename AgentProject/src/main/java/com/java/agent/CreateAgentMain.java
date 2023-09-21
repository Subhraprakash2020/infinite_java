package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAgentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Agent agent = new Agent();
		System.out.println("Enter agent name :");
		agent.setName(sc.next());
		System.out.println("Enter agent city :");
		agent.setCity(sc.next());
		System.out.println("Enter agent gender :");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter maritialstatus :");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter premium :");
		agent.setPremium(sc.nextDouble());
		
		AgentDAO dao = new AgentDaoImpl();
		try {
			System.out.println(dao.createAgentDao(agent));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
