package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (CashOutRecord)实体类
 *
 * @author thorn.lin
 * @since 2024-05-27 13:48:55
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_cash_out_record")
public class CashOutRecord extends Model<CashOutRecord> {
    private static final long serialVersionUID = -45560229318881066L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 平台订单号
     */
    private String platformOrderNo;
    /**
     * 商户编号
     */
    private String merchantNo;
    /**
     * 商户名称
     */
    private String merchantName;
    /**
     * 平台订单号
     */
    private String merchantOrderNo;
    /**
     * 请求类型
     */
    private Integer requestType;
    /**
     * 订单金额
     */
    private Double amount;
    /**
     * 手续费
     */
    private Double fee;
    /**
     * 收款人
     */
    private String payee;
    /**
     * 收款人银行卡号
     */
    private String payeeCardNo;
    /**
     * 身份证号
     */
    private String idCardNo;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 提现状态
     */
    private Integer status;
    /**
     * 通道编号
     */
    private String tunnelCode;
    /**
     * 通道名称
     */
    private String tunnelName;
    /**
     * 通知地址
     */
    private String notifyUrl;
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