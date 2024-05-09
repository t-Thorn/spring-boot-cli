package com.thorn.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thorn.bbs.api.response.VisitRecordCountResponse;
import com.thorn.bbs.entity.VisitRecord;
import com.thorn.bbs.enums.VisitRecordTypeEnum;
import com.thorn.bbs.mapper.VisitRecordMapper;
import com.thorn.bbs.service.VisitRecordService;
import com.thorn.bbs.utils.IpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (VisitRecord)表服务实现类
 *
 * @author thorn.lin
 * @since 2024-05-07 10:31:51
 */
@Service
public class VisitRecordServiceImpl extends ServiceImpl<VisitRecordMapper, VisitRecord> implements VisitRecordService {
    @Resource
    private IpUtil iputil;

    @Override
    public VisitRecordCountResponse statistic() {
        VisitRecordCountResponse response = new VisitRecordCountResponse();
        response.setNavigationCount(count(new LambdaQueryWrapper<VisitRecord>().eq(VisitRecord::getVisitType, VisitRecordTypeEnum.NAVIGATION.getCode())));
        response.setPostCount(count(new LambdaQueryWrapper<VisitRecord>().eq(VisitRecord::getVisitType, VisitRecordTypeEnum.POST.getCode())));
        response.setHomeCount(count(new LambdaQueryWrapper<VisitRecord>().eq(VisitRecord::getVisitType, VisitRecordTypeEnum.HOME.getCode())));
        return response;
    }

    @Override
    public void addVisitCount(Integer code) {
        VisitRecord visitRecord = new VisitRecord();
        String ipAddr = iputil.getIpAddr();
        visitRecord.setClientIp(ipAddr);
        visitRecord.setClientArea(iputil.getRegionFromIp(ipAddr));
        visitRecord.setVisitType(code);
        save(visitRecord);
    }
}