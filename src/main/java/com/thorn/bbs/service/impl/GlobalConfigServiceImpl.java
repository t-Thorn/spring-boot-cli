package com.thorn.bbs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thorn.bbs.entity.GlobalConfig;
import com.thorn.bbs.mapper.GlobalConfigMapper;
import com.thorn.bbs.service.GlobalConfigService;
import org.springframework.stereotype.Service;

/**
 * (GlobalConfig)表服务实现类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:32
 */
@Service
public class GlobalConfigServiceImpl extends ServiceImpl<GlobalConfigMapper, GlobalConfig> implements GlobalConfigService {

}