package invregsystem.logic.invention.operation;

import invregsystem.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "changes")
public class Change extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "changeId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "inventionLogId")
	private InventionLog inventionLog;

	@Column(name = "attributeName")
	private String attributeName;

	@Column(name = "oldValue")
	private String oldValue;

	@Column(name = "newValue")
	private String newValue;

	public Change() {
	}

	public Change(String attributeName, String oldValue, String newValue) {
		super();
		this.attributeName = attributeName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public InventionLog getInventionLog() {
		return inventionLog;
	}

	public void setInventionLog(InventionLog inventionLog) {
		this.inventionLog = inventionLog;
	}
}
