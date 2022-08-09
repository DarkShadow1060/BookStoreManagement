package com.nagarro.bookmanagementsystem.dao;

import com.nagarro.bookmanagementsystem.entities.UserEntity;

/**
 * The Interface LibrarianDao.
 */
public interface LibrarianDao {
	
	/**
	 * Insert.
	 *
	 * @param usr the usr
	 */
	public void insert(UserEntity usr);
	
	/**
	 * Gets the.
	 *
	 * @param uname the uname
	 * @return the user entity
	 */
	public UserEntity get(String uname);
}
