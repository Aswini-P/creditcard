package com.cg.service;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Payment;
import com.cg.repository.IPaymentRepository;

@SpringBootTest
public class IPaymentServiceLayerTest {

	@Autowired
	private IPaymentService serv;
	@MockBean
	private IPaymentRepository rep;

	@Test
	void getPaymentIdTest() {
		int id = 1;
		doReturn(Optional.of(new Payment(1, "creditcard", 500))).when(rep).getById((long) id);
	}

	@Test
	public void removePayment() {
		long id = 1;
		Payment payment = new Payment();
		payment.setPaymentId(id);

	}
	@Test
	public void updatePaymentTest() {
		int id = 1;
		doReturn(Optional.of(new Payment(1, "creditcard", 500))).when(rep).getById((long) id);
	}

}
