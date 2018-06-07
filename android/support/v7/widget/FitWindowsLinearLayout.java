package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.fossil.rx;
import com.fossil.rx.a;

public class FitWindowsLinearLayout extends LinearLayout implements rx {
    private a amN;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(a aVar) {
        this.amN = aVar;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.amN != null) {
            this.amN.g(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
