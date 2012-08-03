package invregsystem.logic.invention;

import invregsystem.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InventionRelation extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "inventionRelationId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "invention1")
	private Invention invention1;

	@ManyToOne
	@JoinColumn(name = "invention2")
	private Invention invention2;

	@Column(name = "type")
	private String title;

	public InventionRelation() {

	}

	public InventionRelation(Invention invention1, Invention invention2, String title) {
		super();
		this.invention1 = invention1;
		this.invention2 = invention2;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Invention getInvention1() {
		return invention1;
	}

	public void setInvention1(Invention invention1) {
		this.invention1 = invention1;
	}

	public Invention getInvention2() {
		return invention2;
	}

	public void setInvention2(Invention invention2) {
		this.invention2 = invention2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
