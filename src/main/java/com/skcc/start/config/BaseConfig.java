package com.skcc.start.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.skcc.start.repository.jpa")
@EntityScan(value={"com.skcc.start.entity", "com.skcc.fwk.entity"})
public class BaseConfig {
}

