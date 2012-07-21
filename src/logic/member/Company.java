package logic.member;

import java.util.List;

import utilities.db.BaseEntity;

public class Company extends BaseEntity<Integer> {
	private Integer id;
	private String name;
	private List<User> agentsList;

	public Company(String name, List<User> agentsList) {
		super();
		this.name = name;
		this.agentsList = agentsList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAgentsList(List<User> agentsList) {
		this.agentsList = agentsList;
	}

	public List<User> getAgentsList() {
		return agentsList;
	}

}
