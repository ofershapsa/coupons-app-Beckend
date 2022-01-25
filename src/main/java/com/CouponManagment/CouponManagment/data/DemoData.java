package com.CouponManagment.CouponManagment.data;

import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CouponRepository;
import com.CouponManagment.CouponManagment.repository.CustomerRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DemoData implements CommandLineRunner {
@Autowired
private CompanyRepository companyRepository;
@Autowired
private CustomerRepository customerRepository;
@Autowired
private CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {




    }
}
