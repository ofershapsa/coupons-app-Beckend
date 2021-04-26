package com.CouponManagment.CouponManagment.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	private Long ID;
	private  String CUST_NAME;
    private String PASSWORD;
    private Collection<Coupon> couponsList = new ArrayList<>() ;
    
    
    @Id
    @GeneratedValue
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	@Column(nullable=false)
	public String getCUST_NAME() {
		return CUST_NAME;
	}
	public void setCUST_NAME(String cUST_NAME) {
		CUST_NAME = cUST_NAME;
	}
	@Column(nullable=false)
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	@OneToMany (targetEntity = Coupon.class,fetch = FetchType.EAGER)
	public Collection<Coupon> getCouponsList() {
		return couponsList;
	}
	public void setCouponsList(Collection<Coupon> couponsList) {
		this.couponsList = couponsList;
	}
	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", CUST_NAME=" + CUST_NAME + ", PASSWORD=" + PASSWORD + "]";
	}
    
		 
	 
	

}
