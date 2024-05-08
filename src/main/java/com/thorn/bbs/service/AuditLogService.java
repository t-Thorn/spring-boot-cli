package com.thorn.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thorn.bbs.admin.request.AuditLogListRequest;
import com.thorn.bbs.entity.AuditLog;

/**
 * (AuditLog)表服务接口
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:20
 */
public interface AuditLogService extends IService<AuditLog> {
    Page<AuditLog> listPage(AuditLogListRequest request);
}