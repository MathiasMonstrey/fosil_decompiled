package com.portfolio.platform.data.source.loader;

import android.content.Context;
import com.fossil.esl;
import com.fossil.gk;
import com.misfit.frameworks.common.log.MFLogger;

public abstract class BaseLoader<T> extends gk<T> {
    public static final Companion Companion = new Companion();
    private static final String TAG;

    public static final class Companion {
        private Companion() {
        }

        public final String getTAG() {
            return BaseLoader.TAG;
        }
    }

    public BaseLoader(Context context) {
        super(context);
    }

    static {
        String simpleName = BaseLoader.class.getSimpleName();
        if (simpleName == null) {
            esl.aGW();
        }
        TAG = simpleName;
    }

    protected void onReset() {
        MFLogger.d(Companion.getTAG(), "Inside .onReset");
        onStopLoading();
        super.onReset();
    }

    protected void onStopLoading() {
        MFLogger.d(Companion.getTAG(), "Inside .onStopLoading");
        cancelLoad();
        super.onStopLoading();
    }

    public void deliverResult(T t) {
        MFLogger.d(Companion.getTAG(), "Inside .deliverResult data=" + t + ", isReset=" + isReset() + ". isStarted=" + isStarted());
        if (!isReset() && isStarted()) {
            super.deliverResult(t);
        }
    }
}
