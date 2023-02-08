package com.jalivv.boot.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "share.v2ray")
public class V2rayProperties {

    private String serverName;

    private String certificate;

}