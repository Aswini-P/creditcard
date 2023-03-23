package com.cg.entity;

import java.time.LocalDate;

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
public class CreditCard {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	public long id;
	@NotBlank(message="CardName can't be blank")
	public String cardname;
	public String cardtype;
	@NotBlank(message="CardNumber can't be Null")
	public String cardnumber;
	public LocalDate expirydate;
	public String bankname;

}
