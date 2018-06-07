package com.fossil;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.fossil.cwa.C2427a;
import com.fossil.cwa.C2428b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.CustomCheckbox;

public class cwb extends drm implements OnClickListener, C2428b, C2095b {
    public static final String TAG = cwb.class.getSimpleName();
    private CustomCheckbox cIE;
    private CustomCheckbox cIF;
    private CustomCheckbox cIG;
    private C2427a cIH;
    private ImageView csh;

    public /* synthetic */ void cK(Object obj) {
        m7739a((C2427a) obj);
    }

    public static cwb aiN() {
        return new cwb();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.BottomSheetTheme);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog asVar = new as(getContext(), getTheme());
        View inflate = View.inflate(getContext(), R.layout.layout_vibration_strength, null);
        this.cIE = (CustomCheckbox) inflate.findViewById(R.id.checkbox_light);
        this.cIF = (CustomCheckbox) inflate.findViewById(R.id.checkbox_medium);
        this.cIG = (CustomCheckbox) inflate.findViewById(R.id.checkbox_strong);
        this.csh = (ImageView) inflate.findViewById(R.id.iv_close);
        this.cIE.setTitle(arp.m4318u(PortfolioApp.ZQ(), R.string.Stats_Activity_Legend_Text_Light));
        this.cIF.setTitle(arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Vibration_Label_Medium));
        this.cIG.setTitle(arp.m4318u(PortfolioApp.ZQ(), R.string.Device_Vibration_Label_High));
        this.cIE.setOnClickListener(this);
        this.cIF.setOnClickListener(this);
        this.cIG.setOnClickListener(this);
        this.csh.setOnClickListener(this);
        asVar.setContentView(inflate);
        return asVar;
    }

    public void onResume() {
        this.cIH.start();
        super.onResume();
    }

    public void onPause() {
        this.cIH.stop();
        super.onPause();
    }

    public void onClick(View view) {
        String str = "device_vibration_set";
        String str2 = "Strength";
        Object obj = "";
        switch (view.getId()) {
            case R.id.iv_close:
                lM();
                break;
            case R.id.checkbox_light:
                obj = "Light";
                this.cIH.setVibrationStrength(25);
                break;
            case R.id.checkbox_medium:
                obj = "Medium";
                this.cIH.setVibrationStrength(50);
                break;
            case R.id.checkbox_strong:
                obj = "Strong";
                this.cIH.setVibrationStrength(100);
                break;
        }
        if (!TextUtils.isEmpty(obj)) {
            m7628n(str, str2, obj);
        }
    }

    public boolean lM() {
        dismiss();
        return false;
    }

    public void m7739a(C2427a c2427a) {
        this.cIH = c2427a;
    }

    public void afL() {
        afT();
    }

    public void afM() {
        afU();
    }

    public void kg(int i) {
        this.cIE.dm(false);
        this.cIF.dm(false);
        this.cIG.dm(false);
        switch (i) {
            case 25:
                this.cIE.dm(true);
                return;
            case 50:
                this.cIF.dm(true);
                return;
            case 100:
                this.cIG.dm(true);
                return;
            default:
                this.cIE.dm(true);
                return;
        }
    }

    public void aiM() {
        if (isActive()) {
            dqw.m9445u(getChildFragmentManager());
        }
    }

    public void mo1746a(String str, int i, Intent intent) {
        MFLogger.m12670d(TAG, "onDialogFragmentResult tag" + str);
        Object obj = -1;
        switch (str.hashCode()) {
            case 1396757004:
                if (str.equals("DEVICE_SET_DATA_FAILED")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (i == R.id.fb_help) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                    return;
                }
                return;
            default:
                super.mo1746a(str, i, intent);
                return;
        }
    }

    public void age() {
    }

    public void agf() {
    }

    public void agg() {
    }

    public void agh() {
    }

    public void agi() {
    }
}
