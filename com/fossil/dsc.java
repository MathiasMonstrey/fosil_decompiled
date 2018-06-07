package com.fossil;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.misfit.frameworks.common.log.MFLogger;
import java.util.List;

public class dsc extends C1234a<C1264v> {
    private static final String TAG = dsc.class.getSimpleName();
    private final fa JV;
    private final List<Fragment> doR;
    private int[] doS;

    public dsc(fa faVar, List<Fragment> list) {
        this.JV = faVar;
        this.doR = list;
    }

    public C1264v mo1090c(ViewGroup viewGroup, int i) {
        View frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        return new C1264v(this, frameLayout) {
            final /* synthetic */ dsc doT;
        };
    }

    public long getItemId(int i) {
        this.doS[i] = ((Fragment) this.doR.get(i)).getId();
        if (this.doS[i] == 0) {
            this.doS[i] = View.generateViewId();
            MFLogger.m12670d(TAG, "getItemId: position = " + i + ", id = " + this.doS[i]);
        }
        return (long) this.doS[i];
    }

    public void mo1089a(final C1264v c1264v, int i) {
        MFLogger.m12670d(TAG, "onBindViewHolder: position = " + i);
        Fragment aF = this.JV.aF(c1264v.arT.getId());
        if (aF != null) {
            this.JV.hW().mo2967a(aF).commitNowAllowingStateLoss();
        }
        c1264v.arT.setId((int) getItemId(i));
        c1264v.arT.addOnAttachStateChangeListener(new OnAttachStateChangeListener(this) {
            final /* synthetic */ dsc doT;

            public void onViewAttachedToWindow(View view) {
                c1264v.arT.removeOnAttachStateChangeListener(this);
                ctm com_fossil_ctm = (ctm) this.doT.doR.get(c1264v.rm());
                Fragment W = this.doT.JV.mo3086W(com_fossil_ctm.getTAG());
                if (W != null) {
                    this.doT.JV.hW().mo2967a(W).commitNowAllowingStateLoss();
                }
                this.doT.JV.hW().mo2966a(view.getId(), com_fossil_ctm, com_fossil_ctm.getTAG()).commitNowAllowingStateLoss();
            }

            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    public int getItemCount() {
        int size = this.doR.size();
        if (this.doS == null || size != this.doS.length) {
            this.doS = new int[size];
        }
        return size;
    }
}
