package com.misfit.frameworks.network.request;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.fossil.eup;
import com.fossil.eut;
import com.fossil.euu;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFHeader;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.responses.MFResponse;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class MFMultipartRequest extends MFBaseRequest {
    private static final String TAG = MFMultipartRequest.class.getSimpleName();
    private eup multipartEntity;

    protected abstract JSONObject initUploadFileUrl();

    protected MFMultipartRequest(Context context) {
        super(context);
    }

    protected void buildRequest() {
        this.configuration = initConfiguration();
        this.jsonData = initJsonData();
        this.method = initHttpMethod();
        this.apiMethod = initApiMethod();
        this.buttonApiResponse = initResponse();
        JSONObject initUploadFileUrl = initUploadFileUrl();
        Uri parse = Uri.parse(this.configuration.getBaseServerUrl() + this.apiMethod);
        eup com_fossil_eup = new eup();
        try {
            if (this.jsonData != null) {
                if (this.jsonData instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) this.jsonData;
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        appendFormDataToEntity(jSONObject.get((String) keys.next()).toString(), com_fossil_eup);
                    }
                } else {
                    throw new Exception("For MultipartRequest, jsonData must be an object");
                }
            }
            if (initUploadFileUrl != null) {
                Iterator keys2 = initUploadFileUrl.keys();
                while (keys2.hasNext()) {
                    String str = (String) keys2.next();
                    com_fossil_eup.a(str, new eut(new File(initUploadFileUrl.get(str).toString()), "image/jpeg"));
                }
            }
            this.url = new URL(parse.toString());
            this.httpURLConnection = (HttpURLConnection) this.url.openConnection();
            this.httpURLConnection.setDoOutput(true);
            this.httpURLConnection.setRequestMethod("POST");
            buildHeader(this.configuration.getHeader());
        } catch (Exception e) {
            MFLogger.e(TAG, "Error when build request multipart " + e);
        }
    }

    private void appendFormDataToEntity(String str, eup com_fossil_eup) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                com_fossil_eup.a(str2, new euu(jSONObject.get(str2).toString()));
            }
        } catch (Exception e) {
            MFLogger.d(TAG, "Exception when appenFormDataToEntity " + e);
        }
    }

    protected void buildHeader(MFHeader mFHeader) {
        if (mFHeader != null) {
            HashMap headerMap = this.configuration.getHeader().getHeaderMap();
            if (headerMap != null) {
                for (String str : headerMap.keySet()) {
                    String str2 = (String) headerMap.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
        }
    }

    public MFResponse execute() {
        InputStream bufferedInputStream;
        Exception e;
        Throwable th;
        InputStream inputStream = null;
        try {
            buildRequest();
            this.buttonApiResponse.setRequestId(this.requestId);
            if (this.httpURLConnection == null) {
                MFLogger.d(TAG, "execute - httpUriRequest == null");
                this.buttonApiResponse.setHttpReturnCode(MFNetworkReturnCode.REQUEST_NOT_FOUND);
                MFResponse mFResponse = this.buttonApiResponse;
                if (this.httpURLConnection != null) {
                    this.httpURLConnection.disconnect();
                }
                if (inputStream == null) {
                    return mFResponse;
                }
                try {
                    inputStream.close();
                    return mFResponse;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return mFResponse;
                }
            }
            String str;
            if (MFNetwork.isDebug()) {
                for (Entry entry : this.httpURLConnection.getRequestProperties().entrySet()) {
                    String str2 = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    String str3 = TAG;
                    StringBuilder append = new StringBuilder().append("Header value--").append(str2).append(":");
                    if (list == null || list.isEmpty()) {
                        str = "";
                    } else {
                        str = (String) list.get(0);
                    }
                    MFLogger.d(str3, append.append(str).toString());
                }
                MFLogger.d(TAG, "Inside MFBaseRequest.doInBackground - sending REQUEST: command=, requestId=" + this.requestId + "\nurl=" + this.httpURLConnection.getURL().toString() + "\njsonData =");
                if (this.jsonData != null) {
                    MFLogger.d(TAG, "Inside MFBaseRequest.doInBackground - jsondata : " + this.jsonData.toString());
                }
            }
            this.httpURLConnection.setUseCaches(false);
            if (this.method == HTTPMethod.POST || this.method == HTTPMethod.PATCH) {
                OutputStream dataOutputStream = new DataOutputStream(this.httpURLConnection.getOutputStream());
                this.multipartEntity.writeTo(dataOutputStream);
                dataOutputStream.flush();
                dataOutputStream.close();
            } else {
                this.httpURLConnection.connect();
            }
            if (this.httpURLConnection.getResponseCode() == MFNetworkReturnCode.RESPONSE_OK) {
                bufferedInputStream = new BufferedInputStream(this.httpURLConnection.getInputStream());
            } else {
                bufferedInputStream = new BufferedInputStream(this.httpURLConnection.getErrorStream());
            }
            try {
                str = readStream(bufferedInputStream);
                MFLogger.d(TAG, "Inside MFBaseRequest.Worker.doInBackground requestId " + this.buttonApiResponse.getRequestId() + "- RESPONSE {httpStatus=" + this.httpURLConnection.getResponseCode() + ", jsonData=" + str + "}");
                this.buttonApiResponse.setHttpReturnCode(this.httpURLConnection.getResponseCode());
                if (!TextUtils.isEmpty(str)) {
                    Object nextValue = new JSONTokener(str).nextValue();
                    if (nextValue instanceof JSONObject) {
                        this.buttonApiResponse.parse(new JSONObject(str));
                    } else if (nextValue instanceof JSONArray) {
                        this.buttonApiResponse.parse(new JSONArray(str));
                    }
                }
                if (this.httpURLConnection != null) {
                    this.httpURLConnection.disconnect();
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    MFLogger.e(TAG, "Error inside MFBaseRequest.Worker.doInBackground - e=" + e);
                    this.exception = e;
                    if (this.httpURLConnection != null) {
                        this.httpURLConnection.disconnect();
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    return this.buttonApiResponse;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = bufferedInputStream;
                    if (this.httpURLConnection != null) {
                        this.httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return this.buttonApiResponse;
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = inputStream;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
