package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (MerchantInfo)实体类
 *
 * @author thorn.lin
 * @since 2024-05-27 13:48:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_merchant_info")
public class MerchantInfo extends Model<MerchantInfo> {
    private static final long serialVersionUID = -52516503258411650L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 商户编号
     */
    private String merchantNo;
    /**
     * 商户名称
     */
    private String merchantName;
    /**
     * 登录账户
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 账户余额
     */
    private Double balance;
    /**
     * 商户状态
     */
    private Integer status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 通道编号
     */
    private String tunnelCode;
    /**
     * 通道名称
     */
    private String tunnelName;
    /**
     * 渠道标识
     */
    private String channelFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}