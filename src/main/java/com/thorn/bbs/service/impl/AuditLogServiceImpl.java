package com.thorn.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thorn.bbs.admin.request.AuditLogListRequest;
import com.thorn.bbs.entity.AuditLog;
import com.thorn.bbs.mapper.AuditLogMapper;
import com.thorn.bbs.service.AuditLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * (AuditLog)表服务实现类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:20
 */
@Service
public class AuditLogServiceImpl extends ServiceImpl<AuditLogMapper, AuditLog> implements AuditLogService {
    @Override
    public Page<AuditLog> listPage(AuditLogListRequest request) {
        Page<AuditLog> page = new Page<>(request.getPageNo(), request.getPageSize());
        LambdaQueryWrapper<AuditLog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Objects.nonNull(request.getSuccess()), AuditLog::isSuccess, request.getSuccess())
                .eq(StringUtils.isNotBlank(request.getClientIp()), AuditLog::getClientIp, request.getClientIp())
                .eq(StringUtils.isNotBlank(request.getMethodName()), AuditLog::getMethodName, request.getMethodName())
                .eq(StringUtils.isNotBlank(request.getClassName()), AuditLog::getClassName, request.getClassName())
                .eq(StringUtils.isNotBlank(request.getOperation()), AuditLog::getOperation, request.getOperation())
                .eq(Objects.nonNull(request.getUserId()), AuditLog::getUserId, request.getUserId())
                .between(Objects.nonNull(request.getCreateBeginTime()) && Objects.nonNull(request.getCreateEndTime()), AuditLog::getCreateTime, request.getCreateBeginTime(),
                        request.getCreateEndTime())
                .orderByDesc(AuditLog::getId);
        return page(page, wrapper);
    }
}