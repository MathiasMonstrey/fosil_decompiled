package com.fossil;

import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.portfolio.platform.PortfolioApp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class cmg implements xe<cmb> {
    public /* synthetic */ us m7074c(Object obj, int i, int i2) {
        return m7073a((cmb) obj, i, i2);
    }

    public us<InputStream> m7073a(final cmb com_fossil_cmb, final int i, final int i2) {
        return new us<InputStream>(this) {
            private us<InputStream> aBo;
            final /* synthetic */ cmg cxr;

            class C21901 implements xe<String> {
                final /* synthetic */ C21921 cxs;

                C21901(C21921 c21921) {
                    this.cxs = c21921;
                }

                public /* synthetic */ us m7068c(Object obj, int i, int i2) {
                    return m7067b((String) obj, i, i2);
                }

                public us<InputStream> m7067b(String str, int i, int i2) {
                    return new uv(new wh(str));
                }
            }

            class C21912 implements xe<Uri> {
                final /* synthetic */ C21921 cxs;

                C21912(C21921 c21921) {
                    this.cxs = c21921;
                }

                public /* synthetic */ us m7070c(Object obj, int i, int i2) {
                    return m7069a((Uri) obj, i, i2);
                }

                public us<InputStream> m7069a(Uri uri, int i, int i2) {
                    return new uy(PortfolioApp.ZQ(), uri);
                }
            }

            public /* synthetic */ Object m7071d(Priority priority) throws Exception {
                return m7072e(priority);
            }

            public InputStream m7072e(Priority priority) throws Exception {
                try {
                    if (!TextUtils.isEmpty(com_fossil_cmb.getUrl())) {
                        this.aBo = new C21901(this).m7067b(com_fossil_cmb.getUrl(), i, i2);
                    } else if (com_fossil_cmb.getUri() != null) {
                        this.aBo = new C21912(this).m7069a(com_fossil_cmb.getUri(), i, i2);
                    }
                    if (this.aBo != null) {
                        return (InputStream) this.aBo.d(priority);
                    }
                } catch (Exception e) {
                    if (this.aBo != null) {
                        this.aBo.lG();
                    }
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                dqq.jk(com_fossil_cmb.getName()).compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }

            public void lG() {
                if (this.aBo != null) {
                    this.aBo.lG();
                }
            }

            public String getId() {
                return com_fossil_cmb.getUrl() + com_fossil_cmb.getUri() + com_fossil_cmb.getName();
            }

            public void cancel() {
                if (this.aBo != null) {
                    this.aBo.cancel();
                }
            }
        };
    }
}
