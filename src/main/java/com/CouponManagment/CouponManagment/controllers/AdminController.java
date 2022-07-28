package com.CouponManagment.CouponManagment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Customer;
import com.CouponManagment.CouponManagment.services.AdminFacade;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
	
@Autowired
private AdminFacade af;


	@CrossOrigin
	@RequestMapping(value = "company", method = RequestMethod.GET)
	public List<Company> getAllCompanies() {
		
	return af.getAllCompanies();
		
	}
	

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		
	return af.getAllCustomers();
		
	}

	@RequestMapping(value = "/company/{id}",method = RequestMethod.GET)
	public  Company getCompany(@PathVariable("id")long id) {
		return af.getCompany(id);
	}
	

	@RequestMapping(value = "/customer/{id}",method = RequestMethod.GET)
	public  Customer getCustomer(@PathVariable("id") long id) {
		
		return af.getCustomer(id);
	}
	@CrossOrigin
	@RequestMapping(value="/company", method = RequestMethod.POST)
	public void createCompany(@RequestBody Company company) {
		af.createCompany(company);
	}
	@CrossOrigin
	@RequestMapping(value ="/customer",method = RequestMethod.POST)
	public void createCustomer(@RequestBody Customer customer) {
		af.createCustomer(customer);
	}
	@CrossOrigin
	@RequestMapping(value ="/company",method = RequestMethod.DELETE)
	public void removeCompany(@RequestBody Company company) {
		af.removeCompany(company);
		
	}
	@CrossOrigin
	@RequestMapping(value ="/customer",method = RequestMethod.DELETE)
	public void removeCustomer(@RequestBody Customer customer) {
		af.removeCustomer(customer);
		
	}
	
	@CrossOrigin
	@RequestMapping(value ="/company",method = RequestMethod.PUT )
	public void updateCompany(@RequestBody Company company) {
		af.updateCompany(company);
	}
	
	@CrossOrigin
	@RequestMapping(value ="/customer",method = RequestMethod.PUT )
	public void updateCustomer(@RequestBody Customer customer) {
		af.updateCustomer(customer);
	}
	
	
	

}
