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
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	private String post;
	private int fileId;
	@OneToOne
	@JoinColumn(name = "fk_file_id")
	private FileManipulate file;
	@OneToMany(mappedBy = "post", cascade = {CascadeType.ALL})
	private List<Comments> comments;
	
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Post(int postId, String post,int fileId) {
		super();
		this.postId = postId;
		this.post = post;
		this.fileId = fileId;
	}
	public Post()
	{
		
	}
}
