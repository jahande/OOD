package logic.member;

import java.util.List;

public class User extends Member {

	private boolean expert;
	private List<ExpertInventionField> expertInventionFieldsList;

	public User() {

	}

	public User(String firstName, String lastName, String userName, String password, String email, java.util.Date birthDate) {
		super(firstName, lastName, userName, password, email, birthDate);
	}

	public boolean isExpert() {
		return expert;
	}

	public void setExpert(boolean expert) {
		this.expert = expert;
	}

	public List<ExpertInventionField> getExpertInventionFieldsList() {
		return expertInventionFieldsList;
	}

	public void setExpertInventionFieldsList(List<ExpertInventionField> expertInventionFields) {
		this.expertInventionFieldsList = expertInventionFields;
	}

}
