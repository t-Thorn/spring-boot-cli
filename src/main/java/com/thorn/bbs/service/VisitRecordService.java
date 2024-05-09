package com.thorn.bbs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thorn.bbs.api.response.VisitRecordCountResponse;
import com.thorn.bbs.entity.VisitRecord;

/**
 * (VisitRecord)表服务接口
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:50
 */
public interface VisitRecordService extends IService<VisitRecord> {
    VisitRecordCountResponse statistic();

    void addVisitCount(Integer code);
}