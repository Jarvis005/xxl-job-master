package com.commonrail.kaluli.controller.jobhandler;

import com.commonrail.kaluli.domain.enums.EventTypeEnum;
import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import com.commonrail.kaluli.one.service.KlbService;
import com.commonrail.kaluli.two.service.OtherService;
import com.commonrail.kaluli.utils.DateUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 所有设备最近5分钟gps数据包数量
 * Created by Administrator on 2018/6/25.
 */
@JobHandler(value = "gpsNumOfFiveMinJobHandler")
@Component
public class GpsNumOfFiveMinJobHandler extends IJobHandler {
    @Autowired
    private KlbService klbService;
    @Autowired
    private OtherService otherService;

    @Override
    @Transactional
    public ReturnT<String> execute(String param) throws Exception {
        Date startTime = DateUtil.addMinute(new Date(), -5);
        Date endTime = new Date();

        int gpsNum = otherService.getGpsNumBy(startTime, endTime);
        KlbDeviceStatusPo po = new KlbDeviceStatusPo(
                null, startTime, endTime, EventTypeEnum.EIGHTEEN_OO.getCode(),EventTypeEnum.EIGHTEEN_OO.getMsg(),
                gpsNum+"", endTime);
        klbService.addNewStatusPo(po);

        return SUCCESS;
    }
}