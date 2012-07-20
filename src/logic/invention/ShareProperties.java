package logic.invention;

import logic.member.User;

public class ShareProperties {
	private User user;
	private Invention invention;
	private int shareValue;

	public ShareProperties(User user, Invention invention, int shareValue) {
		super();
		this.user = user;
		this.invention = invention;
		this.shareValue = shareValue;
	}

	public User getUser() {
		return user;
	}

	public Invention getInvention() {
		return invention;
	}

	public int getShareValue() {
		return shareValue;
	}

}
