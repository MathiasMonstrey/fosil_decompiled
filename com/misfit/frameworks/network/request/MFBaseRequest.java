package com.misfit.frameworks.network.request;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.configuration.MFHeader;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.responses.MFResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class MFBaseRequest {
    private static final String TAG = MFBaseRequest.class.getSimpleName();
    protected String apiMethod;
    protected MFResponse buttonApiResponse = new MFResponse();
    protected MFConfiguration configuration;
    protected Context context;
    protected Exception exception;
    protected HttpURLConnection httpURLConnection;
    protected Object jsonData = new JSONObject();
    protected HTTPMethod method;
    protected int requestId;
    protected URL url;

    public abstract String initApiMethod();

    public abstract MFConfiguration initConfiguration();

    public abstract HTTPMethod initHttpMethod();

    public abstract Object initJsonData();

    public abstract MFResponse initResponse();

    protected MFBaseRequest(Context context) {
        this.context = context;
    }

    protected byte[] initBinaryData() {
        return null;
    }

    public void buildRequest() {
        this.configuration = initConfiguration();
        this.jsonData = initJsonData();
        this.method = initHttpMethod();
        this.apiMethod = initApiMethod();
        this.buttonApiResponse = initResponse();
        Uri parse = Uri.parse(this.configuration.getBaseServerUrl() + this.apiMethod);
        try {
            JSONObject jSONObject;
            Iterator keys;
            Builder buildUpon;
            String str;
            if (this.method == HTTPMethod.GET) {
                if (this.jsonData != null) {
                    if (this.jsonData instanceof JSONObject) {
                        jSONObject = (JSONObject) this.jsonData;
                        keys = jSONObject.keys();
                        buildUpon = parse.buildUpon();
                        while (keys.hasNext()) {
                            str = (String) keys.next();
                            buildUpon.appendQueryParameter(str, String.valueOf(jSONObject.get(str)));
                        }
                        parse = buildUpon.build();
                    } else {
                        throw new Exception("We do not support JSONArray now for GET request.");
                    }
                }
                this.url = new URL(parse.toString());
                this.httpURLConnection = (HttpURLConnection) this.url.openConnection();
                this.httpURLConnection.setDoInput(true);
                this.httpURLConnection.setRequestMethod("GET");
            } else if (this.method == HTTPMethod.POST || this.method == HTTPMethod.PATCH) {
                this.url = new URL(parse.toString());
                this.httpURLConnection = (HttpURLConnection) this.url.openConnection();
                this.httpURLConnection.setDoOutput(true);
                this.httpURLConnection.setRequestMethod("POST");
            } else if (this.method == HTTPMethod.PUT) {
                this.url = new URL(parse.toString());
                this.httpURLConnection = (HttpURLConnection) this.url.openConnection();
                this.httpURLConnection.setDoOutput(true);
                this.httpURLConnection.setRequestMethod("PUT");
            } else if (this.method == HTTPMethod.DELETE) {
                Uri uri;
                if (this.jsonData == null) {
                    uri = parse;
                } else if (this.jsonData instanceof JSONObject) {
                    jSONObject = (JSONObject) this.jsonData;
                    keys = jSONObject.keys();
                    buildUpon = parse.buildUpon();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        buildUpon.appendQueryParameter(str, String.valueOf(jSONObject.get(str)));
                    }
                    uri = buildUpon.build();
                } else {
                    throw new Exception("We do not support JSONArray now for DELETE request.");
                }
                this.url = new URL(uri.toString());
                this.httpURLConnection = (HttpURLConnection) this.url.openConnection();
                this.httpURLConnection.setDoInput(true);
                this.httpURLConnection.setRequestMethod("DELETE");
            }
        } catch (Exception e) {
            MFLogger.m12670d(TAG, "Exception when build request " + e);
        }
        buildHeader(this.configuration.getHeader());
    }

    public void buildHeader(MFHeader mFHeader) {
        this.httpURLConnection.setRequestProperty("Content-Type", Constants.CONTENT_TYPE);
        this.httpURLConnection.setRequestProperty("Accept", "application/json");
        this.httpURLConnection.setRequestProperty("User-Agent", MFNetwork.getInstance(this.context).getUserAgent());
        this.httpURLConnection.setRequestProperty("Installation-ID", MFNetwork.getInstance(this.context).getInstallationId());
        this.httpURLConnection.setRequestProperty("Locale", MFNetwork.getInstance(this.context).getLocale());
        if (this.method == HTTPMethod.PATCH) {
            this.httpURLConnection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        }
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
        this.httpURLConnection.setConnectTimeout(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
        this.httpURLConnection.setReadTimeout(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public Exception getException() {
        return this.exception;
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
                MFLogger.m12670d(TAG, "execute - httpUriRequest == null");
                this.buttonApiResponse.setHttpReturnCode(MFNetworkReturnCode.REQUEST_NOT_FOUND);
                MFResponse mFResponse = this.buttonApiResponse;
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
                Map requestProperties = this.httpURLConnection.getRequestProperties();
                if (requestProperties != null) {
                    for (Entry entry : requestProperties.entrySet()) {
                        String str2 = (String) entry.getKey();
                        List list = (List) entry.getValue();
                        String str3 = TAG;
                        StringBuilder append = new StringBuilder().append("Header value--").append(str2).append(":");
                        if (list == null || list.isEmpty()) {
                            str = "";
                        } else {
                            str = (String) list.get(0);
                        }
                        MFLogger.m12670d(str3, append.append(str).toString());
                    }
                    MFLogger.m12670d(TAG, "Inside MFBaseRequest.doInBackground - sending REQUEST: command=, requestId=" + this.requestId + "\nurl=" + this.httpURLConnection.getURL().toString() + "\njsonData =");
                    if (this.jsonData != null) {
                        MFLogger.m12670d(TAG, "Inside MFBaseRequest.doInBackground - jsondata : " + this.jsonData.toString());
                    }
                }
            }
            this.httpURLConnection.setUseCaches(false);
            if (this.method != HTTPMethod.GET) {
                byte[] initBinaryData = initBinaryData();
                if (initBinaryData != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(this.httpURLConnection.getOutputStream());
                    dataOutputStream.write(initBinaryData);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } else if (this.jsonData != null) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.httpURLConnection.getOutputStream(), "UTF-8"));
                    bufferedWriter.write(this.jsonData.toString());
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } else {
                this.httpURLConnection.connect();
            }
            if (this.httpURLConnection.getResponseCode() < MFNetworkReturnCode.RESPONSE_OK || this.httpURLConnection.getResponseCode() >= MFNetworkReturnCode.BAD_REQUEST) {
                bufferedInputStream = new BufferedInputStream(this.httpURLConnection.getErrorStream());
            } else {
                bufferedInputStream = new BufferedInputStream(this.httpURLConnection.getInputStream());
            }
            try {
                str = readStream(bufferedInputStream);
                MFLogger.m12670d(TAG, "Inside MFBaseRequest.Worker.doInBackground requestId " + this.buttonApiResponse.getRequestId() + "- RESPONSE {httpStatus=" + this.httpURLConnection.getResponseCode() + ", jsonData=" + str + "}");
                this.buttonApiResponse.setHttpReturnCode(this.httpURLConnection.getResponseCode());
                if (!TextUtils.isEmpty(str)) {
                    Object nextValue = new JSONTokener(str).nextValue();
                    if (nextValue instanceof JSONObject) {
                        this.buttonApiResponse.parse(new JSONObject(str));
                    } else if (nextValue instanceof JSONArray) {
                        this.buttonApiResponse.parse(new JSONArray(str));
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (SocketTimeoutException e4) {
                e = e4;
                try {
                    MFLogger.m12671e(TAG, "Error inside MFBaseRequest.Worker.doInBackground - e=SocketTimeoutException");
                    this.buttonApiResponse.setHttpReturnCode(601);
                    this.exception = e;
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
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (ConnectException e5) {
                e = e5;
                inputStream = bufferedInputStream;
                try {
                    MFLogger.m12671e(TAG, "Error inside MFBaseRequest.Worker.doInBackground - e=ConnectException");
                    this.buttonApiResponse.setHttpReturnCode(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    this.exception = e;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                    return this.buttonApiResponse;
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                inputStream = bufferedInputStream;
                MFLogger.m12671e(TAG, "Error inside MFBaseRequest.Worker.doInBackground - e=" + e);
                this.exception = e;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3222) {
                        e3222.printStackTrace();
                    }
                }
                return this.buttonApiResponse;
            }
            return this.buttonApiResponse;
        } catch (SocketTimeoutException e7) {
            e = e7;
            bufferedInputStream = inputStream;
        } catch (ConnectException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
    }

    protected String readStream(InputStream inputStream) {
        IOException e;
        Throwable th;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            e3 = e4;
            bufferedReader2 = null;
            try {
                e3.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                return stringBuilder.toString();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return stringBuilder.toString();
    }
}
