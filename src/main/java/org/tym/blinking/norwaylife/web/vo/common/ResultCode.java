package org.tym.blinking.norwaylife.web.vo.common;

/**
 * Created by tangtomorrow on 2017/3/2.
 */
public enum ResultCode {
    SUCCESS("SUCCESS"),
    WARN("WARN"),
    ERROR("ERROR");

    String value;

    ResultCode(String value) {
        this.value = value;
    }
}
