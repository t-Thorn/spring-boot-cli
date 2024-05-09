package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (GlobalConfig)实体类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_global_config")
public class GlobalConfig extends Model<GlobalConfig> {
    private static final long serialVersionUID = 648734278190493162L;
    @ApiModelProperty(value = " 自增id")
    private Long id;
    @ApiModelProperty(value = " 唯一键")
    private String uniqueKey;
    @ApiModelProperty(value = " 帖子照片")
    private String postImg;
    @ApiModelProperty(value = " 背景图base64")
    private String bgImg;
    @ApiModelProperty(value = " 背景颜色")
    private String bgColor;
    @ApiModelProperty(value = " 广告图 base64")
    private String adImg;
    @ApiModelProperty(value = " 广告备注")
    private String adRemark;
    @ApiModelProperty(value = " 版权信息")
    private String copyRight;
    @ApiModelProperty(value = " 是否删除")
    private Integer deleted;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = " 更新时间")
    private Date updateTime;
}