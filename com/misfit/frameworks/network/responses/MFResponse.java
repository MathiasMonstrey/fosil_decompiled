package com.misfit.frameworks.network.responses;

import android.text.TextUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class MFResponse implements Serializable {
    private static final String TAG = MFResponse.class.getSimpleName();
    protected String action;
    protected String code;
    protected Command command = Command.UNKNOWN;
    protected String developerMessage;
    protected long etag;
    protected int httpReturnCode;
    protected int limit;
    protected String message;
    protected String moreInfo;
    protected int offset;
    protected int requestId;
    protected int status;
    protected int total;

    public Command getCommand() {
        return this.command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public int getStatus() {
        return this.status;
    }

    public int getInternalErrorCode() {
        if (TextUtils.isEmpty(this.code)) {
            return -1;
        }
        return Integer.valueOf(this.code).intValue();
    }

    public long getEtag() {
        return this.etag;
    }

    public String getAction() {
        return this.action;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getTotal() {
        return this.total;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public String getMoreInfo() {
        return this.moreInfo;
    }

    public int getHttpReturnCode() {
        return this.httpReturnCode;
    }

    public void setHttpReturnCode(int i) {
        this.httpReturnCode = i;
    }

    public void parse(JSONArray jSONArray) {
    }

    public void parse(JSONObject jSONObject) {
        try {
            if (jSONObject.has("code")) {
                this.code = jSONObject.getString("code");
            }
            if (jSONObject.has(Constants.ERROR_RESPONSE_KEY_DEVELOPE_MESSAGE)) {
                this.developerMessage = jSONObject.getString(Constants.ERROR_RESPONSE_KEY_DEVELOPE_MESSAGE);
            }
            if (jSONObject.has("message")) {
                this.message = jSONObject.getString("message");
            }
            if (jSONObject.has(Constants.ERROR_RESPONSE_KEY_MORE_INFO)) {
                this.moreInfo = jSONObject.getString(Constants.ERROR_RESPONSE_KEY_MORE_INFO);
            }
            if (jSONObject.has("status")) {
                this.status = jSONObject.getInt("status");
            }
            if (jSONObject.has(Constants.JSON_KEY_META)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.JSON_KEY_META);
                if (jSONObject2.has(Constants.JSON_KEY_ETAG)) {
                    this.etag = jSONObject2.getLong(Constants.JSON_KEY_ETAG);
                }
                if (jSONObject2.has("action")) {
                    this.action = jSONObject2.getString("action");
                }
                if (jSONObject2.has(Constants.JSON_KEY_LIMIT)) {
                    this.limit = jSONObject2.getInt(Constants.JSON_KEY_LIMIT);
                }
                if (jSONObject2.has(Constants.JSON_KEY_TOTAL)) {
                    this.total = jSONObject2.getInt(Constants.JSON_KEY_TOTAL);
                }
                if (jSONObject2.has(Constants.JSON_KEY_OFFSET)) {
                    this.offset = jSONObject2.getInt(Constants.JSON_KEY_OFFSET);
                }
            }
        } catch (Exception e) {
            MFLogger.e(TAG, "Error inside MFResponse.parse - e=" + e);
            this.status = 600;
        }
    }

    public String toString() {
        return "[MFResponse: requestId=" + this.requestId + ", code=" + this.code + ", msg=" + this.message;
    }
}
