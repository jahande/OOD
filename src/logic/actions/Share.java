package logic.actions;

import logic.invention.Invention;
import logic.member.User;

public class Share {
	private User user;
	private Invention invention;
	private int shareValue;

	public Share(User user, Invention invention, int shareValue) {
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
