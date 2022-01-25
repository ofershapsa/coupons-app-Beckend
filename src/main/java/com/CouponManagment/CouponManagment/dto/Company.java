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
@Table(name="companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String companyName;
    private String password;
    private String email;
	@Singular("couponsList")
	@OneToMany (fetch = FetchType.EAGER)
    private List<Coupon> couponsList = new ArrayList<>() ;
        


	
	

}
