package logic.invention.operation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import db.BaseEntity;

@Entity
public class Change extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "changeId")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
