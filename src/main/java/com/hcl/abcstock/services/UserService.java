package com.hcl.abcstock.services;

import java.util.List;

import com.hcl.abcstock.models.User;

public interface UserService {

	List<User> findAllUsers();
}
