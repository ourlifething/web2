package model;

import java.io.Serializable;

public class Movie implements Serializable{
	private String userName;
	private String title;
	private String comment;
	
	public Movie() {}
	public Movie(String userName, String title, String comment) {
		this.userName = userName;
		this.title = title;
		this.comment = comment;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	};
	
	
}
