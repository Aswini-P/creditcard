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
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	public Customer customer;
    @OneToMany(cascade=CascadeType.ALL,mappedBy="statement")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Payment> paymentList;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CreditCard creditCard;

}
