package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.fossil.hh;
import com.fossil.pp;
import java.lang.reflect.Field;

public class ListViewCompat extends ListView {
    private static final int[] aoP = new int[]{0};
    final Rect aoQ;
    int aoR;
    int aoS;
    int aoT;
    int aoU;
    protected int aoV;
    private Field aoW;
    private C1233a aoX;

    static class C1233a extends pp {
        private boolean Vq = true;

        public C1233a(Drawable drawable) {
            super(drawable);
        }

        void setEnabled(boolean z) {
            this.Vq = z;
        }

        public boolean setState(int[] iArr) {
            if (this.Vq) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.Vq) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.Vq) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.Vq) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.Vq) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ListViewCompat(Context context) {
        this(context, null);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoQ = new Rect();
        this.aoR = 0;
        this.aoS = 0;
        this.aoT = 0;
        this.aoU = 0;
        try {
            this.aoW = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.aoW.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.aoX = drawable != null ? new C1233a(drawable) : null;
        super.setSelector(this.aoX);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.aoR = rect.left;
        this.aoS = rect.top;
        this.aoT = rect.right;
        this.aoU = rect.bottom;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        pB();
    }

    protected void dispatchDraw(Canvas canvas) {
        m2390c(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.aoV = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void pB() {
        Drawable selector = getSelector();
        if (selector != null && pC()) {
            selector.setState(getDrawableState());
        }
    }

    protected boolean pC() {
        return oQ() && isPressed();
    }

    protected boolean oQ() {
        return false;
    }

    protected void m2390c(Canvas canvas) {
        if (!this.aoQ.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.aoQ);
                selector.draw(canvas);
            }
        }
    }

    protected void m2387a(int i, View view, float f, float f2) {
        m2388b(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            hh.m11620a(selector, f, f2);
        }
    }

    protected void m2388b(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m2389c(i, view);
        if (z2) {
            Rect rect = this.aoQ;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            hh.m11620a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m2389c(int i, View view) {
        Rect rect = this.aoQ;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.aoR;
        rect.top -= this.aoS;
        rect.right += this.aoT;
        rect.bottom += this.aoU;
        try {
            boolean z = this.aoW.getBoolean(this);
            if (view.isEnabled() != z) {
                this.aoW.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int m2391e(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                listPaddingTop = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, listPaddingTop);
            view.forceLayout();
            if (i8 > 0) {
                listPaddingTop = listPaddingBottom + dividerHeight;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            listPaddingTop += view.getMeasuredHeight();
            if (listPaddingTop < i4) {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                return i4;
            } else {
                return i6;
            }
        }
        return listPaddingBottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.aoX != null) {
            this.aoX.setEnabled(z);
        }
    }
}
