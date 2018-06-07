package com.fossil;

import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class ena {
    private static final Pattern dNx = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final emr dNl;
    private final eov dNp;
    private final HttpMethod dNy;
    private final String dNz;
    private final String url;

    public ena(emr com_fossil_emr, String str, String str2, eov com_fossil_eov, HttpMethod httpMethod) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (com_fossil_eov == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.dNl = com_fossil_emr;
            this.dNz = str;
            this.url = mh(str2);
            this.dNp = com_fossil_eov;
            this.dNy = httpMethod;
        }
    }

    protected String getUrl() {
        return this.url;
    }

    protected HttpRequest aFf() {
        return m2904B(Collections.emptyMap());
    }

    protected HttpRequest m2904B(Map<String, String> map) {
        return this.dNp.mo2989a(this.dNy, getUrl(), map).dK(false).pk(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL).bm("User-Agent", "Crashlytics Android SDK/" + this.dNl.getVersion()).bm("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String mh(String str) {
        if (CommonUtils.isNullOrEmpty(this.dNz)) {
            return str;
        }
        return dNx.matcher(str).replaceFirst(this.dNz);
    }
}
