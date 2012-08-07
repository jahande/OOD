package interfaces;

import invregsystem.db.BaseEntity;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.Share;
import invregsystem.logic.member.Company;

import java.util.List;
import java.util.Set;

public abstract class AbstractInvention extends BaseEntity<Integer> {
	public abstract void setTitle(String title);

	public abstract void setTotalSpec(String totalSpec);

	public abstract void setSummary(String summary);

	public abstract void setIdeaDescription(String ideaDescription);

	public abstract void setIdeaHistory(String ideaHistory);

	public abstract void setClaim(String claim);

	public abstract void setExplanation(String explanation);

	public abstract void setInventionField(InventionField inventionField);

	public abstract String getTitle();

	public abstract String getSummary();

	public abstract String getIdeaDescription();

	public abstract String getIdeaHistory();

	public abstract String getExplanation();

	public abstract String getClaim();

	public abstract InventionField getInventionField();

	public abstract void resendForObjection();

	public abstract List<AbstractInvention> getRelativeInventions();

	public abstract String getTotalSpec();

	public abstract AbstractCompany getCompany();

	public abstract void setCompany(AbstractCompany company);

	public abstract long getPrice();

	public abstract void setPrice(long price);

	public abstract String getFile1();

	public abstract void setFile1(String file1);

	public abstract String getFile2();

	public abstract void setFile2(String file2);

	public abstract String getFile3();

	public abstract void setFile3(String file3);

	public abstract Set<Share> getShares();

	public abstract void setShares(Set<Share> shares);

	public abstract InventionRegistrationRequest getInventionRegistrationRequest();

	public abstract void setInventionRegistrationRequest(InventionRegistrationRequest inventionRegistrationRequest);

	public abstract boolean isRealPossession();

	public abstract void setRealPossession(boolean realPossession);

}
