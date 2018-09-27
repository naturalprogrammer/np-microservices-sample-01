package com.naturalprogrammer.np01.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.np01.auth.domain.User;
import com.naturalprogrammer.spring.lemon.LemonController;

@RestController
@RequestMapping(MyLemonController.BASE_URI)
public class MyLemonController extends LemonController<User, Long> {
	
	public static final String BASE_URI = "/api/core";

}