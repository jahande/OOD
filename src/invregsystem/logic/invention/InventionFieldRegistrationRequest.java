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
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "nearestFieldId", nullable = false)
	private InventionField nearestField;

	@Column(name = "fieldName", nullable = false)
	private String fieldName;

	public InventionFieldRegistrationRequest() {

	}

	public InventionFieldRegistrationRequest(AbstractUser user, InventionField nearestField, String fieldName) {
		super();
		this.user = (User) user;
		this.nearestField = nearestField;
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

	public InventionField getNearestField() {
		return nearestField;
	}

	public void setNearestField(InventionField nearestField) {
		this.nearestField = nearestField;
	}
	public String toString() {
		return this.fieldName;
	}

}
