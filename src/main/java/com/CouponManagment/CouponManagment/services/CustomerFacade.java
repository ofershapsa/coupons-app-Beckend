package com.CouponManagment.CouponManagment.services;

import java.time.LocalDateTime;
import java.util.List;

import com.CouponManagment.CouponManagment.config.JwtTokenUtil;
import com.CouponManagment.CouponManagment.model.Customer;
import com.CouponManagment.CouponManagment.model.TypeEnum;
import com.CouponManagment.CouponManagment.repository.CouponRepository;
import com.CouponManagment.CouponManagment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.CouponManagment.CouponManagment.model.Coupon;


@Service
@Scope("prototype")
public class CustomerFacade implements CouponClientFacade {
    @Autowired
    JwtTokenUtil jwu;
    @Autowired
    private CouponRepository coupRepo;
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerFacade() {

    }

    public List<Coupon> getAllPurchasedCoupons() {
        Long customerId = jwu.getId();
        Customer customer = customerRepository.findById(customerId).get();
        return customer.getCouponsList();
    }


        public List<Long> getAllPurchasedCouponsByType(TypeEnum te) {
            return customerRepository.getCouponsListByIdAndType(jwu.getId(),te);
        }

            public List<Long> getAllPurchasedCouponsByPrice(Double price) {
                return customerRepository.getCouponByPriceLessThanEqualAndId(price,jwu.getId());
            }

    public List<Long> purchaseCoupon(Long couponID) {
        Long customerId = jwu.getId();
        Customer customer= customerRepository.findById(customerId).get();
        List<Coupon> coupons = getAllPurchasedCoupons();
        Coupon coupon = coupRepo.findById(couponID).get();
        if (coupon == null) {
            System.out.println("null exception!!!!!");
           return null ;
        }
        if (customerRepository.existCouponsListByIdAndCouponId(customerId, coupon.getId())) {
            System.out.println("this coupon is already exists !!!!!");
            return null ;
        }
        if (!coupRepo.existsCouponByAmountGreaterThanEqualAndId(1, coupon.getId())) {
            System.out.println("the amount of this coupon is 0 !!!!!");
            return null ;
        }
        if (coupRepo.existsCouponByIdAndEndDateAfterAndStartDateBefore(coupon.getId(), LocalDateTime.now()
                , LocalDateTime.now())) {
            System.out.println("this coupon has Expired!!!!!");
            return null ;
        }
        coupons.add(coupon);
        customer.setCouponsList(coupons);
        coupon.setAmount(coupon.getAmount()-1);
        coupRepo.save(coupon);
        customerRepository.save(customer);
        System.out.println(coupons);

        return coupRepo.getCouponsByAmountGreaterThanAndCouponFreeForCustomer(0,customer.getId());

    }


}
