package com.CouponManagment.CouponManagment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CouponManagment.CouponManagment.dto.Customer;

@Repository 
public class CustomerDAO {
	@Autowired
	private JpaRepository<Customer, Long> repo;
	
	public void addCustomer(Customer customer) {
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
	//	customer.setCUST_NAME(cust.getCUST_NAME());
		customer.setPASSWORD(cust.getPASSWORD());
		repo.save(customer);
		
	}
	
	

}
