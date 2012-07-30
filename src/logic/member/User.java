package logic.member;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import logic.invention.InventionField;

@Entity
public class User extends Member {

	@Column(name = "expert")
	private boolean expert;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "expertinventionfield", joinColumns = { @JoinColumn(name = "memberId") }, inverseJoinColumns = { @JoinColumn(name = "inventionFieldId") })
	private Set<InventionField> inventionFields;

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

	public Set<InventionField> getInventionFields() {
		return inventionFields;
	}

	public void setInventionFields(Set<InventionField> inventionFields) {
		this.inventionFields = inventionFields;
	}
}
