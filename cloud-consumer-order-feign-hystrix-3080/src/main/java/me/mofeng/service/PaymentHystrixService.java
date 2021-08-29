package me.mofeng.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/ok/{id}")
    public  String paymentInfoOK(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public  String paymentInfoTimeout(@PathVariable("id") Integer id);
}
