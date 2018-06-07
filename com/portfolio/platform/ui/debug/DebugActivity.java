package com.portfolio.platform.ui.debug;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.fossil.ckc;
import com.fossil.cnr;
import com.fossil.csw;
import com.fossil.ctj;
import com.fossil.cza;
import com.fossil.cza.b;
import com.fossil.czc.a;
import com.fossil.drk;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.utils.MicroAppEventLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.view.FlexibleButton;
import java.util.List;

public class DebugActivity extends ctj implements OnCheckedChangeListener {
    private TextView cHA;
    private CheckBox cHB;
    public cza cHt;
    private FlexibleButton cHu;
    private CheckBox cHv;
    private CheckBox cHw;
    private CheckBox cHx;
    CheckBox cHy;
    private CheckBox cHz;
    public cnr mSharedPreferencesManager;
    public ckc mUseCaseHandler;

    class C49291 implements OnCheckedChangeListener {
        final /* synthetic */ DebugActivity cHC;

        C49291(DebugActivity debugActivity) {
            this.cHC = debugActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.cHC.mSharedPreferencesManager.bR(z);
        }
    }

    class C49302 implements OnCheckedChangeListener {
        final /* synthetic */ DebugActivity cHC;

        C49302(DebugActivity debugActivity) {
            this.cHC = debugActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.cHC.mSharedPreferencesManager.bS(z);
        }
    }

    class C49313 implements OnCheckedChangeListener {
        final /* synthetic */ DebugActivity cHC;

        C49313(DebugActivity debugActivity) {
            this.cHC = debugActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.cHC.mSharedPreferencesManager.cc(z);
        }
    }

    class C49324 implements Runnable {
        final /* synthetic */ DebugActivity cHC;

        C49324(DebugActivity debugActivity) {
            this.cHC = debugActivity;
        }

        public void run() {
            csw.afk().bD(this.cHC);
        }
    }

    class C49357 implements OnClickListener {
        final /* synthetic */ DebugActivity cHC;

