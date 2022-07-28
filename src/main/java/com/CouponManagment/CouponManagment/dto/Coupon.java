package com.CouponManagment.CouponManagment.dto;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coupons")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  Long companyID;
	private String title;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer amount;
	@Enumerated(EnumType.STRING)
	private TypeEnum type;
	private String message;
	private Double price;
	private String image;


}
