package interfaces;

import invregsystem.db.BaseEntity;
import invregsystemlogic.member.User;

import java.util.Set;


public abstract class AbstractCompany  extends BaseEntity<Integer>{
	public abstract String getName() ;

	public abstract void setName(String name);

	public abstract Set<User> getAgents();

	public abstract void setAgents(Set<User> agents);
}
