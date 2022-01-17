package com.CouponManagment.CouponManagment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.CouponManagment.CouponManagment.dto.Customer;

@Repository 
public class CustomerDAO {
	@Autowired
	private JpaRepository<Customer, Long> repo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public void addCustomer(Customer customer) {
		//System.out.println(customer);
		customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
		repo.save(customer);
		
	}
	public void deleteCustomer(long id) {
    	repo.deleteById(id);
		
	}
	
	public List<Customer> selectAllCustomers() {
		
		return repo.findAll();
		
	}
	
	public Customer findCustomer(long id) {
		
		return repo.findById(id).get();
		
	}
	
	public void updateCustomer(long id,Customer cust ) {
		Customer customer = findCustomer(id);
		customer.setCustomerName(cust.getCustomerName());
		customer.setPassword(bcryptEncoder.encode(cust.getPassword()));
		repo.save(customer);
		
	}
	
	

}
