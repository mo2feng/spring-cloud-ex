package me.mofeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mofeng
 * @create 2021/8/28 11:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderMain3280 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain3280.class, args);
    }
}
