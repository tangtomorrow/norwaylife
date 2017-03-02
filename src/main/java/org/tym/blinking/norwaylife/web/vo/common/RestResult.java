package org.tym.blinking.norwaylife.web.vo.common;

import com.google.common.base.MoreObjects;

/**
 * Created by tangtomorrow on 2017/3/2.
 */
public class RestResult<T> {
    private ResultCode resultCode;
    private String errorMsg;
    private T data;

    public RestResult() {
    }

    public RestResult(ResultCode resultCode, String errorMsg) {
        this.resultCode = resultCode;
        this.errorMsg = errorMsg;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("resultCode", resultCode)
                .add("errorMsg", errorMsg)
                .add("data", data)
                .toString();
    }
}
