package com.cg.impl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.User;
import com.cg.exceptions.PasswordNotFoundException;
import com.cg.exceptions.UserIdNotFoundException;
import com.cg.repository.IUserRepository;
import com.cg.service.IUserService;

@Service
public class UserService implements IUserService 
{

	@Autowired
	IUserRepository userRepository;

	@Override
	public User signIn(User u) {
		return userRepository.signIn(u);
	}

	@Override
	public User signOut(User u) {
		return userRepository.signOut(u);
	}

	@Override
	public User changePassword(long id, User u) {
		return userRepository.changePassword(id, u);
	}

	@Override
	public Optional<User> findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User save(User u) {
		return userRepository.save(u);
	}
	
}