package com.thorn.bbs.api.controller;


import com.thorn.bbs.annotation.AuditLog;
import com.thorn.bbs.common.api.CommonResult;
import com.thorn.bbs.manager.SystemManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>描述: 系统管理 </p>
 * <p>创建时间: 2024/5/9 13:58 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@RestController
@RequestMapping("/system")
@Api(tags = "访问记录管理")
@Validated
public class SystemController {
    @Resource
    private SystemManager service;

    @ApiOperation("关机")
    @PostMapping("shutdown")
    @AuditLog("关机")
    public CommonResult<Boolean> shutdown() throws Exception {
        return CommonResult.success(service.shutdown());
    }
}