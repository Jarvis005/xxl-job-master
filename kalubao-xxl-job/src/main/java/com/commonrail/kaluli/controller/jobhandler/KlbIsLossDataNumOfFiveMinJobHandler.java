package com.commonrail.kaluli.controller.jobhandler;

import com.commonrail.kaluli.domain.enums.EventTypeEnum;
import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import com.commonrail.kaluli.domain.model.KlbIsLossDataPo;
import com.commonrail.kaluli.domain.model.NumOfKlbPo;
import com.commonrail.kaluli.one.service.KlbService;
import com.commonrail.kaluli.two.service.OtherService;
import com.commonrail.kaluli.utils.DateUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 该设备最近5分钟有无丢失体检/gps数据包
 * Created by Administrator on 2018/6/25.
 */
@JobHandler(value = "klbIsLossDataNumOfFiveMinJobHandler")
@Component
public class KlbIsLossDataNumOfFiveMinJobHandler extends IJobHandler {

    @Autowired
    private KlbService klbService;
    @Autowired
    private OtherService otherService;

    @Override
    @Transactional
    public ReturnT<String> execute(String param) throws Exception {
        Date startTime = DateUtil.addMinute(new Date(), -5);
        Date endTime = new Date();

        List<KlbIsLossDataPo> pos = otherService.getKlbIsLossDataList(startTime, endTime);
        for(KlbIsLossDataPo dataPo : pos) {
            String deviceId = dataPo.getDeviceId();
            Integer isLossData = dataPo.getIsLossData();
            KlbDeviceStatusPo po = new KlbDeviceStatusPo(
                    deviceId, startTime, endTime, EventTypeEnum.SEVEN_OO.getCode(), EventTypeEnum.SEVEN_OO.getMsg(),
                    isLossData+"", endTime);
            klbService.addNewStatusPo(po);
        }

        return SUCCESS;
    }
}