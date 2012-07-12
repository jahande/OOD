package logic.invention;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import logic.member.Company;
import logic.member.User;

public class Invention {
	private String title;
	private String totalSpec;
	private String summary;
	private String ideaDescription;
	private String ideaHistory;
	private String claim;
	private String explanation;
	private List<File> attachedFiles;
	private List<User> inventors;
	private InventionField inventionField;
	private Company company;
	private long price;

	public Invention(String title, String totalSpec, String summary,
			String ideaDescription, String ideaHistory, String claim,
			String explanation, List<File> attachedFiles) {
		super();
		this.title = title;
		this.totalSpec = totalSpec;
		this.summary = summary;
		this.ideaDescription = ideaDescription;
		this.ideaHistory = ideaHistory;
		this.explanation = explanation;
		this.claim = claim;
		this.attachedFiles = attachedFiles;
	}

	public void setInventors(List<User> inventors) {
		this.inventors = inventors;
	}

	public void setInventionField(InventionField inventionField) {
		this.inventionField = inventionField;
	}

	public String getTitle() {
		return title;
	}

	public String getSummary() {
		return summary;
	}

	public String getIdeaDescription() {
		return ideaDescription;
	}

	public String getIdeaHistory() {
		return ideaHistory;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getClaim() {
		return claim;
	}

	public List<File> getAttachedFiles() {
		return attachedFiles;
	}

	public List<User> getInventors() {
		return inventors;
	}

	public List<String> getInventorNames() {
		List<String> namesList = new ArrayList<String>();
		for (User inventor : inventors) {
			namesList.add(inventor.getFirstName() + " "
					+ inventor.getLastName());
		}
		return namesList;
	}

	public InventionField getInventionField() {
		return inventionField;
	}

	public void resendForObjection() {

	}

	public List<Invention> getRelativeInventions() {
		return null;
	}

	public String getTotalSpec() {
		return totalSpec;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
