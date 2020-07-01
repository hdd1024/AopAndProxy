package com.example.aop_library;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.aop_library.annotation.NetWorkState;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;


/***********************************************************
 * 创建时间:2020-07-01
 * 作   者: [hanmingze]
 * 功能描述: <网络检查切面>
 * 备注信息: {}
 * @see
 **********************************************************/
@Aspect
public class NetWorkAspect {

    @Pointcut("execution(@com.example.aop_library.annotation.NetWorkState * *(..))")
    public void checkNetWork() {
    }

    @Around("checkNetWork()")
    public Object neteWorkCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d("aaaaa", "进入切面了");
        //获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //获取方法的注解
        NetWorkState annotation = signature.getMethod().getAnnotation(NetWorkState.class);
        if (annotation != null) {
            String hint = annotation.hint();
            //获取使用注解了的上下文this
            Object aThis = joinPoint.getThis();
            //获取Context
            Context context = getContext(aThis);
            if (context != null) {
                Toast.makeText(context, hint, Toast.LENGTH_SHORT).show();
            }
        }
         return    joinPoint.proceed();

    }

    public Context getContext(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        } else if (obj instanceof Fragment) {
            return ((Fragment) obj).getContext();
        }

        return null;
    }
}
