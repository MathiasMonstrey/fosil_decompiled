package com.sina.weibo.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.fossil.dsj.c;
import com.fossil.dsn;
import com.fossil.dsp;
import com.fossil.duj;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

public class LoginButton extends Button implements OnClickListener {
    private SsoHandler cAY;
    private dsp dqr;
    private dsn dqv;
    private OnClickListener duf;
    private Context mContext;

    public LoginButton(Context context) {
        this(context, null);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
    }

    public void m16087a(dsn com_fossil_dsn, dsp com_fossil_dsp) {
        this.dqv = com_fossil_dsn;
        this.dqr = com_fossil_dsp;
    }

    public void m16088a(String str, String str2, String str3, dsp com_fossil_dsp) {
        this.dqv = new dsn(this.mContext, str, str2, str3);
        this.dqr = com_fossil_dsp;
    }

    public void setStyle(int i) {
        int i2 = c.com_sina_weibo_sdk_login_button_with_account_text;
        switch (i) {
            case 1:
                i2 = c.com_sina_weibo_sdk_login_button_with_account_text;
                break;
            case 2:
                i2 = c.com_sina_weibo_sdk_login_button_with_frame_logo;
                break;
            case 3:
                i2 = c.com_sina_weibo_sdk_login_button_with_original_logo;
                break;
        }
        setBackgroundResource(i2);
    }

    public void setExternalOnClickListener(OnClickListener onClickListener) {
        this.duf = onClickListener;
    }

    public void onClick(View view) {
        if (this.duf != null) {
            this.duf.onClick(view);
        }
        if (this.cAY == null && this.dqv != null) {
            this.cAY = new SsoHandler((Activity) this.mContext, this.dqv);
        }
        if (this.cAY != null) {
            this.cAY.m16054a(this.dqr);
        } else {
            duj.e("LoginButton", "Please setWeiboAuthInfo(...) for first");
        }
    }

    private void initialize(Context context) {
        this.mContext = context;
        setOnClickListener(this);
        setStyle(1);
    }
}
