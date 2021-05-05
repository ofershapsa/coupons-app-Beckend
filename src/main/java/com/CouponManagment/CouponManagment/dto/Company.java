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
@Table(name="companies")
public class Company {
	private Long id;
    private String companyName;
    private String password;
    private String email;
   
    private Collection<Coupon> couponsList = new ArrayList<>() ;
        
    @Id
    @GeneratedValue
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable=false)
	public String getPassword() {
		return password;
	}
	@Column(nullable=false)
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(nullable=false)
	
	public String getEmail() {
		return email;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany (mappedBy ="company",fetch = FetchType.EAGER)
	public Collection<Coupon> getCouponsList() {
		return couponsList;
	}
	public void setCouponsList(Collection<Coupon> couponsList) {
		this.couponsList = couponsList;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", password=" + password + ", email=" + email
				+ ", couponsList=" + couponsList + "]";
	}
	
	

}
