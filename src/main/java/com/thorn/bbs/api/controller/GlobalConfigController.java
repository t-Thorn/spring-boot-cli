package com.thorn.bbs.api.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.thorn.bbs.common.api.CommonPage;
import com.thorn.bbs.common.api.CommonResult;
import com.thorn.bbs.common.api.PageRequest;
import com.thorn.bbs.entity.GlobalConfig;
import com.thorn.bbs.service.GlobalConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>描述: 全局设置 </p>
 * <p>创建时间: 2024/5/6 16:07 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@RestController
@RequestMapping("/globalConfig")
@Api(tags = "全局配置")
@Validated
public class GlobalConfigController {

    @Resource
    private GlobalConfigService service;

    @ApiOperation("列表")
    @GetMapping("list")
    public CommonResult<CommonPage<GlobalConfig>> list(PageRequest request) {
        return CommonResult.success(CommonPage.restPage(service.page(request.convert(new GlobalConfig()))));
    }

    @ApiOperation("保存")
    @PostMapping("saveOrUpdate")
    public CommonResult<Boolean> saveOrUpdate(@RequestBody GlobalConfig config) {
        return CommonResult.success(service.saveOrUpdate(config, new LambdaQueryWrapper<GlobalConfig>()
                .eq(GlobalConfig::getUniqueKey, config.getUniqueKey())
        ));
    }

    @ApiOperation("删除")
    @PostMapping("del/{id}")
    public CommonResult<Boolean> del(@PathVariable Long id) {
        return CommonResult.success(service.removeById(id));
    }
}