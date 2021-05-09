package com.CouponManagment.CouponManagment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value = "/getAllCompanies", method = RequestMethod.GET)
	public List<Company> getAllCompanies() {
		
	return af.getAllCompanies();
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		
	return af.getAllCustomers();
		
	}
	@CrossOrigin
	@RequestMapping(value ="/getCompany/{id}",method = RequestMethod.GET)
	public  Company getCompany(@PathVariable("id") long id) {
		return af.getCompany(id);
	}
	
	@CrossOrigin
	@RequestMapping(value ="/getCustomer/{id}",method = RequestMethod.GET)
	public   Customer getCustomer(@PathVariable(value ="id") long id) {
		return af.getCustomer(id);
	}
	@CrossOrigin
	@RequestMapping(value="/createCompany", method = RequestMethod.POST)
	public void createCompany(@RequestBody Company company) {
		af.createCompany(company);
	}
	@CrossOrigin
	@RequestMapping(value ="/createCustomer",method = RequestMethod.POST)
	public void createCustomer(@RequestBody Customer customer) {
		af.createCustomer(customer);
	}
	@CrossOrigin
	@RequestMapping(value ="/removeCompany",method = RequestMethod.DELETE)
	public void removeCompany(@RequestBody Company company) {
		af.removeCompany(company);
		
	}
	@CrossOrigin
	@RequestMapping(value ="/removeCustomer",method = RequestMethod.DELETE)
	public void removeCustomer(@RequestBody Customer customer) {
		af.removeCustomer(customer);
		
	}
	

}
