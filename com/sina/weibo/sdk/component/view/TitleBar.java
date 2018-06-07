package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.dum;

public class TitleBar extends RelativeLayout {
    private TextView dru;
    private TextView drv;
    private C5062a dsj;

    class C50611 implements OnClickListener {
        final /* synthetic */ TitleBar dsk;

        C50611(TitleBar titleBar) {
            this.dsk = titleBar;
        }

        public void onClick(View view) {
            if (this.dsk.dsj != null) {
                this.dsk.dsj.axp();
            }
        }
    }

    public interface C5062a {
        void axp();
    }

    public TitleBar(Context context) {
        super(context);
        ave();
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ave();
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ave();
    }

    private void ave() {
        this.dru = new TextView(getContext());
        this.dru.setClickable(true);
        this.dru.setTextSize(2, 17.0f);
        this.dru.setTextColor(dum.n(-32256, 1728020992));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        layoutParams.leftMargin = dum.I(getContext(), 10);
        layoutParams.rightMargin = dum.I(getContext(), 10);
        this.dru.setLayoutParams(layoutParams);
        this.dru.setOnClickListener(new C50611(this));
        addView(this.dru);
        this.drv = new TextView(getContext());
        this.drv.setTextSize(2, 18.0f);
        this.drv.setTextColor(-11382190);
        this.drv.setEllipsize(TruncateAt.END);
        this.drv.setSingleLine(true);
        this.drv.setGravity(17);
        this.drv.setMaxWidth(dum.I(getContext(), 160));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.drv.setLayoutParams(layoutParams);
        addView(this.drv);
        setLayoutParams(new LayoutParams(-1, dum.I(getContext(), 45)));
        setBackgroundDrawable(dum.P(getContext(), "weibosdk_navigationbar_background.9.png"));
    }

    public void setTitleBarText(String str) {
        this.drv.setText(str);
    }

    public void setLeftBtnText(String str) {
        this.dru.setText(str);
    }

    public void setLeftBtnBg(Drawable drawable) {
        this.dru.setBackgroundDrawable(drawable);
    }

    public void setTitleBarClickListener(C5062a c5062a) {
        this.dsj = c5062a;
    }
}
