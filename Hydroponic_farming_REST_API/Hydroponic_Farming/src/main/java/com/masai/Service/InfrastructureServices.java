package com.masai.Service;

import java.util.List;

import com.masai.model.Infrastructure;

public interface InfrastructureServices {

	public Infrastructure saveInfrastructure(Infrastructure infrastructure,String key); 
	public Infrastructure getInfrastructurebyid(Integer infrastructureid,String key);
	public List<Infrastructure>getallInfrastructure( String key);
	
}
