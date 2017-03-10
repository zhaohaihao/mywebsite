package com.zhh.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是否需要登陆
 * @date 2017-3-10 下午4:07:27
 * @author zhaohaihao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginTag {
	boolean needLogin() default true;
}
