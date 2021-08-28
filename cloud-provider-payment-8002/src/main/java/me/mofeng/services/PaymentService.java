package me.mofeng.services;

import me.mofeng.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author mofeng
 * @create 2021/8/27 15:12
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
