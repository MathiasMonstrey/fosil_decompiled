package com.portfolio.platform.view.blur;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RSRuntimeException;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.fossil.cjz.a;

public class BlurView extends View {
    private static int dnQ;
    private static StopException dnS = new StopException();
    static Boolean dnT = null;
    private float dnB;
    private int dnC;
    private float dnD;
    private Bitmap dnE;
    private Bitmap dnF;
    private Canvas dnG;
    private RenderScript dnH;
    private ScriptIntrinsicBlur dnI;
    private Allocation dnJ;
    private Allocation dnK;
    private boolean dnL;
    private final Rect dnM = new Rect();
    private final Rect dnN = new Rect();
    private View dnO;
    private boolean dnP;
    private final OnPreDrawListener dnR = new C50261(this);
    private boolean mDirty;

    class C50261 implements OnPreDrawListener {
        final /* synthetic */ BlurView dnU;

        C50261(BlurView blurView) {
            this.dnU = blurView;
        }

        public boolean onPreDraw() {
            boolean z = true;
            int[] iArr = new int[2];
            Bitmap a = this.dnU.dnF;
            View b = this.dnU.dnO;
            if (b != null && this.dnU.isShown() && this.dnU.prepare()) {
                boolean z2 = this.dnU.dnF != a;
                b.getLocationOnScreen(iArr);
                int i = -iArr[0];
                int i2 = -iArr[1];
                this.dnU.getLocationOnScreen(iArr);
                i += iArr[0];
                int i3 = iArr[1] + i2;
                this.dnU.dnE.eraseColor(this.dnU.dnC & 16777215);
                i2 = this.dnU.dnG.save();
                this.dnU.dnL = true;
                BlurView.awi();
                try {
                    this.dnU.dnG.scale((((float) this.dnU.dnE.getWidth()) * 1.0f) / ((float) this.dnU.getWidth()), (((float) this.dnU.dnE.getHeight()) * 1.0f) / ((float) this.dnU.getHeight()));
                    this.dnU.dnG.translate((float) (-i), (float) (-i3));
                    if (b.getBackground() != null) {
                        b.getBackground().draw(this.dnU.dnG);
                    }
                    b.draw(this.dnU.dnG);
                } catch (StopException e) {
                } finally {
                    BlurView blurView = null;
                    blurView = null;
                    this.dnU.dnL = false;
                    BlurView.awj();
                    z = this.dnU.dnG;
                    z.restoreToCount(i2);
                }
                this.dnU.m16016c(this.dnU.dnE, this.dnU.dnF);
                if (z2 || this.dnU.dnP) {
                    this.dnU.invalidate();
                }
            }
            return z;
        }
    }

    static class StopException extends RuntimeException {
        private StopException() {
        }
    }

    static /* synthetic */ int awi() {
        int i = dnQ;
        dnQ = i + 1;
        return i;
    }

    static /* synthetic */ int awj() {
        int i = dnQ;
        dnQ = i - 1;
        return i;
    }

    static {
        try {
            BlurView.class.getClassLoader().loadClass("android.support.v8.renderscript.RenderScript");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("RenderScript support not enabled. Add \"android { defaultConfig { renderscriptSupportModeEnabled true }}\" in your build.gradle");
        }
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.BlurView);
        this.dnD = obtainStyledAttributes.getDimension(0, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.dnB = obtainStyledAttributes.getFloat(2, 4.0f);
        this.dnC = obtainStyledAttributes.getColor(1, -1426063361);
        obtainStyledAttributes.recycle();
    }

    public void setBlurRadius(float f) {
        if (this.dnD != f) {
            this.dnD = f;
            this.mDirty = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        } else if (this.dnB != f) {
            this.dnB = f;
            this.mDirty = true;
            awg();
            invalidate();
        }
    }

    public void setOverlayColor(int i) {
        if (this.dnC != i) {
            this.dnC = i;
            invalidate();
        }
    }

    private void awg() {
        if (this.dnJ != null) {
            this.dnJ.destroy();
            this.dnJ = null;
        }
        if (this.dnK != null) {
            this.dnK.destroy();
            this.dnK = null;
        }
        if (this.dnE != null) {
            this.dnE.recycle();
            this.dnE = null;
        }
        if (this.dnF != null) {
            this.dnF.recycle();
            this.dnF = null;
        }
    }

