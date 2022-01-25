package com.CouponManagment.CouponManagment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.repository.CouponDAO;

@Service
@Scope("prototype")
public class CustomerFacade implements CouponClientFacade {
@Autowired
	private CouponDAO coupRepo;

	public CustomerFacade() {
		
	}
	public List<Coupon> getAllPurchasedCoupons() {
		return  coupRepo.selectAllCoupons();
	}
/*	
	public List<Coupon> getAllPurchasedCouponsByType(TypeEnum te) {
		return coupRepo.getCouponByType(te);
	}
	
	public List<Coupon> getAllPurchasedCouponsByPrice(Double price) {
		return coupRepo.getCouponByPrice(price);
	}
	*/
	public void purchaseCoupon(Coupon coupon) {
		List<Coupon> coupons = getAllPurchasedCoupons();
		for(Coupon curr:coupons){
		if(!(coupons.contains(curr))||(!(curr==null))){
			((CouponDAO)coupRepo).addCoupon(coupon);
		}
		}
	}
	

}
