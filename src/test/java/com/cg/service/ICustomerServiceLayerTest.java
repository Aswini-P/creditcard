package com.cg.service;

import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Customer;
import com.cg.repository.ICustomerRepository;

@SpringBootTest
public class ICustomerServiceLayerTest {
	@Autowired
	private ICustomerService serv;
	@MockBean
	private ICustomerRepository rep;


	@Test
	void getAllCustomerIdTest() {
		int custid = 1;
		doReturn(Optional.of(new Customer("Aswini", "aswinipulivarthi@gmail.com", "6268718665", LocalDate.of(2000, 1, 30),"BLR",
				null, null, null, null, null))).when(rep).getById((long) custid);
	}

	@Test
	public void removeCustomer() {
		long id = 1;
		Customer customer = new Customer();
		customer.setId(id);
		
	}

	@Test
	public void updateCustomerTest() {

		int custid = 1;
		doReturn(Optional.of(new Customer("Aswini", "aswinipulivarthi@gmail.com", "6268718665", LocalDate.of(2000, 1, 30),"BLR",
				null, null, null, null, null))).when(rep).getById((long) custid);
	}
}