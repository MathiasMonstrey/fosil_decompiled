package com.fossil;

import android.text.TextUtils;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.Presenter;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

public abstract class dtm implements RedirectHandler {
    private static final String TAG = dtm.class.getCanonicalName();
    String cAW;
    int dsp;
    private String dsq;

    public abstract void axr();

    public abstract boolean jW(String str);

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        duj.m9769d(TAG, "CustomRedirectHandler getLocationURI getRedirectUrl : " + this.dsq);
        if (TextUtils.isEmpty(this.dsq)) {
            return null;
        }
        return URI.create(this.dsq);
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == Presenter.NEXT || statusCode == Presenter.PREVIOUS) {
            this.dsq = httpResponse.getFirstHeader("Location").getValue();
            if (!TextUtils.isEmpty(this.dsq) && this.dsp < 15 && jW(this.dsq)) {
                this.dsp++;
                return true;
            }
        } else if (statusCode == MFNetworkReturnCode.RESPONSE_OK) {
            this.cAW = this.dsq;
        } else {
            axr();
        }
        return false;
    }

    public String getRedirectUrl() {
        return this.cAW;
    }
}
