/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.service
 * FileName: UserLog.java
 * Author : huu.tra
 */
package com.training.spring.boot.service;

import java.util.List;

import com.training.spring.boot.domain.User;

/**
 * @author huu.tra
 *
 */
public interface UserLog {
	List<User> getListLog(String firstName, String lastName);
}
