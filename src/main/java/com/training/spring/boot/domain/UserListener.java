/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.domain
 * FileName: UserListener.java
 * Author : huu.tra
 */
package com.training.spring.boot.domain;

import org.hibernate.envers.RevisionListener;

/**
 * @author huu.tra
 *
 */
public class UserListener implements RevisionListener{

	/* (non-Javadoc)
	 * @see org.hibernate.envers.RevisionListener#newRevision(java.lang.Object)
	 */
	@Override
	public void newRevision(Object revisionEntity) {
		// TODO Auto-generated method stub
		
	}

}
