package com.example.lib_aop_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***********************************************************
 * 创建时间:2020-07-01
 * 作   者: [hanmingze]
 * 功能描述: <检查网络状态>
 * 备注信息: {}
 * @see
 **********************************************************/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NetWorkState {
    //提示语
    String hint() default "暂无网络哦！";
}
