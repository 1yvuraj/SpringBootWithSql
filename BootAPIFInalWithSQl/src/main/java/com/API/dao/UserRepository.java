package com.API.dao;

import org.springframework.data.repository.CrudRepository;

import com.API.Entity.Book;

public interface UserRepository  extends CrudRepository<Book,Integer>{
  public Book findById(int id);
}
