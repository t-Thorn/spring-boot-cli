package com.thorn.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thorn.bbs.admin.request.NavigationListRequest;
import com.thorn.bbs.entity.Navigation;

/**
 * 导航(Navigation)表服务接口
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:36
 */
public interface NavigationService extends IService<Navigation> {
    Page<Navigation> listPage(NavigationListRequest request);
}