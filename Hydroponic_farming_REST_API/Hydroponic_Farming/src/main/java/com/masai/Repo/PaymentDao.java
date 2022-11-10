package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

}
