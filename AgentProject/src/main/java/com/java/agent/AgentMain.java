package com.java.agent;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AgentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter your choice ");
			System.out.println("1. Show all Agent List");
			System.out.println("2. Insert agent in database");
			System.out.println("3. Search agent from database");
			System.out.println("4. Delete agent from databae");
			System.out.println("5. Update Agent");
			System.out.println("6. EXit");
			
			choice = sc.nextInt();
			
			switch(choice){
			case 1:
				ShowEmployMain();
				break;
			case 2:
				CreateAgentMain();
				break;
			case 3:
				SearchAgentMain();
				break;
			case 4:
				DeleteAgentMain();
				break;
			case 5:
				UpdateAgentMain();
				break;
				
			}
			
		}while(choice !=6);
		
		
		
		
	}
	public static void ShowEmployMain() {
		AgentDAO dao = new AgentDaoImpl();
		List<Agent> agentList = null;
		
		try {
			agentList = dao.showAgentDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Agent agent : agentList) {
			System.out.println(agent);
		}
	}
	public static void CreateAgentMain() {
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
	
	public static void SearchAgentMain() {
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
	
	public static void DeleteAgentMain() {
		Scanner sc = new Scanner(System.in);
		int agentId;
		System.out.println("Ente agentID :");
		agentId = sc.nextInt();
		
		AgentDAO dao = new AgentDaoImpl();
		
		try {
			System.out.println(dao.deleteAgentDao(agentId));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void UpdateAgentMain(){
		Scanner sc = new Scanner(System.in);
		Agent agent = new Agent();
		System.out.println("Enter agent id:");
		agent.setAgentId(sc.nextInt());
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
			System.out.println(dao.updateAgentDao(agent));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
