package com.API.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.API.Entity.Book;


@Component
@RestController
public class BookControllers {

	@Autowired
	private BookService bookService;
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book>list=bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBooks(@PathVariable("id") int id) {
		Book b=null;
		try {
			b=this.bookService.getBookById(id);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	//create
	
	@PostMapping("/addBook")
	//@RequestBody ->vo sara data jo json me a rha hoga vo is book me a jaye ga
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b=null;
		try {
			b=this.bookService.createBook(book);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//Delete
	@DeleteMapping("/deleteBook/{id}")
	//@RequestBody ->vo sara data jo json me a rha hoga vo is book me a jaye ga
	public ResponseEntity<Object> deleteBook(@PathVariable("id") int id) {
		
		try {
		   this.bookService.deleteBook(id);
			return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//update
	@PutMapping("/updateBook/{id}")
	//@RequestBody ->vo sara data jo json me a rha hoga vo is book me a jaye ga
	public ResponseEntity<Object> updateBook(@RequestBody Book book,@PathVariable("id") int id) {
		
		try {
			this.bookService.updateBook(book,id);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}