package com.commonrail.kaluli.two.mapper;

import com.commonrail.kaluli.domain.model.KlbIsLossDataPo;
import com.commonrail.kaluli.domain.model.KlbModePo;
import com.commonrail.kaluli.domain.model.KlbTimePo;
import com.commonrail.kaluli.domain.model.NumOfKlbPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */
@Repository
public interface TwoMapper {
    Integer getKlbNumBy(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Integer getResetNumBy(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Integer getReconnectNumBy(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Integer getGpsNumBy(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Integer getHealthNumBy(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<KlbModePo> getModes();

    List<NumOfKlbPo> getKlbGpsNumList(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<NumOfKlbPo> getKlbHealthNumList(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<KlbTimePo> getKlbLoginTimeList();

    List<KlbTimePo> getKlbLatestReportTimeList();

    List<KlbIsLossDataPo> getKlbIsLossDataList(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
