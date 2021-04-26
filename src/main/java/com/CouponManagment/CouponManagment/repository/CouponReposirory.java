package com.CouponManagment.CouponManagment.repository;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.dto.TypeEnum;
 
public interface CouponReposirory extends JpaRepository<Coupon,Long > {
//public List<Coupon> getCouponByType(TypeEnum te);
//public List<Coupon> getCouponByPrice(Double price);
//public List<Coupon> getCouponByDate(Date date); 

	

}
