package com.masai.Service;


import com.masai.model.CustomersDto;

public interface CustomersLoginService {

	public String logIntoAccount(CustomersDto userDTO) throws Exception;
	
	public String logOutAccount(String key);
}
