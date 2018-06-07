package com.fossil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.FlexibleTextView;

class dsg {
    private static final String TAG = dsg.class.getSimpleName();
    private final View adu;
    private final FrameLayout dpH;
    private final View dpI;
    private final FlexibleTextView dpJ;
    private final FlexibleTextView dpK;
    private final LayoutParams dpL = new LayoutParams();
    private final Rect dpM = new Rect();
    private final int[] dpN = new int[2];
    private final int[] dpO = new int[2];
    private final int dpP;
    private final int dpQ;
    private final int dpR;
    private int dpv = 1;
    private int dpw = 80;
    private int dpx = 3;
    private final Context mContext;
    private int sa = 0;

    class C31713 implements OnKeyListener {
        final /* synthetic */ dsg dpT;

        C31713(dsg com_fossil_dsg) {
            this.dpT = com_fossil_dsg;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            this.dpT.hide();
            return true;
        }
    }

    @SuppressLint({"InflateParams"})
    dsg(Context context) {
        this.mContext = context;
        this.dpH = new FrameLayout(this.mContext);
        this.adu = LayoutInflater.from(this.mContext).inflate(R.layout.tooltip_popup, null);
        this.dpI = LayoutInflater.from(this.mContext).inflate(R.layout.tooltip_arrow, null);
        this.dpJ = (FlexibleTextView) this.adu.findViewById(R.id.ftv_content);
        this.dpK = (FlexibleTextView) this.adu.findViewById(R.id.ftv_ok);
        Resources resources = this.adu.getResources();
        this.dpP = resources.getDimensionPixelSize(R.dimen.dp5);
        this.dpQ = resources.getDimensionPixelSize(R.dimen.dp14);
        this.dpR = resources.getDimensionPixelSize(R.dimen.dp18);
        this.dpL.setTitle(getClass().getSimpleName());
        this.dpL.packageName = this.mContext.getPackageName();
        this.dpL.type = 1002;
        this.dpL.width = -1;
        this.dpL.height = -2;
        this.dpL.format = -3;
    }

    void mn(int i) {
        if (i != -1) {
            this.dpJ.setText(arp.m4318u(this.mContext, i));
        }
    }

    void setContent(String str) {
        if (str != null) {
            this.dpJ.setText(str);
        }
    }

    void mo(int i) {
        this.sa = i;
    }

    void m9617b(int i, final OnClickListener onClickListener) {
        this.dpK.setText(arp.m4318u(this.mContext, i));
        this.dpK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ dsg dpT;

            public void onClick(View view) {
                this.dpT.hide();
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    void mp(int i) {
        this.dpv = i;
    }

    void mq(int i) {
        this.dpw = i;
    }

    void mr(int i) {
        this.dpx = i;
    }

    void db(View view) {
        if (isShowing()) {
            hide();
        }
        final WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mContext.getResources().getDimensionPixelSize(R.dimen.dp28), this.mContext.getResources().getDimensionPixelSize(R.dimen.dp28));
            final FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            final View view2 = view;
            view.post(new Runnable(this) {
                final /* synthetic */ dsg dpT;

                public void run() {
                    this.dpT.m9612a(view2, this.dpT.dpL, layoutParams2, layoutParams);
                    this.dpT.dpH.addView(this.dpT.adu, layoutParams2);
                    this.dpT.dpH.addView(this.dpT.dpI, layoutParams);
                    windowManager.addView(this.dpT.dpH, this.dpT.dpL);
                    this.dpT.dpH.setFocusableInTouchMode(true);
                    this.dpT.dpH.requestFocus();
                }
            });
            this.dpH.setOnKeyListener(new C31713(this));
        }
    }

    void hide() {
        if (isShowing()) {
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null) {
                this.dpH.removeAllViews();
                windowManager.removeView(this.dpH);
                this.adu.setOnKeyListener(null);
            }
        }
    }

    private boolean isShowing() {
        return this.dpH.getParent() != null;
    }

    @SuppressLint({"RtlHardcoded"})
    private void m9612a(View view, LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, FrameLayout.LayoutParams layoutParams3) {
        int width = view.getWidth() / 2;
        layoutParams.gravity = 48;
        layoutParams2.gravity = this.dpv;
        View dc = dc(view);
        if (dc == null) {
            Log.e(TAG, "Cannot find app view");
            return;
        }
        int identifier;
        dc.getWindowVisibleDisplayFrame(this.dpM);
        if (this.dpM.left < 0 && this.dpM.top < 0) {
            Resources resources = PortfolioApp.ZQ().getResources();
            identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                identifier = resources.getDimensionPixelSize(identifier);
            } else {
                identifier = 0;
            }
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.dpM.set(0, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        dc.getLocationOnScreen(this.dpO);
        view.getLocationOnScreen(this.dpN);
        int[] iArr = this.dpN;
        iArr[0] = iArr[0] - this.dpO[0];
        iArr = this.dpN;
        iArr[1] = iArr[1] - this.dpO[1];
        identifier = MeasureSpec.makeMeasureSpec(0, 0);
        this.adu.measure(identifier, identifier);
        identifier = this.adu.getMeasuredHeight();
        int i = this.dpN[1];
        int height = view.getHeight() + i;
        if (this.dpw == 80) {
            if (this.dpx == 3) {
                layoutParams2.setMargins(this.dpQ, this.dpR, this.dpQ, this.dpP);
                layoutParams3.gravity = 51;
                layoutParams.y = this.sa + height;
            } else {
                layoutParams2.setMargins(this.dpQ, this.dpP, this.dpQ, this.dpR);
                layoutParams3.gravity = 83;
                layoutParams.y = (height - identifier) - this.sa;
            }
        } else if (this.dpx == 3) {
            layoutParams2.setMargins(this.dpQ, this.dpR, this.dpQ, this.dpP);
            layoutParams3.gravity = 51;
            layoutParams.y = this.sa + i;
        } else {
            layoutParams2.setMargins(this.dpQ, this.dpP, this.dpQ, this.dpR);
            layoutParams3.gravity = 83;
            layoutParams.y = (i - identifier) - this.sa;
        }
        layoutParams3.setMargins((this.dpN[0] + width) - this.dpQ, this.dpP, 0, this.dpP);
    }

    private static View dc(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return view.getRootView();
    }
}
