package android.support.v7.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.fossil.qj;
import com.fossil.qj.b;
import com.fossil.ql;
import com.fossil.qr;
import com.fossil.sw;

public final class ExpandedMenuView extends ListView implements OnItemClickListener, b, qr {
    private static final int[] afU = new int[]{16842964, 16843049};
    private int afV;
    private qj uh;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        sw a = sw.a(context, attributeSet, afU, i, 0);
        if (a.hasValue(0)) {
            setBackgroundDrawable(a.getDrawable(0));
        }
        if (a.hasValue(1)) {
            setDivider(a.getDrawable(1));
        }
        a.recycle();
    }

    public void m2178a(qj qjVar) {
        this.uh = qjVar;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean m2179b(ql qlVar) {
        return this.uh.c(qlVar, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m2179b((ql) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.afV;
    }
}
