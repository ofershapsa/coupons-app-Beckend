package com.CouponManagment.CouponManagment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.dto.TypeEnum;

@Repository 
public class CouponDAO  {
	@Autowired
	private CouponReposirory repo;
	
	public void addCoupon(Coupon coupon) {
		repo.save(coupon);	
	}
	
	public void deleteCoupon(long id) {
		repo.deleteById(id);
	}
	
	public List<Coupon> selectAllCoupons() {
	return	repo.findAll();
	}
	
	public Coupon findCoupon(long id) {
		return repo.findById(id).get();
	}
	
	public void updateCoupon(long id,Coupon coup) {
		Coupon coupon = findCoupon(id);
		coupon.setTITLE(coup.getTITLE());
		coupon.setMESSAGE(coup.getMESSAGE());
		coupon.setPRICE(coup.getPRICE());
		coupon.setSTART_DATE(coup.getSTART_DATE());
		coupon.setEND_DATE(coup.getEND_DATE());
		coupon.setAMOUNT(coup.getAMOUNT());
		coupon.setTYPE(coup.getTYPE());
		coupon.setIMAGE(coup.getIMAGE());
		repo.save(coupon);
	}

	

	

	

}
