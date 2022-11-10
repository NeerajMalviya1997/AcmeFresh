package com.masai.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infrastructure {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer InfrastructureId;
	private String fieldarea;
	private String productName;
	
	@JsonIgnore
	private Double price;
	
	private String status;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customers customers;
}
