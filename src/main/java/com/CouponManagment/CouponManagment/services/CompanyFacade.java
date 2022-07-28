package com.CouponManagment.CouponManagment.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.CouponManagment.CouponManagment.config.JwtTokenUtil;
import com.CouponManagment.CouponManagment.model.TypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.CouponManagment.CouponManagment.model.Coupon;
import com.CouponManagment.CouponManagment.repository.CompanyRepository;
import com.CouponManagment.CouponManagment.repository.CouponRepository;

@Service
@Scope("prototype")
public class CompanyFacade implements CouponClientFacade {
    @Autowired
    JwtTokenUtil jwu;

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


    public List<Coupon> getAllCouponsByCompany(String companyName) {

        return (List<Coupon>) cr.findByCompanyName(companyName).getCouponsList();
    }

    public List<Coupon> getCouponsByType(TypeEnum ct) {

        Long compenyID = jwu.getId();
        System.out.println(compenyID);

        List<Coupon> couponsCompanyByType = coupRepo.getCouponsByTypeAndCompanyID(ct, compenyID);
        System.out.println(ct);
        System.out.println(couponsCompanyByType);


        return couponsCompanyByType;
    }

    public List<Coupon> getCouponsByPrice(Double price) {
        Long compenyID = jwu.getId();

        List<Coupon> couponsCompanyByPrice = coupRepo.getCouponByPriceLessThanEqualAndCompanyID(price, compenyID);

        return couponsCompanyByPrice;
    }

    public List<Coupon> getCouponByDate(Date date) {
        Long compenyID = jwu.getId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        List<Coupon> couponsCompanyByDate = coupRepo.getCouponByEndDateBeforeAndCompanyID(dateTime, compenyID);

        return couponsCompanyByDate;
    }




}
