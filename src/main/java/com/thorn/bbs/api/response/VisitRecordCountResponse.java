package com.thorn.bbs.api.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>描述: 访问量信息 </p>
 * <p>创建时间: 2024/5/9 14:32 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@ApiModel("访问量信息")
@Data
public class VisitRecordCountResponse {

    @ApiModelProperty("导航统计")
    private Integer navigationCount;

    @ApiModelProperty("导航统计")
    private Integer postCount;

    @ApiModelProperty("首页统计")
    private Integer homeCount;
}