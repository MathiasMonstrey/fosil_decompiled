package com.fossil;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import com.fossil.pk.C3985d;
import com.fossil.qq.C3962a;

public class qp {
    private int afC;
    private boolean afJ;
    private C3962a afK;
    private OnDismissListener afM;
    private final int aft;
    private final int afu;
    private final boolean afv;
    private qo ahh;
    private final OnDismissListener ahi;
    private final Context mContext;
    private final qj uh;
    private View yL;

    class C40181 implements OnDismissListener {
        final /* synthetic */ qp ahj;

        C40181(qp qpVar) {
            this.ahj = qpVar;
        }

        public void onDismiss() {
            this.ahj.onDismiss();
        }
    }

    public qp(Context context, qj qjVar, View view, boolean z, int i) {
        this(context, qjVar, view, z, i, 0);
    }

    public qp(Context context, qj qjVar, View view, boolean z, int i, int i2) {
        this.afC = 8388611;
        this.ahi = new C40181(this);
        this.mContext = context;
        this.uh = qjVar;
        this.yL = view;
        this.afv = z;
        this.aft = i;
        this.afu = i2;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.afM = onDismissListener;
    }

    public void setAnchorView(View view) {
        this.yL = view;
    }

    public void setForceShowIcon(boolean z) {
        this.afJ = z;
        if (this.ahh != null) {
            this.ahh.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.afC = i;
    }

    public void show() {
        if (!nt()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public qo ns() {
        if (this.ahh == null) {
            this.ahh = nu();
        }
        return this.ahh;
    }

    public boolean nt() {
        if (isShowing()) {
            return true;
        }
        if (this.yL == null) {
            return false;
        }
        m13203a(0, 0, false, false);
        return true;
    }

    public boolean m13204Q(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.yL == null) {
            return false;
        }
        m13203a(i, i2, true, true);
        return true;
    }

    private qo nu() {
        qo qgVar;
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        if ((Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(C3985d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null) {
            qgVar = new qg(this.mContext, this.yL, this.aft, this.afu, this.afv);
        } else {
            qgVar = new qv(this.mContext, this.uh, this.yL, this.aft, this.afu, this.afv);
        }
        qgVar.mo4031f(this.uh);
        qgVar.setOnDismissListener(this.ahi);
        qgVar.setAnchorView(this.yL);
        qgVar.mo4020a(this.afK);
        qgVar.setForceShowIcon(this.afJ);
        qgVar.setGravity(this.afC);
        return qgVar;
    }

    private void m13203a(int i, int i2, boolean z, boolean z2) {
        qo ns = ns();
        ns.mo4029Y(z2);
        if (z) {
            if ((ke.getAbsoluteGravity(this.afC, li.S(this.yL)) & 7) == 5) {
                i -= this.yL.getWidth();
            }
            ns.setHorizontalOffset(i);
            ns.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            ns.m13149h(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        ns.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.ahh.dismiss();
        }
    }

    protected void onDismiss() {
        this.ahh = null;
        if (this.afM != null) {
            this.afM.onDismiss();
        }
    }

    public boolean isShowing() {
        return this.ahh != null && this.ahh.isShowing();
    }

    public void m13205c(C3962a c3962a) {
        this.afK = c3962a;
        if (this.ahh != null) {
            this.ahh.mo4020a(c3962a);
        }
    }
}
