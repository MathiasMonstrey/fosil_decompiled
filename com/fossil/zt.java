package com.fossil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;
import java.util.HashSet;

public class zt extends Fragment {
    private final zg aFF;
    private final zr aFG;
    private tz aFH;
    private final HashSet<zt> aFI;
    private zt aFS;

    class C4244a implements zr {
        final /* synthetic */ zt aFT;

        private C4244a(zt ztVar) {
            this.aFT = ztVar;
        }
    }

    public zt() {
        this(new zg());
    }

    @SuppressLint({"ValidFragment"})
    public zt(zg zgVar) {
        this.aFG = new C4244a();
        this.aFI = new HashSet();
        this.aFF = zgVar;
    }

    public void m14174g(tz tzVar) {
        this.aFH = tzVar;
    }

    zg wj() {
        return this.aFF;
    }

    public tz wk() {
        return this.aFH;
    }

    public zr wl() {
        return this.aFG;
    }

    private void m14172a(zt ztVar) {
        this.aFI.add(ztVar);
    }

    private void m14173b(zt ztVar) {
        this.aFI.remove(ztVar);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.aFS = zq.wm().m14164a(getActivity().getSupportFragmentManager());
            if (this.aFS != this) {
                this.aFS.m14172a(this);
            }
        } catch (Throwable e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        if (this.aFS != null) {
            this.aFS.m14173b(this);
            this.aFS = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.aFF.onStart();
    }

    public void onStop() {
        super.onStop();
        this.aFF.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.aFF.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.aFH != null) {
            this.aFH.onLowMemory();
        }
    }
}
