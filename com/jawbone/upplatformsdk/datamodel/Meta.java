package com.jawbone.upplatformsdk.datamodel;

import com.fossil.cga;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class Meta {
    @cga("code")
    public Integer code;
    @cga("error_detail")
    public String errorDetail;
    @cga("error_type")
    public String errorType;
    @cga("error_user_msg")
    public String errorUserMsg;
    @cga("message")
    public String message;
    @cga("time")
    public Integer time;
    @cga("user_xid")
    public String userXid;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getUserXid() {
        return this.userXid;
    }

    public Integer getTime() {
        return this.time;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public String getErrorUserMsg() {
        return this.errorUserMsg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setUserXid(String str) {
        this.userXid = str;
    }

    public void setTime(Integer num) {
        this.time = num;
    }

    public void setErrorType(String str) {
        this.errorType = str;
    }

    public void setErrorDetail(String str) {
        this.errorDetail = str;
    }

    public void setErrorUserMsg(String str) {
        this.errorUserMsg = str;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
