package com.thorn.bbs.api.request;


import com.thorn.bbs.common.api.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>描述: 帖子列表请求参数 </p>
 * <p>创建时间: 2024/5/9 11:13 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Data
@ApiModel("帖子列表请求参数")
public class PostListRequest extends PageRequest {

    @ApiModelProperty(value = " 帖子名称")
    private String postName;
    @ApiModelProperty(value = " 帖子类型 1=常规 2=广告")
    private Integer postType;
    @ApiModelProperty(value = " 放置到首页")
    private Boolean onHome;

    @ApiModelProperty(value = " 帖子所有者")
    private String owner;
    @ApiModelProperty(value = " 帖子所有者key")
    private String ownerKey;
    @ApiModelProperty(value = " 帖子状态 1=草稿 2=待审核 3=审核通过 4=审核不通过 5=已发布 6=下架")
    private Integer status;
}