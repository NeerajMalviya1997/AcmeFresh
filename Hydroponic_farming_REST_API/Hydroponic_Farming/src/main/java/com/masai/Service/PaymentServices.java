package com.masai.Service;



import com.masai.model.Customers;
import com.masai.model.Payment;

public interface PaymentServices {

	public Payment addpayment(Payment payment,String key);
	public Payment getmayment(Integer paymentid,String key);
	public Customers getcustomersbymaymentid(Integer paymentid,String key);
}
