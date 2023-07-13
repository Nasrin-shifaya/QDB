package com.introduction.learn.Repository;

import org.springframework.data.repository.CrudRepository;

import com.introduction.learn.Model.FileManipulate;



public interface FileRepository extends CrudRepository<FileManipulate,Integer>{

}
