package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.CustomersSessionDAO;
import com.masai.Repo.PaymentDao;
import com.masai.model.CurrentCustomersSession;
import com.masai.model.Customers;
import com.masai.model.Payment;


@Service
public class PaymentsServiceImpl implements PaymentServices {

	@Autowired
	private CustomersSessionDAO customersSessionDAO;
	
	@Autowired
	private PaymentDao paymentdao;
	
	@Override
	public Payment getmayment(Integer paymentid, String key) {
		java.util.Optional<CurrentCustomersSession> c=customersSessionDAO.findByUuid(key);
		if(c.isEmpty()) {
			throw new RuntimeException("Please login first");
		}
		java.util.Optional<Payment> p =paymentdao.findById(paymentid);
		if(p.isEmpty()) {
			throw new RuntimeException("Payment Id is wrong");
		}
		return p.get();
	}

	@Override
	public Customers getcustomersbymaymentid(Integer paymentid, String key) {
		java.util.Optional<CurrentCustomersSession> c=customersSessionDAO.findByUuid(key);
		if(c.isEmpty()) {
			throw new RuntimeException("Please login first");
		}
		java.util.Optional<Payment> p =paymentdao.findById(paymentid);
		if(p.isEmpty()) {
			throw new RuntimeException("Payment Id is wrong");
		}
		return p.get().getCustomers();
	}

	@Override
	public Payment addpayment(Payment payment, String key) {
		java.util.Optional<CurrentCustomersSession> c=customersSessionDAO.findByUuid(key);
		if(c.isEmpty()) {
			throw new RuntimeException("Please login first");
		}
		return paymentdao.save(payment);
	}

	

}
