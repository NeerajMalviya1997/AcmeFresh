package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentCustomersSession;
import com.masai.model.Customers;
import com.masai.Repo.CustomersDao;
import com.masai.Repo.CustomersSessionDAO;

@Service
public class CustomersServiceImpl implements CustomersService{

	@Autowired
	private CustomersDao customersDao;
	
	
	@Autowired
	private CustomersSessionDAO customersSessionDAO;
	
	@Override
	public Customers createUser(Customers user) {
		
		
		Optional<Customers> opt= customersDao.findByMobileNo(user.getMobileNo());
		
		if(opt.isPresent()) {
//			System.out.println("User already exist");
			throw new RuntimeException("User already exist");
		}
		
		customersDao.save(user);
		return user;
		
	}

	@Override
	public Customers updateUser(Customers user, String key) {

		 Optional<CurrentCustomersSession> optCurrUser= customersSessionDAO.findByUuid(key);
		
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return customersDao.save(user);

	}

}
