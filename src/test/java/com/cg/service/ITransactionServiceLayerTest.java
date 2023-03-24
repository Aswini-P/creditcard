package com.cg.service;

import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Transaction;
import com.cg.repository.ITransactionRepository;
@SpringBootTest
public class ITransactionServiceLayerTest {
	@Autowired
	private ITransactionService serv;
	
	@MockBean
	private ITransactionRepository rep;
	
	@Test
	void getAllTransactionIdTest() {
		int id =1;
		doReturn(Optional.of(new Transaction(1,"555566667890",LocalDate.of(2023, 2, 12),"approved",500,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
	@Test
	public void updateTransactionTest()
	{
		int id =1;
		doReturn(Optional.of(new Transaction(1,"555566667890",LocalDate.of(2023, 2, 12),"approved",500,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
	void getTransactionDetailsTest() {
		int id =1;
		doReturn(Optional.of(new Transaction(1,"555566667890",LocalDate.of(2023, 2, 12),"approved",500,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
		
	
	@Test
	public void updateTransaction()
	{
		long id = 1;
		doReturn(Optional.of(new Transaction(1,"5555 6666 7890",LocalDate.of(2023, 2, 12),"approved",1000,"Credit Card","Business purpose"))).when(rep).getById((long) id);
	}
	

}
