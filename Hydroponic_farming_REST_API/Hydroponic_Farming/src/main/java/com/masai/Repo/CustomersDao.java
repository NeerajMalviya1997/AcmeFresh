package com.masai.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.masai.model.Customers;

@Repository
public interface CustomersDao extends JpaRepository<Customers, Integer>{
	public Optional<Customers> findByMobileNo(String mobileNo);
}
