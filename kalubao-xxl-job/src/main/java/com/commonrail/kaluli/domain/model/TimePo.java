package com.commonrail.kaluli.domain.model;

import java.util.Date;
/**
 * Created by Administrator on 2018/6/26.
 */
public class TimePo {
    private Date startTime;
    private Date endTime;

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

    public TimePo() {
    }

    public TimePo(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
