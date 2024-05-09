package com.thorn.bbs.aspect;

import cn.hutool.json.JSONUtil;
import com.thorn.bbs.annotation.AuditLog;
import com.thorn.bbs.entity.AuditLogRecord;
import com.thorn.bbs.service.AuditLogService;
import com.thorn.bbs.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@Aspect
@Slf4j
public class AuditLogAspect {
    @Resource
    private AuditLogService auditService;
    @Resource
    private IpUtil ipUtil;

    @Around("@within(auditLog) || @annotation(auditLog)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint, AuditLog auditLog) throws Throwable {
        Object result = null;
        Throwable throwable = null;
        AuditLogRecord audit = null;
        auditLog = joinPoint.getTarget().getClass().getDeclaredAnnotation(AuditLog.class);
        audit = this.getAudit(auditLog, joinPoint);

        try {
            result = joinPoint.proceed();
            audit.setSuccess(true);
            audit.setResponse(JSONUtil.toJsonStr(result));
            this.auditService.save(audit);
        } catch (Throwable var7) {
            audit.setSuccess(false);
            audit.setException(var7.getMessage());
            this.auditService.save(audit);
            throwable = var7;
        }

        if (throwable != null) {
            throw throwable;
        } else {
            return result;
        }
    }

    private AuditLogRecord getAudit(AuditLog auditLogRecord, ProceedingJoinPoint joinPoint) {
        AuditLogRecord audit = new AuditLogRecord();
        audit.setClientIp(ipUtil.getIpAddr());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            audit.setUsername(authentication.getName());
        }

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        audit.setClassName(methodSignature.getDeclaringTypeName());
        audit.setMethodName(methodSignature.getName());
        audit.setRequestParam(getRequestParam());
        String operation = auditLogRecord.value();
        audit.setOperation(operation);
        return audit;
    }

    private String getRequestParam() {
        String params = "";
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            // 只记录post方法
            if ("POST".equals(request.getMethod())) {
                // 获取参数, 只取自定义的参数, 自带的HttpServletRequest, HttpServletResponse不管
                BufferedReader br = request.getReader();
                String str;
                StringBuilder wholeStr = new StringBuilder();
                while ((str = br.readLine()) != null) {
                    wholeStr.append(str);
                }
                StringBuilder stringBuilder = new StringBuilder();
                if (wholeStr.length() == 0) {
                    Map<String, String[]> parameterMap = request.getParameterMap();
                    parameterMap.forEach((k, v) -> {
                        if (v != null) {
                            for (String s : v) {
                                //过长的参数就不记录了
                                if (s.length() > 1000) continue;
                                stringBuilder.append(s);
                            }
                        }
                    });
                    params = stringBuilder.toString();
                } else {
                    params = wholeStr.toString();
                }
            }
            if ("GET".equals(request.getMethod())) {
                params = request.getQueryString();
            }
        } catch (IOException e) {
            log.error("获取入参失败:", e);
        }

        return params;
    }
}