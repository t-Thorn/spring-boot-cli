package com.thorn.bbs.api.controller;


import com.thorn.bbs.api.request.AuditLogListRequest;
import com.thorn.bbs.common.api.CommonPage;
import com.thorn.bbs.common.api.CommonResult;
import com.thorn.bbs.entity.AuditLogRecord;
import com.thorn.bbs.service.AuditLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>描述: 审计日志管理 </p>
 * <p>创建时间: 2024/5/6 16:07 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@RestController
@RequestMapping("/auditLog")
@Api(tags = "审计日志")
@Validated
public class AuditLogController {

    @Resource
    private AuditLogService service;

    @ApiOperation("列表")
    @PostMapping("list")
    public CommonResult<CommonPage<AuditLogRecord>> list(@RequestBody AuditLogListRequest request) {
        return CommonResult.success(CommonPage.restPage(service.listPage(request)));
    }
}