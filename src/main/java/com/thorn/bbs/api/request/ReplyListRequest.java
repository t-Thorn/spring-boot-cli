package com.thorn.bbs.api.request;


import com.thorn.bbs.common.api.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>描述: 回复列表请求参数 </p>
 * <p>创建时间: 2024/5/9 11:13 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Data
@ApiModel("回复列表请求参数")
public class ReplyListRequest extends PageRequest {

    @ApiModelProperty(value = " 帖子id")
    private Long postId;

}