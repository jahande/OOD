package invregsystem.logic.invention.operation;

import java.util.Date;
import java.util.Set;

import interfaces.AbstractInvention;
import invregsystem.db.BaseEntity;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.Share;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InventionLog extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "inventionLogId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "inventionId")
	private Invention invention;

	@Column(name = "changeDate")
	private Date changeDate;

	@Column(name = "comment")
	private String comment;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventionLog")
//	private Set<Change> changes;

	public InventionLog() {
	}

	public InventionLog(AbstractInvention invention, Date changeDate, String comment) {
		super();
		this.invention = (Invention) invention;
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

	// public Set<Change> getChanges() {
	// return changes;
	// }
	//
	// public void setChanges(Set<Change> changes) {
	// this.changes = changes;
	// }

}
