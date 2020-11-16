package com.macro.mall.tiny.modules.test.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.macro.mall.tiny.modules.test.service.TestService;
import com.macro.mall.tiny.modules.test.model.Test;
import java.util.List;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author macro
 * @since 2020-11-16
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    public TestService testService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody Test test) {
        boolean success = testService.save(test);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody Test test) {
        test.setId(id);
        boolean success = testService.updateById(test);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        boolean success = testService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteBatch(@RequestParam("ids") List<Long> ids) {
        boolean success = testService.removeByIds(ids);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }


    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Test>> listAll() {
        List<Test> testList = testService.list();
        return CommonResult.success(testList);
    }
}

