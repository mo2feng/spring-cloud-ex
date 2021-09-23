package me.mofeng.controllers;

import lombok.extern.slf4j.Slf4j;
import me.mofeng.entities.CommonResult;
import me.mofeng.entities.Payment;
import me.mofeng.services.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author mofeng
 * @create 2021/8/27 15:17
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        System.out.println(payment);
        int result = paymentService.create(payment);
        log.info("****插入结果***，{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据成功,Server Port:" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果***，{}", result);
        if (result != null) {
            return new CommonResult<>(200, "查询成功,Server Port:" + serverPort, result);
        } else {
            return new CommonResult<>(444, "没有记录：" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (var element : services) {
            log.info("**** element: {}", element);
        }
        var instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (var instance : instances) {
            log.info("{}\t{}\t{}\t{}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //模拟长流程调用
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentServicePort() {
        return serverPort;
    }
}
