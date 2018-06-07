package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.facebook.internal.AnalyticsEvents;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.constants.Constants;

public enum JsonValueFormat {
    DATE_TIME("date-time"),
    DATE("date"),
    TIME("time"),
    UTC_MILLISEC("utc-millisec"),
    REGEX("regex"),
    COLOR(BaseFeatureModel.COLUMN_COLOR),
    STYLE(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE),
    PHONE("phone"),
    URI("uri"),
    EMAIL(Constants.EMAIL),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    HOST_NAME("host-name");
    
    private final String _desc;

    private JsonValueFormat(String str) {
        this._desc = str;
    }

    public String toString() {
        return this._desc;
    }
}