        C49357(DebugActivity debugActivity) {
            this.cHC = debugActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class C4936a implements InputFilter {
        final /* synthetic */ DebugActivity cHC;
        private double cHJ;
        private double cHK;

        public C4936a(DebugActivity debugActivity, double d, double d2) {
            this.cHC = debugActivity;
            this.cHJ = d;
            this.cHK = d2;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            try {
                String str = spanned.toString().substring(0, i3) + spanned.toString().substring(i4, spanned.toString().length());
                if (m15714a(this.cHJ, this.cHK, Double.parseDouble(str.substring(0, i3) + charSequence.toString() + str.substring(i3, str.length())))) {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        private boolean m15714a(double d, double d2, double d3) {
            return d2 > d ? d3 >= d && d3 <= d2 : d3 >= d2 && d3 <= d;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug);
        this.cHu = (FlexibleButton) findViewById(R.id.btn_low_battery);
        findViewById(R.id.btn_view_log).setOnClickListener(this);
        findViewById(R.id.btn_send_log).setOnClickListener(this);
        findViewById(R.id.btn_simulate_disconnection).setOnClickListener(this);
        findViewById(R.id.btn_reset_device_setting_to_default).setOnClickListener(this);
        findViewById(R.id.btn_bluetooth_setting).setOnClickListener(this);
        findViewById(R.id.btn_best_week).setOnClickListener(this);
        findViewById(R.id.btn_my_devices).setOnClickListener(this);
        findViewById(R.id.btn_disconnection_test).setOnClickListener(this);
        findViewById(R.id.btn_watch_ota_15r_v2).setOnClickListener(this);
        findViewById(R.id.btn_watch_ota_14r_prod_v3_test).setOnClickListener(this);
        findViewById(R.id.btn_low_battery).setOnClickListener(this);
        findViewById(R.id.btn_clear_data).setOnClickListener(this);
        findViewById(R.id.btn_reset_uapp_log).setOnClickListener(this);
        this.cHA = (TextView) findViewById(R.id.tv_bundle_firmware_description);
        this.cHv = (CheckBox) findViewById(R.id.cb_filter_all_devices);
        this.cHv.setOnCheckedChangeListener(this);
        this.cHw = (CheckBox) findViewById(R.id.cb_disable_hwlog_sync);
        this.cHw.setOnCheckedChangeListener(this);
        this.cHx = (CheckBox) findViewById(R.id.cb_disable_auto_sync);
        this.cHx.setOnCheckedChangeListener(this);
        this.cHy = (CheckBox) findViewById(R.id.cb_skip_ota);
        this.cHy.setOnCheckedChangeListener(new C49291(this));
        this.cHz = (CheckBox) findViewById(R.id.cb_bundle_firmware_latest);
        this.cHz.setOnCheckedChangeListener(new C49302(this));
        this.cHB = (CheckBox) findViewById(R.id.cb_debug_buddy_challenge);
        this.cHB.setOnCheckedChangeListener(new C49313(this));
        PortfolioApp.ZQ().aam().a(this);
    }

    public void aig() {
        LogcatActivity.bF(this);
    }

    public void aih() {
        new Handler().postDelayed(new C49324(this), 1000);
        Toast.makeText(this, "Log will be sent after 1 second", 1).show();
        finish();
    }

    public void aii() {
        Builder builder = new Builder(this);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.simulate_disconnection_input, null);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        create.show();
        EditText editText = (EditText) inflate.findViewById(R.id.et_delay);
        EditText editText2 = (EditText) inflate.findViewById(R.id.et_duration);
        EditText editText3 = (EditText) inflate.findViewById(R.id.et_repeat);
        EditText editText4 = (EditText) inflate.findViewById(R.id.et_delay_each_time);
        Button button = (Button) inflate.findViewById(R.id.btn_done);
        editText.setFilters(new InputFilter[]{new C4936a(this, 0.0d, 65535.0d)});
        editText2.setFilters(new InputFilter[]{new C4936a(this, 0.0d, 65535.0d)});
        editText3.setFilters(new InputFilter[]{new C4936a(this, 0.0d, 65535.0d)});
        editText4.setFilters(new InputFilter[]{new C4936a(this, 0.0d, 4294967.0d)});
        final EditText editText5 = editText;
        final EditText editText6 = editText2;
        final EditText editText7 = editText3;
        final EditText editText8 = editText4;
        button.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ DebugActivity cHC;

            public void onClick(View view) {
                int parseInt;
                int parseInt2;
                int parseInt3;
                int parseInt4;
                String obj = editText5.getText().toString();
                String obj2 = editText6.getText().toString();
                String obj3 = editText7.getText().toString();
                String obj4 = editText8.getText().toString();
                try {
                    parseInt = Integer.parseInt(obj);
                } catch (Exception e) {
                    parseInt = 0;
                }
                try {
                    parseInt2 = Integer.parseInt(obj2);
                } catch (Exception e2) {
                    parseInt2 = 0;
                }
                try {
                    parseInt3 = Integer.parseInt(obj3);
                } catch (Exception e3) {
                    parseInt3 = 0;
                }
                try {
                    parseInt4 = Integer.parseInt(obj4);
                } catch (Exception e4) {
                    parseInt4 = 0;
                }
                if (parseInt > 65535 || parseInt2 > 65535 || parseInt3 > 65535 || parseInt4 > 65535) {
                    Toast.makeText(this.cHC, "Value should be in range [0, 65535]", 0).show();
                    return;
                }
                PortfolioApp.ZQ().simulateDisconnection(parseInt, parseInt2, parseInt3, parseInt4);
                create.dismiss();
            }
        });
    }

    private void aij() {
        PortfolioApp.ZQ().resetDeviceSettingToDefault();
    }

    protected void onResume() {
        boolean z = true;
        super.onResume();
        this.cHv.setChecked(this.mSharedPreferencesManager.acF());
        this.cHw.setChecked(!this.mSharedPreferencesManager.acG());
        CheckBox checkBox = this.cHx;
        if (this.mSharedPreferencesManager.acH()) {
            z = false;
        }
        checkBox.setChecked(z);
        jQ(getResources().getColor(R.color.status_color_activity_debug));
        this.cHy.setChecked(this.mSharedPreferencesManager.acD());
        this.cHB.setChecked(this.mSharedPreferencesManager.adj());
        aik();
    }

    private void aik() {
        this.cHz.setChecked(this.mSharedPreferencesManager.acE());
        List<Firmware> akg = a.akg();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bundle Firmwares: \n");
        for (Firmware versionNumber : akg) {
            stringBuilder.append(versionNumber.getVersionNumber()).append("\n");
        }
        this.cHA.setText(stringBuilder.toString());
    }

    public void ail() {
        Intent intent = new Intent();
        intent.setAction("android.settings.BLUETOOTH_SETTINGS");
        startActivity(intent);
    }

    public void aim() {
    }

    public void ain() {
    }

    public void aio() {
    }

    public void hP(String str) {
        this.mUseCaseHandler.a(this.cHt, new b(PortfolioApp.ZQ().aaa(), cza.a.if(str)), null);
    }

    public void aip() {
        Builder builder = new Builder(this);
        final View editText = new EditText(this);
        editText.setLayoutParams(new LayoutParams(-1, -1));
        editText.setInputType(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        builder.setView(editText);
        builder.setTitle("Custom dialog");
        builder.setMessage("Enter text below");
        builder.setPositiveButton("Done", new OnClickListener(this) {
            final /* synthetic */ DebugActivity cHC;

            public void onClick(DialogInterface dialogInterface, int i) {
                int intValue = Integer.valueOf(editText.getText().toString().trim()).intValue();
                if (intValue > 0) {
                    this.cHC.mSharedPreferencesManager.jH(intValue);
                    this.cHC.cHu.setText(String.format("Replace battery level: %s", new Object[]{Integer.valueOf(intValue)}));
                }
            }
        });
        builder.setNegativeButton("Cancel", new C49357(this));
        builder.create().show();
    }

    public void aiq() {
        drk jw = new drk.a(R.layout.dialog_confirm).w(R.id.ftv_confirm_title, "ARE YOU SURE?").w(R.id.ftv_confirm_desc, "** This will NOT happen on production **").w(R.id.fb_ok, "OK").lB(R.id.fb_ok).jw("CONFIRM_CLEAR_DATA");
        jw.setCancelable(true);
        jw.setStyle(0, R.style.DialogNotFullScreen);
        jw.show(getSupportFragmentManager(), "CONFIRM_CLEAR_DATA");
    }

    private void air() {
        MicroAppEventLogger.resetLogFiles();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view_log:
                aig();
                return;
            case R.id.btn_send_log:
                aih();
                return;
            case R.id.btn_best_week:
                aim();
                return;
            case R.id.btn_my_devices:
                ain();
                return;
            case R.id.btn_clear_data:
                aiq();
                return;
            case R.id.btn_bluetooth_setting:
                ail();
                return;
            case R.id.btn_simulate_disconnection:
                aii();
                return;
            case R.id.btn_reset_device_setting_to_default:
                aij();
                return;
            case R.id.btn_disconnection_test:
                aio();
                return;
            case R.id.btn_low_battery:
                aip();
                return;
            case R.id.btn_watch_ota_15r_v2:
                hP("HW0.0.0.15r.v2");
                return;
            case R.id.btn_watch_ota_14r_prod_v3_test:
                hP("HW0.0.0.14r.prod.v3_disable_hibernation");
                return;
            case R.id.btn_reset_uapp_log:
                air();
                return;
            default:
                super.onClick(view);
                return;
        }
    }

    public void m15716a(String str, int i, Intent intent) {
        if (str.equals("CONFIRM_CLEAR_DATA") && i == R.id.fb_ok) {
            DebugClearDataWarningActivity.bF(this);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2 = true;
        cnr com_fossil_cnr;
        switch (compoundButton.getId()) {
            case R.id.cb_filter_all_devices:
                this.mSharedPreferencesManager.bT(z);
                DeviceHelper.abH().abI();
                return;
            case R.id.cb_disable_hwlog_sync:
                com_fossil_cnr = this.mSharedPreferencesManager;
                if (z) {
                    z2 = false;
                }
                com_fossil_cnr.bU(z2);
                return;
            case R.id.cb_disable_auto_sync:
                com_fossil_cnr = this.mSharedPreferencesManager;
                if (z) {
                    z2 = false;
                }
                com_fossil_cnr.bV(z2);
                return;
            default:
                return;
        }
    }
}
