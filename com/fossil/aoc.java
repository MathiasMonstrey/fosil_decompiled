package com.fossil;

import com.fossil.wearables.fsl.location.DeviceLocation;
import com.misfit.frameworks.common.constants.Constants;
import com.portfolio.platform.data.model.microapp.MicroApp;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoc implements aqi<anh> {
    private static final String aWB = aoc.class.getSimpleName();

    public final /* synthetic */ void mo1105a(OutputStream outputStream, Object obj) throws IOException {
        anh com_fossil_anh = (anh) obj;
        if (outputStream != null && com_fossil_anh != null) {
            DataOutputStream c17581 = new DataOutputStream(this, outputStream) {
                final /* synthetic */ aoc aYU;

                public final void close() {
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                Object obj2;
                m4072a(jSONObject, "project_key", com_fossil_anh.aWB);
                m4072a(jSONObject, "bundle_id", com_fossil_anh.aWR);
                m4072a(jSONObject, Constants.APP_VERSION, com_fossil_anh.aWS);
                jSONObject.put("sdk_version", com_fossil_anh.f1386d);
                jSONObject.put(MicroApp.COLUMN_PLATFORM, com_fossil_anh.f1387e);
                m4072a(jSONObject, "platform_version", com_fossil_anh.aXl);
                jSONObject.put("limit_ad_tracking", com_fossil_anh.aWF);
                if (com_fossil_anh.aXr == null || com_fossil_anh.aXr.aXA == null) {
                    obj2 = null;
                } else {
                    obj2 = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    m4072a(jSONObject2, "model", com_fossil_anh.aXr.aXA.aWB);
                    m4072a(jSONObject2, Constants.PROFILE_KEY_BRAND, com_fossil_anh.aXr.aXA.aWR);
                    m4072a(jSONObject2, "id", com_fossil_anh.aXr.aXA.aWS);
                    m4072a(jSONObject2, Constants.DEVICE, com_fossil_anh.aXr.aXA.f1380d);
                    m4072a(jSONObject2, "product", com_fossil_anh.aXr.aXA.aWX);
                    m4072a(jSONObject2, "version_release", com_fossil_anh.aXr.aXA.aXl);
                    obj2.put("com.flurry.proton.generated.avro.v2.AndroidTags", jSONObject2);
                }
                if (obj2 != null) {
                    jSONObject.put("device_tags", obj2);
                } else {
                    jSONObject.put("device_tags", JSONObject.NULL);
                }
                JSONArray jSONArray = new JSONArray();
                for (anj com_fossil_anj : com_fossil_anh.aXs) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", com_fossil_anj.f1388a);
                    m4072a(jSONObject3, "id", com_fossil_anj.aWR);
                    jSONArray.put(jSONObject3);
                }
                jSONObject.put("device_ids", jSONArray);
                if (com_fossil_anh.aXt == null || com_fossil_anh.aXt.aXG == null) {
                    obj2 = null;
                } else {
                    obj2 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt(DeviceLocation.COLUMN_LATITUDE, Double.valueOf(com_fossil_anh.aXt.aXG.aXD));
                    jSONObject4.putOpt(DeviceLocation.COLUMN_LONGITUDE, Double.valueOf(com_fossil_anh.aXt.aXG.aXE));
                    jSONObject4.putOpt("accuracy", Float.valueOf(com_fossil_anh.aXt.aXG.aXF));
                    obj2.put("com.flurry.proton.generated.avro.v2.Geolocation", jSONObject4);
                }
                if (obj2 != null) {
                    jSONObject.put("geo", obj2);
                } else {
                    jSONObject.put("geo", JSONObject.NULL);
                }
                JSONObject jSONObject5 = new JSONObject();
                if (com_fossil_anh.aXu != null) {
                    m4072a(jSONObject5, "string", com_fossil_anh.aXu.aWB);
                    jSONObject.put("publisher_user_id", jSONObject5);
                } else {
                    jSONObject.put("publisher_user_id", JSONObject.NULL);
                }
                app.m4180g(5, aWB, "Proton Request String: " + jSONObject.toString());
                c17581.write(jSONObject.toString().getBytes());
                c17581.flush();
                c17581.close();
            } catch (Throwable e) {
                throw new IOException("Invalid Json", e);
            } catch (Throwable th) {
                c17581.close();
            }
        }
    }

    private static void m4072a(JSONObject jSONObject, String str, String str2) throws IOException, JSONException {
        if (str2 != null) {
            jSONObject.put(str, str2);
        } else {
            jSONObject.put(str, JSONObject.NULL);
        }
    }

    public final /* synthetic */ Object mo1106j(InputStream inputStream) throws IOException {
        throw new IOException("Deserialize not supported for request");
    }
}
