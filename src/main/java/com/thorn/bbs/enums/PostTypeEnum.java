package com.thorn.bbs.enums;

/**
 * <p>描述: 帖子类型枚举 </p>
 * <p>创建时间: 2024/5/9 14:57 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
public enum PostTypeEnum {
    POST(1),
    AD(2);


    private Integer code;

    PostTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}