/**
 * Project: spring-boot-training
 * Package: com.training.spring.boot.service
 * FileName: UserService.java
 * Author : huu.tra
 */
package com.training.spring.boot.service;

import java.util.List;

/**
 * @author huu.tra
 *
 */
public interface UserService {
	List<String> getList();
	
	Boolean saveUser(String firstName, String lastName, String address);
}
