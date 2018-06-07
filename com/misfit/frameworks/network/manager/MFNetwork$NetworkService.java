package com.misfit.frameworks.network.manager;

import android.os.Build;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.request.MFBaseRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class MFNetwork$NetworkService {
    private ExecutorService pool;
    final /* synthetic */ MFNetwork this$0;

    public MFNetwork$NetworkService(MFNetwork mFNetwork) {
        int i = 1;
        this.this$0 = mFNetwork;
        if (!Build.MANUFACTURER.equals("HUAWEI")) {
            i = Math.max(1, Runtime.getRuntime().availableProcessors());
        }
        MFLogger.d(MFNetwork.access$000(), "Inside " + MFNetwork.access$000() + ".NetworkService - num_of_cores=" + i);
        this.pool = Executors.newFixedThreadPool(i);
    }

    public void pollRequest(MFBaseRequest mFBaseRequest) {
        try {
            this.pool.execute(new MFNetwork$Worker(this.this$0, mFBaseRequest));
        } catch (Exception e) {
            MFLogger.e(MFNetwork.access$000(), "Error inside " + MFNetwork.access$000() + ".execute - e=" + e);
        }
    }
}
