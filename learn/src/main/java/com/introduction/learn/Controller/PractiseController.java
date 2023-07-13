package com.introduction.learn.Controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.introduction.learn.Model.Comments;
import com.introduction.learn.Model.CommentsAPI;
import com.introduction.learn.Model.FileManipulate;
import com.introduction.learn.Model.Post;
import com.introduction.learn.Model.PostAPI;
import com.introduction.learn.Service.PractiseService;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@RestController
public class PractiseController {

	@Autowired
	PractiseService service;
	
	//mapping starts
	@PostMapping("/upload")
	  public FileManipulate fileUpload(@RequestBody MultipartFile file ) throws IOException {
		 //String fileName = System.getProperty("user.dir") + "/Uploads" + File.separator + file.getOriginalFilename();
	 
		return service.fileUpload(file);
	 
}
	 @GetMapping(value = "/download/{id}")
	    public ResponseEntity downloadFile(@PathVariable("id") int id) throws FileNotFoundException {
		 return service.fileDownload(id);
	        // Checking whether the file requested for download exists or not
	                                                                                                       
	    }
	 
	 @GetMapping(value = "/getFiles")
	    public List<String> getFiles()
	    {
		return service.getAllFiles();
	       
	         
	    }
	 @GetMapping("/getFile/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable int id) {
	    FileManipulate fileDB = service.getFile(id);
	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFileName() + "\"")
	            .body(fileDB.getData());
	  }
	  
	    @GetMapping("/remove/{id}")
	    public void removeById(@PathVariable int id) {
			 service.removeById(id);
	}
	  
	  // Post manipulation
	  @PostMapping("/postupload") 
	  public Post postUpload(@RequestBody Post post ) throws IOException {
		 //String fileName = System.getProperty("user.dir") + "/Uploads" + File.separator + file.getOriginalFilename();
	 
		return service.postUpload(post);
		
}
	  
	    @GetMapping("/getPosts")
		public List<Post> getAllPosts() {
			return service.getAllPosts();
		}
	    @GetMapping("/getAllPostsAPI")
	    public PostAPI[] getAllPostsUsingAPI() {
	        return service.getAllPostsUsingAPI();
	    }
	    
	    @GetMapping("/getPostAPI/{id}")
	    public PostAPI getPostByPostIdUsingAPI(@PathVariable int id) {
	        return service.getPostByPostIdUsingAPI(id);
	    }
	    @GetMapping("/deletePost/{id}")
	    public void deleteByPostId(@PathVariable int postId) {
			 service.deleteByPostId(postId);
	}
	    
	  
	  //deleteAll
	    @GetMapping("/deleteAllPosts")
	  		public String deleteAllPosts() {
	  		return	service.deleteAllPosts();
	  			
	  		}
	  	
	  		
	  		//Comments 
	  		
	  		@PostMapping("/commentsupload") 
	  	  public Comments commentsUpload(@RequestBody Comments comments ) throws IOException {
	  		
	  	 
	  		return service.commentsUpload(comments);
	  		
	  }
	  	  
	  	    @GetMapping("/getComments")
	  		public List<Comments> getAllComments() {
	  			return service.getAllComments();
	  		}
	  	    
	  	    @GetMapping("/deleteComment/{id}")
	  	    public void deleteByCommentId(@PathVariable int commentId) {
	  			 service.deleteByCommentId(commentId);
	  	}

	  	  //deleteAll
	  	  		public String deleteAllComments() {
	  	  		return	service.deleteAllComments();
	  	  			
	  	  		}
	  	  		
	  	  		//CommentsAPI
	  	  	 @GetMapping("/getAllCommentsAPI")
	 	    public CommentsAPI[] getAllCommentsUsingAPI() {
	 	        return service.getAllCommentsUsingAPI();
	 	    }
	  	  	 @GetMapping("/getCommentsAPI/{id}")
	 	    public CommentsAPI getCommentsByCommentIdUsingAPI(@PathVariable int id) {
	 	        return service.getCommentsByCommentIdUsingAPI(id);
	 	    }
	  	
}
	
