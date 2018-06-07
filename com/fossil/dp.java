package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
class dp extends dq {
    dp(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    public static dp m9315d(ViewGroup viewGroup) {
        return (dp) dq.m9314D(viewGroup);
    }

    public void add(View view) {
        this.GV.add(view);
    }

    public void remove(View view) {
        this.GV.remove(view);
    }
}
