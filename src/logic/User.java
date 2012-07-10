package logic;

import java.util.List;

public class User extends Member {

	private boolean expert;
	private List<InventionField> assignedInventionFields;

	public User(String firstName, String lastName, String userName,
			String password, String email, java.util.Date birthDate) {
		super(firstName, lastName, userName, password, email, birthDate);
	}

	public boolean isExpert() {
		return expert;
	}

	public void setExpert(boolean expert) {
		this.expert = expert;
	}

	public void assignInventionField(InventionField field) {
		// TODO
	}

	public void deleteAssignedInventionField(InventionField field) {
		// TODO
	}

	public List<InventionField> getAssignedInventionFields() {
		return assignedInventionFields;
	}

}
