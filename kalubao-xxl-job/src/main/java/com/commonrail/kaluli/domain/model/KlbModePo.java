package com.commonrail.kaluli.domain.model;

/**
 * Created by Administrator on 2018/6/26.
 */
public class KlbModePo {
    private String deviceId;
    private String modeDesc;
    private Long usedVer;


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getModeDesc() {
        return modeDesc;
    }

    public void setModeDesc(String modeDesc) {
        this.modeDesc = modeDesc;
    }

    public Long getUsedVer() {
        return usedVer;
    }

    public void setUsedVer(Long usedVer) {
        this.usedVer = usedVer;
    }
}
