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

import com.cg.entity.Statement;
import com.cg.repository.IStatementRepository;
@SpringBootTest
public class IStatementServiceLayerTest {
	@Autowired
	private IStatementService serv;
	@MockBean
	private IStatementRepository rep;
	@Test
	void addStatementTest() {
		Statement statement = new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27) );
		when(rep.save(statement)).thenReturn(statement);
		assertEquals(statement,serv.addStatement(statement));
	}
	@Test
	void getAllStatementIdTest() {
		int id =1;
		doReturn(Optional.of(new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27)))).when(rep).getById((long) id);
	}
	@Test
	public void updateStatementTest()
	{
		int id = 1;
		doReturn(Optional.of(new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27)))).when(rep).getById((long) id);
		
	}
	@Test
	public void RemoveStatementId_Success() {
		long id = 1;
		Statement statement = new Statement();
		statement.setStatementId(1);
		
	}
	

}
