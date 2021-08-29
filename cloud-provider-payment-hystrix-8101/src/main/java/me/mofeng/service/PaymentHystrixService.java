package me.mofeng.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author mofeng
 * @create 2021/8/28 17:14
 */
@Service
public class PaymentHystrixService {

    /**
     * 正常访问的方法
     *
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id) {
        return "线程池:" + Thread.currentThread().getName()
                + "payment_info_ok,id" + id + "\tO(∩_∩)O哈哈~";
    }

    /**
     * 模拟复杂的流程,需要长时间耗时
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
        //设置一个运行过程中的异常
//        int age = 10/0;
        //设置 sleep 时间用于超时控制
        int seconds = 3;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池:" + Thread.currentThread().getName()
                + "payment_info_timeout,id" + id + "\tO(∩_∩)O哈哈~" +
                ",耗时 " + seconds + "秒";
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName()
                + "payment_info_timeout,id" + id + "\tε=(´ο｀*)))唉";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后断路
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("****** id 不能小于 0 ******");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t 调用成功,流水号" + serialNumber;
//        return "\t 调用成功,流水号" + serialNumber;
    }

    public String paymentCircuitBreakerHandler(Integer id) {
        return "id 不能小于 0,当前 id" + id;
    }

}
