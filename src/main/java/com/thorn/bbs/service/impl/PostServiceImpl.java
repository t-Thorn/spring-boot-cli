package com.thorn.bbs.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.thorn.bbs.api.request.PostListRequest;
import com.thorn.bbs.api.request.PostStatusChangeRequest;
import com.thorn.bbs.entity.Post;
import com.thorn.bbs.enums.VisitRecordTypeEnum;
import com.thorn.bbs.mapper.PostMapper;
import com.thorn.bbs.modules.ums.model.UmsAdmin;
import com.thorn.bbs.modules.ums.service.UmsAdminService;
import com.thorn.bbs.service.PostService;
import com.thorn.bbs.service.VisitRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (Post)表服务实现类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:42
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Resource
    private UmsAdminService adminService;
    @Resource
    private VisitRecordService visitRecordService;

    @Override
    public Page<Post> listPage(PostListRequest request) {
        if (Objects.nonNull(request.getOnHome())) {
            visitRecordService.addVisitCount(request.getOnHome() ? VisitRecordTypeEnum.HOME.getCode()
                    : VisitRecordTypeEnum.POST.getCode());
        }

        List<UmsAdmin> list = Lists.newArrayList();
        if (StringUtils.isNotBlank(request.getOwner())) {
            list = adminService.list(new LambdaQueryWrapper<UmsAdmin>()
                    .like(UmsAdmin::getNickName, request.getOwner())
            );
        }
        return page(request.convert(new Post()), new LambdaQueryWrapper<Post>()
                .select(Post::getId, Post::getPostName, Post::getPostType, Post::getOnHome, Post::getPostOrder, Post::getOwnerId, Post::getOwnerKey, Post::getStatus, Post::getHeat, Post::getReplyCount, Post::getCreateTime, Post::getUpdateTime)
                .like(StringUtils.isNotBlank(request.getPostName()), Post::getPostName, request.getPostName())
                .eq(Objects.nonNull(request.getPostType()), Post::getPostType, request.getPostType())
                .eq(Objects.nonNull(request.getOnHome()), Post::getOnHome, request.getOnHome())
                .like(StringUtils.isNotBlank(request.getOwnerKey()), Post::getOwnerKey, request.getOwnerKey())
                .in(CollUtil.isNotEmpty(list), Post::getOwnerId, list.stream().map(UmsAdmin::getId).collect(Collectors.toList()))
                .eq(Objects.nonNull(request.getStatus()), Post::getStatus, request.getStatus())

        );
    }

    @Override
    public Boolean changeStatus(PostStatusChangeRequest request) {
        return lambdaUpdate()
                .set(Post::getStatus, request.getStatus())
                .eq(Post::getId, request.getId())
                .update();
    }
}