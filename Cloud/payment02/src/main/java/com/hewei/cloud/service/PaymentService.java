package com.hewei.cloud.service;

import com.hewei.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;


public interface PaymentService {

    // 增加
    int insetPayment(@Param("serial") String serial);

    Payment selById(@Param("id") Long id);


}
