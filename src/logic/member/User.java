package logic.member;

import interfaces.AbstractCompany;
import interfaces.AbstractUser;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import logic.invention.InventionField;

@Entity
public class User extends AbstractUser {

	private Member memberDelegator ;
	@Column(name = "expert")
	private boolean expert;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "expertinventionfield", joinColumns = { @JoinColumn(name = "memberId") }, inverseJoinColumns = { @JoinColumn(name = "inventionFieldId") })
	private Set<InventionField> inventionFields;

	public User() {

	}

	public User(String firstName, String lastName, String userName, String password, String email, java.util.Date birthDate) {
		this.memberDelegator = new Member(firstName, lastName, userName, password, email, birthDate);
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

	@Override
	public void deleteMessages() {
		this.memberDelegator.deleteMessages();
		
	}

	@Override
	public Date getBirthDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		return this.memberDelegator.getEmail();
	}

	@Override
	public String getFirstName() {
		return this.memberDelegator.getFirstName();
	}

	@Override
	public String getFullName() {
		return this.memberDelegator.getFullName();
	}

	@Override
	public String getLastName() {
		return this.memberDelegator.getLastName();
	}

	@Override
	public void getMessages() {
		//TODO this is clear that this function must not have void return type
		this.memberDelegator.getMessages();
		
	}

	@Override
	public String getPassword() {
		return this.memberDelegator.getPassword();
	}

	@Override
	public String getUserName() {
		return this.memberDelegator.getUserName();
	}

	@Override
	public Date getbirthDate() {
		//TODO little 'b'?
		return this.memberDelegator.getbirthDate();
	}

	@Override
	public void setBirthDate(Date birthDate) {
		this.memberDelegator.setBirthDate(birthDate);		
	}

	@Override
	public void setEmail(String email) {
		this.memberDelegator.setEmail(email);		
	}

	public void setFirstName(String firstName) {
		memberDelegator.setFirstName(firstName);
	}

	public void setId(Integer id) {
		memberDelegator.setId(id);
	}

	public void setLastName(String lastName) {
		memberDelegator.setLastName(lastName);
	}

	public void setPassword(String password) {
		memberDelegator.setPassword(password);
	}

	public void setUserName(String userName) {
		memberDelegator.setUserName(userName);
	}

	public void sigin() {
		memberDelegator.sigin();
	}

	public void signout() {
		memberDelegator.signout();
	}

	public void signup() {
		memberDelegator.signup();
	}

	@Override
	public Integer getId() {
		return this.memberDelegator.getId();
	}

	
}
