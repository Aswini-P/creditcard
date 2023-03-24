package com.cg.service;

import java.util.Optional;

import com.cg.entity.User;

public interface IUserService {
	public User signIn(User u);
	public User signOut(User u);
	public User changePassword(long id, User u);
	
	Optional<User> findByUserId(String userId);
	User save(User u);

}
