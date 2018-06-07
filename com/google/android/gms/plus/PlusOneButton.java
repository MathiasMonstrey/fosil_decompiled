package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.fossil.awl;
import com.fossil.bzx;

public final class PlusOneButton extends FrameLayout {
    private View adu;
    private String bFB;
    private int bJY;
    private int bJZ;
    private C4263b bKa;
    private int mSize;

    public interface C4263b {
        void mo4447k(Intent intent);
    }

    public class C4264a implements OnClickListener, C4263b {
        private final C4263b bKb;
        private /* synthetic */ PlusOneButton bKc;

        public C4264a(PlusOneButton plusOneButton, C4263b c4263b) {
            this.bKc = plusOneButton;
            this.bKb = c4263b;
        }

        public void mo4447k(Intent intent) {
            Context context = this.bKc.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.bKc.bJZ);
            }
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.bKc.adu.getTag();
            if (this.bKb != null) {
                this.bKb.mo4447k(intent);
            } else {
                mo4447k(intent);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = m14289h(context, attributeSet);
        this.bJY = m14290i(context, attributeSet);
        this.bJZ = -1;
        aV(getContext());
        if (!isInEditMode()) {
        }
    }

    private final void aV(Context context) {
        if (this.adu != null) {
            removeView(this.adu);
        }
        this.adu = bzx.a(context, this.mSize, this.bJY, this.bFB, this.bJZ);
        setOnPlusOneClickListener(this.bKa);
        addView(this.adu);
    }

    protected static int m14289h(Context context, AttributeSet attributeSet) {
        String a = awl.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(a) ? 0 : "MEDIUM".equalsIgnoreCase(a) ? 1 : "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    protected static int m14290i(Context context, AttributeSet attributeSet) {
        String a = awl.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        return "INLINE".equalsIgnoreCase(a) ? 2 : !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.adu.layout(0, 0, i3 - i, i4 - i2);
    }

    protected final void onMeasure(int i, int i2) {
        View view = this.adu;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public final void setAnnotation(int i) {
        this.bJY = i;
        aV(getContext());
    }

    public final void setIntent(Intent intent) {
        this.adu.setTag(intent);
    }

    public final void setOnPlusOneClickListener(C4263b c4263b) {
        this.bKa = c4263b;
        this.adu.setOnClickListener(new C4264a(this, c4263b));
    }

    public final void setSize(int i) {
        this.mSize = i;
        aV(getContext());
    }
}
