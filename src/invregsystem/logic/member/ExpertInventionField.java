package invregsystem.logic.member;

import invregsystem.db.BaseEntity;
import invregsystem.logic.invention.InventionField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class ExpertInventionField extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "expertInventionFieldId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "expertId")
	private User expert;

	@ManyToOne
	@JoinColumn(name = "inventionFieldId")
	private InventionField inventionField;

	public ExpertInventionField() {

	}

	public ExpertInventionField(User expert, InventionField inventionField) {
		super();
		this.expert = expert;
		this.inventionField = inventionField;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getExpert() {
		return expert;
	}

	public void setExpert(User expert) {
		this.expert = expert;
	}

	public InventionField getInventionField() {
		return inventionField;
	}

	public void setInventionField(InventionField inventionField) {
		this.inventionField = inventionField;
	}

}
