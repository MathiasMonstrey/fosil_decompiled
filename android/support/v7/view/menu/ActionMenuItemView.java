package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.widget.ActionMenuView.C1204a;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.fossil.hb;
import com.fossil.li;
import com.fossil.pk.j;
import com.fossil.qj.b;
import com.fossil.ql;
import com.fossil.qr.a;
import com.fossil.qu;
import com.fossil.ry;

public class ActionMenuItemView extends AppCompatTextView implements C1204a, OnClickListener, OnLongClickListener, a {
    private Drawable AN;
    private CharSequence Od;
    b afc;
    private ry afd;
    C1203b afe;
    private boolean aff;
    private boolean afg;
    private int afh;
    private int afi;
    private int oL;
    ql tR;

    class C1202a extends ry {
        final /* synthetic */ ActionMenuItemView afj;

        public C1202a(ActionMenuItemView actionMenuItemView) {
            this.afj = actionMenuItemView;
            super(actionMenuItemView);
        }

        public qu mC() {
            if (this.afj.afe != null) {
                return this.afj.afe.mC();
            }
            return null;
        }

        protected boolean mD() {
            if (this.afj.afc == null || !this.afj.afc.b(this.afj.tR)) {
                return false;
            }
            qu mC = mC();
            if (mC == null || !mC.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class C1203b {
        public abstract qu mC();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.aff = my();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMenuItemView, i, 0);
        this.oL = obtainStyledAttributes.getDimensionPixelSize(j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.afi = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.afh = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aff = my();
        mz();
    }

    private boolean my() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int b = hb.m11553b(getResources());
        return b >= 480 || ((b >= 640 && hb.m11552a(getResources()) >= 480) || configuration.orientation == 2);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.afh = i;
        super.setPadding(i, i2, i3, i4);
    }

    public ql getItemData() {
        return this.tR;
    }

    public void m2176a(ql qlVar, int i) {
        this.tR = qlVar;
        setIcon(qlVar.getIcon());
        setTitle(qlVar.m12648a((a) this));
        setId(qlVar.getItemId());
        setVisibility(qlVar.isVisible() ? 0 : 8);
        setEnabled(qlVar.isEnabled());
        if (qlVar.hasSubMenu() && this.afd == null) {
            this.afd = new C1202a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tR.hasSubMenu() && this.afd != null && this.afd.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.afc != null) {
            this.afc.b(this.tR);
        }
    }

    public void setItemInvoker(b bVar) {
        this.afc = bVar;
    }

    public void setPopupCallback(C1203b c1203b) {
        this.afe = c1203b;
    }

    public boolean eT() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.afg != z) {
            this.afg = z;
            if (this.tR != null) {
                this.tR.nj();
            }
        }
    }

    private void mz() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.Od) ? 1 : 0;
        if (this.AN == null || (this.tR.no() && (this.aff || this.afg))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.Od : null);
    }

    public void setIcon(Drawable drawable) {
        this.AN = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.afi) {
                f = ((float) this.afi) / ((float) intrinsicWidth);
                intrinsicWidth = this.afi;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.afi) {
                f = ((float) this.afi) / ((float) intrinsicHeight);
                intrinsicHeight = this.afi;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        mz();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void m2177a(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.Od = charSequence;
        setContentDescription(this.Od);
        mz();
    }

    public boolean mA() {
        return hasText() && this.tR.getIcon() == null;
    }

    public boolean mB() {
        return hasText();
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (li.m12235S(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.tR.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean hasText = hasText();
        if (hasText && this.afh >= 0) {
            super.setPadding(this.afh, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.oL) : this.oL;
        if (mode != 1073741824 && this.oL > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!hasText && this.AN != null) {
            super.setPadding((getMeasuredWidth() - this.AN.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
