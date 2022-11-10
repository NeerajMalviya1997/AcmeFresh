package com.masai.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.masai.model.CurrentCustomersSession;

@Repository
public interface CustomersSessionDAO extends JpaRepository<CurrentCustomersSession, Integer>{
public Optional<CurrentCustomersSession> findByUserId(Integer userId);
	
	public Optional<CurrentCustomersSession> findByUuid(String uuid);
}