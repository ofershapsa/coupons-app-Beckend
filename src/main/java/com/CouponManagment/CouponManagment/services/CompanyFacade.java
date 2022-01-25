package com.CouponManagment.CouponManagment.services;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CouponRepository;

@Service
@Scope("prototype")
public class CompanyFacade implements CouponClientFacade {

	@Autowired
	private CouponRepository coupRepo;

	@Autowired
	private CompanyRepository cr;

	@Autowired
	private CouponRepository cour;

	public CompanyFacade() {

	}

	public void createCoupon(Coupon coupon) {
		coupRepo.save(coupon);

	}

	public void removeCoupon(long id) {
		coupRepo.deleteById(id);
	}

	public void updateCoupon(Coupon coup) {
		coupRepo.saveAndFlush(coup);
	}

	public Coupon getCoupon(long id) {
	
		return coupRepo.getOne(id);
	}

	/*
	 * public List<Coupon> getAllCouponsByCompany(long id) {
	 * 
	 * return companyDAO.getCouponsListByCompany(id); }
	 */
	public List<Coupon> getAllCouponsByCompany(String companyName) {

		return (List<Coupon>) cr.findByCompanyName(companyName).getCouponsList();
	}

	public List<Coupon> getCouponsByType(String token ) {
		List<Coupon> allCouponsByCompany = getAllCouponsByCompany(token);

		// List<Coupon> allCouponsByType= coupInterface.getCouponsByType(te);
		List<Coupon> couponsCompanyByType = new Vector<Coupon>();
		/*for (Coupon curr : allCouponsByCompany) {
			if (curr.getType().equals()) {
				couponsCompanyByType.add(curr);
			}
		}*/

		return couponsCompanyByType;
	}

	public List<Coupon> getCouponsByPrice(Double price, String token) {
		List<Coupon> allCouponsByCompany = getAllCouponsByCompany(token);
		List<Coupon> couponsCompanyByPrice = new Vector<Coupon>();
		for (Coupon curr : allCouponsByCompany) {
			if (curr.getPrice() <= price) {
				couponsCompanyByPrice.add(curr);
			}
		}
		return couponsCompanyByPrice;
	}

	public List<Coupon> getCouponByDate(java.util.Date date, String token) {
		List<Coupon> allCouponsByCompany = getAllCouponsByCompany(token);
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
