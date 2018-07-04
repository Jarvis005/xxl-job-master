package com.commonrail.kaluli.two.service;

import com.commonrail.kaluli.domain.model.KlbIsLossDataPo;
import com.commonrail.kaluli.domain.model.KlbModePo;
import com.commonrail.kaluli.domain.model.KlbTimePo;
import com.commonrail.kaluli.domain.model.NumOfKlbPo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */
public interface OtherService {
    Integer getKlbNumBy(Date startTime, Date endTime);

    Integer getResetNumBy(Date startTime, Date endTime);

    Integer getReconnectNumBy(Date startTime, Date endTime);

    Integer getGpsNumBy(Date startTime, Date endTime);

    Integer getHealthNumBy(Date startTime, Date endTime);

    List<KlbModePo> getModes();

    List<NumOfKlbPo> getKlbGpsNumList(Date startTime, Date endTime);

    List<NumOfKlbPo> getKlbHealthNumList(Date startTime, Date endTime);

    List<KlbTimePo> getKlbLoginTimeList();

    List<KlbTimePo> getKlbLatestReportTimeList();

    List<KlbIsLossDataPo> getKlbIsLossDataList(Date startTime, Date endTime);
}
