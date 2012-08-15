package invregsystem;

import invregsystem.db.BaseEntity;
import invregsystem.logic.member.CompanyRegistrationRequest;
import invregsystem.logic.member.User;

import java.util.Set;

public abstract class AbstractCompany extends BaseEntity<Integer> {
	public abstract String getName();

	public abstract void setName(String name);

	public abstract Set<User> getAgents();

	public abstract void setAgents(Set<User> agents);

	public abstract String getPhone();

	public abstract void setPhone(String phone);

	public abstract String getAddress();

	public abstract void setAddress(String address);

	public abstract String getWebsite();

	public abstract void setWebsite(String website);

	public abstract String getIntroDocFile();

	public abstract void setIntroDocFile(String introDocFile);

	public abstract CompanyRegistrationRequest getCompanyRegistrationRequest();

	public abstract void setCompanyRegistrationRequest(CompanyRegistrationRequest companyRegistrationRequest);
}
