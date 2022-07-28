package com.CouponManagment.CouponManagment.controllers.request;

import com.CouponManagment.CouponManagment.model.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CouponsByType {
    private TypeEnum type;
}
