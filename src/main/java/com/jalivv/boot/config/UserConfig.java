package com.jalivv.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Jalivv
 * @create: 2023-02-08 11:24
 **/
@Configuration
@Data
@ConfigurationProperties("user-config.user")
public class UserConfig {
    private String name;
    private String age;
}
