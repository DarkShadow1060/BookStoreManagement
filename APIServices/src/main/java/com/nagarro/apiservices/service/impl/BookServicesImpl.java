/**
 * 
 */
package com.nagarro.apiservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.apiservices.entities.BookEntity;
import com.nagarro.apiservices.repositories.UserRepository;
import com.nagarro.apiservices.service.BookServices;

/**
 * @author heramb
 *
 */
@Service("bookService")
public class BookServicesImpl implements BookServices {
	@Autowired
	UserRepository userRepository;
	@Override
	public boolean insertBooksInfo(BookEntity bookEntity) {
		if(getBookbyID(bookEntity.getBookCode()) != null) {
			return false;
		}
		else {
			userRepository.save(bookEntity);
			return true;
		}
	}

	@Override
	public void updateBooksInfo(BookEntity bookEntity) {
		userRepository.save(bookEntity);
	}

	@Override
	public void deleteBookInfo(BookEntity bookEntity) {
		userRepository.delete(bookEntity);
	}

	@Override
	public List<BookEntity> getBookInfo() {
		return userRepository.findAll();
	}

	@Override
	public BookEntity getBookbyID(String id) {
		
		Optional<BookEntity> option = userRepository.findById(id);
		if(option.isPresent()) {
			return option.get();			
		}
		else
			return null;
	}

	@Override
	public BookEntity updateBooksInfoById(BookEntity book, String id) {
		BookEntity bkinfo = getBookbyID(id);

			bkinfo.setAuthorName(book.getAuthorName());
			bkinfo.setBookName(book.getBookName());
			userRepository.save(bkinfo);
			return bkinfo;
	}

	@Override
	public String deleteBook(String id) {
		BookEntity bk = getBookbyID(id);
		if(bk!=null) {
			userRepository.deleteById(id);
			return "true";
		}
		else {
			return "false";
		}
		
	}

	

}
