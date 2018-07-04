package com.commonrail.kaluli.controller.jobhandler;

import com.commonrail.kaluli.domain.enums.EventTypeEnum;
import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import com.commonrail.kaluli.domain.model.NumOfKlbPo;
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
import java.util.List;

/**
 * 该设备最近1小时体检数据包数量
 * Created by Administrator on 2018/6/25.
 */
@JobHandler(value = "klbHealthNumOfHourJobHandler")
@Component
public class KlbHealthNumOfHourJobHandler extends IJobHandler {
    @Autowired
    private KlbService klbService;
    @Autowired
    private OtherService otherService;

    @Override
    @Transactional
    public ReturnT<String> execute(String param) throws Exception {
        Date startTime = DateUtil.addHour(new Date(), -1);
        Date endTime = new Date();

        List<NumOfKlbPo> pos = otherService.getKlbHealthNumList(startTime, endTime);
        for(NumOfKlbPo numOfKlbPo : pos) {
            String deviceId = numOfKlbPo.getDeviceId();
            int num = numOfKlbPo.getCnt();
            KlbDeviceStatusPo po = new KlbDeviceStatusPo(
                    deviceId, startTime, endTime, EventTypeEnum.THREE_OO.getCode(), EventTypeEnum.THREE_OO.getMsg(),
                    num + "", endTime);
            klbService.addNewStatusPo(po);
        }

        return SUCCESS;
    }
}