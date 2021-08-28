package me.mofeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mofeng
 * @create 2021/8/28 16:50
 */
@SpringBootApplication
@EnableEurekaClient
public class HystrixPayment8101 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8101.class, args);
    }
}
