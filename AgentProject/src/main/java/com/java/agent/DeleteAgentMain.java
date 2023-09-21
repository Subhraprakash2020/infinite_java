package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAgentMain {
	public static void main(String[] args) {
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
}
