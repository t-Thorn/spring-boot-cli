package com.macro.mall.tiny.modules.test.service.impl;

import com.macro.mall.tiny.modules.test.model.Test;
import com.macro.mall.tiny.modules.test.mapper.TestMapper;
import com.macro.mall.tiny.modules.test.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author macro
 * @since 2020-11-16
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
