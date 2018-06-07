package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class djk extends ckb<C2840a, C2841b, C2131a> {
    private static final String TAG = djk.class.getSimpleName();

    public static final class C2840a implements C2132b {
        private final double cNh;
        private final double cXr;
        private final String cXs;
        private final boolean mIsAvoidTolls;

        public C2840a(double d, double d2, String str, boolean z) {
            this.cNh = d;
            this.cXr = d2;
            this.cXs = str;
            this.mIsAvoidTolls = z;
        }
    }

    public static final class C2841b implements C2133c {
        private final long CZ;

        public C2841b(long j) {
            this.CZ = j;
        }

        public long getDuration() {
            return this.CZ;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8836a((C2840a) c2132b);
    }

    protected void m8836a(C2840a c2840a) {
        Object e;
        MFLogger.m12670d(TAG, "executeUseCase");
        String str = "https://maps.googleapis.com/maps/api/distancematrix/json?departure_time=now&mode=driving&units=imperial&origins=%f,%f&destinations=%s&key=%s";
        if (c2840a.mIsAvoidTolls) {
            str = "https://maps.googleapis.com/maps/api/distancematrix/json?departure_time=now&mode=driving&units=imperial&avoid=tolls&origins=%f,%f&destinations=%s&key=%s";
        }
        try {
            URL url = new URL(String.format(Locale.US, str, new Object[]{Double.valueOf(c2840a.cNh), Double.valueOf(c2840a.cXr), URLEncoder.encode(c2840a.cXs, "utf-8"), PortfolioApp.ZQ().getString(R.string.google_map_key)}));
            MFLogger.m12670d(TAG, "executeUseCase url " + url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Accept-Language", Locale.US.toString());
            httpURLConnection.setReadTimeout(MFNetworkReturnCode.REQUEST_NOT_FOUND);
            httpURLConnection.setConnectTimeout(MFNetworkReturnCode.REQUEST_NOT_FOUND);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine).append("\n");
            }
            str = stringBuilder.toString();
            if (!str.equals("")) {
                MFLogger.m12670d(TAG, "executeUseCase jsonData=" + str);
                JSONArray jSONArray = new JSONObject(str).getJSONArray("rows");
                if (jSONArray != null) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                    if (jSONObject != null) {
                        jSONObject = (JSONObject) jSONObject.getJSONArray("elements").get(0);
                        if (jSONObject.getString("status").equalsIgnoreCase("OK")) {
                            abr().onSuccess(new C2841b(jSONObject.getJSONObject("duration_in_traffic").getLong("value")));
                            return;
                        }
                        abr().onSuccess(new C2841b(-1));
                        return;
                    }
                }
            }
        } catch (IOException e2) {
            e = e2;
            MFLogger.m12670d(TAG, "IO Exception - e=" + e);
        } catch (JSONException e3) {
            e = e3;
            MFLogger.m12670d(TAG, "IO Exception - e=" + e);
        } catch (Exception e4) {
            MFLogger.m12670d(TAG, "Exception - ex=" + e4);
        }
        abr().onError(null);
    }
}
