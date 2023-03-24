package com.cg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.exceptions.NotLoggedInException;
import com.cg.exceptions.SamePasswordException;
import com.cg.exceptions.UserIdNotFoundException;
import com.cg.exceptions.WrongPasswordException;
import com.cg.impl.UserService;

@RestController
@RequestMapping("/loginapi")
public class UserController {
	@Autowired
	private UserService userService;
	public User currentUser;
	public UserController() {}

	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<User> signInUser(@RequestBody User u) throws WrongPasswordException {
		Optional<User> userOp = userService.findByUserId(u.getUserId());
		if (userOp.isPresent()) {
			User dbUser = userOp.get();
			if (u.getPassword().equals(dbUser.getPassword())) {
				currentUser = userService.signIn(u);
				currentUser.setStatus(true);
				return new ResponseEntity<>(currentUser, HttpStatus.ACCEPTED);
				} else {
					throw new WrongPasswordException("Wrong Password");
					}
			} else {
				throw new UserIdNotFoundException("No user exists");
				}
	}
	@PostMapping("/signOut")
	public ResponseEntity<String> signOutUser(@RequestBody User u) throws NotLoggedInException {
		if (currentUser.isStatus() && currentUser.getUserId().equals(u.getUserId())&& currentUser.getPassword().equals(u.getPassword())) {
			currentUser.setStatus(false);
			return new ResponseEntity<>("sign out : " + u.getUserId(), HttpStatus.ACCEPTED);
			} else {
				throw new NotLoggedInException("Not logged in to any account");
				}
		}
	@PutMapping("/changePassword/{id}")
	public ResponseEntity<String> changePasswordForUser(@PathVariable("id") long id, @RequestBody User u) throws SamePasswordException {
		User repUser = userService.changePassword(id, u);
		// check for status also
		if (repUser != null) {
			if (!repUser.getPassword().equals(u.getPassword())) {
				repUser.setPassword(u.getPassword());
				User cc =repUser;
				userService.save(cc);currentUser = repUser;
				return new ResponseEntity<>("Password changed ", HttpStatus.ACCEPTED);
				}
			else {
				throw new SamePasswordException("Same password entered");
				}
			} else {
				throw new UserIdNotFoundException("No user exists");
				}
		}
			
		
	}
		
	
	


