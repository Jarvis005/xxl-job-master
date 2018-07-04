package com.commonrail.kaluli.domain.enums;

/**
 * Created by Administrator on 2018/6/26.
 */
public enum  EventTypeEnum {
    ONE_OO("001", "该设备最后一次登录时间"),
    TWO_OO("002", "该设备最后一次上传数据时间"),
    THREE_OO("003", "该设备最近1小时体检数据包数量"),
    FOUR_OO("004", "该设备最近一小时GPS数据包数量"),
    FIVE_OO("005", "该设备最近5分钟体检数据包数量"),
    SIX_OO("006", "该设备最近5分钟gps数据包数量"),
    SEVEN_OO("007", "该设备最近5分钟有无丢失体检/gps数据包"),
//    EIGHT_OO("008", "该设备最近5分钟有无丢失gps数据包"),

    NINE_OO("009", "最近一小时运行的卡路宝数量"),
    TEN_OO("010", "最近一小时卡路宝reset次数"),
    ELEVEN_OO("011", "最近一小时卡路宝recollect次数"),
    TWELVE_OO("012", "最近5分钟内运行的卡路宝数量"),
    THIRTEEN_OO("013", "最近5分钟内卡路宝的reset次数"),
    FOURTEEN_OO("014", "最近5分钟内卡路宝的recollect次数"),
    FIFTEEN_OO("015", "最近1小时内体检数据流条数"),
    SIXTEEN_OO("016", "最近5分钟内体检数据流条数"),
    SEVENTEEN_OO("017", "最近1小时内gps数据包数量"),
    EIGHTEEN_OO("018", "最近5分钟内gps数据包数量"),

    NINETEEN_OO("019", "该设备在用固件号和工作模式");

    private String code;
    private String msg;

    EventTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
