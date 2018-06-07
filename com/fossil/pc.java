package com.fossil;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.fossil.pk.C3982a;
import com.fossil.pu.C3965a;

public class pc extends Dialog implements ou {
    private ov abe;

    public pc(Context context, int i) {
        super(context, m12944b(context, i));
        ls().onCreate(null);
        ls().lu();
    }

    protected void onCreate(Bundle bundle) {
        ls().lt();
        super.onCreate(bundle);
        ls().onCreate(bundle);
    }

    public void setContentView(int i) {
        ls().setContentView(i);
    }

    public void setContentView(View view) {
        ls().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        ls().setContentView(view, layoutParams);
    }

    public View findViewById(int i) {
        return ls().findViewById(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        ls().setTitle(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        ls().setTitle(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        ls().addContentView(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        ls().onStop();
    }

    public boolean cp(int i) {
        return ls().requestWindowFeature(i);
    }

    public void invalidateOptionsMenu() {
        ls().invalidateOptionsMenu();
    }

    public ov ls() {
        if (this.abe == null) {
            this.abe = ov.m12950a((Dialog) this, (ou) this);
        }
        return this.abe;
    }

    private static int m12944b(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C3982a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void m12945a(pu puVar) {
    }

    public void m12947b(pu puVar) {
    }

    public pu m12946b(C3965a c3965a) {
        return null;
    }
}
