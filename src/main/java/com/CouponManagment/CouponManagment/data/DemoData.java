package com.CouponManagment.CouponManagment.data;

import com.CouponManagment.CouponManagment.model.Company;
import com.CouponManagment.CouponManagment.model.Coupon;
import com.CouponManagment.CouponManagment.model.Customer;
import com.CouponManagment.CouponManagment.model.TypeEnum;
import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CouponRepository;
import com.CouponManagment.CouponManagment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Order(1)
public class DemoData implements CommandLineRunner {
@Autowired
private  CompanyRepository companyRepository;
@Autowired
private CustomerRepository customerRepository;
@Autowired
private CouponRepository couponRepository;
@Autowired
private PasswordEncoder bcryptEncoder;


    @Override
    public void run(String... args) throws Exception {
        Coupon coupon = Coupon.builder()
                .amount(15)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .companyID(1L)
                .message("new watch")
                .title("watch")
                .type(TypeEnum.ELECTRICITY)
                .price(150.0)
                .image("watch.jpg")
                .build();

        Company company = Company.builder()
                .companyName("nike")
                .couponsList(coupon)
                .password(bcryptEncoder.encode("nike123"))
                .email("nike@gmail.com")
                .build();



        companyRepository.save(company);

        Customer customer = Customer.builder()
                .customerName("ofer")
                .password(bcryptEncoder.encode("ofer123"))
                .couponsList(coupon)
                .build();

        customerRepository.save(customer);





     }
}
