package me.mofeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mofeng
 * @create 2021/8/28 14:42
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeign3080 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeign3080.class, args);
    }
}
