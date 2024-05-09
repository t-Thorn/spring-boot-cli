package com.thorn.bbs.api.request;


import com.thorn.bbs.common.api.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>描述: 导航列表参数 </p>
 * <p>创建时间: 2024/5/8 17:17 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Data
@ApiModel("导航列表参数")
public class NavigationListRequest extends PageRequest {

    @ApiModelProperty("导航名称")
    private String title;
    @ApiModelProperty("tab名")
    private String tabName;
    @ApiModelProperty("地址")
    private String tabUrl;
    @ApiModelProperty("状态")
    private Integer status;
}