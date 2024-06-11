package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (Tunnel)实体类
 *
 * @author thorn.lin
 * @since 2024-05-27 13:48:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_tunnel")
public class Tunnel extends Model<Tunnel> {
    private static final long serialVersionUID = 506122785512059629L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 通道编号
     */
    private String tunnelCode;
    /**
     * 通道名称
     */
    private String tunnelName;
    /**
     * 支付开始时间
     */
    private String payBeginTime;
    /**
     * 支付结束时间
     */
    private String payEndTime;
    /**
     * 手续费余额
     */
    private Double balance;
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
     * 单日限额
     */
    private Double payLimit;
    /**
     * 单笔最低
     */
    private Double payLowLimit;
    /**
     * 单笔最高
     */
    private Double payHighLimit;
    /**
     * 通道状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}