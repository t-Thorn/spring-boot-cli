package com.thorn.bbs.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * 谷歌绑定参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminGoogleBindParam {
    @NotEmpty
    @ApiModelProperty(value = "密钥")
    private String secret;

    @ApiModelProperty(value = "谷歌验证码", required = true)
    @NotBlank
    private Long googleCode;
}