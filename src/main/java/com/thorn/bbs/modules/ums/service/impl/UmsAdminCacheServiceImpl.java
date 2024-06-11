package com.thorn.bbs.modules.ums.service.impl;

import com.thorn.bbs.modules.ums.model.UmsAdmin;
import com.thorn.bbs.modules.ums.model.UmsResource;
import com.thorn.bbs.modules.ums.service.UmsAdminCacheService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户缓存管理Service实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
/*    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationService adminRoleRelationService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;
    @Value("${redis.key.isAdmin}")
    private String REDIS_KEY_IS_ADMIN;*/

    @Override
    public void delAdmin(Long adminId) {
        /*UmsAdmin admin = adminService.getById(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }*/
    }

    @Override
    public void delResourceList(Long adminId) {
        /*String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.del(key);*/
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        /*QueryWrapper<UmsAdminRoleRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UmsAdminRoleRelation::getRoleId,roleId);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationService.list(wrapper);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }*/
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        /*QueryWrapper<UmsAdminRoleRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(UmsAdminRoleRelation::getRoleId,roleIds);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationService.list(wrapper);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }*/
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        /*List<Long> adminIdList = adminMapper.getAdminIdList(resourceId);
        if (CollUtil.isNotEmpty(adminIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = adminIdList.stream().map(adminId -> keyPrefix + adminId).collect(Collectors.toList());
            redisService.del(keys);
        }*/
    }

    @Override
    public UmsAdmin getAdmin(String username) {
/*        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);*/
        return null;
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
/*        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);*/
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        /*String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<UmsResource>) redisService.get(key);*/
        return null;
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
/*        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);*/
    }

    @Override
    public Boolean isAdmin(Long id) {
/*        String key = REDIS_DATABASE + ":" + REDIS_KEY_IS_ADMIN + ":" + id;
        return (boolean) redisService.get(key);*/
        return null;
    }

    @Override
    public void delIsAdmin(Long userId) {
        /*String key = REDIS_DATABASE + ":" + REDIS_KEY_IS_ADMIN + ":" + userId;
        redisService.del(key);*/
    }

    @Override
    public void setIsAdmin(Long userId, Boolean isAdmin) {
       /* String key = REDIS_DATABASE + ":" + REDIS_KEY_IS_ADMIN + ":" + userId;
        redisService.set(key, isAdmin, REDIS_EXPIRE);*/
    }
}