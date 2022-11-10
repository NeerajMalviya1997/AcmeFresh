package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Infrastructure;


@Repository
public interface InfrastructureDao extends JpaRepository<Infrastructure, Integer> {

}
