package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentCustomersSession;
import com.masai.model.Customers;
import com.masai.model.CustomersDto;
import com.masai.Repo.CustomersDao;
import com.masai.Repo.CustomersSessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomersLogInServiceImpl implements CustomersLoginService{

	@Autowired
	private CustomersDao customersDao;
	
	@Autowired
	private CustomersSessionDAO customersSessionDAO;
	
	@Override
	public String logIntoAccount(CustomersDto userDTO) throws Exception {

		Optional<Customers> opt= customersDao.findByMobileNo(userDTO.getMobileNo());
		
		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}
		
		Customers user1= opt.get();
		Integer userId = user1.getId();
		Optional<CurrentCustomersSession>  currUseropt1= customersSessionDAO.findByUserId(userId);
		
		if(currUseropt1.isPresent()) {
			return "User already logged in with this number.";
		}
		
		if(user1.getPassword().equals(userDTO.getPassword())) {
			
			String key = RandomString.make(6);
			CurrentCustomersSession currentUserSession = new CurrentCustomersSession(userId, key, LocalDateTime.now());
			
			customersSessionDAO.save(currentUserSession);

			return currentUserSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}

		
	}
	

	@Override
	public String logOutAccount(String key) {
		Optional<CurrentCustomersSession> currUserOpt=customersSessionDAO.findByUuid(key);
		
		if(currUserOpt.isPresent()) {
			CurrentCustomersSession currUser1=currUserOpt.get();
			
			customersSessionDAO.delete(currUser1);
			return "User logged out successfully.";
		}
		return "User does not exist, Enter correct uuid";

	}

}
