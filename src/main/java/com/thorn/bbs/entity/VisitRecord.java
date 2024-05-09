package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (VisitRecord)实体类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_visit_record")
public class VisitRecord extends Model<VisitRecord> {
    private static final long serialVersionUID = 163528200590087944L;
    @ApiModelProperty(value = " 自增id")
    private Long id;
    @ApiModelProperty(value = " 客户端ip")
    private String clientIp;
    @ApiModelProperty(value = " 客户端地区")
    private String clientArea;
    @ApiModelProperty(value = " 访问类型1=导航 2=帖子")
    private Integer visitType;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = " 更新时间")
    private Date updateTime;
}