package com.commonrail.kaluli.domain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/25.
 */
public class KlbDeviceStatusPo implements Serializable {
    private Integer sid;
    private String deviceId;
    private Date startTime;
    private Date endTime;
    private String eventType;
    private String eventTypeDesc;
    private String eventValue;
    private Date createTime;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventValue() {
        return eventValue;
    }

    public void setEventValue(String eventValue) {
        this.eventValue = eventValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEventTypeDesc() {
        return eventTypeDesc;
    }

    public void setEventTypeDesc(String eventTypeDesc) {
        this.eventTypeDesc = eventTypeDesc;
    }

    public KlbDeviceStatusPo() {
    }

    public KlbDeviceStatusPo(String deviceId, Date startTime, Date endTime, String eventType, String eventTypeDesc, String eventValue, Date createTime) {
        this.deviceId = deviceId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventType = eventType;
        this.eventTypeDesc = eventTypeDesc;
        this.eventValue = eventValue;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "KlbDeviceStatusPo{" +
                "deviceId='" + deviceId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", eventType='" + eventType + '\'' +
                ", eventTypeDesc='" + eventTypeDesc + '\'' +
                ", eventValue='" + eventValue + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
