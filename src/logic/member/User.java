package logic.member;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class User extends Member {

	@Column(name = "expert")
	private boolean expert;

	// private List<ExpertInventionField> expertInventionFieldsList;

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
}
