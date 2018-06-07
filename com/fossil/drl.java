package com.fossil;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.Map;

public class drl extends at implements OnKeyListener, View.OnKeyListener {
    private cmj cEE;
    private int cGD;
    private int dgs = -1;
    private boolean dgt;
    private boolean dgu;
    private float dgv = 0.3f;
    private OnDismissListener dgw;
    private int mGravity = 80;

    public final int auT() {
        return this.cGD;
    }

    public final void lC(int i) {
        this.cGD = i;
    }

    public final int auU() {
        return this.dgs;
    }

    public boolean isActive() {
        return isAdded();
    }

    public final void afT() {
        if (isActive()) {
            ew activity = getActivity();
            if (!(activity instanceof ctj)) {
                activity = null;
            }
            ctj com_fossil_ctj = (ctj) activity;
            if (com_fossil_ctj != null) {
                com_fossil_ctj.afL();
            }
        }
    }

    public final void afU() {
        ew activity = getActivity();
        if (!(activity instanceof ctj)) {
            activity = null;
        }
        ctj com_fossil_ctj = (ctj) activity;
        if (com_fossil_ctj != null) {
            com_fossil_ctj.afM();
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        Window window;
        if (this.dgt) {
            if (dialog != null) {
                window = dialog.getWindow();
                if (window != null) {
                    window.setDimAmount(0.0f);
                }
            }
        } else if (dialog != null) {
            window = dialog.getWindow();
            if (window != null) {
                window.setDimAmount(this.dgv);
            }
        }
        if (dialog != null) {
            window = dialog.getWindow();
            if (window != null) {
                window.setGravity(this.mGravity);
            }
        }
        if (dialog != null) {
            window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, this.dgs);
            }
        }
        if (dialog != null) {
            window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(R.color.transparent);
            }
        }
        if (this.dgu && dialog != null) {
            window = dialog.getWindow();
            if (window != null) {
                window.setFlags(32, 32);
            }
        }
        if (dialog != null) {
            dialog.setOnKeyListener(this);
        }
    }

    public void onAttach(Context context) {
        esl.m11128j(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof OnDismissListener)) {
            parentFragment = null;
        }
        OnDismissListener onDismissListener = (OnDismissListener) parentFragment;
        if (onDismissListener == null) {
            onDismissListener = (OnDismissListener) (!(context instanceof OnDismissListener) ? null : context);
        }
        this.dgw = onDismissListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cmj bs = cmj.bs(PortfolioApp.ZQ());
        esl.m11127i(bs, "AnalyticsHelper.getInsta…rtfolioApp.getInstance())");
        this.cEE = bs;
    }

    public final void dp(boolean z) {
        this.dgt = z;
    }

    public final int aid() {
        return this.dgs;
    }

    public void lc(int i) {
        this.dgs = i;
    }

    public final void dq(boolean z) {
        this.dgu = z;
    }

    public final void setDimAmount(float f) {
        this.dgv = f;
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        return dialog != null ? dialog.isShowing() : isAdded();
    }

    protected final boolean auV() {
        if (getActivity() == null) {
            return false;
        }
        ew activity = getActivity();
        if (!(activity instanceof ctj) || activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public final void m7626c(Fragment fragment, String str, int i) {
        esl.m11128j(fragment, "fragment");
        esl.m11128j(str, "tag");
        fg hW = getChildFragmentManager().hW();
        Fragment aF = getChildFragmentManager().aF(i);
        if (aF != null) {
            hW.mo2967a(aF);
        }
        hW.mo2964T(null);
        hW.mo2966a(i, fragment, str);
        hW.commitAllowingStateLoss();
        getChildFragmentManager().executePendingTransactions();
    }

    public void show(fa faVar, String str) {
        esl.m11128j(faVar, "fragmentManager");
        esl.m11128j(str, "tag");
        fg hW = faVar.hW();
        Fragment W = faVar.mo3086W(str);
        if (W != null) {
            hW.mo2967a(W);
        }
        hW.mo2964T(null);
        show(hW, str);
        faVar.executePendingTransactions();
    }

    public void dismiss() {
        fa fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fg hW = fragmentManager.hW();
            if (hW != null) {
                hW = hW.mo2967a(this);
                if (hW != null) {
                    hW.commitAllowingStateLoss();
                }
            }
        }
    }

    public boolean lM() {
        dismiss();
        return true;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        MFLogger.m12670d(getClass().getSimpleName(), "onKey KEYCODE_BACK");
        return lM();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        MFLogger.m12670d(getClass().getSimpleName(), "onKey KEYCODE_BACK");
        return lM();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OnDismissListener onDismissListener = this.dgw;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    protected final void hB(String str) {
        esl.m11128j(str, Constants.EVENT);
        cmj com_fossil_cmj = this.cEE;
        if (com_fossil_cmj == null) {
            esl.mF("mAnalyticHelper");
        }
        com_fossil_cmj.logEvent(str);
    }

    protected final void m7628n(String str, String str2, String str3) {
        esl.m11128j(str, Constants.EVENT);
        esl.m11128j(str2, "paramName");
        esl.m11128j(str3, "paramValue");
        cmj com_fossil_cmj = this.cEE;
        if (com_fossil_cmj == null) {
            esl.mF("mAnalyticHelper");
        }
        com_fossil_cmj.m7086l(str, str2, str3);
    }

    protected final void m7627f(String str, Map<String, String> map) {
        esl.m11128j(str, Constants.EVENT);
        esl.m11128j(map, "values");
        cmj com_fossil_cmj = this.cEE;
        if (com_fossil_cmj == null) {
            esl.mF("mAnalyticHelper");
        }
        com_fossil_cmj.m7085e(str, map);
    }
}
