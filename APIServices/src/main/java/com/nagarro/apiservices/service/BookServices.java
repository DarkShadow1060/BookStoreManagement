package com.nagarro.apiservices.service;

import java.util.List;

import com.nagarro.apiservices.entities.BookEntity;

/**
 * The Interface BookServices.
 */
public interface BookServices {
	
	/**
	 * Insert books info.
	 *
	 * @param bookEntity the book entity
	 * @return 
	 */
	boolean insertBooksInfo(BookEntity bookEntity);
	
	/**
	 * Update books info.
	 *
	 * @param bookENtity the book Entity
	 */
	void updateBooksInfo(BookEntity bookENtity);
	
	BookEntity updateBooksInfoById(BookEntity book,String id);
	
	/**
	 * Delete book info.
	 *
	 * @param bookEntity the book entity
	 */
	void deleteBookInfo(BookEntity bookEntity);
	
	/**
	 * Gets the book info.
	 *
	 * @return the book info
	 */
	List<BookEntity> getBookInfo();
	
	BookEntity getBookbyID(String id);
	
	String deleteBook(String id) ;
}
