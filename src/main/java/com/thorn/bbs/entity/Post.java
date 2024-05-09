package com.thorn.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (Post)实体类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_post")
public class Post extends Model<Post> {
    private static final long serialVersionUID = -32374129180713184L;
    @ApiModelProperty(value = " 自增id")
    private Long id;
    @ApiModelProperty(value = " 帖子名称")
    private Integer postName;
    @ApiModelProperty(value = " 帖子类型 1=常规 2=广告")
    private Object postType;
    @ApiModelProperty(value = " 放置到首页")
    private Integer onHome;
    @ApiModelProperty(value = " 帖子排序越大优先级越高")
    private Object postOrder;
    @ApiModelProperty(value = " 帖子内容")
    private String content;
    @ApiModelProperty(value = " 帖子所有者id")
    private Long ownerId;
    @ApiModelProperty(value = " 帖子状态 1=草稿 2=待审核 3=审核通过 4=审核不通过 5=已发布 6=下架")
    private Object status;
    @ApiModelProperty(value = " 帖子热度")
    private Long heat;
    @ApiModelProperty(value = " 回复数量")
    private Long replyCount;
    @ApiModelProperty(value = " 是否删除")
    private Integer deleted;
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;
    @ApiModelProperty(value = " 更新时间")
    private Date updateTime;
}