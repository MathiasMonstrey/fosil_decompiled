package com.fossil;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MusicObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.component.BrowserLauncher;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class dtd extends dtb {
    private String dqW;
    private String dqh;
    private dsp dqr;
    private String dre;
    private String drf;
    private String drg;
    private dsm drh;
    private String dri;
    private byte[] drj;

    public static class C3183a {
        private int drk = -2;
        private String drl;

        private C3183a() {
        }

        public int getCode() {
            return this.drk;
        }

        public String awW() {
            return this.drl;
        }

        public static C3183a jI(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C3183a c3183a = new C3183a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c3183a.drk = jSONObject.optInt("code", -2);
                c3183a.drl = jSONObject.optString("data", "");
                return c3183a;
            } catch (JSONException e) {
                return c3183a;
            }
        }
    }

    public dtd(Context context) {
        super(context);
        this.drc = BrowserLauncher.SHARE;
    }

    protected void mo2683L(Bundle bundle) {
        this.dqh = bundle.getString("source");
        this.drf = bundle.getString("packagename");
        this.drg = bundle.getString("key_hash");
        this.dre = bundle.getString("access_token");
        this.dqW = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.dqW)) {
            this.dqr = dtf.cL(this.mContext).jJ(this.dqW);
        }
        m9682O(bundle);
        this.cxk = jH("");
    }

    private void m9682O(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.toObject(bundle);
        StringBuilder stringBuilder = new StringBuilder();
        if (weiboMultiMessage.textObject instanceof TextObject) {
            stringBuilder.append(weiboMultiMessage.textObject.text);
        }
        if (weiboMultiMessage.imageObject instanceof ImageObject) {
            ImageObject imageObject = weiboMultiMessage.imageObject;
            m9684g(imageObject.imagePath, imageObject.imageData);
        }
        if (weiboMultiMessage.mediaObject instanceof TextObject) {
            stringBuilder.append(((TextObject) weiboMultiMessage.mediaObject).text);
        }
        if (weiboMultiMessage.mediaObject instanceof ImageObject) {
            imageObject = (ImageObject) weiboMultiMessage.mediaObject;
            m9684g(imageObject.imagePath, imageObject.imageData);
        }
        if (weiboMultiMessage.mediaObject instanceof WebpageObject) {
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(((WebpageObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        if (weiboMultiMessage.mediaObject instanceof MusicObject) {
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(((MusicObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        if (weiboMultiMessage.mediaObject instanceof VideoObject) {
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(((VideoObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        if (weiboMultiMessage.mediaObject instanceof VoiceObject) {
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(((VoiceObject) weiboMultiMessage.mediaObject).actionUrl);
        }
        this.dri = stringBuilder.toString();
    }

    private void m9684g(String str, byte[] bArr) {
        Throwable th;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[((int) file.length())];
                    FileInputStream fileInputStream = null;
                    FileInputStream fileInputStream2;
                    try {
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            fileInputStream2.read(bArr2);
                            this.drj = dui.ap(bArr2);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            return;
                        } catch (IOException e2) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            if (bArr != null) {
                            }
                            return;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            fileInputStream = fileInputStream2;
                            th = th3;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (bArr != null) {
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (SecurityException e6) {
        }
        if (bArr != null && bArr.length > 0) {
            this.drj = dui.ap(bArr);
        }
    }

    public void mo2684M(Bundle bundle) {
        if (this.drh != null) {
            this.drh.m9623o(bundle);
        }
        if (!TextUtils.isEmpty(this.drf)) {
            this.drg = duk.kn(duq.m9791T(this.mContext, this.drf));
        }
        bundle.putString("access_token", this.dre);
        bundle.putString("source", this.dqh);
        bundle.putString("packagename", this.drf);
        bundle.putString("key_hash", this.drg);
        bundle.putString("_weibo_appPackage", this.drf);
        bundle.putString("_weibo_appKey", this.dqh);
        bundle.putInt("_weibo_flag", 538116905);
        bundle.putString("_weibo_sign", this.drg);
        if (this.dqr != null) {
            dtf cL = dtf.cL(this.mContext);
            this.dqW = cL.awX();
            cL.m9692a(this.dqW, this.dqr);
            bundle.putString("key_listener", this.dqW);
        }
    }

    public void mo2685d(Activity activity, int i) {
        if (i == 3) {
            m9685A(activity);
            dth.m9698a(activity, this.dqW, null);
        }
    }

    public boolean awV() {
        if (this.drj == null || this.drj.length <= 0) {
            return false;
        }
        return true;
    }

    public dtq m9689a(dtq com_fossil_dtq) {
        if (awV()) {
            com_fossil_dtq.put("img", new String(this.drj));
        }
        return com_fossil_dtq;
    }

    public String jH(String str) {
        Builder buildUpon = Uri.parse("http://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.dri);
        buildUpon.appendQueryParameter("version", "0031405000");
        if (!TextUtils.isEmpty(this.dqh)) {
            buildUpon.appendQueryParameter("source", this.dqh);
        }
        if (!TextUtils.isEmpty(this.dre)) {
            buildUpon.appendQueryParameter("access_token", this.dre);
        }
        Object U = duq.m9792U(this.mContext, this.dqh);
        if (!TextUtils.isEmpty(U)) {
            buildUpon.appendQueryParameter("aid", U);
        }
        if (!TextUtils.isEmpty(this.drf)) {
            buildUpon.appendQueryParameter("packagename", this.drf);
        }
        if (!TextUtils.isEmpty(this.drg)) {
            buildUpon.appendQueryParameter("key_hash", this.drg);
        }
        if (!TextUtils.isEmpty(str)) {
            buildUpon.appendQueryParameter("picinfo", str);
        }
        return buildUpon.build().toString();
    }

    private void m9683a(Activity activity, int i, String str) {
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
            intent.setFlags(131072);
            intent.setPackage(extras.getString("_weibo_appPackage"));
            intent.putExtras(extras);
            intent.putExtra("_weibo_appPackage", activity.getPackageName());
            intent.putExtra("_weibo_resp_errcode", i);
            intent.putExtra("_weibo_resp_errstr", str);
            try {
                activity.startActivityForResult(intent, 765);
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    public void m9685A(Activity activity) {
        m9683a(activity, 1, "send cancel!!!");
    }

    public void m9686B(Activity activity) {
        m9683a(activity, 0, "send ok!!!");
    }

    public void m9690b(Activity activity, String str) {
        m9683a(activity, 2, str);
    }

    public String awy() {
        return this.dqh;
    }

    public dsp awQ() {
        return this.dqr;
    }

    public String awR() {
        return this.dqW;
    }
}
