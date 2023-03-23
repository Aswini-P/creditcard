package com.cg.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="Customer_Address")
public class Address {
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=400001,name= "add_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="add_seq")
	@Column(name="Door_Number")
	@NotNull(message="Door number cannot be null")
	@NotBlank(message="Please enter valid door number ")
	private String doorNo;
	
	@Column(name="Street_Name")
	@NotNull(message="Street name cannot be null")
	@NotBlank(message="Please enter valid street name")
	private String street;
	
	
	@Column(name="Area_Name")
	@NotNull(message="Area name cannot be null")
	@NotBlank(message="Please enter valid area name")
	private String area;
	
	
	@Column(name="City_Name")
	@NotNull(message="City name cannot be null")
	@NotBlank(message="Please enter valid city name")
	private String city;
	
	@Column(name="State_Name")
	@NotNull(message="State name cannot be null")
	@NotBlank(message="Please enter valid state name")
	private String state;
	
	@Column(name="Pincode")
	private int pincode;

}
