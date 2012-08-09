package interfaces;

import invregsystem.db.BaseEntity;

import java.util.Date;

public abstract class AbstractMember extends BaseEntity<Integer> {

	public abstract void setBirthDate(Date birthDate);

	public abstract void setFirstName(String firstName);

	public abstract void setLastName(String lastName);

	public abstract void setUserName(String userName);

	public abstract void setPassword(String password);

	public abstract void setEmail(String email);

	public abstract String getFirstName();

	public abstract String getLastName();

	public abstract String getUserName();

	public abstract String getPassword();

	public abstract String getEmail();

	public abstract Date getBirthDate();

	public abstract String getFullName();
}
