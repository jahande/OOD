package logic.invention;

import utilities.db.BaseEntity;
import logic.member.User;

public class Share extends BaseEntity<Integer> {
	private Integer id;
	private User user;
	private Invention invention;
	private int shareValue;

	public Share(User user, Invention invention, int shareValue) {
		super();
		this.user = user;
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
