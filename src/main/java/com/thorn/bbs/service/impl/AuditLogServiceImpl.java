package com.thorn.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thorn.bbs.api.request.AuditLogListRequest;
import com.thorn.bbs.entity.AuditLogRecord;
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
public class AuditLogServiceImpl extends ServiceImpl<AuditLogMapper, AuditLogRecord> implements AuditLogService {
    @Override
    public Page<AuditLogRecord> listPage(AuditLogListRequest request) {
        Page<AuditLogRecord> page = new Page<>(request.getPageNo(), request.getPageSize());
        LambdaQueryWrapper<AuditLogRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Objects.nonNull(request.getSuccess()), AuditLogRecord::isSuccess, request.getSuccess())
                .like(StringUtils.isNotBlank(request.getClientIp()), AuditLogRecord::getClientIp, request.getClientIp())
                .like(StringUtils.isNotBlank(request.getMethodName()), AuditLogRecord::getMethodName, request.getMethodName())
                .like(StringUtils.isNotBlank(request.getClassName()), AuditLogRecord::getClassName, request.getClassName())
                .like(StringUtils.isNotBlank(request.getOperation()), AuditLogRecord::getOperation, request.getOperation())
                .eq(StringUtils.isNotBlank(request.getUsername()), AuditLogRecord::getUsername, request.getUsername())
                .between(Objects.nonNull(request.getCreateBeginTime()) && Objects.nonNull(request.getCreateEndTime()), AuditLogRecord::getCreateTime, request.getCreateBeginTime(),
                        request.getCreateEndTime())
                .orderByDesc(AuditLogRecord::getId);
        return page(page, wrapper);
    }
}