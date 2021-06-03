package com.hhl.kunkka.client.transactionannotation;

import com.hhl.kunkka.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ATTransactionalAspect {

    @Pointcut("@annotation(com.hhl.kunkka.client.transactionannotation.ATTransactional)")
    public void transactionalAspect() {
    }

    @Before("transactionalAspect()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("TODO create global transaction");
        // TODO create global transaction
        RootContext.bindXID(String.valueOf(System.currentTimeMillis()));
    }

    @After("transactionalAspect()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("TODO commit global transaction");
        // TODO commit global transaction
    }

    @AfterThrowing("transactionalAspect()")
    public void doException(JoinPoint joinPoint) {
        log.info("TODO rollback global transaction");
        // TODO rollback global transaction
    }
}