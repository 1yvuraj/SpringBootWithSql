package com.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import com.API.Entity.Book;
import com.API.dao.UserRepository;

@Component

public class BookService {
	@Autowired
	private UserRepository Repository;
		public BookService(UserRepository Repository) {
			super();
			this.Repository = Repository;
		}
		//all book
		public List<Book> getAllBooks(){
			List<Book>list=(List<Book>)this.Repository.findAll();
			return list;
		}
		
		//single id
		
		public  Book getBookById(int id) {
			
			Book book=this.Repository.findById(id);
			return book;
			
			
		}
		
		//create
		public  Book createBook(Book book){
			Book result=this.Repository.save(book);
			return result;
			
		}
		
		
		
		//delete book
		public  void deleteBook(int id){
			
			this.Repository.deleteById(id);
			
			
			
			
		}
		//update
		public  void updateBook(Book book ,int id){
			
			book.setId(id);
			this.Repository.save(book);
			
			
			
		}
}
