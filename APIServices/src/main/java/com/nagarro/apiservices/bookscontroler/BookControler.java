package com.nagarro.apiservices.bookscontroler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.apiservices.entities.BookEntity;
import com.nagarro.apiservices.service.BookServices;

@RestController
@RequestMapping("/bookmanagement")
public class BookControler {

	@Autowired
	BookServices bookService;
	// get book details using id
	@GetMapping("{id}")
	public ResponseEntity<BookEntity> getBookbyId(@PathVariable("id") String id){
		return new ResponseEntity<>(bookService.getBookbyID(id),HttpStatus.OK);	
	}
	// get all book details
	@GetMapping
	public List<BookEntity> getBooks() {
		// return list of books
		return bookService.getBookInfo();
	}
	//add book details using rest api
	@PostMapping( consumes = "application/json")
	public BookEntity addBookDetils(@RequestBody BookEntity book) {
		boolean b1= bookService.insertBooksInfo(book);
		if(b1) {
			return book;			
		}
		else {
			return null;
		}
	}
	// update by id 
	@PutMapping("{id}")
	public ResponseEntity<BookEntity> updateEmploye(@PathVariable("id") String id,@RequestBody BookEntity book){
		return new ResponseEntity<> (bookService.updateBooksInfoById(book, id),HttpStatus.OK);
	}
	//delete
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") String id){
		if(bookService.deleteBook(id).equals("true")) {
			return new ResponseEntity<>("deleted",HttpStatus.OK);		
		}
		else {
			return new ResponseEntity<>("no such element found",HttpStatus.BAD_REQUEST);
		}
	}
	
}
