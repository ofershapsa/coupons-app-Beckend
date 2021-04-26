package com.CouponManagment.CouponManagment.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Customer;
import com.CouponManagment.CouponManagment.repository.CompanyDAO;
import com.CouponManagment.CouponManagment.repository.CustomerDAO;
@Service
@Scope("singleton")
public class AdminFacade implements CouponClientFacade {
	@Autowired
	private CompanyDAO compRepo;
	@Autowired
	private CustomerDAO custRepo;
	
	public   AdminFacade() {
		
	}
	
	public void createCompany(Company company){
	Iterable<Company> companies =getAllCompanies(); 
		for(Company curr:companies){
			if((!company.equals(curr.getCOMP_NAME()))){
				compRepo.addCompany(company);
				
			}
		}
	}
	public void removeCompany(Company company) {
		compRepo.deleteCompany(company.getID());
	}
	public void updateCompany(Company comp) {
		compRepo.updateCompany(comp.getID(),comp);
	}
	public Company getCompany(long id){
   return    compRepo.findCompany(id);
	}
	public Iterable<Company> getAllCompanies() {
		return compRepo.selectAllCompanies();
	}
	public void createCustomer(Customer customer) {
		custRepo.addCustomer(customer);
	}
	public void removeCustomer(Customer customer) {
		custRepo.deleteCustomer(customer.getID());
	}
	public void updateCustomer(Customer cust) {
		custRepo.updateCustomer(cust.getID(), cust);
	}
	public Customer getCustomer(long id) {
		return custRepo.findCustomer(id);
	}
	public Iterable<Customer> getAllCustomers() {
		return custRepo.selectAllCustomers();
	}
	
}
