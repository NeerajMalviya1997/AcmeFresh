package com.masai.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {

	public static final String HttpStatus = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Name is mandatory")
	private String name;
	
	@Size(max = 10,min = 10)
	private String mobileNo;
	
	@NotNull(message = "Password is mandatory")
	private String password;
	
	
	@NotNull(message = "Email is mandatory")
	private String email;
  
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
     private List<Products> products;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Payment> payments;
	
}