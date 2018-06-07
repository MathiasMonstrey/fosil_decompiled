package com.fossil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.fossil.evb.C2096a;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.util.List;
import java.util.Map;

public abstract class ctm extends Fragment implements OnKeyListener, C2096a {
    private final String TAG = "BaseFragment";
    protected cmj cEE;
    protected C2160d cEN = new ckn(this);

    public void afT() {
        MFLogger.m12670d("BaseFragment", "showProgressDialog");
        if (isActive() && getActivity() != null) {
            ((ctj) getActivity()).afL();
        }
    }

    public void afU() {
        MFLogger.m12670d("BaseFragment", "hideProgressDialog");
        if (getActivity() != null) {
            ((ctj) getActivity()).afM();
        }
    }

    public boolean isActive() {
        return isAdded();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cEE = cmj.bs(PortfolioApp.ZQ());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOnKeyListener(this);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    public void m7516b(Fragment fragment, String str, int i) {
        fa childFragmentManager = getChildFragmentManager();
        fg hW = childFragmentManager.hW();
        Fragment aF = childFragmentManager.aF(i);
        if (aF != null) {
            hW.mo2967a(aF);
        }
        hW.mo2964T(null);
        hW.mo2970b(i, fragment, str);
        hW.commitAllowingStateLoss();
    }

    public void m7517c(Fragment fragment, String str, int i) {
        fa childFragmentManager = getChildFragmentManager();
        fg hW = childFragmentManager.hW();
        Fragment aF = childFragmentManager.aF(i);
        if (aF != null) {
            hW.mo2967a(aF);
        }
        hW.mo2964T(null);
        hW.mo2970b(i, fragment, str);
        hW.commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        evb.m11254a(i, strArr, iArr, this);
    }

    public void mo1745a(int i, List<String> list) {
        for (String str : list) {
            MFLogger.m12670d("BaseFragment", "onPermissionsGranted: perm = " + str);
        }
    }

    public void mo1747b(int i, List<String> list) {
        for (String str : list) {
            MFLogger.m12670d("BaseFragment", "onPermissionsDenied: perm = " + str);
        }
    }

    public String getTAG() {
        return "BaseFragment";
    }

    protected boolean lM() {
        return false;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        MFLogger.m12670d("BaseFragment", "onKey KEYCODE_BACK");
        return lM();
    }

    protected void hB(String str) {
        this.cEE.logEvent(str);
    }

    protected void m7519n(String str, String str2, String str3) {
        this.cEE.m7086l(str, str2, str3);
    }

    protected void m7518f(String str, Map<String, String> map) {
        this.cEE.m7085e(str, map);
    }
}
