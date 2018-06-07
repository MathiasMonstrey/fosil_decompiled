package com.fossil;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController;
import android.support.v7.app.AlertController.a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.fossil.pk.C3982a;

public class os extends pc implements DialogInterface {
    final AlertController abc = new AlertController(getContext(), this, getWindow());

    public static class C3944a {
        private final a abd;
        private final int mTheme;

        public C3944a(Context context) {
            this(context, os.m12948h(context, 0));
        }

        public C3944a(Context context, int i) {
            this.abd = new a(new ContextThemeWrapper(context, os.m12948h(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.abd.mContext;
        }

        public C3944a m12941l(CharSequence charSequence) {
            this.abd.Od = charSequence;
            return this;
        }

        public C3944a bl(View view) {
            this.abd.aal = view;
            return this;
        }

        public C3944a m12943m(CharSequence charSequence) {
            this.abd.ZR = charSequence;
            return this;
        }

        public C3944a m12942m(Drawable drawable) {
            this.abd.AN = drawable;
            return this;
        }

        public C3944a m12939a(CharSequence charSequence, OnClickListener onClickListener) {
            this.abd.aaB = charSequence;
            this.abd.aaC = onClickListener;
            return this;
        }

        public C3944a m12940b(CharSequence charSequence, OnClickListener onClickListener) {
            this.abd.aaD = charSequence;
            this.abd.aaE = onClickListener;
            return this;
        }

        public C3944a m12936R(boolean z) {
            this.abd.mCancelable = z;
            return this;
        }

        public C3944a m12937a(OnKeyListener onKeyListener) {
            this.abd.aaJ = onKeyListener;
            return this;
        }

        public C3944a m12938a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.abd.aam = listAdapter;
            this.abd.aaL = onClickListener;
            return this;
        }

        public C3944a bm(View view) {
            this.abd.mView = view;
            this.abd.ZT = 0;
            this.abd.ZY = false;
            return this;
        }

        public os ln() {
            os osVar = new os(this.abd.mContext, this.mTheme);
            this.abd.a(osVar.abc);
            osVar.setCancelable(this.abd.mCancelable);
            if (this.abd.mCancelable) {
                osVar.setCanceledOnTouchOutside(true);
            }
            osVar.setOnCancelListener(this.abd.aaH);
            osVar.setOnDismissListener(this.abd.aaI);
            if (this.abd.aaJ != null) {
                osVar.setOnKeyListener(this.abd.aaJ);
            }
            return osVar;
        }

        public os lo() {
            os ln = ln();
            ln.show();
            return ln;
        }
    }

    protected os(Context context, int i) {
        super(context, m12948h(context, i));
    }

    static int m12948h(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C3982a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.abc.setTitle(charSequence);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.abc.lk();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.abc.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.abc.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
