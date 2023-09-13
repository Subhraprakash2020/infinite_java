package com.java.agent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AgentDaoImpl implements AgentDAO{
	
	ArrayList<Integer> arr1 = new ArrayList<>();
	static List<Agent> agentList ;
	static{
		agentList = new ArrayList<Agent>();
	}
	@Override
	public List<Agent> showAgentDao() {
		// TODO Auto-generated method stub
		return agentList;
	}
	
	public int generateAgentId(){
		if(agentList.size() == 0){
			return 1;
		}
		else{
			return agentList.get(agentList.size()-1).getAgentId()+1;
		}
	}

	@Override
	public String addAgentDao(Agent agent) {
		agentList.add(agent);
		return "Record inserted";
	}


	@Override
	public Agent searchAgentDao(int agentid) {
		Agent agentFound = null;
		for (Agent agent : agentList) {
			agentFound = agent;
		}
		return agentFound;
	}

	@Override
	public String deleteAgentDao(int agentid) {
		// TODO Auto-generated method stub
		Agent agentFound = searchAgentDao(agentid);
		if(agentFound != null){
			agentList.remove(agentid);
			return "Employ Record deleted";
		}
	
			return "Record not found";
	
	
	}

	@Override
	public String updateAgentDao(Agent agentUpdate) {
		// TODO Auto-generated method stub
		Agent agentFound = searchAgentDao(agentUpdate.getAgentId());
		if(agentFound != null){
			for (Agent agent : agentList) {
				if(agent.getAgentId() == agentUpdate.getAgentId()){
					agent.setFirstName(agentUpdate.getFirstName());
					agent.setLastName(agentUpdate.getLastName());
					agent.setCity(agentUpdate.getCity());
					agent.setPayMode(agentUpdate.getPayMode());
					agent.setPremium(agentUpdate.getPremium());
					break;
				}
				return "Employ Record Update";
				
			}
		}
		return "Employ Record not found";
	}

	@Override
	public String writeEmployFileDao() throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fout = new FileOutputStream("d:/files/AgentProject.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(agentList);
		objout.close();
		fout.close();
		return "Data stored in File";
		
	}

	@Override
	public String readEmployFileDao() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("d:/files/AgentProject.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		agentList = (List<Agent>)objin.readObject();
		objin.close();
		fin.close();
		return "Data Retrive From file";
		
	}

	

}
