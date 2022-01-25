package com.CouponManagment.CouponManagment.services;


import java.util.List;

import com.CouponManagment.CouponManagment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Customer;

@Service
//@Scope("singleton")
public class AdminFacade implements CouponClientFacade {
    @Autowired
    private CompanyRepository compRepo;
    @Autowired
    private CustomerRepository custRepo;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    public AdminFacade() {

    }

    public void createCompany(Company company) {
        if (compRepo.existsByCompanyName(company.getCompanyName())) {
            throw new RuntimeException();
        }

        company.setPassword(bcryptEncoder.encode(company.getPassword()));
        compRepo.save(company);
    }


    public void removeCompany(Company company) {
        compRepo.deleteById(company.getId());
    }

    public void updateCompany(Company comp) {
        comp.setPassword(bcryptEncoder.encode(comp.getPassword()));
       // comp.setEmail(comp.getEmail());
        compRepo.saveAndFlush(comp);

    }

    public Company getCompany(long id) {
        return compRepo.findById(id).get();
    }

    public List<Company> getAllCompanies() {
        return compRepo.findAll();
    }

    public void createCustomer(Customer customer) {
        customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
        custRepo.save(customer);
    }

    public void removeCustomer(Customer customer) {
        custRepo.deleteById(customer.getId());
    }

    public void updateCustomer(Customer cust) {
        cust.setPassword(bcryptEncoder.encode(cust.getPassword()));
        custRepo.saveAndFlush(cust);

    }

    public Customer getCustomer(long id) {
        return custRepo.findById(id).get();
    }

    public List<Customer> getAllCustomers() {
        return custRepo.findAll();
    }

}
