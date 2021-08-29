package me.mofeng.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "----- 来自PaymentFallbackService  OK fall back o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "----- 来自PaymentFallbackService Timeout fall back o(╥﹏╥)o";
    }
}
