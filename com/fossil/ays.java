package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.LinkedList;

public abstract class ays<T extends ayr> {
    private T bjD;
    private Bundle bjE;
    private LinkedList<aza> bjF;
    private final azd<T> bjG = new ayt(this);

    private final void m4708a(Bundle bundle, aza com_fossil_aza) {
        if (this.bjD != null) {
            com_fossil_aza.mo1220b(this.bjD);
            return;
        }
        if (this.bjF == null) {
            this.bjF = new LinkedList();
        }
        this.bjF.add(com_fossil_aza);
        if (bundle != null) {
            if (this.bjE == null) {
                this.bjE = (Bundle) bundle.clone();
            } else {
                this.bjE.putAll(bundle);
            }
        }
        m4712a(this.bjG);
    }

    private final void hD(int i) {
        while (!this.bjF.isEmpty() && ((aza) this.bjF.getLast()).getState() >= i) {
            this.bjF.removeLast();
        }
    }

    public final T LQ() {
        return this.bjD;
    }

    public final void m4710a(Activity activity, Bundle bundle, Bundle bundle2) {
        m4708a(bundle2, new ayu(this, activity, bundle, bundle2));
    }

    protected void m4711a(FrameLayout frameLayout) {
        atp Ku = atp.Ku();
        Context context = frameLayout.getContext();
        int aj = Ku.aj(context);
        CharSequence y = axa.m4672y(context, aj);
        CharSequence A = axa.m4667A(context, aj);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(y);
        linearLayout.addView(textView);
        Intent b = aye.m4436b(context, aj, null);
        if (b != null) {
            View button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(A);
            linearLayout.addView(button);
            button.setOnClickListener(new ayx(context, b));
        }
    }

    public abstract void m4712a(azd<T> com_fossil_azd_T);

    public final void onCreate(Bundle bundle) {
        m4708a(bundle, new ayv(this, bundle));
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m4708a(bundle, new ayw(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.bjD == null) {
            m4711a(frameLayout);
        }
        return frameLayout;
    }

    public final void onDestroy() {
        if (this.bjD != null) {
            this.bjD.onDestroy();
        } else {
            hD(1);
        }
    }

    public final void onDestroyView() {
        if (this.bjD != null) {
            this.bjD.onDestroyView();
        } else {
            hD(2);
        }
    }

    public final void onLowMemory() {
        if (this.bjD != null) {
            this.bjD.onLowMemory();
        }
    }

    public final void onPause() {
        if (this.bjD != null) {
            this.bjD.onPause();
        } else {
            hD(5);
        }
    }

    public final void onResume() {
        m4708a(null, new ayz(this));
    }

    public final void onSaveInstanceState(Bundle bundle) {
        if (this.bjD != null) {
            this.bjD.onSaveInstanceState(bundle);
        } else if (this.bjE != null) {
            bundle.putAll(this.bjE);
        }
    }

    public final void onStart() {
        m4708a(null, new ayy(this));
    }

    public final void onStop() {
        if (this.bjD != null) {
            this.bjD.onStop();
        } else {
            hD(4);
        }
    }
}
