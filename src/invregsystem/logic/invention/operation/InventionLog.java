package invregsystem.logic.invention.operation;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import interfaces.AbstractInvention;
import interfaces.AbstractUser;
import invregsystem.db.BaseEntity;
import invregsystem.db.ChangeDao;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.member.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InventionLog extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "inventionLogId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "inventionId")
	private Invention invention;

	@ManyToOne
	@JoinColumn(name = "editorUser")
	private User editorUser;

	@Column(name = "changeDate")
	private Date changeDate;

	@Column(name = "comment")
	private String comment;

	public InventionLog() {
	}

	public InventionLog(AbstractInvention invention, AbstractUser editorUser, Date changeDate, String comment) {
		super();
		this.invention = (Invention) invention;
		this.editorUser = (User) editorUser;
		this.changeDate = changeDate;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public Invention getInvention() {
		return invention;
	}

	public void setInvention(Invention invention) {
		this.invention = invention;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getEditorUser() {
		return editorUser;
	}

	public void setEditorUser(User editorUser) {
		this.editorUser = editorUser;
	}

	public AbstractInvention getInventionVersion() {
		AbstractInvention versionInstance = new Invention();
		InventionLogCatalog inventionLogCatalog = InventionLogCatalog.getInstance();
		List<InventionLog> previousLogs = inventionLogCatalog.getItemsBeforeDate(this.changeDate);
		ListIterator<InventionLog> li = previousLogs.listIterator(previousLogs.size());
		while (li.hasPrevious()) { // Iterate reversely.
			InventionLog log = li.previous();
			if (versionInstance.getTotalSpec() == null) {
				String newValue = log.getNewValueOfAttribute("totalSpec");
				if (newValue != null)
					versionInstance.setTotalSpec(newValue);
			}
			if (versionInstance.getSummary() == null) {
				String newValue = log.getNewValueOfAttribute("summary");
				if (newValue != null)
					versionInstance.setSummary(newValue);
			}
			if (versionInstance.getIdeaDescription() == null) {
				String newValue = log.getNewValueOfAttribute("ideaDescription");
				if (newValue != null)
					versionInstance.setIdeaDescription(newValue);
			}
			if (versionInstance.getIdeaHistory() == null) {
				String newValue = log.getNewValueOfAttribute("ideaHistory");
				if (newValue != null)
					versionInstance.setIdeaHistory(newValue);
			}
			if (versionInstance.getClaim() == null) {
				String newValue = log.getNewValueOfAttribute("claim");
				if (newValue != null)
					versionInstance.setClaim(newValue);
			}
			if (versionInstance.getExplanation() == null) {
				String newValue = log.getNewValueOfAttribute("explanation");
				if (newValue != null)
					versionInstance.setExplanation(newValue);
			}
			if (versionInstance.getFile1() == null) {
				String newValue = log.getNewValueOfAttribute("file1");
				if (newValue != null)
					versionInstance.setFile1(newValue);
			}
			if (versionInstance.getFile2() == null) {
				String newValue = log.getNewValueOfAttribute("file2");
				if (newValue != null)
					versionInstance.setFile2(newValue);
			}
			if (versionInstance.getFile3() == null) {
				String newValue = log.getNewValueOfAttribute("file3");
				if (newValue != null)
					versionInstance.setFile3(newValue);
			}
		}
		if (versionInstance.getTotalSpec() == null)
			versionInstance.setTotalSpec(this.invention.getTotalSpec());
		if (versionInstance.getSummary() == null)
			versionInstance.setSummary(this.invention.getSummary());
		if (versionInstance.getIdeaDescription() == null)
			versionInstance.setIdeaDescription(this.invention.getIdeaDescription());
		if (versionInstance.getIdeaHistory() == null)
			versionInstance.setIdeaHistory(this.invention.getIdeaHistory());
		if (versionInstance.getClaim() == null)
			versionInstance.setClaim(this.invention.getClaim());
		if (versionInstance.getExplanation() == null)
			versionInstance.setExplanation(this.invention.getExplanation());
		if (versionInstance.getFile1() == null)
			versionInstance.setFile1(this.invention.getFile1());
		if (versionInstance.getFile2() == null)
			versionInstance.setFile2(this.invention.getFile2());
		if (versionInstance.getFile3() == null)
			versionInstance.setFile3(this.invention.getFile3());

		return versionInstance;
	}

	private String getNewValueOfAttribute(String attrName) {
		InventionLogCatalog inventionLogCatalog = InventionLogCatalog.getInstance();
		List<Change> changes = inventionLogCatalog.getChangesByInventionLog(this);
		for (Change change : changes) {
			if (change.getAttributeName().equals(attrName)) {
				return change.getNewValue();
			}
		}
		return null;
	}
}
