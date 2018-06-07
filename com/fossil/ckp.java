package com.fossil;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fossil.C2161i.C3687b;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.view.FlexibleTextView;

public class ckp extends C2161i {
    private static final C3687b cpG = null;
    private static final SparseIntArray cpH = new SparseIntArray();
    public final FlexibleTextView cpC;
    private long cpL = -1;
    public final ImageView cpM;
    private final LinearLayout cpN;
    public final WebView webView;

    static {
        cpH.put(R.id.ivRightButton, 1);
        cpH.put(R.id.ftvTitle, 2);
        cpH.put(R.id.webView, 3);
    }

    public ckp(C2160d c2160d, View view) {
        super(c2160d, view, 0);
        Object[] a = C2161i.m6993a(c2160d, view, 4, cpG, cpH);
        this.cpC = (FlexibleTextView) a[2];
        this.cpM = (ImageView) a[1];
        this.cpN = (LinearLayout) a[0];
        this.cpN.setTag(null);
        this.webView = (WebView) a[3];
        m7001a(view);
        abv();
    }

    public void abv() {
        synchronized (this) {
            this.cpL = 1;
        }
        dA();
    }

    public boolean dy() {
        synchronized (this) {
            if (this.cpL != 0) {
                return true;
            }
            return false;
        }
    }

    protected void dx() {
        synchronized (this) {
            long j = this.cpL;
            this.cpL = 0;
        }
    }

    public static ckp m7005b(View view, C2160d c2160d) {
        if ("layout/activity_webview_0".equals(view.getTag())) {
            return new ckp(c2160d, view);
        }
        throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
}
