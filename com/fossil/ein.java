package com.fossil;

import android.content.Context;
import com.ua.sdk.UaException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class ein {
    private final Context context;
    private final String dDv;

    public ein(Context context, String str) {
        this.context = (Context) eiy.m10771e(context, "context");
        this.dDv = (String) eiy.m10771e(str, "clientId");
    }

    public HttpsURLConnection m10760b(URL url) throws IOException, UaException {
        eiy.ek(this.context);
        ecq.debug("connect=%s", url.toString());
        return (HttpsURLConnection) m10761c((HttpsURLConnection) url.openConnection());
    }

    public <T extends URLConnection> T m10761c(T t) {
        t.setRequestProperty("Api-Key", this.dDv);
        return t;
    }
}
