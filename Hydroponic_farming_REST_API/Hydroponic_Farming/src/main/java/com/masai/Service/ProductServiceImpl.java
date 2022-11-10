package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.AminSessionDao;
import com.masai.Repo.CustomersDao;
import com.masai.Repo.ProductDao;
import com.masai.model.CurrentAdminSession;
import com.masai.model.Customers;
import com.masai.model.Products;

@Service 
public class ProductServiceImpl implements ProductServices {
	
	@Autowired
	private AminSessionDao adminSession;
	
	
	@Autowired
	private ProductDao produDao;
	
	@Autowired
	private CustomersDao customersDao;
 
	@Override
	public Products addProducts(Products products, String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSession.findByUuid(key);
		
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		return produDao.save(products);
	}

	@Override
	public Products getProducts(Integer productsId) {
		Optional<Products>	p=produDao.findById(productsId);
		if(p.get()==null) {
			throw new RuntimeException("Wrong Productid");
		}
		return p.get();
	}

	@Override
	public List<Products> getallProducts() {
		List<Products> p=produDao.findAll();
		return p;
	}

	@Override
	public List<Products> getallProductByCustomerId(Integer customerId) {
		Optional<Customers> c=customersDao.findById(customerId);
		if(c.isEmpty()) {
			throw new RuntimeException("customer is not present with this id");
		}
		List<Products> p=c.get().getProducts();
		return p;
	}

	@Override
	public List<Customers> getallCustomersByProductId(Integer productId) {
		Optional<Products> p=produDao.findById(productId);
		if(p.isEmpty()) {
			throw new RuntimeException("customer is not present with this id");
		}
		List<Customers> c=p.get().getCustoemrs();
		return c;
	}

}
