package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId;
	@NotBlank(message="Name Can't be blank")
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	private String address;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;

}
