package com.naturalprogrammer.np01.profile.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("auth")
public interface AuthClient {
	
	@GetMapping("/api/core/users/{id}")
	void fetchUserById(@PathVariable Long id);
}
