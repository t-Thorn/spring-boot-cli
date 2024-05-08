package com.thorn.bbs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thorn.bbs.entity.Navigation;
import com.thorn.bbs.mapper.NavigationMapper;
import com.thorn.bbs.service.NavigationService;
import org.springframework.stereotype.Service;

/**
 * 导航(Navigation)表服务实现类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:38
 */
@Service
public class NavigationServiceImpl extends ServiceImpl<NavigationMapper, Navigation> implements NavigationService {

}