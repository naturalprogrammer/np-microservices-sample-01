package com.naturalprogrammer.np01.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("auth")
public interface AuthClient {
	
	@GetMapping("/api/core/fetch-full-token")
	MyToken fetchFullToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
}
