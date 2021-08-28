package me.mofeng.service;

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
     * @param id
     * @return
     */
    public String paymentInfoTimeout(Integer id) {
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


}
