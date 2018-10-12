package com.naturalprogrammer.np01.lib001.scan;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.naturalprogrammer.spring.lemon.commons.security.LemonPrincipal;
import com.naturalprogrammer.spring.lemon.commons.util.LecUtils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignAccessTokenRelyInterceptor implements RequestInterceptor {

    private static final Log log = LogFactory.getLog(FeignAccessTokenRelyInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {

    	log.debug("Relying bearer token ...");
    	
    	Authentication auth = SecurityContextHolder
                .getContext().getAuthentication();

    	if (auth == null) // not authenticated
    		return;

	    if (!(auth.getPrincipal() instanceof LemonPrincipal)) // not sure what authentication
	    	return;

    	log.debug("Relyed bearer token " + auth.getCredentials());
        template.header("Authorization", LecUtils.TOKEN_PREFIX + auth.getCredentials());
    }
}
