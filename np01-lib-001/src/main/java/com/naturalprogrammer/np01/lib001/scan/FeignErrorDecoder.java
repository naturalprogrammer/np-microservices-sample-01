package com.naturalprogrammer.np01.lib001.scan;

import java.io.IOException;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.io.CharStreams;
import com.naturalprogrammer.np01.lib001.scan.exceptions.MyFeignException;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Throws a FeignException when an error response
 * is received by some feign client when calling another module
 */
@Component
public class FeignErrorDecoder implements ErrorDecoder {

    private static final Logger log = LoggerFactory.getLogger(FeignErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {

        String body;

        try (Reader reader = response.body().asReader()) {

            body = CharStreams.toString(reader);
            log.info("{} returned {} {}", methodKey, response.status(), body);

        } catch (IOException e) {

            body = "{\"error\", \"" + response.reason() + "\"}";
            log.warn("Exception: ", e);
        }

        return new MyFeignException(response.status(), body);
    }
}
