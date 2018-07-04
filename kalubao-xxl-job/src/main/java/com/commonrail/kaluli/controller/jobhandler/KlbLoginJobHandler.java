package com.commonrail.kaluli.controller.jobhandler;

import com.commonrail.kaluli.domain.enums.EventTypeEnum;
import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import com.commonrail.kaluli.domain.model.KlbTimePo;
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
 * 该设备最后一次登录时间
 * Created by Administrator on 2018/6/25.
 */
@JobHandler(value = "klbLoginJobHandler")
@Component
public class KlbLoginJobHandler extends IJobHandler {
    @Autowired
    private KlbService klbService;
    @Autowired
    private OtherService otherService;

    @Override
    @Transactional
    public ReturnT<String> execute(String param) throws Exception {

        List<KlbTimePo> pos = otherService.getKlbLoginTimeList();
        for(KlbTimePo klbTimePo : pos) {
            String deviceId = klbTimePo.getDeviceId();
            Date createTime = klbTimePo.getCreateTime();
            KlbDeviceStatusPo po = new KlbDeviceStatusPo(
                    deviceId, null, null, EventTypeEnum.ONE_OO.getCode(), EventTypeEnum.ONE_OO.getMsg(),
                    DateUtil.format(createTime), new Date());
            klbService.addNewStatusPo(po);
        }

        return SUCCESS;
    }
}