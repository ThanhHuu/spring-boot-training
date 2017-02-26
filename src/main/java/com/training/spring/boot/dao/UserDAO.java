/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.dao
 * FileName: UserDAO.java
 * Author : huu.tra
 */
package com.training.spring.boot.dao;

import java.util.List;

import com.training.spring.boot.domain.User;

/**
 * @author huu.tra
 *
 */
public interface UserDAO{
	/**
	 * 
	 * @return
	 */
	List<User> getList();
	
	User getUser(String firstName, String lastName);
	
	void create(String firstName, String lastName, String address);

	void update(String firstName, String lastName, String address);
}
