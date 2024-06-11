create table tb_tunnel
(
    id             int unsigned comment '自增id' primary key,
    tunnel_code    varchar(32) comment '通道编号'    null,
    tunnel_name    varchar(128) comment '通道名称',
    pay_begin_time varchar(32) comment '支付开始时间',
    pay_end_time   varchar(32) comment '支付结束时间',
    balance        decimal(10, 2) comment '手续费余额',
    recharge_rate  decimal(10, 2) unsigned comment '充值费率',
    recharge_per   decimal(10, 2) comment '每笔充值费用',
    pay_cost_per   decimal(10, 2) comment '每笔代付费用',
    pay_limit      decimal(10, 2) comment '单日限额' null,
    pay_low_limit  decimal(10, 2) comment '单笔最低' null,
    pay_high_limit decimal(10, 2) comment '单笔最高' null,
    status         boolean comment '通道状态',
    create_time    timestamp default current_timestamp comment '创建时间',
    update_time    timestamp default current_timestamp on update current_timestamp comment '修改时间'
);

create table tb_cash_out_record
(
    id                int unsigned comment '自增id' primary key,
    platform_order_no varchar(64) comment '平台订单号' null,
    merchant_no       varchar(64) comment '商户编号'   null,
    merchant_name     varchar(64) comment '商户名称',
    merchant_order_no varchar(64) comment '平台订单号' null,
    request_type      tinyint comment '请求类型'       null,
    amount            decimal(10, 2) comment '订单金额',
    fee               decimal(10, 2) comment '手续费',
    payee             varchar(32) comment '收款人',
    payee_card_no     varchar(32) comment '收款人银行卡号',
    id_card_no        varchar(32) comment '身份证号',
    phone             varchar(32) comment '手机号',
    status            tinyint comment '提现状态',
    tunnel_code       varchar(32) comment '通道编号'   null,
    tunnel_name       varchar(128) comment '通道名称',
    notify_url        varchar(512) comment '通知地址',
    operator_id       bigint comment '操作人id',
    operator_name     varchar(200) DEFAULT NULL COMMENT '操作人名',
    create_time       timestamp    default current_timestamp comment '创建时间',
    update_time       timestamp    default current_timestamp on update current_timestamp comment '修改时间'
);


create table tb_merchant_info
(
    id            int unsigned comment '自增id' primary key,
    merchant_no   varchar(64) comment '商户编号' null,
    merchant_name varchar(64) comment '商户名称',
    username      varchar(64) comment '登录账户',
    `password`    varchar(64) DEFAULT NULL comment '登录密码',
    balance       decimal(10, 2) comment '账户余额',
    status        tinyint comment '商户状态',
    email         varchar(64) comment '邮箱',
    phone         varchar(32) comment '手机号',
    tunnel_code   varchar(32) comment '通道编号' null,
    tunnel_name   varchar(128) comment '通道名称',
    channel_flag  varchar(32) comment '渠道标识',
    create_time   timestamp   default current_timestamp comment '创建时间',
    update_time   timestamp   default current_timestamp on update current_timestamp comment '修改时间'
);

create table tb_merchant_fee
(
    id            int unsigned comment '自增id' primary key,
    merchant_no   varchar(64) comment '商户编号' null,
    recharge_rate decimal(10, 2) unsigned comment '充值费率',
    recharge_per  decimal(10, 2) comment '每笔充值费用',
    pay_cost_per  decimal(10, 2) comment '每笔代付费用',
    tunnel_code   varchar(32) comment '通道编号' null,
    tunnel_name   varchar(128) comment '通道名称',
    create_time   timestamp default current_timestamp comment '创建时间',
    update_time   timestamp default current_timestamp on update current_timestamp comment '修改时间'
);

create table tb_recharge_record
(
    id                   int unsigned comment '自增id' primary key,
    merchant_no          varchar(64) comment '商户编号'    null,
    order_no             varchar(64) comment '订单编号'    null,
    merchant_name        varchar(64) comment '商户名称',
    channel_flag         varchar(32) comment '渠道标识',
    recharge_amount      decimal(10, 2) comment '充值金额' null,
    fee                  decimal(10, 2) comment '手续费'   null,
    real_recharge_amount decimal(10, 2) comment '入账金额' null,
    tunnel_code          varchar(32) comment '通道编号'    null,
    tunnel_name          varchar(128) comment '通道名称',
    operator_id          bigint comment '操作人id',
    operator_name        varchar(200) DEFAULT NULL COMMENT '操作人名',
    create_time          timestamp    default current_timestamp comment '创建时间',
    update_time          timestamp    default current_timestamp on update current_timestamp comment '修改时间'
);