package com.portfolio.platform.ui.widget;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.fossil.dql;
import com.fossil.tz;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;

public class PresetLayout extends ConstraintLayout {
    public static final String TAG = PresetLayout.class.getSimpleName();
    public ImageView cUW;
    private int deB;
    private int deC;
    private TextView deD;
    public TextView deE;
    private boolean deF = false;

    class C49691 implements Runnable {
        final /* synthetic */ PresetLayout deG;

        C49691(PresetLayout presetLayout) {
            this.deG = presetLayout;
        }

        public void run() {
            this.deG.deB = this.deG.getWidth();
        }
    }

    public void setDragging(boolean z) {
        this.deF = z;
    }

    public PresetLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            layoutInflater.inflate(R.layout.view_customized_section, this, true);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.cUW = (ImageView) findViewById(R.id.view_icon);
        this.deD = (TextView) findViewById(R.id.tv_button);
        this.deE = (TextView) findViewById(R.id.tv_feature);
    }

    protected void onAttachedToWindow() {
        MFLogger.d("PresetLayout", "onAttachedToWindow left=" + getLeft() + " right=" + getRight() + " top=" + getTop() + " bottom" + getBottom());
        super.onAttachedToWindow();
        setSelected(false);
        post(new C49691(this));
    }

    public void setPresetBackground(int i) {
        findViewById(R.id.presets_bg).setBackgroundColor(i);
    }

    public void m15811a(String str, int i, tz tzVar) {
        if (this.cUW != null) {
            tzVar.ah(str).ew(i).mo4173c(this.cUW);
        }
    }

    public void m15810a(int i, int i2, long j) {
        MFLogger.d(TAG, "translateTo end=" + i + " start=" + i2 + " getTop=" + getTop());
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (i2 - getTop()), (float) (i - getTop()));
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        startAnimation(translateAnimation);
    }

    public void aug() {
        if (this.cUW != null) {
            this.cUW.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bouncing_animation));
        }
        if (this.deE != null) {
            this.deE.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bouncing_animation));
        }
    }

    public void setButtonName(int i) {
        if (this.deD != null) {
            this.deD.setText(i);
        }
    }

    public void setPresetName(String str) {
        if (this.deE != null) {
            this.deE.setText(str);
            this.deE.invalidate();
            this.deE.requestLayout();
        }
    }

    public void setDragListener(OnDragListener onDragListener) {
        if (this.cUW != null) {
            setOnDragListener(onDragListener);
        }
    }

    public void setAnimationProgress(float f) {
        MFLogger.d("PresetLayout", "setAnimationProgress start" + f);
        this.deC = getHeight();
        int cV = cV(this);
        int cW = cW(this);
        int cV2 = cV(this.cUW);
        int cW2 = cW(this.cUW);
        int cV3 = cV(this.deD);
        int cW3 = cW(this.deD);
        int cV4 = cV(this.deE);
        cV2 = (((this.deB / 2) + cV) - cV2) - (this.cUW.getWidth() / 2);
        cW2 = (((this.deC / 2) + cW) - cW2) - (this.cUW.getHeight() / 2);
        cV3 = (((this.deB / 2) + cV) - cV3) - (this.deD.getWidth() / 2);
        cW3 = (((((this.deC / 2) + cW) - cW3) - (this.cUW.getHeight() / 2)) - dql.aj(0)) - this.deD.getHeight();
        cV = ((cV + (this.deB / 2)) - (this.deE.getWidth() / 2)) - cV4;
        cW = (((cW + (this.deC / 2)) + (this.cUW.getHeight() / 2)) + dql.aj(5)) - cW(this.deE);
        this.cUW.setTranslationY(((float) cW2) * f);
        this.cUW.setTranslationX(((float) cV2) * f);
        this.deD.setTranslationY(((float) cW3) * f);
        this.deD.setTranslationX(((float) cV3) * f);
        this.deE.setTranslationY(((float) cW) * f);
        this.deE.setTranslationX(((float) cV) * f);
        MFLogger.d("PresetLayout", "setAnimationProgress end");
    }

    private int cV(View view) {
        if (view.getParent() == view.getRootView()) {
            return view.getLeft();
        }
        return cV((View) view.getParent()) + view.getLeft();
    }

    private int cW(View view) {
        if (view.getParent() == view.getRootView()) {
            return view.getTop();
        }
        return cW((View) view.getParent()) + view.getTop();
    }

    public View getRootView() {
        return findViewById(R.id.root_view);
    }
}
