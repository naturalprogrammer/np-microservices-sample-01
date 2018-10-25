package com.naturalprogrammer.np01.lib001.scan.exceptions.handlers;

import org.springframework.stereotype.Component;

import com.naturalprogrammer.np01.lib001.scan.exceptions.MyFeignException;
import com.naturalprogrammer.spring.lemon.commons.util.LecUtils;
import com.naturalprogrammer.spring.lemon.exceptions.ErrorResponse;
import com.naturalprogrammer.spring.lemon.exceptions.handlers.AbstractExceptionHandler;

@Component
public class MyFeignExceptionHandler extends AbstractExceptionHandler<MyFeignException> {

	public MyFeignExceptionHandler() {
		super(MyFeignException.class);
	}

	@Override
	public ErrorResponse getErrorResponse(MyFeignException ex) {
		
		ErrorResponse errorResponse;
		
		try {
			
			errorResponse = LecUtils.fromJson(ex.getBody(), ErrorResponse.class);
			
		} catch (Exception e) {
			
			errorResponse = new ErrorResponse();
			errorResponse.setMessage(ex.getBody());
			errorResponse.setStatus(ex.getStatus());
		}
		
		return errorResponse;
	}
}
