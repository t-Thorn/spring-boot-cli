package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = " 自增id")
    private Long id;
    @ApiModelProperty(value = " 标题")
    private String title;
    @ApiModelProperty(value = " tab名")
    private String tabName;
    @ApiModelProperty(value = " 颜色")
    private String tabColor;
    @ApiModelProperty(value = " 地址")
    private String tabUrl;
    @ApiModelProperty(value = " 状态")
    private Integer status;
    @ApiModelProperty(value = " 是否删除")
    private Integer deleted;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = " 更新时间")
    private Date updateTime;
}