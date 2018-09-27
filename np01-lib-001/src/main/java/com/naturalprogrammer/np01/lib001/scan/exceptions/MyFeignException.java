package com.naturalprogrammer.np01.lib001.scan.exceptions;

/**
 * Gets thrown by FeignErrorDecoder
 * when a feign request receives an error response
 */
public class MyFeignException extends RuntimeException {

	private static final long serialVersionUID = -507478854309522141L;

	private int status;
    private String body;

    public MyFeignException(int status, String body) {

        super();
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
