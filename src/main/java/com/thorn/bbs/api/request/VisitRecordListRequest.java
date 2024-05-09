package com.thorn.bbs.api.request;


import com.thorn.bbs.common.api.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>描述: 访问记录列表请求参数 </p>
 * <p>创建时间: 2024/5/9 13:56 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Data
@ApiModel("访问记录列表请求参数")
public class VisitRecordListRequest extends PageRequest {

    @ApiModelProperty("客户端ip")
    private String clientIp;
    @ApiModelProperty("客户端区域")
    private String clientArea;
    @ApiModelProperty("访问类型1=导航 2=帖子 3=首页")
    private Integer visitType;
    @ApiModelProperty("创建时间-开始")
    private Date createBeginTime;
    @ApiModelProperty("创建时间-结束")
    private Date createEndTime;
}