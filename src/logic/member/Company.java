package logic.member;

import java.util.List;

public class Company {
	private String name;
	private List<User> agentsList;

	public Company(String name, List<User> agentsList) {
		super();
		this.name = name;
		this.agentsList = agentsList;
	}

	public String getName() {
		return name;
	}

	public List<User> getAgentsList() {
		return agentsList;
	}

}
