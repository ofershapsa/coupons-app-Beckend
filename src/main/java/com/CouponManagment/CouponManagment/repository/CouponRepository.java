package com.CouponManagment.CouponManagment.repository;




import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.CouponManagment.CouponManagment.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.dto.TypeEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CouponRepository extends JpaRepository<Coupon,Long > {
public List<Coupon> getCouponsByTypeAndCompanyID(TypeEnum te,Long companyID);
public List<Coupon> getCouponByPriceLessThanEqualAndCompanyID(Double price,Long companyID);
public List<Coupon> getCouponByEndDateBeforeAndCompanyID(LocalDateTime date, Long companyID);
public boolean existsCouponByAmountGreaterThanEqualAndId(Integer amount,Long id);
public  boolean existsCouponByIdAndEndDateAfterAndStartDateBefore(Long id,LocalDateTime endDate,LocalDateTime startDate);
@Query(value = "select coupon.id from coupons coupon " +
        " where coupon.amount >=  :amount  AND " +
        "        NOT EXISTS(SELECT cl.customer_id FROM customers_coupons_list cl " +
        "        WHERE cl.customer_id = :customerID AND cl.coupons_list_id=coupon.id) ",
        nativeQuery = true)
public List<Long>
getCouponsByAmountGreaterThanAndCouponFreeForCustomer
        (@Param("amount") Integer amount,@Param("customerID") Long customerID);


}
