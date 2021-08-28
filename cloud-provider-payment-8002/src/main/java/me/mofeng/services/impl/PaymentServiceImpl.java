package me.mofeng.services.impl;

import me.mofeng.dao.PaymentDao;
import me.mofeng.entities.Payment;
import me.mofeng.services.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mofeng
 * @create 2021/8/27 15:14
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
