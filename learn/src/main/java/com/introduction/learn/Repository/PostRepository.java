package com.introduction.learn.Repository;

import org.springframework.data.repository.CrudRepository;

import com.introduction.learn.Model.Post;

public interface PostRepository extends CrudRepository<Post,Integer> {

}
