package com.fossil;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public final class ir {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m11851a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            is.m11852b(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
