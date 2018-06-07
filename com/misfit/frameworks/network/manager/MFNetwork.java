package com.misfit.frameworks.network.manager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode.InternalErrorCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.BuildConfig;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.misfit.frameworks.network.utils.ReturnCodeRangeChecker;

public class MFNetwork {
    private static final int MAX_REQUEST = 10;
    private static final String TAG = MFNetwork.class.getSimpleName();
    private static MFNetwork instance;
    private static boolean isDebug;
    private String appUserAgent;
    private Context context;
    private int currentTotalRequest = 0;
    private String installationId;
    private String locale;
    private NetworkService networkService;
    private OnGlobalServerEvent onGlobalServerEvent;
    private SparseArray pendingRequests;
    private int requestId = 0;

    public interface MFServerResultCallback {
        void onFail(int i, MFResponse mFResponse);

        void onSuccess(MFResponse mFResponse);
    }

    public interface OnGlobalServerEvent {
        void onServerMaintenance();

        void onTokenExpired();
    }

    private MFNetwork(Context context) {
        this.context = context;
        this.pendingRequests = new SparseArray();
        this.networkService = new NetworkService(this);
    }

    public void initialize(boolean z, String str) {
        isDebug = z;
        this.appUserAgent = str;
        MFLogger.initialize(this.context);
    }

    public static synchronized MFNetwork getInstance(Context context) {
        MFNetwork mFNetwork;
        synchronized (MFNetwork.class) {
            if (instance == null) {
                instance = new MFNetwork(context);
            }
            mFNetwork = instance;
        }
        return mFNetwork;
    }

    public String getVersion() {
        return BuildConfig.VERSION;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public synchronized void execute(MFBaseRequest mFBaseRequest, MFServerResultCallback mFServerResultCallback) {
        if (mFServerResultCallback == null) {
            throw new IllegalArgumentException("Callback must not be null!");
        }
        this.requestId++;
        this.pendingRequests.put(this.requestId, mFServerResultCallback);
        mFBaseRequest.setRequestId(this.requestId);
        if (NetworkUtils.isNetworkAvailable(this.context)) {
            MFLogger.m12670d(TAG, "Execute request, currentRequest: " + this.currentTotalRequest);
            executeRequest(mFBaseRequest);
        } else {
            MFResponse mFResponse = new MFResponse();
            mFResponse.setRequestId(this.requestId);
            mFServerResultCallback.onFail(601, mFResponse);
        }
    }

    private void executeRequest(MFBaseRequest mFBaseRequest) {
        this.currentTotalRequest++;
        this.networkService.pollRequest(mFBaseRequest);
    }

    public void setOnGlobalServerEvent(OnGlobalServerEvent onGlobalServerEvent) {
        this.onGlobalServerEvent = onGlobalServerEvent;
    }

    public String getUserAgent() {
        return this.appUserAgent;
    }

    public String getInstallationId() {
        return this.installationId;
    }

    public void setInstallationId(String str) {
        this.installationId = str;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    private void notifyListeners(MFResponse mFResponse, Exception exception) {
        MFLogger.m12670d(TAG, "Inside .notifyListeners with response=" + mFResponse + ", exception=" + exception + ", of id=" + mFResponse.getRequestId());
        new Handler(Looper.getMainLooper()).post(new 1(this, mFResponse, exception));
    }

    public int getRequestId() {
        return this.requestId;
    }

    private void notifyReceiver(MFResponse mFResponse) {
        MFLogger.m12670d(TAG, "Inside .notifyListeners notify receiver");
        Bundle bundle = new Bundle();
        bundle.putSerializable("com.misfit.frameworks.response", mFResponse);
        bundle.putSerializable("com.misfit.frameworks.response", mFResponse.getCommand());
        Intent intent = new Intent();
        intent.setAction("com.misfit.frameworks.response");
        intent.putExtras(bundle);
        this.context.sendBroadcast(intent);
    }

    private synchronized void notifyCallback(MFResponse mFResponse) {
        MFLogger.m12670d(TAG, "Inside .notifyListeners notifyCallback response=" + mFResponse);
        if (mFResponse == null) {
            Log.e(TAG, "Response from request is null");
        } else {
            MFServerResultCallback mFServerResultCallback = (MFServerResultCallback) this.pendingRequests.get(mFResponse.getRequestId());
            MFLogger.m12670d(TAG, "Notify receiver with callback " + mFServerResultCallback + ", id=" + mFResponse.getRequestId() + ", code=" + mFResponse.getHttpReturnCode() + ", callback=" + mFServerResultCallback);
            if (!ReturnCodeRangeChecker.isSuccessReturnCode(mFResponse.getHttpReturnCode())) {
                if (mFResponse.getHttpReturnCode() == 401) {
                    int internalErrorCode = mFResponse.getInternalErrorCode();
                    if (this.onGlobalServerEvent != null && (internalErrorCode == 401 || internalErrorCode == InternalErrorCode.TOKEN_EXCHANGE_ERROR)) {
                        this.onGlobalServerEvent.onTokenExpired();
                    }
                } else if ((mFResponse.getHttpReturnCode() == 504 || mFResponse.getHttpReturnCode() == 503) && this.onGlobalServerEvent != null) {
                    this.onGlobalServerEvent.onServerMaintenance();
                }
                if (mFServerResultCallback != null) {
                    MFLogger.m12670d(TAG, "Notify receiver with callback fail of id=" + mFResponse.getRequestId());
                    mFServerResultCallback.onFail(mFResponse.getHttpReturnCode(), mFResponse);
                }
            } else if (mFServerResultCallback != null) {
                MFLogger.m12670d(TAG, "Notify receiver with callback success of id=" + mFResponse.getRequestId());
                mFServerResultCallback.onSuccess(mFResponse);
            }
        }
    }
}
