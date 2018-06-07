package com.fossil;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class oe extends nk {
    private int Ye;
    private int Yf;
    private LayoutInflater Yg;

    @Deprecated
    public oe(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.Yf = i;
        this.Ye = i;
        this.Yg = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.Yg.inflate(this.Ye, viewGroup, false);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.Yg.inflate(this.Yf, viewGroup, false);
    }
}
