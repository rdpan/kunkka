package com.hhl.kunkka.client.transactionannotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
public @interface ATTransactional {
    int timeoutMills() default 60000;
    String name() default "";
    Class<? extends Throwable>[] rollbackFor() default {};
}
