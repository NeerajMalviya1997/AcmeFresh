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
import com.masai.model.Admin;
import com.masai.model.Customers;
import com.masai.model.Products;
import com.masai.Service.AdminServiceImpl;
import com.masai.Service.ProductServiceImpl;

       
@RestController
@RequestMapping("/admin")
public class AdminController {

  
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    
    @Autowired 
    ProductServiceImpl productServiceImpl;
  
    @PostMapping("/")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminServiceImpl.createAdmin(admin);
    }

    // to update admin by passing key
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin, @RequestParam(required = false) String key) {

        return adminServiceImpl.updateAdmin(admin, key);
    }

    
    @PostMapping("/Product")
    public ResponseEntity<Products> addProducts(@RequestBody Products product,@RequestParam String key){
    	Products p=productServiceImpl.addProducts(product, key);
    	return new  ResponseEntity<Products>(p,HttpStatus.ACCEPTED);
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
   
    @GetMapping("/Customers")
    public ResponseEntity<Customers> getcustomer(@RequestParam Integer customerID,@RequestParam String key){
    	Customers c=adminServiceImpl.getCustomer(customerID, key);
    	return new  ResponseEntity<Customers>(c,HttpStatus.ACCEPTED);
    }
    
    
    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customers>> allcustomer(@RequestParam String key){
    	List<Customers> c=adminServiceImpl.getallCustomers(key);
    	return new  ResponseEntity<List<Customers>>(c,HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/allproductbyCustomers")
    public ResponseEntity<List<Products>> allproductbyCustomers(@RequestParam Integer customerId){
    	List<Products> c=productServiceImpl.getallProductByCustomerId(customerId);
    	return new  ResponseEntity<List<Products>>(c,HttpStatus.ACCEPTED);
    }
    
    
    @GetMapping("/allCustomersbyproduct")
    public ResponseEntity<List<Customers>> allCustomersbyprodu(@RequestParam Integer productId){
    	List<Customers> c=productServiceImpl.getallCustomersByProductId(productId);
    	return new  ResponseEntity<List<Customers>>(c,HttpStatus.ACCEPTED);
    }
}

