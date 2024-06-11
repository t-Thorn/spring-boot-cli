package com.thorn.bbs.api.controller;


import com.thorn.bbs.annotation.AuditLog;
import com.thorn.bbs.api.request.PostListRequest;
import com.thorn.bbs.common.api.CommonPage;
import com.thorn.bbs.common.api.CommonResult;
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
 * <p>描述: 帖子管理 </p>
 * <p>创建时间: 2024/5/6 16:05 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@RestController
@RequestMapping("/post")
@Api(tags = "帖子配置")
@Validated
public class PostController {

    @Resource
    private PostService service;

    @ApiOperation("列表")
    @PostMapping("list")
    public CommonResult<CommonPage<Post>> list(@RequestBody PostListRequest request) {
        return CommonResult.success(CommonPage.restPage(service.listPage(request)));
    }

    @ApiOperation("创建")
    @PostMapping("create")
    @AuditLog("创建帖子")
    public CommonResult<Boolean> create(@RequestBody Post post) {
        return CommonResult.success(service.save(post));
    }

    @ApiOperation("编辑")
    @PostMapping("edit")
    @AuditLog("编辑帖子")
    public CommonResult<Boolean> edit(@RequestBody Post post) {
        return CommonResult.success(service.updateById(post));
    }

    @ApiOperation("删除")
    @PostMapping("del/{id}")
    @AuditLog("删除帖子")
    public CommonResult<Boolean> del(@PathVariable Long id) {
        return CommonResult.success(service.removeById(id));
    }
}