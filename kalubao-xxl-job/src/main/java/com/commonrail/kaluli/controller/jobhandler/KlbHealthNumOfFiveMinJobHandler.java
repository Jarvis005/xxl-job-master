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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 该设备最近5分钟体检数据包数量
 * Created by Administrator on 2018/6/25.
 */
@JobHandler(value = "klbHealthNumOfFiveMinJobHandler")
@Component
public class KlbHealthNumOfFiveMinJobHandler extends IJobHandler {

    private  static final Logger logger = LoggerFactory.getLogger(KlbHealthNumOfFiveMinJobHandler.class);
    @Autowired
    private KlbService klbService;
    @Autowired
    private OtherService otherService;

    @Override
    @Transactional
    public ReturnT<String> execute(String param) throws Exception {
        logger.info("KlbHealthNumOfFiveMinJobHandler");
        Date startTime = DateUtil.addMinute(new Date(), -5);
        Date endTime = new Date();

        List<NumOfKlbPo> pos = otherService.getKlbHealthNumList(startTime, endTime);
        for(NumOfKlbPo numOfKlbPo : pos) {
            String deviceId = numOfKlbPo.getDeviceId();
            int num = numOfKlbPo.getCnt();
            KlbDeviceStatusPo po = new KlbDeviceStatusPo(
                    deviceId, startTime, endTime, EventTypeEnum.FIVE_OO.getCode(), EventTypeEnum.FIVE_OO.getMsg(),
                    num + "", endTime);
            logger.info(deviceId+"该设备最近5分钟体检数据包数量"+"==>"+num);
            klbService.addNewStatusPo(po);
        }

        return SUCCESS;
    }
}