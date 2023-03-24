package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="account")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Payment> paymentList;

}
