package invregsystem.logic.invention.operation;

import invregsystem.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class InventionLog extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "inventionLogId")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
