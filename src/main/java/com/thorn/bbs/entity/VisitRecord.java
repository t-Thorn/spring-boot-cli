package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
    /**
     * 自增id
     */
    private Long id;
    /**
     * 客户端ip
     */
    private String clientIp;
    /**
     * 客户端地区
     */
    private String clientArea;
    /**
     * 访问类型1=导航 2=帖子
     */
    private Integer visitType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}