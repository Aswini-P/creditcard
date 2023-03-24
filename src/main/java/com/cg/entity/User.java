package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Users")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	@NotBlank(message="No userId provided")
	private String userId;
	@NotBlank(message="Password can't be blank")
    private String password;
	private boolean status;
	public User(String userId, String password) {
		this.userId=userId;
		this.password=password;
	}
	

}
