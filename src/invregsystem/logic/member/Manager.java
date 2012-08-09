package invregsystem.logic.member;

import interfaces.AbstractManager;
import invregsystem.db.ManagerDao;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manager extends AbstractManager {
	@Id
	@GeneratedValue
	@Column(name = "managerId")
	private Integer id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "birthDate")
	private Date birthDate;

	public Manager() {
	}

	public Manager(String firstName, String lastName, String userName, String password, String email, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
	}

	public static Manager getManager() {
		ManagerDao managerDao = ManagerDao.getInstance();
		List<Manager> managers = managerDao.fetchAll();
		if (!managers.isEmpty()) {
			return managers.get(0);
		} else {
			return null;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String getFullName() {
		return firstName + " " + lastName;
	}

}
