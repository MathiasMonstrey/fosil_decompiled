package com.fossil;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.C1083a;
import android.support.design.widget.CoordinatorLayout;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.fossil.ag.C1621b;
import com.fossil.ag.C1625f;
import com.fossil.ag.C1627h;
import com.fossil.ag.C1629j;

public class as extends pc {
    boolean mCancelable = true;
    private BottomSheetBehavior<FrameLayout> wo;
    private boolean wp = true;
    private boolean wq;
    private C1083a wr = new C18863(this);

    class C18841 implements OnClickListener {
        final /* synthetic */ as ws;

        C18841(as asVar) {
            this.ws = asVar;
        }

        public void onClick(View view) {
            if (this.ws.mCancelable && this.ws.isShowing() && this.ws.fs()) {
                this.ws.cancel();
            }
        }
    }

    class C18852 extends jz {
        final /* synthetic */ as ws;

        C18852(as asVar) {
            this.ws = asVar;
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            if (this.ws.mCancelable) {
                mlVar.addAction(1048576);
                mlVar.setDismissable(true);
                return;
            }
            mlVar.setDismissable(false);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 1048576 || !this.ws.mCancelable) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            this.ws.cancel();
            return true;
        }
    }

    class C18863 extends C1083a {
        final /* synthetic */ as ws;

        C18863(as asVar) {
            this.ws = asVar;
        }

        public void mo1143c(View view, int i) {
            if (i == 5) {
                this.ws.cancel();
            }
        }

        public void mo1142b(View view, float f) {
        }
    }

    public as(Context context, int i) {
        super(context, m4348b(context, i));
        cp(1);
    }

    public void setContentView(int i) {
        super.setContentView(m4347a(i, null, null));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    public void setContentView(View view) {
        super.setContentView(m4347a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(m4347a(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.mCancelable != z) {
            this.mCancelable = z;
            if (this.wo != null) {
                this.wo.setHideable(z);
            }
        }
    }

    protected void onStart() {
        super.onStart();
        if (this.wo != null) {
            this.wo.setState(4);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.wp = z;
        this.wq = true;
    }

    private View m4347a(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), C1627h.design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(C1625f.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(C1625f.design_bottom_sheet);
        this.wo = BottomSheetBehavior.m1784i(view2);
        this.wo.m1787a(this.wr);
        this.wo.setHideable(this.mCancelable);
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(C1625f.touch_outside).setOnClickListener(new C18841(this));
        li.m12249a(view2, new C18852(this));
        return frameLayout;
    }

    boolean fs() {
        if (!this.wq) {
            if (VERSION.SDK_INT < 11) {
                this.wp = true;
            } else {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
                this.wp = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.wq = true;
        }
        return this.wp;
    }

    private static int m4348b(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C1621b.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return C1629j.Theme_Design_Light_BottomSheetDialog;
    }
}
