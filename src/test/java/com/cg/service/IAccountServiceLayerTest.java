package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Account;
import com.cg.repository.IAccountRepository;

@SpringBootTest
public class IAccountServiceLayerTest {
	@Autowired
	private IAccountService serv;
	@MockBean
	private IAccountRepository rep;
	
	@Test
	void addAccountTest() {
		Account account = new Account(1,"Saving",4000,"SALARY_ACCOUNT");
		when(rep.save(account)).thenReturn(account);
		assertEquals(account,serv.addAccount(account));
	}
	@Test
	void getAllAccountIdTest() {
		int id =1;
		doReturn(Optional.of(new Account(1,"Saving",4000,"SALARY_ACCOUNT"))).when(rep).getById((long) id);
	}
	@Test
	public void testRemoveAccount_Success() {
		long id = 1;
		Account account = new Account();
		account.setAccountId(1);
		account.setAccountName("Saving");
		account.setBalance(1000.0);
	}
}
