package com.banking.ms.bankingmsproducts.config;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class TrackingIdFilter implements WebFilter {

    public static final String TRACK_ID = "X-Tracking-Id";

    @Override
    @NonNull
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String trackId = exchange.getRequest().getHeaders().getFirst(TRACK_ID);
        if(trackId == null) return chain.filter(exchange);
        return chain.filter(exchange).contextWrite(ctx -> ctx.put(TRACK_ID, trackId));
    }
}
