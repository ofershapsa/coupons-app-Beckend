package com.CouponManagment.CouponManagment;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Customer;
import com.CouponManagment.CouponManagment.repository.CompanyDAO;
import com.CouponManagment.CouponManagment.repository.CustomerDAO;
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
	private CompanyDAO companyDAO;
	@Autowired
	private CustomerDAO custDAO;
	@Autowired
	private  AdminFacade af;
	@Autowired
private  ApplicationContext ctx;

	
	public CouponSystem() {
		
	}
	@PostConstruct
	public  void init() {
		 
	
		
		Thread t = new Thread(task);
	//	t.start();
		
	}
	
	
	
	public CouponClientFacade login(String name,String password,ClientType type) {
		CouponClientFacade ccf = new CouponClientFacade() {
		};
		
		
		List<Company> companies = companyDAO.selectAllCompanies();
		List<Customer> customers = custDAO.selectAllCustomers();
		if(name.equals("admin") && password.equals("1234") && type.equals(ClientType.ADMIN)){
			
			  
			 return af ;
		}
		for(Company curr : companies){
			if(name.equals(curr.getCOMP_NAME())&& password.equals(curr.getPASSWORD()) && type.equals(ClientType.COMPANY)){
			CouponClientFacade cof =  ctx.getBean(CompanyFacade.class);
			
				
				return cof;
			}
		}
		for(Customer curr : customers){
			if(name.equals(curr.getCUST_NAME()) && password.equals(curr.getPASSWORD()) && type.equals(ClientType.CUSTOMER)){
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
