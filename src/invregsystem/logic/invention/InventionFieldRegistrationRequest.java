package invregsystem.logic.invention;

import interfaces.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.member.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InventionFieldRegistrationRequest extends Request {
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@Column(name = "fieldName")
	private String fieldName;

	public InventionFieldRegistrationRequest() {

	}

	public InventionFieldRegistrationRequest(AbstractUser user, String fieldName) {
		super();
		this.user = (User) user;
		this.fieldName = fieldName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
