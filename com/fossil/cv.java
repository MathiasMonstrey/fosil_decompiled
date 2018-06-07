package com.fossil;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.ct.C2284a;

@TargetApi(14)
final class cv {
    Runnable Ga;
    private ViewGroup Gb;

    static void m7615a(View view, cv cvVar) {
        view.setTag(C2284a.transition_current_scene, cvVar);
    }

    static cv m7616z(View view) {
        return (cv) view.getTag(C2284a.transition_current_scene);
    }

    public void exit() {
        if (m7616z(this.Gb) == this && this.Ga != null) {
            this.Ga.run();
        }
    }
}
