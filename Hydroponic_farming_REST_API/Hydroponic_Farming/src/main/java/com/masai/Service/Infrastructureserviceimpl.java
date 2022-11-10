package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.AminSessionDao;
import com.masai.Repo.CustomersSessionDAO;
import com.masai.Repo.InfrastructureDao;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentCustomersSession;
import com.masai.model.Infrastructure;

@Service
public class Infrastructureserviceimpl implements InfrastructureServices {
	
	
	@Autowired
	private InfrastructureDao dao;
	@Autowired
	private CustomersSessionDAO customersSessionDAO;
    
	@Autowired
	private AminSessionDao aminSessionDao;
	
	@Override
	public Infrastructure saveInfrastructure(Infrastructure infrastructure, String key) {
		java.util.Optional<CurrentCustomersSession> c=customersSessionDAO.findByUuid(key);
		if(c.isEmpty()) {
			throw new RuntimeException("Please login first");
		}
		
		
		return dao.save(infrastructure);
	}

	@Override
	public Infrastructure getInfrastructurebyid(Integer infrastructureid, String key) {
		java.util.Optional<CurrentCustomersSession> c=customersSessionDAO.findByUuid(key);
		if(c.isEmpty()) {
			throw new RuntimeException("Please login first");
		}
		return dao.findById(infrastructureid).get();
	}

	@Override
	public List<Infrastructure> getallInfrastructure(String key) {
		Optional<CurrentAdminSession> c=aminSessionDao.findByUuid(key);
		if(c.isEmpty()) {
			throw new RuntimeException("Please login first");
		}
		return dao.findAll();
	}

}
