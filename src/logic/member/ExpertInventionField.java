package logic.member;

import utilities.db.BaseEntity;

import logic.invention.InventionField;

public class ExpertInventionField extends BaseEntity<Integer> {

	private Integer id;
	private User expert;
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
