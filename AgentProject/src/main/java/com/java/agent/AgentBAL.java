package com.java.agent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AgentBAL {
	static StringBuilder sb;
	static AgentDAO dao;
	
	static{
		sb = new StringBuilder();
		dao = new AgentDaoImpl();
	}
	
	public String writeEmployFileBal() throws IOException{
		return dao.writeEmployFileDao();
	}
	
	public String readEmployFileBal() throws FileNotFoundException, ClassNotFoundException, IOException{
		return dao.readEmployFileDao();
	}
	
	public String updateAgentBal(Agent agentUpdate) throws AgentException{
		if(validateAgent(agentUpdate) == true){
			return dao.updateAgentDao(agentUpdate);
		}
		throw new AgentException(sb.toString());
		
	}
	
	
	public String deleteAgentBal(int agentid){
		return dao.deleteAgentDao(agentid);
	}
	
	public Agent searAgentBal(int agentid){
		return dao.searchAgentDao(agentid);
	}
	
	public List<Agent> showAgentBal(){
		return dao.showAgentDao();
	}
	
	public String addAgentBal(Agent agent) throws AgentException{
		if(validateAgent(agent) == true){
			return dao.addAgentDao(agent);
		}
		throw new AgentException(sb.toString());
	}
	
	public boolean validateAgent(Agent agent){
		boolean flag = true;
		if(agent.getFirstName().length() < 4){
			flag = false;
			sb.append("First name contaion must be 4 character..\r\n");
		}
		if(agent.getLastName().length() < 4){
			flag = false;
			sb.append("Last name contain must be 4 character ..\r\n");
		}
		if(agent.getCity().contains("Delhi")){
			flag = false;
			sb.append("Delhi people cannot be added...\r\n");
		} 
		if(agent.getPremium()< 5000 ||agent.getPremium() > 99000){
			flag = false;
			sb.append("Premium must be in between 5000 to 99000");
		}
		return flag;
	}
	
	
}
