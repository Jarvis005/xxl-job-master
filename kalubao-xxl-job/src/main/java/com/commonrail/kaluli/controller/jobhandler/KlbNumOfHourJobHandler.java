package com.commonrail.kaluli.controller.jobhandler;

import com.commonrail.kaluli.domain.enums.EventTypeEnum;
import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import com.commonrail.kaluli.domain.model.TimePo;
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

/**
 * 最近1小时运行的卡路宝数量
 * Created by Administrator on 2018/6/25.
 */
@JobHandler(value = "klbNumOfHourJobHandler")
@Component
public class KlbNumOfHourJobHandler extends IJobHandler {

    private static final Logger logger = LoggerFactory.getLogger(KlbNumOfHourJobHandler.class);
    @Autowired
    private KlbService klbService;
    @Autowired
    private OtherService otherService;

    @Override
    @Transactional
    public ReturnT<String> execute(String param) throws Exception {
        Date startTime = DateUtil.addHour(new Date(), -1);
        Date endTime = new Date();
//        TimePo timePo = new TimePo(startTime, endTime);
        int klbNum = otherService.getKlbNumBy(startTime, endTime);
        logger.info("最近1小时运行的卡路宝数量--->" + klbNum);
        KlbDeviceStatusPo po = new KlbDeviceStatusPo(
                null, startTime, endTime, EventTypeEnum.NINE_OO.getCode(), EventTypeEnum.NINE_OO.getMsg(),  klbNum+"", new Date());
        klbService.addNewStatusPo(po);

        return SUCCESS;
    }
}