/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.service
 * FileName: AppServiceImpl.java
 * Author : huu.tra
 */
package com.training.spring.boot.service;

import org.springframework.stereotype.Service;

/**
 * @author huu.tra
 *
 */
@Service
public class AppServiceImpl implements AppService{

	/* (non-Javadoc)
	 * @see com.training.spring.boot.service.AppService#getAuthor()
	 */
	@Override
	public String getAuthor() {
		return "Huu Tra";
	}

}
