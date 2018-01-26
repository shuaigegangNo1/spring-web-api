package com.sgg.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgg.rest.model.User;
import com.sgg.rest.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
    public User findOne(Integer id){
        return userRepository.findOne(id);
    }
}
