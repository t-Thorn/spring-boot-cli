package com.thorn.bbs.api.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.thorn.bbs.annotation.AuditLog;
import com.thorn.bbs.api.request.ReplyListRequest;
import com.thorn.bbs.common.api.CommonPage;
import com.thorn.bbs.common.api.CommonResult;
import com.thorn.bbs.entity.Reply;
import com.thorn.bbs.service.ReplyService;
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
 * <p>描述:  </p>
 * <p>创建时间: 2024/5/6 16:05 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@RestController
@RequestMapping("/reply")
@Api(tags = "回复配置")
@Validated
public class ReplyController {

    @Resource
    private ReplyService service;

    @ApiOperation("列表")
    @PostMapping("list")
    public CommonResult<CommonPage<Reply>> list(@RequestBody ReplyListRequest request) {
        return CommonResult.success(CommonPage.restPage(service.page(request.convert(new Reply()),
                new LambdaQueryWrapper<Reply>()
                        .eq(Reply::getPostId, request.getPostId())
        )));
    }

    @ApiOperation("创建")
    @PostMapping("create")
    @AuditLog("创建回复")
    public CommonResult<Boolean> create(@RequestBody Reply reply) {
        return CommonResult.success(service.save(reply));
    }

    @ApiOperation("删除")
    @PostMapping("del/{id}")
    @AuditLog("删除回复")
    public CommonResult<Boolean> del(@PathVariable Long id) {
        return CommonResult.success(service.removeById(id));
    }

}