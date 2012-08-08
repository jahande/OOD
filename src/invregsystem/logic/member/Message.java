package invregsystem.logic.member;

import java.util.Date;

import interfaces.AbstractUser;
import invregsystem.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message extends BaseEntity<Integer> {

	@Id
	@GeneratedValue
	@Column(name = "messageId")
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "sendDate", nullable = false)
	private Date sendDate;

	@ManyToOne
	@JoinColumn(name = "toId", nullable = false)
	private User to;

	public Message() {

	}

	public Message(String title, String content, AbstractUser to) {
		super();
		this.title = title;
		this.content = content;
		this.sendDate = new Date();
		this.to = (User) to;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

}
