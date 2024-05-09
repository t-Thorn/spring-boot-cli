package com.thorn.bbs.api.controller;


import com.thorn.bbs.annotation.AuditLog;
import com.thorn.bbs.api.request.NavigationListRequest;
import com.thorn.bbs.common.api.CommonPage;
import com.thorn.bbs.common.api.CommonResult;
import com.thorn.bbs.entity.Navigation;
import com.thorn.bbs.service.NavigationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>描述: 导航管理 </p>
 * <p>创建时间: 2024/5/6 16:08 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@RestController
@RequestMapping("/navigation")
@Api(tags = "导航管理")
@Validated
public class NavigationController {

    @Resource
    private NavigationService service;

    @ApiOperation("列表")
    @PostMapping("list")
    public CommonResult<CommonPage<Navigation>> list(@RequestBody NavigationListRequest request) {
        return CommonResult.success(CommonPage.restPage(service.listPage(request)));
    }

    @ApiOperation("创建")
    @PostMapping("create")
    @AuditLog("创建导航")
    public CommonResult<Boolean> create(@RequestBody Navigation navigation) {
        return CommonResult.success(service.save(navigation));
    }

    @ApiOperation("编辑")
    @PostMapping("edit")
    @AuditLog("编辑导航")
    public CommonResult<Boolean> edit(@RequestBody Navigation navigation) {
        return CommonResult.success(service.updateById(navigation));
    }

    @ApiOperation("删除")
    @PostMapping("del/{id}")
    @AuditLog("删除导航")
    public CommonResult<Boolean> del(@PathVariable Long id) {
        return CommonResult.success(service.removeById(id));
    }
}