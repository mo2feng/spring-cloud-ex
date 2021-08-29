package me.mofeng.controller;


import lombok.extern.slf4j.Slf4j;
import me.mofeng.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mofeng
 * @create 2021/8/28 17:20
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/ok/{id}")
    public  String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOK(id);
        log.info("*******result: {}",result);
        return result;
    }
    @GetMapping("/payment/timeout/{id}")
    public  String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("*******result: {}",result);
        return result;
    }


    @GetMapping("/payment/circuit/{id}")
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        log.info("*******result: {}",result);
        return result;
    }


}
