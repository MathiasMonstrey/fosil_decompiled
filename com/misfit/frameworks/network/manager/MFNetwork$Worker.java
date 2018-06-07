package com.misfit.frameworks.network.manager;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFResponse;

final class MFNetwork$Worker implements Runnable {
    private MFBaseRequest request;
    final /* synthetic */ MFNetwork this$0;

    private MFNetwork$Worker(MFNetwork mFNetwork, MFBaseRequest mFBaseRequest) {
        this.this$0 = mFNetwork;
        this.request = mFBaseRequest;
    }

    public void run() {
        MFResponse execute = this.request.execute();
        MFLogger.d(MFNetwork.access$000(), "Execution network is done, response is " + execute.toString() + ", id done:" + execute.getRequestId());
        MFNetwork.access$500(this.this$0, execute, this.request.getException());
    }
}
