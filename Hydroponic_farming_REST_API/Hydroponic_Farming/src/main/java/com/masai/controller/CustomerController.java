package com.masai.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.model.Customers;
import com.masai.model.Payment;
import com.masai.model.Products;
import com.masai.Service.CustomersServiceImpl;
import com.masai.Service.PaymentsServiceImpl;
import com.masai.Service.ProductServiceImpl;

@RestController
@RequestMapping("/user")
public class CustomerController {
	
	@Autowired
	private CustomersServiceImpl userServiceImpl;
	  
    @Autowired 
    private  ProductServiceImpl productServiceImpl;  
    
    
    @Autowired
    private PaymentsServiceImpl paymentsServiceImpl;
	
	// to register user
	@PostMapping("/")
	public  Customers  saveUser(@RequestBody Customers er) {
		Customers user= userServiceImpl.createUser(er);
		return user;
		
	}

	// to update user by passing key
	@PutMapping("/update")
	public Customers updateUser(@RequestBody Customers user, @RequestParam(required = false) String key) {

		return userServiceImpl.updateUser(user, key);
	}

	 @GetMapping("/Product")
	    public ResponseEntity<Products> getProducts(@RequestParam Integer productid){
	    	Products p=productServiceImpl.getProducts(productid);
	    	return new  ResponseEntity<Products>(p,HttpStatus.ACCEPTED);
	    }
	    @GetMapping("/allProduct")
	    public ResponseEntity<List<Products>> allProducts(){
	    	List<Products> p=productServiceImpl.getallProducts();
	    	return new  ResponseEntity<List<Products>>(p,HttpStatus.ACCEPTED);
	    }
	    
	    @PostMapping("/addpayment")
		public  ResponseEntity<Payment>  addpayment(@RequestBody Payment payment,@RequestParam String key) {
	    	Payment p=paymentsServiceImpl.addpayment(payment, key);
	    	return new  ResponseEntity<Payment>(p,HttpStatus.ACCEPTED);
			
		}   
	    
	    @GetMapping("/getpayment")
		public  ResponseEntity<Payment> getpayment(@RequestParam Integer productid,@RequestParam String key) {
	    	Payment p=paymentsServiceImpl.getmayment(productid, key);
	    	return new  ResponseEntity<Payment>(p,HttpStatus.ACCEPTED);
			
		}   
	    
	    
	    @GetMapping("/getcustoemr")
	 		public  ResponseEntity<Customers> getcustomer(@RequestParam Integer productid,@RequestParam String key) {
	 	    	Customers c=paymentsServiceImpl.getcustomersbymaymentid(productid, key);
	 	    	return new  ResponseEntity<Customers>(c,HttpStatus.ACCEPTED);
	 			
	 		}   


}