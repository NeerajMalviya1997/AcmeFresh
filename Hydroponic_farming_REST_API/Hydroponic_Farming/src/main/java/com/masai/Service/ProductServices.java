package com.masai.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.model.Customers;
import com.masai.model.Products;

@Service
public interface ProductServices {

	public Products addProducts(Products products,String key);
	public Products getProducts(Integer productsId);
	public List<Products> getallProducts();
	public List<Products> getallProductByCustomerId(Integer customerId);
	public List<Customers> getallCustomersByProductId(Integer productId);

}
