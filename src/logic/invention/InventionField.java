package logic.invention;

import db.BaseEntity;

public class InventionField extends BaseEntity<Integer> {
	private Integer id;
	private String name;

	public InventionField() {
	}

	public InventionField(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
