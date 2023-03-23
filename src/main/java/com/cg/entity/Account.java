package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountId;
	@NotBlank(message="AccountName shouldn't be blank")
	private String accountName;
	@Min(value=1000,message="Balance should be more than 1000")
	private double balance;
	private String accountType;

}
