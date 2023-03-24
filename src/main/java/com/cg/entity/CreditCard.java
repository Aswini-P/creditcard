package com.cg.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CreditCard{
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
	@ManyToOne
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private Customer customer;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="creditCard")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Statement> statementList;

}
