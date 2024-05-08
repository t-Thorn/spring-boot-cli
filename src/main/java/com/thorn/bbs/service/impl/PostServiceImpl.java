package com.thorn.bbs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thorn.bbs.entity.Post;
import com.thorn.bbs.mapper.PostMapper;
import com.thorn.bbs.service.PostService;
import org.springframework.stereotype.Service;

/**
 * (Post)表服务实现类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:42
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}