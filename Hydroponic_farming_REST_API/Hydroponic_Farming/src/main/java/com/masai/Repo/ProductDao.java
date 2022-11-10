package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Products;

public interface ProductDao extends JpaRepository<Products, Integer> {

}
