package com.naturalprogrammer.np01.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.naturalprogrammer.spring.lemon.commons.util.LecUtils;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Validates an authorization token and then replaces it with a
 * self sufficient short-term token (for inter-service communications) that won't
 * be validated again downstream
 */
@Component
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorizationTokenConvertionFilter implements WebFilter {
	
	private static final Log log = LogFactory.getLog(AuthorizationTokenConvertionFilter.class);
	
	private AuthClient authClient;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		
		String token = getAuthHeader(exchange);		
		log.debug("Original token: " + token);
			
		if(token == null || !token.startsWith(LecUtils.TOKEN_PREFIX))
			return chain.filter(exchange); // Anonymous request, just pass
		
		String fullToken = fetchFullToken(token);
		log.debug("New token: " + fullToken);
		
		// replace the token
		exchange = exchange.mutate().request(
				exchange.getRequest().mutate().headers(
						headers -> headers.set(HttpHeaders.AUTHORIZATION, fullToken)				
				).build())
			.build();
		
		log.debug("Changed token: " + getAuthHeader(exchange));
		return chain.filter(exchange);
	}

	/**
	 * Validates the existing token and creates a full token.
	 */
	private String fetchFullToken(String token) {
		
		 /* Calls the auth service, but better might be
		  * to have a redis store of replicated users
		  */
		MyToken myToken = authClient.fetchFullToken(token);		
		return myToken.getToken();
	}
	
	private String getAuthHeader(ServerWebExchange exchange) {
		
		return exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
	}
}
