package invregsystemlogic.member;

import invregsystem.db.ManagerDao;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;


@Entity
public class Manager extends Member {
	public Manager() {
	}

	public Manager(String firstName, String lastName, String userName, String password, String email, Date birthDate) {
		super(firstName, lastName, userName, password, email, birthDate);
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
}
