package com.misfit.frameworks.network.manager;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;

class MFNetwork$1 implements Runnable {
    final /* synthetic */ MFNetwork this$0;
    final /* synthetic */ Exception val$exception;
    final /* synthetic */ MFResponse val$response;

    MFNetwork$1(MFNetwork mFNetwork, MFResponse mFResponse, Exception exception) {
        this.this$0 = mFNetwork;
        this.val$response = mFResponse;
        this.val$exception = exception;
    }

    public void run() {
        MFLogger.d(MFNetwork.access$000(), "Inside .notifyListeners running with response=" + this.val$response + ", exception=" + this.val$exception + ", of id=" + this.val$response.getRequestId());
        if (this.val$response == null) {
            throw new IllegalArgumentException("Response is null!");
        } else if (this.val$exception != null) {
            synchronized (MFNetwork.access$100(this.this$0)) {
                MFServerResultCallback mFServerResultCallback = (MFServerResultCallback) MFNetwork.access$100(this.this$0).get(this.val$response.getRequestId());
                MFNetwork.access$100(this.this$0).remove(this.val$response.getRequestId());
                MFLogger.d(MFNetwork.access$000(), "Inside .notifyListeners notify callback=" + mFServerResultCallback + ",id" + this.val$response.getRequestId());
                if (mFServerResultCallback != null) {
                    mFServerResultCallback.onFail(this.val$response.getInternalErrorCode(), this.val$response);
                } else {
                    MFLogger.e(MFNetwork.access$000(), "Callback is null, do something");
                }
            }
        } else {
            MFLogger.d(MFNetwork.access$000(), "Inside .notifyListeners notify receiver and callback");
            MFNetwork.access$200(this.this$0, this.val$response);
            MFNetwork.access$300(this.this$0, this.val$response);
        }
    }
}
