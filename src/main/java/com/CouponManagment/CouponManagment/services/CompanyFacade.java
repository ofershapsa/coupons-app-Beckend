package com.CouponManagment.CouponManagment.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.CouponManagment.CouponManagment.config.JwtTokenUtil;
import com.CouponManagment.CouponManagment.controllers.CompanyController;
import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.dto.TypeEnum;
import com.CouponManagment.CouponManagment.repository.CompanyDAO;
import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CouponDAO;
import com.CouponManagment.CouponManagment.repository.CouponReposirory;
import com.CouponManagment.CouponManagment.serviceForJWT.CustomUserDetails;
import com.CouponManagment.CouponManagment.serviceForJWT.JwtUserDetailsService;

@Service
@Scope("prototype")
public class CompanyFacade implements CouponClientFacade {

	@Autowired
	private CouponDAO coupRepo;

	@Autowired
	private CompanyRepository cr;

	@Autowired
	private CouponReposirory cour;

	public CompanyFacade() {

	}

	public void createCoupon(Coupon coupon) {
		coupRepo.addCoupon(coupon);

	}

	public void removeCoupon(Coupon coupon) {
		coupRepo.deleteCoupon(coupon.getId());
	}

	public void updateCoupon(Coupon coup) {
		coupRepo.updateCoupon(coup.getId(), coup);
	}

	public Coupon getCoupon(long id) {
	
		return coupRepo.findCoupon(id);
	}

	/*
	 * public List<Coupon> getAllCouponsByCompany(long id) {
	 * 
	 * return companyDAO.getCouponsListByCompany(id); }
	 */
	public List<Coupon> getAllCouponsByCompany(HttpServletRequest request) {
		String companyName = getcookie(request);
		Company company = cr.findByCompanyName(companyName);
		return (List<Coupon>) company.getCouponsList();
	}

	public List<Coupon> getCouponsByType(TypeEnum te, HttpServletRequest request) {
		List<Coupon> allCouponsByCompany = getAllCouponsByCompany(request);
		// List<Coupon> allCouponsByType= coupInterface.getCouponsByType(te);
		List<Coupon> couponsCompanyByType = new Vector<Coupon>();
		for (Coupon curr : allCouponsByCompany) {
			if (curr.getType().equals(te)) {
				couponsCompanyByType.add(curr);
			}
		}

		return couponsCompanyByType;
	}

	public List<Coupon> getCouponsByPrice(Double price, HttpServletRequest request) {
		List<Coupon> allCouponsByCompany = getAllCouponsByCompany(request);
		List<Coupon> couponsCompanyByPrice = new Vector<Coupon>();
		for (Coupon curr : allCouponsByCompany) {
			if (curr.getPrice() <= price) {
				couponsCompanyByPrice.add(curr);
			}
		}
		return couponsCompanyByPrice;
	}

	public List<Coupon> getCouponByDate(java.util.Date date, HttpServletRequest request) {
		List<Coupon> allCouponsByCompany = getAllCouponsByCompany(request);
		System.out.println("companyCoupons"+allCouponsByCompany);
		List<Coupon> couponsCompanyByDate = new Vector<Coupon>();
		for (Coupon curr : allCouponsByCompany) {
			
			if ((curr.getEndDate().before(date)) || (curr.getEndDate().equals(date))) {
				couponsCompanyByDate.add(curr);
			}
		}
		System.out.println("couponsCompanyByDate"+couponsCompanyByDate);
		return couponsCompanyByDate;
	}

	public String getcookie(HttpServletRequest request) {

		javax.servlet.http.Cookie[] cookies = request.getCookies();

		String cookieName = "userName";

		String defaultValue = "not found";

		for (int i = 0; i < cookies.length; i++) {

			javax.servlet.http.Cookie cookie = cookies[i];

			if (cookieName.equals(cookie.getName()))

				return (cookie.getValue());

		}

		return (defaultValue);

	}

}
