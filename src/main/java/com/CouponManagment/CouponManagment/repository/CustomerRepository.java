package com.CouponManagment.CouponManagment.repository;

import com.CouponManagment.CouponManagment.model.Coupon;
import com.CouponManagment.CouponManagment.model.TypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CouponManagment.CouponManagment.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByCustomerName(String customerName);
	Coupon   findCouponById(Long id);
	@Query("SELECT CASE WHEN count(c) >0 then true else false end" +
			" FROM Customer c JOIN c.couponsList e " +
			"WHERE c.id=:customerID and e.id= :couponID ")
	Boolean existCouponsListByIdAndCouponId(@Param("customerID") Long customerID,@Param("couponID") Long couponID);
	@Query("SELECT e.id FROM Customer customer  join customer.couponsList e  " +
			"where customer.id = :customerID and e.type = :type ")
    List<Long> getCouponsListByIdAndType(@Param("customerID") Long id,@Param("type")TypeEnum type);
	@Query("SELECT e.id FROM Customer customer  join customer.couponsList e  " +
			"where customer.id = :customerID and e.price <= :price ")
	List<Long> getCouponByPriceLessThanEqualAndId(@Param("price") Double price,@Param("customerID")Long id);

}
