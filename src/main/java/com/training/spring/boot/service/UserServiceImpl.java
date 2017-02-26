/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.service
 * FileName: UserServiceImpl.java
 * Author : huu.tra
 */
package com.training.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.boot.dao.UserDAO;
import com.training.spring.boot.domain.User;

/**
 * @author huu.tra
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDAO userDao;
	
	@Override
	public List<String> getList() {
		List<User> users = userDao.getList();
		List<String> result = new ArrayList<String>(users.size());
		for (User user : users){
			String name = user.getFirstName() + " " + user.getLastName();
			result.add(name);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.training.spring.boot.service.UserService#saveUser(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean saveUser(String firstName, String lastName, String address) {
		User user = userDao.getUser(firstName, lastName);
			
		try {
			if (user != null) {
				userDao.update(firstName, lastName, address);
			}else{
				userDao.create(firstName, lastName, address);
			}
			return Boolean.TRUE;
		} catch (Exception e) {
			LOG.error("Error create user", e);
		}
		return Boolean.FALSE;
	}

}
