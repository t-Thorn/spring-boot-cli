package com.thorn.bbs.api.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.thorn.bbs.api.request.VisitRecordListRequest;
import com.thorn.bbs.api.response.VisitRecordCountResponse;
import com.thorn.bbs.common.api.CommonPage;
import com.thorn.bbs.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>描述: 访问记录管理 </p>
 * <p>创建时间: 2024/5/6 16:08 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@RestController
@RequestMapping("/visitRecord")
@Api(tags = "访问记录管理")
@Validated
public class VisitRecordController {

    @Resource
    private VisitRecordService service;

    @ApiOperation("列表")
    @PostMapping("list")
    public CommonResult<CommonPage<VisitRecord>> list(@RequestBody VisitRecordListRequest request) {
        return CommonResult.success(CommonPage.restPage(service.page(request.convert(new VisitRecord()),
                new LambdaQueryWrapper<VisitRecord>()
                        .eq(Objects.nonNull(request.getVisitType()), VisitRecord::getVisitType, request.getVisitType())
                        .like(StringUtils.isNoneBlank(request.getClientArea()), VisitRecord::getClientArea, request.getClientArea())
                        .like(StringUtils.isNoneBlank(request.getClientIp()), VisitRecord::getClientIp, request.getClientIp())
                        .between(Objects.nonNull(request.getCreateBeginTime()) && Objects.nonNull(request.getCreateEndTime()),
                                VisitRecord::getCreateTime, request.getCreateBeginTime(), request.getCreateEndTime())
        )));
    }

    @ApiOperation("访问量查询")
    @PostMapping("statistic")
    public CommonResult<VisitRecordCountResponse> count() {
        return CommonResult.success(service.statistic());
    }
}