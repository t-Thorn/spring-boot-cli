package com.thorn.bbs.enums;

/**
 * <p>描述: 访问记录枚举类 </p>
 * <p>创建时间: 2024/5/9 14:47 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
public enum VisitRecordTypeEnum {
    NAVIGATION(1),
    POST(2),
    HOME(3);


    private Integer code;

    VisitRecordTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}