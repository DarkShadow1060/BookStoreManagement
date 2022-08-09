package com.nagarro.bookmanagement.service;

import com.nagarro.bookmanagementsystem.entities.UserEntity;

/**
 * The Interface LibraryService.
 */
public interface LibraryService {
	 
 	/**
 	 * Gets the library user.
 	 *
 	 * @param libraryUname the library uname
 	 * @return the library user
 	 */
 	UserEntity getLibraryUser(String libraryUname);
	 
	 
 	/**
 	 * Insert.
 	 *
 	 * @param user the user
 	 */
 	void insert(UserEntity user);
}

