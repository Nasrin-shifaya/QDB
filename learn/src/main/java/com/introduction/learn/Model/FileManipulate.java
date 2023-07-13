package com.introduction.learn.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class FileManipulate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fileId;
	private String fileName;
	@Lob
	private byte[] data;
	@OneToOne(mappedBy = "file")
	private Post post;
	
	public FileManipulate()
	{
		
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public FileManipulate(int fileId, String fileName) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public FileManipulate(int fileId, String fileName, byte[] data) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.data = data;
	}
	public FileManipulate(String fileName, byte[] data) {
		super();
		
		this.fileName = fileName;
		this.data = data;
	}
	
}
