package com.hewei.cloud.service.impl;

import com.hewei.cloud.dao.PaymentDao;
import com.hewei.cloud.entity.Payment;
import com.hewei.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    public int insetPayment(String serial) {
        return paymentDao.insetPayment(serial);
    }

    public Payment selById(Long id) {
        return paymentDao.selById(id);
    }


}
