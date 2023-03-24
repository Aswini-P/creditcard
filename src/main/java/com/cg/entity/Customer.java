package com.cg.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
	@NotBlank(message="Name Can't be blank")
	private String name;
	@Email(message="invalid email")
	private String email;
	@NotBlank(message="No contact no provided")
	private String contactNo;
	private LocalDate dob;
	private String address;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Account> accountlist;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Statement> statement;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(cascade=CascadeType.ALL)
	private List<CreditCard> creditcard;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Payment> payment;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Transaction> transaction;

}
