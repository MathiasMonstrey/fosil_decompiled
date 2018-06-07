package com.fossil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;

@TargetApi(11)
public class zp extends Fragment {
    private final zg aFF;
    private final zr aFG;
    private tz aFH;
    private final HashSet<zp> aFI;
    private zp aFJ;

    class C4242a implements zr {
        final /* synthetic */ zp aFK;

        private C4242a(zp zpVar) {
            this.aFK = zpVar;
        }
    }

    public zp() {
        this(new zg());
    }

    @SuppressLint({"ValidFragment"})
    zp(zg zgVar) {
        this.aFG = new C4242a();
        this.aFI = new HashSet();
        this.aFF = zgVar;
    }

    public void m14159g(tz tzVar) {
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

    private void m14157a(zp zpVar) {
        this.aFI.add(zpVar);
    }

    private void m14158b(zp zpVar) {
        this.aFI.remove(zpVar);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.aFJ = zq.wm().m14163a(getActivity().getFragmentManager());
            if (this.aFJ != this) {
                this.aFJ.m14157a(this);
            }
        } catch (Throwable e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        if (this.aFJ != null) {
            this.aFJ.m14158b(this);
            this.aFJ = null;
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

    public void onTrimMemory(int i) {
        if (this.aFH != null) {
            this.aFH.onTrimMemory(i);
        }
    }

    public void onLowMemory() {
        if (this.aFH != null) {
            this.aFH.onLowMemory();
        }
    }
}
