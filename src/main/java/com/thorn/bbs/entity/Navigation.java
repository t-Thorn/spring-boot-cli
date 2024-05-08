package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 导航(Navigation)实体类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_navigation")
public class Navigation extends Model<Navigation> {
    private static final long serialVersionUID = -38939952446579985L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * tab名
     */
    private String tabName;
    /**
     * 颜色
     */
    private String tabColor;
    /**
     * 地址
     */
    private String tabUrl;
    /**
     * 状态
     */
    private Integer status;
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