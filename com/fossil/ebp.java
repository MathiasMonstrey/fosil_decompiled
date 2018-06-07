package com.fossil;

import com.misfit.ble.shine.ShineProfile;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

class ebp extends DefaultConnectionKeepAliveStrategy {
    final /* synthetic */ ebo dDn;

    ebp(ebo com_fossil_ebo) {
        this.dDn = com_fossil_ebo;
    }

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        return keepAliveDuration == -1 ? ShineProfile.LOG_UPLOADING_DELAY : keepAliveDuration;
    }
}
