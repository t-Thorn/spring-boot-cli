package com.thorn.bbs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thorn.bbs.api.request.PostListRequest;
import com.thorn.bbs.api.request.PostStatusChangeRequest;
import com.thorn.bbs.entity.Post;

/**
 * (Post)表服务接口
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:42
 */
public interface PostService extends IService<Post> {
    Page<Post> listPage(PostListRequest request);

    Boolean changeStatus(PostStatusChangeRequest request);
}