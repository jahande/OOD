package invregsystem.logic.invention;

import invregsystem.AbstractInvention;
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
	@JoinColumn(name = "invention1", nullable = false)
	private Invention invention1;

	@ManyToOne
	@JoinColumn(name = "invention2", nullable = false)
	private Invention invention2;

	@Column(name = "type", nullable = false)
	private String type;

	public final static String CONTINUE = "ادامه";
	public final static String RELATED = "مرتبط";
	public final static String REFORMED = "اصلاح";
	public final static String SUBSET = "زیرمجموعه";

	public InventionRelation() {

	}

	public InventionRelation(AbstractInvention invention1, AbstractInvention invention2, String type) {
		super();
		this.invention1 = (Invention) invention1;
		this.invention2 = (Invention) invention2;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