    private void awh() {
        if (this.dnH != null) {
            this.dnH.destroy();
            this.dnH = null;
        }
        if (this.dnI != null) {
            this.dnI.destroy();
            this.dnI = null;
        }
    }

    protected void release() {
        awg();
        awh();
    }

    protected boolean prepare() {
        float f = 25.0f;
        if (this.dnD == 0.0f) {
            release();
            return false;
        }
        float f2 = this.dnB;
        if (this.mDirty || this.dnH == null) {
            if (this.dnH == null) {
                try {
                    this.dnH = RenderScript.create(getContext());
                    this.dnI = ScriptIntrinsicBlur.create(this.dnH, Element.U8_4(this.dnH));
                } catch (RSRuntimeException e) {
                    if (!cD(getContext())) {
                        awh();
                        return false;
                    } else if (e.getMessage() == null || !e.getMessage().startsWith("Error loading RS jni library: java.lang.UnsatisfiedLinkError:")) {
                        throw e;
                    } else {
                        throw new RuntimeException("Error loading RS jni library, Upgrade buildToolsVersion=\"24.0.2\" or higher may solve this issue");
                    }
                }
            }
            this.mDirty = false;
            float f3 = this.dnD / f2;
            if (f3 > 25.0f) {
                f3 = (f3 * f2) / 25.0f;
            } else {
                f = f3;
                f3 = f2;
            }
            this.dnI.setRadius(f);
            f2 = f3;
        }
        int width = getWidth();
        int height = getHeight();
        width = Math.max(1, (int) (((float) width) / f2));
        height = Math.max(1, (int) (((float) height) / f2));
        if (this.dnG != null && this.dnF != null && this.dnF.getWidth() == width && this.dnF.getHeight() == height) {
            return true;
        }
        awg();
        try {
            this.dnE = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            if (this.dnE == null) {
                awg();
                return false;
            }
            this.dnG = new Canvas(this.dnE);
            this.dnJ = Allocation.createFromBitmap(this.dnH, this.dnE, MipmapControl.MIPMAP_NONE, 1);
            this.dnK = Allocation.createTyped(this.dnH, this.dnJ.getType());
            this.dnF = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            if (this.dnF != null) {
                return true;
            }
            awg();
            return false;
        } catch (OutOfMemoryError e2) {
            awg();
            return false;
        } catch (Throwable th) {
            awg();
            return false;
        }
    }

    protected void m16016c(Bitmap bitmap, Bitmap bitmap2) {
        this.dnJ.copyFrom(bitmap);
        this.dnI.setInput(this.dnJ);
        this.dnI.forEach(this.dnK);
        this.dnK.copyTo(bitmap2);
    }

    protected View getActivityDecorView() {
        Context context = getContext();
        int i = 0;
        while (i < 4 && context != null && !(context instanceof Activity) && (context instanceof ContextWrapper)) {
            i++;
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context instanceof Activity ? ((Activity) context).getWindow().getDecorView() : null;
    }

    protected void onAttachedToWindow() {
        boolean z = false;
        super.onAttachedToWindow();
        this.dnO = getActivityDecorView();
        if (this.dnO != null) {
            this.dnO.getViewTreeObserver().addOnPreDrawListener(this.dnR);
            if (this.dnO.getRootView() != getRootView()) {
                z = true;
            }
            this.dnP = z;
            if (this.dnP) {
                this.dnO.postInvalidate();
                return;
            }
            return;
        }
        this.dnP = false;
    }

    protected void onDetachedFromWindow() {
        if (this.dnO != null) {
            this.dnO.getViewTreeObserver().removeOnPreDrawListener(this.dnR);
        }
        release();
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        if (this.dnL) {
            throw dnS;
        } else if (dnQ <= 0) {
            super.draw(canvas);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m16015a(canvas, this.dnF, this.dnC);
    }

    protected void m16015a(Canvas canvas, Bitmap bitmap, int i) {
        if (bitmap != null) {
            this.dnM.right = bitmap.getWidth();
            this.dnM.bottom = bitmap.getHeight();
            this.dnN.right = getWidth();
            this.dnN.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.dnM, this.dnN, (Paint) null);
        }
        canvas.drawColor(i);
    }

    static boolean cD(Context context) {
        if (dnT == null && context != null) {
            boolean z;
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            dnT = Boolean.valueOf(z);
        }
        if (dnT == Boolean.TRUE) {
            return true;
        }
        return false;
    }
}
