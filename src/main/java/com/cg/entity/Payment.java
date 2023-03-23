package com.cg.entity;

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
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long paymentId;
	@NotBlank(message="Mention the payment method")
	private String method;
	private double amountDue;

}
