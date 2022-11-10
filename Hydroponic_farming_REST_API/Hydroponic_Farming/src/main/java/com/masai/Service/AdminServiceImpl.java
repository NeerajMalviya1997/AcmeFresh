package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Admin;
import com.masai.model.CurrentAdminSession;
import com.masai.model.Customers;
import com.masai.Repo.AdminDao;
import com.masai.Repo.AminSessionDao;
import com.masai.Repo.CustomersDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	
	@Autowired
	private AminSessionDao adminSessionDAO;
	
	@Autowired
	private CustomersDao customersDao;
	
	@Override
	public Admin createAdmin(Admin admin) {
		Optional<Admin> opt= adminDao.findByMobileNo(admin.getMobileNo());
		
		if(opt.isPresent()) {
			System.out.println("User already exist");
		}
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return adminDao.save(admin);
	}

	@Override
	public Customers getCustomer(Integer customerId, String Key) {
	
		Optional<Customers>	c=customersDao.findById(customerId);
		if(c.isEmpty()) {
			throw new RuntimeException("Wromg customer id");
		}
		return c.get();
	}

	@Override
	public List<Customers> getallCustomers(String Key) {
		
		return customersDao.findAll();
	}

}
