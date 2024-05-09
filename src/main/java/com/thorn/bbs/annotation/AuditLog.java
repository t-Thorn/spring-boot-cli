package com.thorn.bbs.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>描述: 审计日志 </p>
 * <p>创建时间: 2024/5/9 15:01 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {

    String value() default "";
}