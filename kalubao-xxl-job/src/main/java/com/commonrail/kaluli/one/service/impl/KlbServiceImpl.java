package com.commonrail.kaluli.one.service.impl;

import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import com.commonrail.kaluli.one.mapper.OneMapper;
import com.commonrail.kaluli.one.service.KlbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/6/25.
 */
@Service("klbService")
public class KlbServiceImpl implements KlbService {

    @Autowired
    private OneMapper oneMapper;

    @Override
    public void addNewStatusPo(KlbDeviceStatusPo klbDeviceStatusPo) {
        oneMapper.addNewStatusPo(klbDeviceStatusPo);
    }

}
