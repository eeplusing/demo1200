package com.eplusing.demo1200.base.aop;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * 日志切面类
 *
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    HttpServletRequest request;

    @Pointcut("bean(*Controller)")
    public void controllerPointCut() {
    }

    @Pointcut("execution(* org.springframework.web.client.RestTemplate.*(..))")
    public void restTemplatePointCut() {
    }



    @Around("restTemplatePointCut()")
    public Object aroundRestTemplatePointCut(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        try {
            result = point.proceed();
        } finally {
            //打印出入参
            printInAndOutParamsJson(point, result);
        }

        return result;
    }

    private void printInAndOutParamsJson(ProceedingJoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        methodName = (className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        String inputParams = "";
        String outParams = "";
        try {
            inputParams = JSON.toJSONString(args);
            outParams = JSON.toJSONString(result);
        } catch (Exception e) {
        }
        log.info("methodName:{};input params:{};output params:{}", methodName, inputParams, outParams);
    }

    @Around("controllerPointCut()")
    public Object aroundControllerPointCut(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();

        printSysLog(point, request );
        Object result = null;
        //执行方法
        try {
            result = point.proceed();
        } finally {
            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            String resultStr = "result toJson error";
            try{
                resultStr = JSON.toJSONString(result);
            }catch (Exception e){}
            printCostTime(point, request, time, resultStr);
        }

        return result;
    }
    private void printSysLog(ProceedingJoinPoint joinPoint, HttpServletRequest request) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        methodName = (className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params = "";
        try{
             params = new Gson().toJson(args);
        }catch (Exception e){

        }
        Map<String, String> headersInfo = getHeadersInfo(request);
        log.info("方法:{},请求参数:{},请求头:{}", methodName, params, JSON.toJSONString(headersInfo));
    }
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
    private void printCostTime(ProceedingJoinPoint joinPoint, HttpServletRequest request, Long time, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        methodName = (className + "." + methodName + "()");

        log.info("方法:{},cost time:{}ms,请求结果={}", methodName, time, result);
    }
}
