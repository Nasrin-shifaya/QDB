package com.introduction.learn.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentsId;
	private int postId;
	private String comment;
	@ManyToOne
	private Post post;
	
	
	public int getCommentsId() {
		return commentsId;
	}
	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Comments(int commentsId, int postId, String comment) {
		super();
		this.commentsId = commentsId;
		this.postId = postId;
		this.comment = comment;
	}
 public Comments() {
		
	}
}
