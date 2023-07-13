package com.introduction.learn.Repository;

import org.springframework.data.repository.CrudRepository;

import com.introduction.learn.Model.Comments;

public interface CommentRepository extends CrudRepository<Comments,Integer>{

}
