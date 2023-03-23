package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Statement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long statementId;
	@Min(value=1000,message="Dueamount should be greater than 1000")
	private double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;
	
    @ManyToOne(cascade=CascadeType.ALL)
	public Customer customer;

}
