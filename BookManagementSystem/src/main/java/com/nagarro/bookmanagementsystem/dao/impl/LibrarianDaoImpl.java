package com.nagarro.bookmanagementsystem.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.bookmanagementsystem.dao.LibrarianDao;
import com.nagarro.bookmanagementsystem.entities.UserEntity;


@Repository("usrDao")
public class LibrarianDaoImpl implements LibrarianDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Transactional
	@Override
	public void insert(UserEntity usr) {
		 hibernateTemplate.save(usr);
	}
	@Transactional
	@Override
	public UserEntity get(String uname) {
		return hibernateTemplate.get(UserEntity.class, uname);
	}
}
