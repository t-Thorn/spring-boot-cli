package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (Reply)实体类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_reply")
public class Reply extends Model<Reply> {
    private static final long serialVersionUID = 227767585846802115L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 回复所有者id
     */
    private Long ownerId;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 是否删除
     */
    private Integer deleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}