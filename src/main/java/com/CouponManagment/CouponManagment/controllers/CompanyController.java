package com.CouponManagment.CouponManagment.controllers;

import java.util.Date;
import java.util.List;

import com.CouponManagment.CouponManagment.controllers.request.CouponsByCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CouponManagment.CouponManagment.model.Coupon;
import com.CouponManagment.CouponManagment.model.TypeEnum;
import com.CouponManagment.CouponManagment.services.CompanyFacade;

@RestController
@RequestMapping("/company")
@PreAuthorize("hasRole('ROLE_COMPANY')")
public class CompanyController {
	@Autowired
	private CompanyFacade cf;

	
	
/*
	@CrossOrigin
	@RequestMapping(value = "/getAllCouponsByCompany/{id}", method = RequestMethod.GET)
	public List<Coupon>  getAllCouponsByCompany(@PathVariable("id") long id) {
		
		
		return cf.getAllCouponsByCompany(id);
	}
	*/
	@CrossOrigin
	@RequestMapping(value = "/getAllCouponsByCompany", method = RequestMethod.GET)
	public List<Coupon>  getAllCouponsByCompany(@RequestBody CouponsByCompany couponsByCompany) {

		return cf.getAllCouponsByCompany(couponsByCompany.getCompanyName());
	}
	
	@CrossOrigin
	@RequestMapping(value="/createCoupon", method = RequestMethod.POST)
	public void createCoupon(@RequestBody Coupon coupon) {
		cf.createCoupon(coupon);
	}
	

	@CrossOrigin

	@RequestMapping(value = "/coupons/{type}", method = RequestMethod.GET)
	public List<Coupon> getCouponsByType(@PathVariable("type")TypeEnum te) {
		
		return cf.getCouponsByType(te);
	}

	
	@CrossOrigin
	@RequestMapping(value = "/getCouponsByPrice/{price}", method = RequestMethod.GET)
	public List<Coupon> getCouponsByPrice(@PathVariable("price")double price) {
		
		return cf.getCouponsByPrice(price);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCouponsByDate/{date}", method = RequestMethod.GET)
	public List<Coupon> getCouponsByDate(@PathVariable("date") @DateTimeFormat(pattern = "dd.MM.yyyy") Date date ) {

		return cf.getCouponByDate(date);
	}
	
	@CrossOrigin
	@RequestMapping(value="/removeCoupon", method = RequestMethod.DELETE)
	public void removeCoupon(@RequestBody long id) {
		cf.removeCoupon(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/updateCoupon", method = RequestMethod.PUT)
	public void updateCoupon(@RequestBody Coupon coupon) {
		cf.updateCoupon(coupon);
	}
	
	@CrossOrigin
	@RequestMapping(value="/getCoupon/{id}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("id") long id ) {
	return	cf.getCoupon(id);
	}
	

}
