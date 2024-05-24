package com.thorn.bbs.modules.ums.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>描述: 谷歌绑定响应 </p>
 * <p>创建时间: 2024/5/24 10:29 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Data
@ApiModel("谷歌绑定响应")
public class UmsGoogleBindResponse {

    @ApiModelProperty("二维码地址")
    private String qrCodeText;

    @ApiModelProperty("随机密钥")
    private String secret;
}