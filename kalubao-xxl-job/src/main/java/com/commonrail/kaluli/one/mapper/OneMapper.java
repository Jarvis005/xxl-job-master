package com.commonrail.kaluli.one.mapper;

import com.commonrail.kaluli.domain.model.KlbDeviceStatusPo;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/6/25.
 */
@Repository
public interface OneMapper {
    void addNewStatusPo(KlbDeviceStatusPo klbDeviceStatusPo);

}
