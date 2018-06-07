package com.fossil;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.portfolio.platform.PortfolioApp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class cmf implements xe<cma> {
    public /* synthetic */ us m7066c(Object obj, int i, int i2) {
        return m7065a((cma) obj, i, i2);
    }

    public us<InputStream> m7065a(final cma com_fossil_cma, int i, int i2) {
        return new us<InputStream>(this) {
            final /* synthetic */ cmf cxn;

            public /* synthetic */ Object m7063d(Priority priority) throws Exception {
                return m7064e(priority);
            }

            public InputStream m7064e(Priority priority) throws Exception {
                Drawable applicationIcon = PortfolioApp.ZQ().getPackageManager().getApplicationIcon(com_fossil_cma.aby().getIdentifier());
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                dqq.m9393A(applicationIcon).compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }

            public void lG() {
            }

            public String getId() {
                return com_fossil_cma.aby().getIdentifier();
            }

            public void cancel() {
            }
        };
    }
}
