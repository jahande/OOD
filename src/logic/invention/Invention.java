package logic.invention;

import interfaces.AbstractCompany;
import interfaces.AbstractInvention;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import db.BaseEntity;

import logic.member.Company;

@Entity
public class Invention extends AbstractInvention{
	@Id
	@GeneratedValue
	@Column(name = "inventionId")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "totalSpec")
	private String totalSpec;

	@Column(name = "summary")
	private String summary;

	@Column(name = "ideaDescription")
	private String ideaDescription;

	@Column(name = "ideaHistory")
	private String ideaHistory;

	@Column(name = "claim")
	private String claim;

	@Column(name = "explanation")
	private String explanation;

	@Column(name = "file1")
	private String file1;

	@Column(name = "file2")
	private String file2;

	@Column(name = "file3")
	private String file3;

	@Column(name = "price")
	private long price;

	@ManyToOne
	@JoinColumn(name = "inventionFieldId")
	private InventionField inventionField;

	@ManyToOne
	@JoinColumn(name = "companyId")
	private AbstractCompany company;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invention")
	private Set<Share> shares;

	@OneToOne(cascade = CascadeType.ALL)
	private InventionRegistrationRequest inventionRegistrationRequest;

	public Invention() {

	}

	public Invention(String title, String totalSpec, String summary, String ideaDescription, String ideaHistory, String claim, String explanation, List<String> attachedFiles) {
		super();
		this.title = title;
		this.totalSpec = totalSpec;
		this.summary = summary;
		this.ideaDescription = ideaDescription;
		this.ideaHistory = ideaHistory;
		this.explanation = explanation;
		this.claim = claim;
		if (attachedFiles.size() > 0)
			this.file1 = attachedFiles.get(0);
		if (attachedFiles.size() > 1)
			this.file1 = attachedFiles.get(1);
		if (attachedFiles.size() > 2)
			this.file1 = attachedFiles.get(2);
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTotalSpec(String totalSpec) {
		this.totalSpec = totalSpec;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setIdeaDescription(String ideaDescription) {
		this.ideaDescription = ideaDescription;
	}

	public void setIdeaHistory(String ideaHistory) {
		this.ideaHistory = ideaHistory;
	}

	public void setClaim(String claim) {
		this.claim = claim;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
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

	public InventionField getInventionField() {
		return inventionField;
	}

	public void resendForObjection() {
		// TODO
	}

	public List<AbstractInvention> getRelativeInventions() {
		return null;
	}

	public String getTotalSpec() {
		return totalSpec;
	}

	public AbstractCompany getCompany() {
		return company;
	}

	public void setCompany(AbstractCompany company) {
		this.company = company;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	public Set<Share> getShares() {
		return shares;
	}

	public void setShares(Set<Share> shares) {
		this.shares = shares;
	}

	public InventionRegistrationRequest getInventionRegistrationRequest() {
		return inventionRegistrationRequest;
	}

	public void setInventionRegistrationRequest(InventionRegistrationRequest inventionRegistrationRequest) {
		this.inventionRegistrationRequest = inventionRegistrationRequest;
	}

}
