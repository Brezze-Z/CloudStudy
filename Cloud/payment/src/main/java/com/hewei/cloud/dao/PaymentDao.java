package com.hewei.cloud.dao;

import com.hewei.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    // 增加
    int insetPayment(@Param("serial") String serial);

    Payment selById(@Param("id") Long id);



}
