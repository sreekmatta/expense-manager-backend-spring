package com.expensegator.demo.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.expensegator.demo.utils.FriendRequestStatus;

@Table(name = "friend_request")
@Entity
public class FriendRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User sentFrom;
	@ManyToOne
	private User sentTo;
	
	@Enumerated(EnumType.STRING)
	private FriendRequestStatus status;
	
	public int getId() {
		return id;
	}

	public User getSentFrom() {
		return sentFrom;
	}
	public void setSentFrom(User sentFrom) {
		this.sentFrom = sentFrom;
	}
	public User getSentTo() {
		return sentTo;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setSentTo(User sentTo) {
		this.sentTo = sentTo;
	}
	public FriendRequestStatus getStatus() {
		return status;
	}
	public void setStatus(FriendRequestStatus status) {
		this.status = status;
	}

}
