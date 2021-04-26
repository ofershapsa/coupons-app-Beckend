package com.CouponManagment.CouponManagment.dto;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="coupons")
public class Coupon {
	private Long ID;
	private Company company;
	private Customer customer;
	private String TITLE;
	private java.util.Date START_DATE;
	private java.util.Date END_DATE;
	private Integer AMOUNT;
	private TypeEnum TYPE;
	private String MESSAGE;
	private Double PRICE;
	private String IMAGE;
	
	 
	
    @Id
    @GeneratedValue
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	
	@Column(nullable=false)
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	
	@Column(nullable=false)
	public Integer getAMOUNT() {
		return AMOUNT;
	}
	@Column(nullable=false)
	public java.util.Date getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(java.util.Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	@Column(nullable=false)
	public java.util.Date getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(java.util.Date eND_DATE) {
		END_DATE = eND_DATE;
	}
	public void setAMOUNT(Integer aMOUNT) {
		AMOUNT = aMOUNT;
	}
	@Column(nullable=false)
	public TypeEnum getTYPE() {
		return TYPE;
	}
	public void setTYPE(TypeEnum tYPE) {
		TYPE = tYPE;
	}
	@Column(nullable=false)
	public String getMESSAGE() {
		return MESSAGE;
	}
	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}
	@Column(nullable=false)
	public Double getPRICE() {
		return PRICE;
	}
	public void setPRICE(Double pRICE) {
		PRICE = pRICE;
	}
	@Column(nullable=false)
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
	
	@ManyToOne
	//@JoinColumn(name = "ID",insertable = false, updatable = false)
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@ManyToOne
	//@JoinColumn(name = "ID",insertable = false, updatable = false)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Coupon [ID=" + ID + ", company=" + company + ", customer=" + customer + ", TITLE=" + TITLE
				+ ", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE + ", AMOUNT=" + AMOUNT + ", TYPE=" + TYPE
				+ ", MESSAGE=" + MESSAGE + ", PRICE=" + PRICE + ", IMAGE=" + IMAGE + "]";
	}
}
	
	
	

	
	
	
	

