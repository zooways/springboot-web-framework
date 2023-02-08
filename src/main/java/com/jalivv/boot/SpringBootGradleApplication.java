package com.jalivv.boot;

import com.jalivv.boot.config.UserConfig;
import com.jalivv.boot.config.V2rayProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.jalivv.boot.mapper")
public class SpringBootGradleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootGradleApplication.class, args);

        V2rayProperties bean = run.getBean(V2rayProperties.class);
        System.out.println(bean);
    }

}
