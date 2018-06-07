package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

@TargetApi(14)
class dq {
    protected C3087a GV;

    static class C3087a extends ViewGroup {
        static Method GW;
        ViewGroup GX;
        View GY;
        ArrayList<Drawable> GZ = null;
        dq Ha;

        static {
            try {
                GW = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException e) {
            }
        }

        C3087a(Context context, ViewGroup viewGroup, View view, dq dqVar) {
            super(context);
            this.GX = viewGroup;
            this.GY = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.Ha = dqVar;
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void add(Drawable drawable) {
            if (this.GZ == null) {
                this.GZ = new ArrayList();
            }
            if (!this.GZ.contains(drawable)) {
                this.GZ.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void remove(Drawable drawable) {
            if (this.GZ != null) {
                this.GZ.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        protected boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.GZ != null && this.GZ.contains(drawable));
        }

        public void add(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.GX || viewGroup.getParent() == null)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.GX.getLocationOnScreen(iArr2);
                    li.m12275q(view, iArr[0] - iArr2[0]);
                    li.m12274p(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public void remove(View view) {
            super.removeView(view);
            if (isEmpty()) {
                this.GX.removeView(this);
            }
        }

        boolean isEmpty() {
            if (getChildCount() == 0 && (this.GZ == null || this.GZ.size() == 0)) {
                return true;
            }
            return false;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        protected void dispatchDraw(Canvas canvas) {
            int i = 0;
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            ViewGroup viewGroup = (ViewGroup) getParent();
            this.GX.getLocationOnScreen(iArr);
            this.GY.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.GY.getWidth(), this.GY.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.GZ == null ? 0 : this.GZ.size();
            while (i < size) {
                ((Drawable) this.GZ.get(i)).draw(canvas);
                i++;
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        private void m9358c(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            ViewGroup viewGroup = (ViewGroup) getParent();
            this.GX.getLocationOnScreen(iArr2);
            this.GY.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.GX != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.GX instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    m9358c(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }

    dq(Context context, ViewGroup viewGroup, View view) {
        this.GV = new C3087a(context, viewGroup, view, this);
    }

    static ViewGroup m9313C(View view) {
        View view2 = view;
        while (view2 != null) {
            if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                return (ViewGroup) view2;
            }
            if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        return null;
    }

    public static dq m9314D(View view) {
        ViewGroup C = m9313C(view);
        if (C == null) {
            return null;
        }
        int childCount = C.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = C.getChildAt(i);
            if (childAt instanceof C3087a) {
                return ((C3087a) childAt).Ha;
            }
        }
        return new dp(C.getContext(), C, view);
    }

    public void add(Drawable drawable) {
        this.GV.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.GV.remove(drawable);
    }
}
