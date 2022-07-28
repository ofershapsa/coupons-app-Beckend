package com.CouponManagment.CouponManagment.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  String customerName;
    private String password;
	@Singular("couponsList")
	@ManyToMany (fetch = FetchType.EAGER)
   private List<Coupon> couponsList = new ArrayList<>() ;
    
    

}
