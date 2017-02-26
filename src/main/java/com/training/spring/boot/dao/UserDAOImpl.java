/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.dao
 * FileName: UserDAOImpl.java
 * Author : huu.tra
 */
package com.training.spring.boot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.training.spring.boot.domain.User;

/**
 * @author huu.tra
 *
 */
@Repository
public class UserDAOImpl implements UserDAO{

	@PersistenceContext
	private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.training.spring.boot.dao.UserDAO#getList()
	 */
	@Override
	public List<User> getList() {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM user AS u", User.class);
		return query.getResultList();
	}
	/* (non-Javadoc)
	 * @see com.training.spring.boot.dao.UserDAO#create(java.lang.String, java.lang.String)
	 */
	@Override
	public void create(String firstName, String lastName, String address) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		entityManager.persist(user);
	}
	/* (non-Javadoc)
	 * @see com.training.spring.boot.dao.UserDAO#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String firstName, String lastName) {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM user AS u WHERE u.firstName LIKE :firstName AND u.lastName LIKE :lastName", User.class);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		List<User> users = query.getResultList();
		Assert.isTrue(users.size() <= 1, "We found out duplicate user");
		return users.size() == 1 ? users.get(0) : null;
	}
	/* (non-Javadoc)
	 * @see com.training.spring.boot.dao.UserDAO#update(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void update(String firstName, String lastName, String address) {
		User user = getUser(firstName, lastName);
		user.setAddress(address);
		entityManager.merge(user);
	}

}
