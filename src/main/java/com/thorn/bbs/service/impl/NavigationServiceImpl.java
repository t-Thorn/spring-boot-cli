package com.thorn.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thorn.bbs.api.request.NavigationListRequest;
import com.thorn.bbs.entity.Navigation;
import com.thorn.bbs.enums.VisitRecordTypeEnum;
import com.thorn.bbs.mapper.NavigationMapper;
import com.thorn.bbs.service.NavigationService;
import com.thorn.bbs.service.VisitRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 导航(Navigation)表服务实现类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:38
 */
@Service
public class NavigationServiceImpl extends ServiceImpl<NavigationMapper, Navigation> implements NavigationService {
    @Resource
    private VisitRecordService service;

    @Override
    public Page<Navigation> listPage(NavigationListRequest request) {
        service.addVisitCount(VisitRecordTypeEnum.NAVIGATION.getCode());
        return page(new Page<>(request.getPageNo(), request.getPageSize()),
                new LambdaQueryWrapper<Navigation>()
                        .like(StringUtils.isNotBlank(request.getTitle()), Navigation::getTitle, request.getTitle())
                        .eq(Objects.nonNull(request.getStatus()), Navigation::getStatus, request.getStatus())
                        .like(StringUtils.isNotBlank(request.getTabName()), Navigation::getTabName, request.getTabName())
                        .like(StringUtils.isNotBlank(request.getTabUrl()), Navigation::getTabUrl, request.getTabUrl())
        );
    }
}