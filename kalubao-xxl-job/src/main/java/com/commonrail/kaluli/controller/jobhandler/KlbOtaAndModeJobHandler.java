package com.commonrail.kaluli.controller.jobhandler;

import com.commonrail.kaluli.domain.enums.EventTypeEnum;
import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import com.commonrail.kaluli.domain.model.KlbModePo;
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
 * 该设备目前在用ota及工作模式
 * Created by Administrator on 2018/6/25.
 */
@JobHandler(value = "klbOtaAndModeJobHandler")
@Component
public class KlbOtaAndModeJobHandler extends IJobHandler {
    @Autowired
    private KlbService klbService;
    @Autowired
    private OtherService otherService;

    @Override
    @Transactional
    public ReturnT<String> execute(String param) throws Exception {
        List<KlbModePo> modes = otherService.getModes();

        for(KlbModePo klbModePo : modes) {
            String modeDesc = klbModePo.getModeDesc();
            String deviceId = klbModePo.getDeviceId();
            long usedVer = klbModePo.getUsedVer();
            KlbDeviceStatusPo po = new KlbDeviceStatusPo(
                        deviceId, null, null, EventTypeEnum.NINETEEN_OO.getCode(), EventTypeEnum.NINETEEN_OO.getMsg(),
                        usedVer+"_"+modeDesc, new Date());
            klbService.addNewStatusPo(po);
        }

        return SUCCESS;
    }

}