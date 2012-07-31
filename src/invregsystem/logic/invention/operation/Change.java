package invregsystem.logic.invention.operation;

import invregsystem.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
