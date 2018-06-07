package com.sina.weibo.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.fossil.dsj.a;
import com.fossil.dsj.b;
import com.fossil.dsj.c;
import com.fossil.dsj.d;
import com.fossil.dsn;
import com.fossil.dso;
import com.fossil.dsp;
import com.fossil.dto;
import com.fossil.dts;
import com.fossil.duj;
import com.misfit.frameworks.common.constants.Constants;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginoutButton extends Button implements OnClickListener {
    private SsoHandler cAY;
    private dsp dqr;
    private dsn dqv;
    private dso dsz;
    private OnClickListener duf;
    private dto dug;
    private Context mContext;

    class C50661 implements dsp {
        final /* synthetic */ LoginoutButton duh;

        C50661(LoginoutButton loginoutButton) {
            this.duh = loginoutButton;
        }

        public void m16089G(Bundle bundle) {
            this.duh.dsz = dso.K(bundle);
            if (this.duh.dsz.awC()) {
                this.duh.setText(d.com_sina_weibo_sdk_logout);
            }
            if (this.duh.dqr != null) {
                this.duh.dqr.G(bundle);
            }
        }

        public void onCancel() {
            if (this.duh.dqr != null) {
                this.duh.dqr.onCancel();
            }
        }

        public void m16090a(WeiboException weiboException) {
            if (this.duh.dqr != null) {
                this.duh.dqr.a(weiboException);
            }
        }
    }

    class C50672 implements dto {
        final /* synthetic */ LoginoutButton duh;

        C50672(LoginoutButton loginoutButton) {
            this.duh = loginoutButton;
        }

        public void jP(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.isNull("error")) {
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(jSONObject.getString(Constants.RESULT))) {
                            this.duh.dsz = null;
                            this.duh.setText(d.com_sina_weibo_sdk_login_with_weibo_account);
                        }
                    } else if (jSONObject.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE).equals("21317")) {
                        this.duh.dsz = null;
                        this.duh.setText(d.com_sina_weibo_sdk_login_with_weibo_account);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (this.duh.dug != null) {
                this.duh.dug.jP(str);
            }
        }

        public void m16091a(WeiboException weiboException) {
            duj.e("LoginButton", "WeiboException： " + weiboException.getMessage());
            this.duh.setText(d.com_sina_weibo_sdk_logout);
            if (this.duh.dug != null) {
                this.duh.dug.a(weiboException);
            }
        }
    }

    public LoginoutButton(Context context) {
        this(context, null);
    }

    public LoginoutButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoginoutButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16097u(context, attributeSet);
    }

    public void m16098a(dsn com_fossil_dsn, dsp com_fossil_dsp) {
        this.dqv = com_fossil_dsn;
        this.dqr = com_fossil_dsp;
    }

    public void m16100a(String str, String str2, String str3, dsp com_fossil_dsp) {
        this.dqv = new dsn(this.mContext, str, str2, str3);
        this.dqr = com_fossil_dsp;
    }

    public void m16099a(dso com_fossil_dso, dto com_fossil_dto) {
        this.dsz = com_fossil_dso;
        this.dug = com_fossil_dto;
        if (this.dsz != null && this.dsz.awC()) {
            setText(d.com_sina_weibo_sdk_logout);
        }
    }

    public void setLogoutListener(dto com_fossil_dto) {
        this.dug = com_fossil_dto;
    }

    public void setExternalOnClickListener(OnClickListener onClickListener) {
        this.duf = onClickListener;
    }

    public void onClick(View view) {
        if (this.duf != null) {
            this.duf.onClick(view);
        }
        if (this.dsz == null || !this.dsz.awC()) {
            axZ();
        } else {
            logout();
        }
    }

    private void m16097u(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        setOnClickListener(this);
        m16096l(attributeSet);
    }

    private void m16096l(AttributeSet attributeSet) {
        if (attributeSet != null && attributeSet.getStyleAttribute() == 0) {
            Resources resources = getResources();
            setBackgroundResource(c.com_sina_weibo_sdk_button_blue);
            setPadding(resources.getDimensionPixelSize(b.com_sina_weibo_sdk_loginview_padding_left), resources.getDimensionPixelSize(b.com_sina_weibo_sdk_loginview_padding_top), resources.getDimensionPixelSize(b.com_sina_weibo_sdk_loginview_padding_right), resources.getDimensionPixelSize(b.com_sina_weibo_sdk_loginview_padding_bottom));
            setCompoundDrawablesWithIntrinsicBounds(c.ic_com_sina_weibo_sdk_logo, 0, 0, 0);
            setCompoundDrawablePadding(resources.getDimensionPixelSize(b.com_sina_weibo_sdk_loginview_compound_drawable_padding));
            setTextColor(resources.getColor(a.com_sina_weibo_sdk_loginview_text_color));
            setTextSize(0, resources.getDimension(b.com_sina_weibo_sdk_loginview_text_size));
            setTypeface(Typeface.DEFAULT_BOLD);
            setGravity(17);
            setText(d.com_sina_weibo_sdk_login_with_weibo_account);
        }
    }

    private void axZ() {
        duj.i("LoginButton", "Click to login");
        if (this.cAY == null && this.dqv != null) {
            this.cAY = new SsoHandler((Activity) this.mContext, this.dqv);
        }
        if (this.cAY != null) {
            this.cAY.m16054a(new C50661(this));
        } else {
            duj.e("LoginButton", "Please setWeiboAuthInfo(...) for first");
        }
    }

    private void logout() {
        if (this.dsz != null && this.dsz.awC()) {
            duj.i("LoginButton", "Click to logout");
            new dts(this.mContext, this.dqv.awy(), this.dsz).a(new C50672(this));
        }
    }
}
