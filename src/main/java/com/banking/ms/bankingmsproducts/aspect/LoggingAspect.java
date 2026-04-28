package com.banking.ms.bankingmsproducts.aspect;

import com.banking.ms.bankingmsproducts.config.TrackingIdFilter;
import com.banking.ms.bankingmsproducts.util.MdcUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Around("execution(* com.banking.ms.bankingmsproducts.service.implementation.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        return ((Flux<?>) joinPoint.proceed())
                .contextWrite(ctx -> {
                    String id = ctx.getOrDefault(TrackingIdFilter.TRACK_ID, "No-ID");
                    MdcUtil.map(ctx);
                    log.info("AOP Log [ID:{}] - starting method : {}()",id,  methodName);
                    return ctx;
                })
                .doOnEach(signal -> {
                    if (signal.isOnComplete()) {
                        String id = signal.getContextView().getOrDefault(TrackingIdFilter.TRACK_ID, "No-ID");
                        log.info("AOP Log [ID:{}] - method : {}() finalized successfully", id, methodName);
                    } else if (signal.isOnError()) {
                        String id = signal.getContextView().getOrDefault(TrackingIdFilter.TRACK_ID, "No-ID");
                        log.error("AOP Log [ID:{}] - method : {}() failed with error: {}",
                                id, methodName, signal.getThrowable().getMessage());
                    }
                });
    }
}
