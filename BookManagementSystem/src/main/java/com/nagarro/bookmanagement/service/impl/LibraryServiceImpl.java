package com.nagarro.bookmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.bookmanagement.service.LibraryService;
import com.nagarro.bookmanagementsystem.dao.LibrarianDao;
import com.nagarro.bookmanagementsystem.entities.UserEntity;

@Service("libraryService")
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LibrarianDao usrDao;

	@Override
	public UserEntity getLibraryUser(String libraryUname) {
		
		return usrDao.get(libraryUname);
	}

	@Override
	public void insert(UserEntity user) {
		usrDao.insert(user);
	}
	

}
