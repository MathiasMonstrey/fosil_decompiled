package com.fossil;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import com.fossil.evb.C2096a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.List;

public abstract class ctl extends ev implements OnKeyListener, C2096a {
    private final String TAG = getClass().getSimpleName();
    protected cmj cEE;
    protected C2160d cEN = new ckn(this);

    public boolean isActive() {
        return isAdded();
    }

    public void setupDialog(Dialog dialog, int i) {
        dialog.requestWindowFeature(1);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
            dialog.getWindow().setLayout(-1, -1);
            dialog.getWindow().getDecorView().setSystemUiVisibility(3328);
            dialog.setOnKeyListener(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.AppTheme);
        this.cEE = cmj.bs(PortfolioApp.ZQ());
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        evb.m11254a(i, strArr, iArr, this);
    }

    public void mo1745a(int i, List<String> list) {
        for (String str : list) {
            MFLogger.m12670d(this.TAG, "onPermissionsGranted: perm = " + str);
        }
    }

    public void mo1747b(int i, List<String> list) {
        for (String str : list) {
            MFLogger.m12670d(this.TAG, "onPermissionsDenied: perm = " + str);
        }
    }

    protected boolean lM() {
        dismiss();
        return true;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        MFLogger.m12670d(this.TAG, "onKey KEYCODE_BACK");
        return lM();
    }

    protected void m7513n(String str, String str2, String str3) {
        this.cEE.m7086l(str, str2, str3);
    }

    public void show(fa faVar, String str) {
        if (!isAdded()) {
            fg hW = faVar.hW();
            Fragment W = faVar.mo3086W(str);
            if (W != null) {
                hW.mo2967a(W);
            }
            hW.mo2964T(null).mo2968a((Fragment) this, str).commitAllowingStateLoss();
            faVar.executePendingTransactions();
        }
    }

    public void dismiss() {
        if (getFragmentManager() != null) {
            getFragmentManager().hW().mo2967a(this).commitAllowingStateLoss();
        }
    }
}
