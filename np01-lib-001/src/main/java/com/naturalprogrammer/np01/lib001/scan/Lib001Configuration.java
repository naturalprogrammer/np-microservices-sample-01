package com.naturalprogrammer.np01.lib001.scan;

import java.io.Serializable;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.naturalprogrammer.spring.lemon.commons.domain.IdConverter;

import feign.Logger;

@Configuration
@EnableFeignClients
public class Lib001Configuration {

	@Bean
	public IdConverter<Serializable> idConverter() {
		return id -> Long.valueOf(id);
	}

	@Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
