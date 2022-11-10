package com.masai.Service;

import java.util.List;

import com.masai.model.Admin;
import com.masai.model.Customers;

public interface AdminService {

	public Admin createAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin, String key);
	
	public Customers getCustomer(Integer customerId,String Key);
	public List<Customers> getallCustomers(String Key);
	
	
}
