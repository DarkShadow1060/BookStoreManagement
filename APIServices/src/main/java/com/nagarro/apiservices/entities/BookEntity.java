package com.nagarro.apiservices.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class BookEntity.
 */
@Entity
public class BookEntity {
	
	
	

	@Override
	public String toString() {
		return "BookEntity [bookCode=" + bookCode + ", bookName=" + bookName + ", authorName=" + authorName
				+  "]";
	}

	/** The book code. */
	@Id
	private String bookCode;
	
	/** The book name. */
	@Column
	private String bookName;
	
	/** The author name. */
	@Column
	private String authorName;
	
	/** The current date. */
//	
	private String currDate ;
//	
	/**
	 * Gets the book code.
	 *
	 * @return the bookCode
	 */
	public String getBookCode() {
		return bookCode;
	}
	
	/**
	 * Sets the book code.
	 *
	 * @param string the bookCode to set
	 */
	public void setBookCode(String code) {
		this.bookCode = code;
	}
	
	/**
	 * Gets the book name.
	 *
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	
	/**
	 * Sets the book name.
	 *
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	/**
	 * Gets the author name.
	 *
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	
	/**
	 * Sets the author name.
	 *
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCurrDate() {
		return currDate;
	}

	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}
}
