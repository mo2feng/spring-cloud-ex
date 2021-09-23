package me.mofeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mofeng
 * @date 2021/9/23 11:26
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3366.class, args);
    }
}
