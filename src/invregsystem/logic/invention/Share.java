package invregsystem.logic.invention;

import interfaces.AbstractInvention;
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
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "inventionId", nullable = false)
	private Invention invention;

	@Column(name = "shareValue", nullable = false)
	private int shareValue;

	@Column(name = "isRequester", nullable = false)
	private boolean isRequester;

	public Share() {

	}

	public Share(AbstractUser user, AbstractInvention invention, int shareValue, boolean isRequester) {
		super();
		this.user = (User) user;
		this.invention = (Invention) invention;
		this.shareValue = shareValue;
		this.isRequester = isRequester;
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

	public boolean isRequester() {
		return isRequester;
	}

	public void setRequester(boolean isRequester) {
		this.isRequester = isRequester;
	}

}
