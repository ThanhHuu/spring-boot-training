/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.service
 * FileName: UserLogImpl.java
 * Author : huu.tra
 */
package com.training.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.boot.dao.UserDAO;
import com.training.spring.boot.domain.User;

/**
 * @author huu.tra
 *
 */
@Service
public class UserLogImpl implements UserLog{
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UserDAO userDao;
	
	private AuditReader getAuditReader(){
		return AuditReaderFactory.get(em);
	}

	/* (non-Javadoc)
	 * @see com.training.spring.boot.service.UserLog#getListLog(java.lang.String, java.lang.String)
	 */
	@Override
	public List<User> getListLog(String firstName, String lastName) {
		User user = userDao.getUser(firstName, lastName);
		if (user != null){
			AuditReader auditReader = getAuditReader();
			List<Number> revisions = auditReader.getRevisions(User.class, user.getId());
			List<User> result = new ArrayList<User>();
			for (Number revision : revisions){
				User userRev = auditReader.find(User.class, user.getId(), revision);
				result.add(userRev);
			} 
			return result;
		}
		return new ArrayList<User>();
	}
}
