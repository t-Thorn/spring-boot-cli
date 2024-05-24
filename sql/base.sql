create table tb_post
(
    id        int unsigned comment '自增id' primary key,
    post_name varchar(512)          null comment '帖子名称',
    post_type   tinyint unsigned                                                null comment '帖子类型 1=常规 2=广告',
    on_home     int                                                             null comment '放置到首页',
    post_order  tinyint unsigned                                                null comment '帖子排序越大优先级越高',
    content     longtext                                                        null comment '帖子内容',
    owner_id    int unsigned                                                    null comment '帖子所有者id',
    owner_key int unsigned          null comment '帖子所有者唯一key',
    status      tinyint unsigned                                                null comment '帖子状态 1=草稿 2=待审核 3=审核通过 4=审核不通过 5=已发布 6=下架',
    heat        int unsigned                                                    null comment '帖子热度',
    reply_count int unsigned                                                    null comment '回复数量',
    deleted   boolean default false null comment '是否删除',
    create_time timestamp default CURRENT_TIMESTAMP                             null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP on update current_timestamp null comment '更新时间'
);