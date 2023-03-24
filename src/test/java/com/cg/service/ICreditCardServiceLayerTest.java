package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.CreditCard;
import com.cg.repository.ICreditCardRepository;

@SpringBootTest
public class ICreditCardServiceLayerTest {
	
	@Autowired
	private ICreditCardService serv;
	@MockBean
	private ICreditCardRepository rep;
	@Test
	void addCreditCardTest() {
		CreditCard creditcard = new CreditCard(1,"Anupama","Visa","555566667890",LocalDate.of(20023, 6, 27),"HDFC");
		when(rep.save(creditcard)).thenReturn(creditcard);
		assertEquals(creditcard,serv.addCreditCard(creditcard));
	}
	@Test
	void getAllCreditCardIdTest() {
		int id =1;
		doReturn(Optional.of(new CreditCard(1,"Anupama","Visa","555566667890",LocalDate.of(20023, 6, 27),"HDFC"))).when(rep).getById((long) id);
	}
	@Test
	public void removeCreditCardIdTest() {
		long id = 1;
		CreditCard CreditCard = new CreditCard();
		CreditCard.setId(id);
		
	}
	
	
	
}
	
