package com.CouponManagment.CouponManagment.dto;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;





@Entity
@Table(name="companies")
public class Company {
	private Long ID;
    private String COMP_NAME;
    private String PASSWORD;
    private String EMAIL;
   
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
	public String getCOMP_NAME() {
		return COMP_NAME;
	}
	public void setCOMP_NAME(String cOMP_NAME) {
		COMP_NAME = cOMP_NAME;
	}
	@Column(nullable=false)
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	@Column(nullable=false)
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
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
		return "Company [ID=" + ID + ", COMP_NAME=" + COMP_NAME + ", PASSWORD=" + PASSWORD + ", EMAIL=" + EMAIL + "]";
	}
	
    
    
    



}
