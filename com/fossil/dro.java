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
import android.widget.FrameLayout;
import com.fossil.wearables.fossil.R;

public class dro extends pc {
    boolean mCancelable = true;
    private int vR;
    private BottomSheetBehavior<FrameLayout> wo;
    private boolean wp = true;
    private boolean wq;
    private C1083a wr = new C31291(this);

    class C31291 extends C1083a {
        final /* synthetic */ dro diG;

        C31291(dro com_fossil_dro) {
            this.diG = com_fossil_dro;
        }

        public void mo1143c(View view, int i) {
            if (i == 5) {
                this.diG.cancel();
            }
        }

        public void mo1142b(View view, float f) {
        }
    }

    class C31302 implements OnClickListener {
        final /* synthetic */ dro diG;

        C31302(dro com_fossil_dro) {
            this.diG = com_fossil_dro;
        }

        public void onClick(View view) {
            if (this.diG.mCancelable && this.diG.isShowing() && this.diG.fs()) {
                this.diG.cancel();
            }
        }
    }

    class C31313 extends jz {
        final /* synthetic */ dro diG;

        C31313(dro com_fossil_dro) {
            this.diG = com_fossil_dro;
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            if (this.diG.mCancelable) {
                mlVar.addAction(1048576);
                mlVar.setDismissable(true);
                return;
            }
            mlVar.setDismissable(false);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 1048576 || !this.diG.mCancelable) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            this.diG.cancel();
            return true;
        }
    }

    public dro(Context context, int i) {
        super(context, m9515b(context, i));
        cp(1);
    }

    public void lE(int i) {
        this.vR = i;
    }

    public void setContentView(int i) {
        super.setContentView(m9514a(i, null, null));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void setContentView(View view) {
        super.setContentView(m9514a(0, view, null));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(m9514a(0, view, layoutParams));
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

    private View m9514a(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.bottom_sheet_dialog_container, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.wo = BottomSheetBehavior.m1784i(view2);
        this.wo.m1787a(this.wr);
        if (this.vR >= 0) {
            this.wo.setPeekHeight(this.vR);
        }
        this.wo.setHideable(this.mCancelable);
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new C31302(this));
        li.m12249a(view2, new C31313(this));
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

    private static int m9515b(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme.Design.Light.BottomSheetDialog;
    }
}
