package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (MerchantFee)实体类
 *
 * @author thorn.lin
 * @since 2024-05-27 13:48:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_merchant_fee")
public class MerchantFee extends Model<MerchantFee> {
    private static final long serialVersionUID = 964676609382033078L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 商户编号
     */
    private String merchantNo;
    /**
     * 充值费率
     */
    private Object rechargeRate;
    /**
     * 每笔充值费用
     */
    private Double rechargePer;
    /**
     * 每笔代付费用
     */
    private Double payCostPer;
    /**
     * 通道编号
     */
    private String tunnelCode;
    /**
     * 通道名称
     */
    private String tunnelName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}