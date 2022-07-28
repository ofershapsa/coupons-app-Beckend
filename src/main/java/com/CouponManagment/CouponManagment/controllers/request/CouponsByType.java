package com.CouponManagment.CouponManagment.controllers.request;

import com.CouponManagment.CouponManagment.dto.TypeEnum;
import com.CouponManagment.CouponManagment.services.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CouponsByType {
    private TypeEnum type;
}
