package me.mofeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mofeng
 * @create 2021/8/28 10:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZKOrderMain3180 {
    public static void main(String[] args) {
        SpringApplication.run(ZKOrderMain3180.class, args);
    }
}
