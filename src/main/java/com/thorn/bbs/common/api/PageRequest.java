package com.thorn.bbs.common.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>描述: 分页基础参数 </p>
 * <p>创建时间: 2024/5/7 11:20 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Data
@ApiModel("分页基础参数")
public class PageRequest {

    @ApiModelProperty("页码")
    private Integer pageNo;
    @ApiModelProperty("分页大小")
    private Integer pageSize;

    public <E> Page<E> convert(E e) {
        return new Page<>(pageNo, pageSize);
    }
}