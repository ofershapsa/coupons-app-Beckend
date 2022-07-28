package com.CouponManagment.CouponManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.CouponManagment.CouponManagment.model.Company;




public interface CompanyRepository extends JpaRepository<Company,Long>  {
	Company findByCompanyName(String companyName);
	boolean existsByCompanyName(String companyName);

}
