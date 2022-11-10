package com.masai.Service;

import com.masai.model.Customers;

public interface CustomersService {

	public Customers createUser(Customers user);
	
	public Customers updateUser(Customers user, String key);
}
