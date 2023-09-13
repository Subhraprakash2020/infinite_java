package com.java.agent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AgentDAO {
	List<Agent> showAgentDao();
	String addAgentDao(Agent agent);
	Agent searchAgentDao(int agentid);
	String deleteAgentDao(int agentid);
	String updateAgentDao(Agent agentUpdate);
	
	String writeEmployFileDao() throws IOException;
	String readEmployFileDao() throws FileNotFoundException, IOException, ClassNotFoundException;
}
