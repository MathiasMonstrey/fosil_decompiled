package android.support.design.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import com.fossil.jz;
import com.fossil.li;
import com.fossil.ml;
import com.fossil.pk.a;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] wt = new int[]{16842912};
    private boolean wu;

    class C00231 extends jz {
        final /* synthetic */ CheckableImageButton wv;

        C00231(CheckableImageButton checkableImageButton) {
            this.wv = checkableImageButton;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(this.wv.isChecked());
        }

        public void mo2a(View view, ml mlVar) {
            super.mo2a(view, mlVar);
            mlVar.setCheckable(true);
            mlVar.setChecked(this.wv.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        li.m12249a((View) this, new C00231(this));
    }

    public void setChecked(boolean z) {
        if (this.wu != z) {
            this.wu = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.wu;
    }

    public void toggle() {
        setChecked(!this.wu);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.wu) {
            return mergeDrawableStates(super.onCreateDrawableState(wt.length + i), wt);
        }
        return super.onCreateDrawableState(i);
    }
}
