package com.commonrail.kaluli.domain.model;

import java.util.Date;
/**
 * Created by Administrator on 2018/6/27.
 */
public class KlbTimePo {
    private String deviceId;
    private Date createTime;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
