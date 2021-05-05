package com.CouponManagment.CouponManagment;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.repository.CouponDAO;

@Service
@Scope("singleton")
public class DailyCouponExpirationTask implements Runnable {
	@Autowired
	private CouponDAO couponDAO ;
	private boolean quit;
	 
	
	
	

	


	@Override
	public void run() {
	while (true) {
	checkCoupons();
	try {
		Thread.sleep(60*60*20*1000);
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
		
	}
		
	}
	public void stopTask() {
		quit = true;
	}
	
	public void checkCoupons() {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		java.util.List<Coupon> coupons = couponDAO.selectAllCoupons();
		for(Coupon curr : coupons){
			if(curr != null && curr.getEndDate()!= null && today.getDate() == curr.getEndDate().getDate()){
				couponDAO.deleteCoupon(curr.getId());
			}
		}
	}
	

}
