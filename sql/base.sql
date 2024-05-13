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
create table tb_reply
(
    id      int unsigned comment '自增id' primary key,
    owner_id    int unsigned                                                    null comment '回复所有者id',
    content     text                                                            null comment '回复内容',
    deleted boolean default false null comment '是否删除',
    create_time timestamp default CURRENT_TIMESTAMP                             null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP on update current_timestamp null comment '更新时间'
);

create table tb_global_config
(
    id         int unsigned comment '自增id' primary key,
    unique_key varchar(128)          null comment '唯一键,如域名等',
    bg_img     blob                  null comment '背景图片',
    bg_color   char(6)               null comment '背景颜色',
    post_img   blob                  null comment '帖子标签图',
    ad_img     blob                  null comment '广告图',
    ad_remark  varchar(512)          null comment '广告备注',
    copyright  text                  null comment '版权信息',
    deleted    boolean default false null comment '是否删除',
    create_time timestamp default CURRENT_TIMESTAMP                             null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP on update current_timestamp null comment '更新时间'
);

create table tb_audit_log_record
(
    id       int unsigned comment '自增id' primary key,
    success       boolean                                                         null comment '是否成功',
    exception     mediumtext                                                      null comment '异常信息',
    client_ip     varchar(64)                                                     null comment '客户端ip',
    method_name   varchar(64)                                                     null comment '方法名',
    class_name    varchar(128)                                                    null comment '类名',
    username varchar(64) null comment '用户名',
    operation     varchar(64)                                                     null comment '操作',
    request_param text                                                            null comment '请求参数',
    response      text                                                            null comment '响应',
    create_time   timestamp default CURRENT_TIMESTAMP                             null comment '创建时间',
    update_time   timestamp default CURRENT_TIMESTAMP on update current_timestamp null comment '更新时间'
);


create table tb_visit_record
(
    id int unsigned comment '自增id' primary key,
    client_ip   varchar(64)                                                     null comment '客户端ip',
    client_area varchar(64)                                                     null comment '客户端地区',
    visit_type  tinyint                                                         null comment '访问类型1=导航 2=帖子',
    create_time timestamp default CURRENT_TIMESTAMP                             null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP on update current_timestamp null comment '更新时间'
)

create table tb_navigation
(
    id int unsigned comment '自增id'
        primary key,
    title       varchar(128)                          null comment '标题',
    tab_name    varchar(128)                          null comment 'tab名',
    tab_color   char(6)                               null comment '颜色',
    tab_url     varchar(512)                          null comment '地址',
    status      tinyint(1)                            null comment '状态',
    deleted     tinyint(1)                            null comment '是否删除',
    create_time timestamp default current_timestamp() null comment '创建时间',
    update_time timestamp default current_timestamp() null on update current_timestamp() comment '更新时间'
)
    comment '导航';