package com.introduction.learn.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class CommentsAPI {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	private int id;
	private String name;
	private String email;
	private String body;
	@ManyToOne
	private PostAPI postApi;
	public CommentsAPI()
	{
		
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public PostAPI getPostApi() {
		return postApi;
	}
	public void setPostApi(PostAPI postApi) {
		this.postApi = postApi;
	}
	public CommentsAPI(int postId, int id, String name, String email, String body, PostAPI postApi) {
		super();
		this.postId = postId;
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
		this.postApi = postApi;
	}
}
