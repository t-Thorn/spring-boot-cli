package com.thorn.bbs.api.request;


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
@ApiModel("帖子状态更改请求参数")
public class PostStatusChangeRequest {

    @ApiModelProperty(value = " 帖子id")
    private Long id;
    @ApiModelProperty(value = " 帖子状态 1=草稿 2=待审核 3=审核通过 4=审核不通过 5=已发布 6=下架")
    private Integer status;
}