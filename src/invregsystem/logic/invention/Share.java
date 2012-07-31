package invregsystem.logic.invention;

import interfaces.AbstractUser;
import invregsystem.db.BaseEntity;
import invregsystem.logic.member.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Share extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "shareId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "inventionId")
	private Invention invention;

	@Column(name = "shareValue")
	private int shareValue;

	public Share() {

	}

	public Share(AbstractUser user, Invention invention, int shareValue) {
		super();
		this.user = (User) user;
		this.invention = invention;
		this.shareValue = shareValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setInvention(Invention invention) {
		this.invention = invention;
	}

	public void setShareValue(int shareValue) {
		this.shareValue = shareValue;
	}

	public Invention getInvention() {
		return invention;
	}

	public int getShareValue() {
		return shareValue;
	}

}
