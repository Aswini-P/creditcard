package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.User;
import com.cg.repository.IUserRepository;
@SpringBootTest
public class IUserServiceLayerTest {
	@Autowired 
	private IUserService service;
	@MockBean
	private IUserRepository rep;
	  @Test
	  public void testSignIn() {
		  User user = new User(1,"Aswini","Aswini@123",true);
		  when(rep.signIn(user)).thenReturn(user);
		  assertEquals(user,rep.signIn(user));
	  }
		  
	  @Test
	  public void testSignOut() {
		  User user = new User(1,"Aswini","Aswini@123",false);
		  when(rep.signOut(user)).thenReturn(user);
		  assertEquals(user,service.signOut(user));
	  }
	  @Test
	  public void testChangePassword() {
	    long id = 1;
	    User user = new User(1,"Aswini","Aswini@123",true);
	    when(rep.changePassword(id, user)).thenReturn(user);
	    User returnedUser = service.changePassword(id, user);
	    assertEquals(user, returnedUser);
	  }

	  @Test
	  public void testFindByUserId() {
		User user = new User(1,"Aswini","Aswini@123",true);
		long id = 1;
	    when(rep.findByUserId("Aswini")).thenReturn(Optional.of(user));
	    Optional<User> returnedUser = service.findByUserId("Aswini");
	    assertEquals(user, returnedUser.get());
	  }
	}
	
