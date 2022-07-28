package com.CouponManagment.CouponManagment.controllers;

import com.CouponManagment.CouponManagment.model.Coupon;
import com.CouponManagment.CouponManagment.model.TypeEnum;
import com.CouponManagment.CouponManagment.services.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@PreAuthorize("hasRole('ROLE_CUSTOMER')")
public class CustomerController {
    @Autowired
    private CustomerFacade customerFacade;

    @CrossOrigin
    @RequestMapping(value = "coupons", method = RequestMethod.GET)
    public List<Coupon> getAllPurchasedCoupons() {

        return customerFacade.getAllPurchasedCoupons();

    }

    @CrossOrigin
    @RequestMapping(value="coupon/{couponID}", method = RequestMethod.POST)
    public List<Long> purchaseCoupon(@PathVariable("couponID")  Long couponID) {
     return  customerFacade.purchaseCoupon(couponID);
    }

    @CrossOrigin
    @RequestMapping(value = "coupons/{type}", method = RequestMethod.GET)
    public List<Long> getAllPurchasedCouponsByType(@PathVariable("type") TypeEnum type) {

        return customerFacade.getAllPurchasedCouponsByType(type);

    }

    @CrossOrigin
    @RequestMapping(value = "coupon/{price}", method = RequestMethod.GET)
    public List<Long> getAllPurchasedCouponsByPrice(@PathVariable("price") Double price) {

        return customerFacade.getAllPurchasedCouponsByPrice(price);

    }
}
