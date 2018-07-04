package com.commonrail.kaluli.two.service.impl;

import com.commonrail.kaluli.domain.model.KlbIsLossDataPo;
import com.commonrail.kaluli.domain.model.KlbModePo;
import com.commonrail.kaluli.domain.model.KlbTimePo;
import com.commonrail.kaluli.domain.model.NumOfKlbPo;
import com.commonrail.kaluli.two.service.OtherService;
import com.commonrail.kaluli.two.mapper.TwoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by Administrator on 2018/6/26.
 */
@Service("otherService")
public class OtherServiceImpl implements OtherService {

    @Autowired
    private TwoMapper twoMapper;

    @Override
    public Integer getKlbNumBy(Date startTime, Date endTime) {
        return twoMapper.getKlbNumBy(startTime, endTime);
    }

    @Override
    public Integer getResetNumBy(Date startTime, Date endTime) {
        return twoMapper.getResetNumBy(startTime, endTime);
    }

    @Override
    public Integer getReconnectNumBy(Date startTime, Date endTime) {
        return twoMapper.getReconnectNumBy(startTime, endTime);
    }

    @Override
    public Integer getGpsNumBy(Date startTime, Date endTime) {
        return twoMapper.getGpsNumBy(startTime, endTime);
    }

    @Override
    public Integer getHealthNumBy(Date startTime, Date endTime) {
        return twoMapper.getHealthNumBy(startTime, endTime);
    }

    @Override
    public List<KlbModePo> getModes() {
        return twoMapper.getModes();
    }

    @Override
    public List<NumOfKlbPo> getKlbGpsNumList(Date startTime, Date endTime) {
        return twoMapper.getKlbGpsNumList(startTime, endTime);
    }

    @Override
    public List<NumOfKlbPo> getKlbHealthNumList(Date startTime, Date endTime) {
        return twoMapper.getKlbHealthNumList(startTime, endTime);
    }

    @Override
    public List<KlbTimePo> getKlbLoginTimeList() {
        return twoMapper.getKlbLoginTimeList();
    }

    @Override
    public List<KlbTimePo> getKlbLatestReportTimeList() {
        return twoMapper.getKlbLatestReportTimeList();
    }

    @Override
    public List<KlbIsLossDataPo> getKlbIsLossDataList(Date startTime, Date endTime) {
        return twoMapper.getKlbIsLossDataList(startTime, endTime);
    }
}
