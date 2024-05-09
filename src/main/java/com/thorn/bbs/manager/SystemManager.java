package com.thorn.bbs.manager;


import org.springframework.stereotype.Component;

/**
 * <p>描述: 系统管理 </p>
 * <p>创建时间: 2024/5/9 13:59 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Component
public class SystemManager {

    public Boolean shutdown() throws Exception {
        Runtime.getRuntime().exec("shutdown -s -t " + 10);
        return true;
    }
}