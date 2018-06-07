package com.fossil;

import android.annotation.TargetApi;
import android.os.AsyncTask;

@TargetApi(11)
class is {
    static <Params, Progress, Result> void m11852b(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
