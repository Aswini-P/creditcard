package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transId;
	
	@NotBlank(message="cardNumber can't be blank")
	@Column(name="CardNumber")
	private String cardNumber;
	private LocalDate tranDate;
	private String status;
	private double amount;
	private String paymentMethod;
	private String description;

}
