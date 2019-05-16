package com.hcl.abcstock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.abcstock.models.User;
import com.hcl.abcstock.repositories.UserRepository;

@Service
public class UserServiceImpl  implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	

}
