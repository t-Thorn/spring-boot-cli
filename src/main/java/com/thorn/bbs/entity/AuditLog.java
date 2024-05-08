package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (AuditLog)实体类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:29:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_audit_log")
public class AuditLog extends Model<AuditLog> {
    private static final long serialVersionUID = -36364198596208177L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 异常信息
     */
    private String exception;
    /**
     * 客户端ip
     */
    private String clientIp;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 类名
     */
    private String className;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 操作
     */
    private String operation;
    /**
     * 请求参数
     */
    private String requestParam;
    /**
     * 响应
     */
    private String response;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}