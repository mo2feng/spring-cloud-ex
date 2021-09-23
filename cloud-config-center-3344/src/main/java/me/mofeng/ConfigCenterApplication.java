package me.mofeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author mofeng
 * @date 2021/9/22 17:02
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication.class,args);
    }
}
