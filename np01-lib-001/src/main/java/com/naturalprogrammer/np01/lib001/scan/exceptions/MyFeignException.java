package com.naturalprogrammer.np01.lib001.scan.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Gets thrown by FeignErrorDecoder
 * when a feign request receives an error response
 */
@Getter @Setter @AllArgsConstructor
public class MyFeignException extends RuntimeException {

	private static final long serialVersionUID = -507478854309522141L;

	private int status;
    private String body;
}
