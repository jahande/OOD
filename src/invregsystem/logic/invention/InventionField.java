package invregsystem.logic.invention;

import invregsystem.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class InventionField extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "inventionFieldId")
	private Integer id;

	@Column(name = "name")
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
