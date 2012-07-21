package logic.invention;

import utilities.db.BaseEntity;

public class Change extends BaseEntity<Integer> {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
