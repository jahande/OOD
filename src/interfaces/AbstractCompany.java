package interfaces;

import java.util.Set;

import logic.member.User;
import db.BaseEntity;

public abstract class AbstractCompany  extends BaseEntity<Integer>{
	public abstract String getName() ;

	public abstract void setName(String name);

	public abstract Set<User> getAgents();

	public abstract void setAgents(Set<User> agents);
}
