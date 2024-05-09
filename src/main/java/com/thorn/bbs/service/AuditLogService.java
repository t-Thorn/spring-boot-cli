package com.thorn.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thorn.bbs.api.request.AuditLogListRequest;
import com.thorn.bbs.entity.AuditLogRecord;

/**
 * (AuditLog)表服务接口
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:20
 */
public interface AuditLogService extends IService<AuditLogRecord> {
    Page<AuditLogRecord> listPage(AuditLogListRequest request);
}