package com.hnu.webmanagementdemo.AOP;

import com.alibaba.fastjson.JSONObject;
import com.hnu.webmanagementdemo.Mapper.OperateLogMapper;
import com.hnu.webmanagementdemo.Pojo.OperateLog;
import com.hnu.webmanagementdemo.Utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogRecordAspect {
    //注入请求
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.hnu.webmanagementdemo.MyAnnotation.MylogAnno)")
    public Object logRecord(ProceedingJoinPoint joinPoint) throws Throwable {


        //运用类似反射的方法
        //1.获取操作人的信息调用JWT令牌获取
        String JWT = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(JWT);
        Integer id = (Integer)claims.get("id");

        //2.获取操作时间
        LocalDateTime localDateTime = LocalDateTime.now();

        //3.获取操作的目标对象类名
        String targetObjectName = joinPoint.getTarget().getClass().toString();

        //4.操作方法名
        String methodName = joinPoint.getSignature().getName();

        //5.操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        //调用原始目标方法运行
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //方法返回值
        String returnValue = JSONObject.toJSONString(result);

        //操作耗时
        Long costTime = end - begin;

        OperateLog operateLoglog = new OperateLog(null,id,localDateTime,targetObjectName,methodName,methodParams,returnValue,costTime);

        operateLogMapper.insert(operateLoglog);

        log.info("AOP记录操作日志: {}" , operateLoglog);

        return result;



    }
}
