package com.introduction.learn.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class PostAPI {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private int id;
	private String title;
	private String body;
	
	@OneToOne
	@JoinColumn(name = "fk_file_id")
	private FileManipulate file;
	@OneToMany(mappedBy = "postApi", cascade = {CascadeType.ALL})
	private List<CommentsAPI> commentsApi;
	public PostAPI() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public PostAPI(int userId, int id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
