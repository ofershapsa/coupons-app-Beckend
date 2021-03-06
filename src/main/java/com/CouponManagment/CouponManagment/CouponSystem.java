package com.CouponManagment.CouponManagment;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.CouponManagment.CouponManagment.model.Company;
import com.CouponManagment.CouponManagment.model.Customer;
import com.CouponManagment.CouponManagment.services.AdminFacade;
import com.CouponManagment.CouponManagment.services.ClientType;
import com.CouponManagment.CouponManagment.services.CompanyFacade;
import com.CouponManagment.CouponManagment.services.CouponClientFacade;
import com.CouponManagment.CouponManagment.services.CustomerFacade;

@Service
public class CouponSystem {
	@Autowired
	private DailyCouponExpirationTask task;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private  AdminFacade af;
	@Autowired
private  ApplicationContext ctx;

	
	public CouponSystem() {
		
	}
	@PostConstruct
	public  void init() {
		 
	
		
		Thread t = new Thread(task);
		t.start();

	}
	
	
	
	public CouponClientFacade login(String name,String password,ClientType type) {
		CouponClientFacade ccf = new CouponClientFacade() {
		};
		
		
		List<Company> companies = companyRepository.findAll();
		List<Customer> customers = customerRepository.findAll();
		if(name.equals("admin") && password.equals("1234") && type.equals(ClientType.ADMIN)){
			
			  
			 return af ;
		}
		for(Company curr : companies){
			if(name.equals(curr.getCompanyName())&& password.equals(curr.getPassword()) && type.equals(ClientType.COMPANY)){
			CouponClientFacade cof =  ctx.getBean(CompanyFacade.class);
			
				
				return cof;
			}
		}
		for(Customer curr : customers){
			if(name.equals(curr.getCustomerName()) && password.equals(curr.getPassword()) && type.equals(ClientType.CUSTOMER)){
			CouponClientFacade cuf =ctx.getBean(CustomerFacade.class);
				
				return cuf;
			}
		}
		return ccf;
	}
	@PreDestroy
	public  void shotdown() {
	//	task.stopTask();
	}

}
