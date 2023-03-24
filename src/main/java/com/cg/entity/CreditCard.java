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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CreditCard{
	@Id
	@GeneratedValue
	private long id;
	@NotBlank(message="No card name provided")
	private String cardName;
	private String cardType;
	@NotBlank(message="No card number name provided")
	private String cardNumber;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate expirtyDate;
	private String bankName;
	@ManyToOne@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;@OneToMany(cascade=CascadeType.ALL,mappedBy="creditCard")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Statement> statementList;
	public CreditCard(long id, @NotBlank(message = "No card name provided") String cardName, String cardType,
			@NotBlank(message = "No card number name provided") String cardNumber, LocalDate expirtyDate,
			String bankName) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expirtyDate = expirtyDate;
		this.bankName = bankName;
	}
	
}
