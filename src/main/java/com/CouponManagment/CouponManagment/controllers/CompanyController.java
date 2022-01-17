package com.CouponManagment.CouponManagment.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.dto.Customer;
import com.CouponManagment.CouponManagment.dto.TypeEnum;
import com.CouponManagment.CouponManagment.serviceForJWT.JwtUserDetailsService;
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
	public List<Coupon>  getAllCouponsByCompany(HttpServletRequest request) {
		
		
		return cf.getAllCouponsByCompany(request);
	}
	
	@CrossOrigin
	@RequestMapping(value="/createCoupon", method = RequestMethod.POST)
	public void createCoupon(@RequestBody Coupon coupon) {
		cf.createCoupon(coupon);
	}
	

	@CrossOrigin
	@RequestMapping(value = "/getCouponsByType/{type}", method = RequestMethod.GET)
	public List<Coupon> getCouponsByType(@PathVariable("type")TypeEnum te,HttpServletRequest request) {
		
		return cf.getCouponsByType(te,request);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/getCouponsByPrice/{price}", method = RequestMethod.GET)
	public List<Coupon> getCouponsByPrice(@PathVariable("price")double price,HttpServletRequest request) {
		
		return cf.getCouponsByPrice(price, request);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCouponsByDate/{date}", method = RequestMethod.GET)
	public List<Coupon> getCouponsByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date date ,HttpServletRequest request) {
		
		return cf.getCouponByDate(date, request);
	}
	
	@CrossOrigin
	@RequestMapping(value="/removeCoupon", method = RequestMethod.DELETE)
	public void removeCoupon(@RequestBody Coupon coupon) {
		cf.removeCoupon(coupon);
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
