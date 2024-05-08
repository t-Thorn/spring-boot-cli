package com.thorn.bbs.modules.ums.service;


import com.thorn.bbs.modules.ums.model.UmsAdmin;
import com.thorn.bbs.modules.ums.model.UmsResource;

import java.util.List;

/**
 * 后台用户缓存管理Service
 * Created by macro on 2020/3/13.
 */
public interface UmsAdminCacheService {
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 删除后台用户资源列表缓存
     */
    void delResourceList(Long adminId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRole(Long roleId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * 当资源信息改变时，删除资源项目后台用户缓存
     */
    void delResourceListByResource(Long resourceId);

    /**
     * 获取缓存后台用户信息
     */
    UmsAdmin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UmsAdmin admin);

    /**
     * 获取缓存后台用户资源列表
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 设置后台后台用户资源列表
     */
    void setResourceList(Long adminId, List<UmsResource> resourceList);

    /**
     * 获取账号是否是超管
     *
     * @param id 用户id
     * @return 是否是超管
     */
    Boolean isAdmin(Long id);

    /**
     * 删除缓存
     *
     * @param userId 用户id
     */
    void delIsAdmin(Long userId);

    /**
     * 获取账号是否是超管
     *
     * @param userId  用户id
     * @param isAdmin 是否是超管
     */
    void setIsAdmin(Long userId, Boolean isAdmin);
}