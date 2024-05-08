package com.thorn.bbs.admin.request;


import com.thorn.bbs.common.api.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>描述: 审计日志列表请求参数 </p>
 * <p>创建时间: 2024/5/7 11:15 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Data
@ApiModel("审计日志列表请求参数")
public class AuditLogListRequest extends PageRequest {

    @ApiModelProperty("是否成功")
    private Boolean success;
    @ApiModelProperty("客户端ip")
    private String clientIp;
    @ApiModelProperty("方法名")
    private String methodName;
    @ApiModelProperty("类名")
    private String className;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("操作")
    private String operation;
    @ApiModelProperty("创建时间-开始")
    private Date createBeginTime;
    @ApiModelProperty("创建时间-结束")
    private Date createEndTime;
}