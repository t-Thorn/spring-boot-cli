package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (RechargeRecord)实体类
 *
 * @author thorn.lin
 * @since 2024-05-27 13:48:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_recharge_record")
public class RechargeRecord extends Model<RechargeRecord> {
    private static final long serialVersionUID = -35690260881885609L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 商户编号
     */
    private String merchantNo;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 商户名称
     */
    private String merchantName;
    /**
     * 渠道标识
     */
    private String channelFlag;
    /**
     * 充值金额
     */
    private Double rechargeAmount;
    /**
     * 手续费
     */
    private Double fee;
    /**
     * 入账金额
     */
    private Double realRechargeAmount;
    /**
     * 通道编号
     */
    private String tunnelCode;
    /**
     * 通道名称
     */
    private String tunnelName;
    /**
     * 操作人id
     */
    private Long operatorId;
    /**
     * 操作人名
     */
    private String operatorName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}