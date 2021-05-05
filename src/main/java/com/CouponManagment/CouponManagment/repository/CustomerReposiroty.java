package com.CouponManagment.CouponManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CouponManagment.CouponManagment.dto.Customer;

public interface CustomerReposiroty extends JpaRepository<Customer, Long> {
	Customer findByCustomerName(String customerName);
}
