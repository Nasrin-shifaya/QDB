package com.introduction.learn.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import com.introduction.learn.Repository.FileRepository;
import com.example.demo.globalexception.NotFoundException;
import com.introduction.learn.Model.Comments;
import com.introduction.learn.Model.CommentsAPI;
import com.introduction.learn.Model.FileManipulate;
import com.introduction.learn.Model.Post;
import com.introduction.learn.Model.PostAPI;
import com.introduction.learn.Repository.CommentRepository;
import com.introduction.learn.Repository.PostRepository;


@Service
public class PractiseService {
	
	@Autowired
	FileRepository filerepo;
	@Autowired
	PostRepository postrepo;
	@Autowired
	CommentRepository commentrepo;
	

	@Autowired
    RestTemplate template = new RestTemplate();
	String Base_url = "https://jsonplaceholder.typicode.com";
    
	  public FileManipulate fileUpload(MultipartFile file ) throws IOException
	  {
		  String fileName = file.getOriginalFilename();
		    
		    	FileManipulate filedb = new FileManipulate(fileName, file.getBytes());
		    return	filerepo.save(filedb);
		  }
	  public FileManipulate getFile(int id) {
			// TODO Auto-generated method stub
			return filerepo.findById(id).get();
		}
		public ResponseEntity<?> fileDownload(int id) {
			
			FileManipulate filedb = filerepo.findById(id).get();
			byte[] data = filedb.getData();
			
		        String contentType = "application/octet-stream";
		   
		              
		        return ResponseEntity.ok()
		                .contentType(MediaType.parseMediaType(contentType))
		                 .body(new ByteArrayResource(data));
		         
		}
		public List<String> getAllFiles() {
			List<FileManipulate> fb = new ArrayList<FileManipulate>();
			List<String> getFiles = new ArrayList<String>();
			filerepo.findAll().forEach(temp -> fb.add(temp));
			for (FileManipulate fileManipulate: fb) {
				getFiles.add(fileManipulate.getFileName());
			}
			return getFiles;
		}
		public void removeById(int id) {
			filerepo.deleteById(id);			
		}
	
		//uploadPost
		public Post postUpload(Post post) {
		
		return postrepo.save(post);
		}
		
		
		//getAllPosts
		public List<Post> getAllPosts() {
			List<Post> post = new ArrayList<>();
			postrepo.findAll().forEach(temp ->post.add(temp));
			return post;
		}
		//getAllpostsUsing third party API
		public PostAPI[] getAllPostsUsingAPI() {
			
			//List<PostAPI> postApi = new ArrayList<>();
			PostAPI[] object = template.getForObject(Base_url + "/posts/", PostAPI[].class);
			return object;
		}
		
		
		//getPostById
		public Post getPostByPostId(int postId) {
			Post post = postrepo.findById(postId).get();
			
			if(null == post) {
				throw new NotFoundException("Post not found", HttpStatus.NOT_FOUND);
			}
			
			return post;
		}
		
		//getPostById using third party API
				public PostAPI getPostByPostIdUsingAPI(int postId) {
					String uri = Base_url+ "/posts/" + postId;
					 PostAPI postApi = template.getForObject(uri, PostAPI.class);
					return postApi;
				}
				
		
		
		  
		//deleteById
		public void deleteByPostId(int postId) {
			 postrepo.deleteById(postId);
			
		}
		//deleteById Using third party API
				public void deleteByPostIdUsingAPI(int postId) {
					String uri = Base_url+ "/posts/" + postId;
					  template.delete(uri);
				
					
				}
		
		//deleteAll
		public String deleteAllPosts() {
			postrepo.deleteAll();
			return "Deleted All Posts";
		}
		//deleteAllusing third party API
				public String deleteAllPostsusingAPI() {
					String uri = Base_url +"/posts/";
					  template.delete(uri);
					  return "Deleted All Posts";
				}
		
		//CommentsAPIService
		public Comments commentsUpload(Comments comments) {
			return commentrepo.save(comments);
		}
		public List<Comments> getAllComments() {
			List<Comments> commentslist = new ArrayList<Comments>();
			commentrepo.findAll().forEach(temp -> commentslist.add(temp));
			return commentslist;
		}
		public void deleteByCommentId(int commentId) {
			commentrepo.deleteById(commentId);
			
		}
		public String deleteAllComments() {
			commentrepo.deleteAll();
			return "Deleted All Comments";
		}
		public CommentsAPI[] getAllCommentsUsingAPI() {
			CommentsAPI[] object = template.getForObject(Base_url + "/comments/", CommentsAPI[].class);
			return object;
			
		}
		public CommentsAPI getCommentsByCommentIdUsingAPI(int id) {
			String uri = Base_url+ "/comments/" + id;
			CommentsAPI commentsAPI = template.getForObject(uri, CommentsAPI.class);
			return commentsAPI;
		}
	
}