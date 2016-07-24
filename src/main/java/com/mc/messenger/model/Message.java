package com.mc.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Message {
	private long id;
	private Date created;
	private String message, author;

	public Message() {
	}

	public Message(long id, String message, String author) {
		super();
		this.id = id;
		this.created = new Date();
		this.message = message;
		this.author = author;
	}

	//@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//@XmlElement
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	//@XmlElement
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//@XmlElement
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
