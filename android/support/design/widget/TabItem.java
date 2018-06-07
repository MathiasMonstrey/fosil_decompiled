package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.fossil.ag.C1630k;
import com.fossil.sw;

public final class TabItem extends View {
    final Drawable AN;
    final int AO;
    final CharSequence xf;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        sw a = sw.a(context, attributeSet, C1630k.TabItem);
        this.xf = a.getText(C1630k.TabItem_android_text);
        this.AN = a.getDrawable(C1630k.TabItem_android_icon);
        this.AO = a.getResourceId(C1630k.TabItem_android_layout, 0);
        a.recycle();
    }
}
