package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton extends ImageButton {
    private int Dr;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Dr = getVisibility();
    }

    public void setVisibility(int i) {
        m1863a(i, true);
    }

    public final void m1863a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.Dr = i;
        }
    }

    final int getUserSetVisibility() {
        return this.Dr;
    }
}
