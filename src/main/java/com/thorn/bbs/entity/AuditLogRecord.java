package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("tb_audit_log_record")
public class AuditLogRecord extends Model<AuditLogRecord> {
    private static final long serialVersionUID = -36364198596208177L;
    @ApiModelProperty(value = " 自增id")
    private Long id;
    @ApiModelProperty(value = " 是否成功")
    private boolean success;
    @ApiModelProperty(value = " 异常信息")
    private String exception;
    @ApiModelProperty(value = " 客户端ip")
    private String clientIp;
    @ApiModelProperty(value = " 方法名")
    private String methodName;
    @ApiModelProperty(value = " 类名")
    private String className;
    @ApiModelProperty(value = " 用户名")
    private String username;
    @ApiModelProperty(value = " 操作")
    private String operation;
    @ApiModelProperty(value = " 请求参数")
    private String requestParam;
    @ApiModelProperty(value = " 响应")
    private String response;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = " 更新时间")
    private Date updateTime;
}