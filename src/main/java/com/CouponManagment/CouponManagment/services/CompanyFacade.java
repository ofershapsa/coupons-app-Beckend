package com.CouponManagment.CouponManagment.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.dto.TypeEnum;
import com.CouponManagment.CouponManagment.repository.CouponDAO;
import com.CouponManagment.CouponManagment.repository.CouponReposirory;

@Service
@Scope("prototype")
public class CompanyFacade implements CouponClientFacade {
	@Autowired
	private CouponDAO coupRepo;

	public CompanyFacade() {
		
	}
	public void createCoupon(Coupon coupon) {
	 coupRepo.addCoupon(coupon);
		
	}
	public void removeCoupon(Coupon coupon){
		 coupRepo.deleteCoupon(coupon.getID());
	}
	
	public void updateCoupon(Coupon coup) {
		 coupRepo.updateCoupon(coup.getID(), coup);
	}
	public Coupon getCoupon(long id) {
		return  coupRepo.findCoupon(id);
	}
	public List<Coupon> getAllCoupons() {
		return  coupRepo.selectAllCoupons();
	}
/*	
	public List<Coupon> getCouponByType(TypeEnum te) {
		return coupRepo.getCouponByType(te);
	}
	
	public List<Coupon> getCouponByPrice(Double price) {
		return coupRepo.getCouponByPrice(price);
	}
	public List<Coupon> getCouponByDate(Date date) {
		return coupRepo.getCouponByDate(date);
	}
	*/

}
