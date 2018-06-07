package com.fossil;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.fossil.drk.C2095b;
import com.fossil.evb.C2096a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.IButtonConnectivity;
import com.misfit.frameworks.buttonservice.IButtonConnectivity.Stub;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork.OnGlobalServerEvent;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.AppType;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.FossilBrand;
import com.portfolio.platform.service.MFDeviceService;
import com.portfolio.platform.service.MFDeviceService.C3908b;
import com.portfolio.platform.ui.user.WelcomeActivity;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.FlexibleTextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ctj extends ot implements OnClickListener, C2095b, C2096a, OnGlobalServerEvent {
    protected static IButtonConnectivity cmE;
    protected final String TAG = getClass().getSimpleName();
    protected FlexibleTextView cEA;
    protected FlexibleTextView cEB;
    protected FlexibleTextView cEC;
    protected ImageView cED;
    protected cmj cEE;
    public cnr cEF;
    private drq cEG;
    private BroadcastReceiver cEH = new C23021(this);
    private final ServiceConnection cEI = new C23043(this);
    private final ServiceConnection cEJ = new C23054(this);
    protected MFDeviceService cEw;
    protected boolean cEx;
    protected boolean cEy;
    protected Toolbar cEz;
    protected ImageView cuE;
    private Handler mHandler = new Handler();
    public UserRepository mUserRepository;

    class C23021 extends BroadcastReceiver {
        final /* synthetic */ ctj cEK;

        C23021(ctj com_fossil_ctj) {
            this.cEK = com_fossil_ctj;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                CommunicateMode communicateMode = CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())];
                int intExtra = intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1);
                if (intExtra != -1 && intExtra != ServiceActionResult.PROCESSING.ordinal()) {
                    PortfolioApp.ZQ().m12690a(communicateMode);
                }
            }
        }
    }

    class C23032 implements Runnable {
        final /* synthetic */ ctj cEK;

        C23032(ctj com_fossil_ctj) {
            this.cEK = com_fossil_ctj;
        }

        public void run() {
            if (this.cEK.getSupportFragmentManager().getBackStackEntryCount() > 1) {
                this.cEK.getSupportFragmentManager().popBackStack();
            } else {
                this.cEK.finish();
            }
        }
    }

    class C23043 implements ServiceConnection {
        final /* synthetic */ ctj cEK;

        C23043(ctj com_fossil_ctj) {
            this.cEK = com_fossil_ctj;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MFLogger.m12670d(this.cEK.TAG, "Button service connected");
            ctj.cmE = Stub.asInterface(iBinder);
            this.cEK.cEy = true;
            PortfolioApp.m12674a(ctj.cmE);
            this.cEK.afJ();
            try {
                MFUser currentUser = this.cEK.mUserRepository.getCurrentUser();
                if (!(currentUser == null || ctj.cmE == null)) {
                    ctj.cmE.updateUserId(currentUser.getUserId());
                }
                this.cEK.afS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            MFLogger.m12670d(this.cEK.TAG, "Button service disconnected");
            this.cEK.cEy = false;
            ctj.cmE = null;
        }
    }

    class C23054 implements ServiceConnection {
        final /* synthetic */ ctj cEK;

        C23054(ctj com_fossil_ctj) {
            this.cEK = com_fossil_ctj;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MFLogger.m12670d(this.cEK.TAG, "Misfit service connected");
            C3908b c3908b = (C3908b) iBinder;
            this.cEK.cEw = c3908b.afj();
            PortfolioApp.m12676a(c3908b);
            this.cEK.cEx = true;
            this.cEK.afI();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.cEK.cEx = false;
            this.cEK.cEw = null;
        }
    }

    class C23076 implements Runnable {
        final /* synthetic */ ctj cEK;

        C23076(ctj com_fossil_ctj) {
            this.cEK = com_fossil_ctj;
        }

        public void run() {
            try {
                if (this.cEK.cEG == null) {
                    this.cEK.cEG = (drq) this.cEK.getSupportFragmentManager().mo3086W(drq.TAG);
                }
                if (this.cEK.cEG != null) {
                    MFLogger.m12670d(drq.TAG, "hideLoadingDialog dismissAllowingStateLoss");
                    this.cEK.cEG.dismissAllowingStateLoss();
                    this.cEK.cEG = null;
                }
            } catch (Exception e) {
                MFLogger.m12670d(this.cEK.TAG, "Exception when dismiss progress dialog=" + e);
            }
        }
    }

    protected void onStart() {
        super.onStart();
        ZY();
        if (this.mUserRepository.getCurrentUser() == null) {
        }
        if (this.mUserRepository.getCurrentUser() != null) {
            if (PortfolioApp.ZR() == null) {
                PortfolioApp.ZQ().ZZ();
            }
            Intent intent = new Intent(this, ButtonService.class);
            startService(intent);
            bindService(intent, this.cEI, 1);
        }
        afF();
    }

    private void afF() {
        getWindow().setSoftInputMode(32);
    }

    protected void ZY() {
        Intent intent = new Intent(this, MFDeviceService.class);
        startService(intent);
        bindService(intent, this.cEJ, 0);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.cEz = (Toolbar) findViewById(R.id.toolbar);
        if (this.cEz != null) {
            m6459a(this.cEz);
            if (VERSION.SDK_INT < 21) {
                TextView afG = afG();
                if (afG != null) {
                    if (PortfolioApp.ZQ().aag() == FossilBrand.EA) {
                        afG.setAllCaps(true);
                    }
                    afG.setTypeface(PortfolioApp.ZV());
                }
            }
            jO(R.drawable.ic_close_dark);
            cnc.m7185a(this.cEz, this);
        }
    }

    public void m6647j(int i, int i2, int i3, int i4, int i5) {
        if (i > 0) {
            this.cuE = (ImageView) findViewById(R.id.iv_toolbar_left);
            this.cuE.setImageResource(i);
            this.cuE.setVisibility(0);
            this.cuE.setOnClickListener(this);
        }
        if (i3 > 0) {
            this.cEA = (FlexibleTextView) findViewById(R.id.ftv_toolbar_title);
            this.cEA.setText(getResources().getString(i3));
            this.cEA.setVisibility(0);
        }
        if (i4 > 0) {
            this.cED = (ImageView) findViewById(R.id.iv_toolbar_right);
            this.cED.setImageResource(i);
            this.cuE.setVisibility(0);
            this.cuE.setOnClickListener(this);
        }
        if (i2 > 0) {
            this.cEB = (FlexibleTextView) findViewById(R.id.tv_toolbar_left);
            this.cEB.setText(getResources().getString(i2));
            this.cEB.setVisibility(0);
            this.cEB.setOnClickListener(this);
        }
        if (i5 > 0) {
            this.cEC = (FlexibleTextView) findViewById(R.id.tv_toolbar_right);
            this.cEC.setText(getResources().getString(i5));
            this.cEC.setVisibility(0);
            this.cEC.setOnClickListener(this);
        }
    }

    protected void jO(int i) {
        ActionBar lp = lp();
        if (lp != null) {
            lp.setDisplayHomeAsUpEnabled(true);
            lp.setHomeAsUpIndicator(i);
        }
    }

    protected TextView afG() {
        CharSequence title;
        ActionBar lp = lp();
        if (lp != null) {
            title = lp.getTitle();
        } else {
            title = null;
        }
        CharSequence title2 = TextUtils.isEmpty(title) ? this.cEz.getTitle() : title;
        if (TextUtils.isEmpty(title2)) {
            return null;
        }
        for (int i = 0; i < this.cEz.getChildCount(); i++) {
            View childAt = this.cEz.getChildAt(i);
            if (childAt != null && (childAt instanceof TextView)) {
                TextView textView = (TextView) childAt;
                CharSequence text = textView.getText();
                if (PortfolioApp.ZQ().aag() == FossilBrand.EA) {
                    text = textView.getText().toString().toUpperCase();
                    textView.setAllCaps(true);
                }
                if (!TextUtils.isEmpty(text) && title2.equals(text) && textView.getId() == -1) {
                    return textView;
                }
            }
        }
        return null;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (afQ()) {
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        PortfolioApp.ZQ().aam().mo1836a(this);
        cns.adq().adr();
        getWindow().getDecorView().setSystemUiVisibility(3328);
        this.cEE = cmj.bs(PortfolioApp.ZQ());
    }

    protected void afH() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_base_background);
        if (imageView != null) {
            tx.a(this).a(Integer.valueOf(R.drawable.fs_background)).c(imageView);
        }
    }

    public void onResume() {
        super.onResume();
        afH();
        PortfolioApp.cM(this);
        gy.m11536p(this).m11537a(this.cEH, new IntentFilter(PortfolioApp.ZQ().getPackageName().concat(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            abm.xd().aHj.au(currentUser.getUserId());
            abm.xd().aHj.setString("UserId", currentUser.getUserId());
        }
        ck(false);
        if (PortfolioApp.cmB) {
            cns.adq().adr();
        }
    }

    public void onPause() {
        super.onPause();
        gy.m11536p(this).unregisterReceiver(this.cEH);
        try {
            PortfolioApp.cN(this);
        } catch (Exception e) {
            MFLogger.m12671e(this.TAG, "Inside " + this.TAG + ".onPause - exception=" + e);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        runOnUiThread(new C23032(this));
    }

    public void onStop() {
        super.onStop();
        if (this.cEx) {
            MFLogger.m12670d(this.TAG, "Unbinding from misfitService");
            unbindService(this.cEJ);
            this.cEx = false;
        }
        if (this.cEy) {
            MFLogger.m12670d(this.TAG, "Unbinding from buttonServiceBound");
            unbindService(this.cEI);
            this.cEy = false;
        }
    }

    private void afI() {
        MFLogger.m12670d(this.TAG, "onMisfitServiceBound bound");
    }

    private void afJ() {
        MFLogger.m12670d(this.TAG, "onButtonServiceBound bound");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                afK();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void afK() {
        try {
            fl.m11438f(this);
        } catch (IllegalArgumentException e) {
            finish();
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        System.runFinalization();
    }

    public void afL() {
        cj(false);
    }

    public void cj(final boolean z) {
        MFLogger.m12670d(drq.TAG, "showLoadingDialog: cancelable = " + z);
        afM();
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ ctj cEK;

            public void run() {
                try {
                    if (this.cEK.isDestroyed() || this.cEK.isFinishing()) {
                        MFLogger.m12670d(this.cEK.TAG, "Activity is destroy or finishing, no need to show dialog");
                        return;
                    }
                    this.cEK.cEG = new drq();
                    this.cEK.cEG.setCancelable(z);
                    fg hW = this.cEK.getSupportFragmentManager().hW();
                    hW.mo2968a(this.cEK.cEG, drq.TAG);
                    hW.commitAllowingStateLoss();
                } catch (Exception e) {
                    MFLogger.m12670d(this.cEK.TAG, "Exception when showing progress dialog=" + e);
                }
            }
        });
    }

    public void afM() {
        MFLogger.m12670d(drq.TAG, "hideLoadingDialog");
        this.mHandler.post(new C23076(this));
    }

    public void mo1746a(String str, int i, Intent intent) {
        MFLogger.m12670d(this.TAG, "Inside .onDialogFragmentResult tag=" + str);
        Object obj = -1;
        switch (str.hashCode()) {
            case 1008390942:
                if (str.equals("NO_INTERNET_CONNECTION")) {
                    obj = null;
                    break;
                }
                break;
            case 1156423641:
                if (str.equals("DEVICE_NOT_SUPPORTED")) {
                    obj = 3;
                    break;
                }
                break;
            case 1925385819:
                if (str.equals("DEVICE_CONNECT_FAILED")) {
                    obj = 2;
                    break;
                }
                break;
            case 2009556792:
                if (str.equals("NOTIFICATION_ACCESS")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                switch (i) {
                    case R.id.ftv_go_to_setting:
                        afN();
                        return;
                    default:
                        return;
                }
            case 1:
                switch (i) {
                    case R.id.ftv_go_to_setting:
                        afO();
                        return;
                    default:
                        return;
                }
            case 2:
                switch (i) {
                    case R.id.fb_help:
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                        return;
                    case R.id.iv_close:
                    case R.id.fb_tryagain:
                        finish();
                        return;
                    case R.id.ftv_desc_2:
                        dqw.m9447w(getSupportFragmentManager());
                        return;
                    default:
                        return;
                }
            case 3:
                switch (i) {
                    case R.id.fb_help:
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLHelper.a(StaticPage.SUPPORT, null))));
                        return;
                    case R.id.fb_download_aw:
                        m6648n("device_not_supported", "App", "Android_Wear");
                        if (hE("com.google.android.wearable.app")) {
                            hF("com.google.android.wearable.app");
                            return;
                        } else {
                            hG("com.google.android.wearable.app");
                            return;
                        }
                    case R.id.fb_download_legacy:
                        m6648n("device_not_supported", "App", "QLegacy");
                        if (hE("com.fossil.qlegacy")) {
                            hF("com.fossil.qlegacy");
                            return;
                        } else {
                            hG("com.fossil.qlegacy");
                            return;
                        }
                    default:
                        return;
                }
            default:
                return;
        }
    }

    protected void afN() {
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    protected void afO() {
        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    public boolean hE(String str) {
        return AppType.isInstalled(this, str);
    }

    public void hF(String str) {
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            }
        } catch (Exception e) {
            MFLogger.m12671e(this.TAG, "Exception when start activity with packageName=" + str);
        }
    }

    public void hG(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_left:
                finish();
                return;
            default:
                return;
        }
    }

    private boolean jP(int i) {
        return 1.0d - ((((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i)))) / 255.0d) >= 0.5d;
    }

    @TargetApi(23)
    protected void jQ(int i) {
        if (VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(i);
            }
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (jP(i)) {
                decorView.setSystemUiVisibility(systemUiVisibility & -8193);
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility | Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
            decorView.setBackgroundColor(i);
        }
    }

    @TargetApi(23)
    protected void ck(boolean z) {
        if (VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                decorView.setSystemUiVisibility(systemUiVisibility & -8193);
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility | Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        if (intent == null) {
            intent = new Intent();
        }
        super.startActivityForResult(intent, i);
    }

    protected void m6642a(Fragment fragment, int i) {
        m6643a(fragment, null, i);
    }

    protected void m6646b(Fragment fragment, String str) {
        m6643a(fragment, str, (int) R.id.content);
    }

    public void m6643a(Fragment fragment, String str, int i) {
        getSupportFragmentManager().hW().mo2970b(i, fragment, str).mo2964T(str).commitAllowingStateLoss();
    }

    public void onTokenExpired() {
        MFLogger.m12671e(this.TAG, "Token expired, force user logout");
        afP();
    }

    protected void afP() {
        cnq.acd().reset();
        clv.reset();
        this.cEF.reset();
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            this.mUserRepository.deleteUser(currentUser, null);
        }
        WelcomeActivity.bJ(this);
        finish();
    }

    public void onServerMaintenance() {
    }

    public void mo1745a(int i, List<String> list) {
    }

    public void mo1747b(int i, List<String> list) {
    }

    public void finish() {
        super.finish();
        if (afQ()) {
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    private boolean afQ() {
        return afR() == R.style.AppTheme.ScreenTransition;
    }

    private int afR() {
        try {
            Method method = Context.class.getMethod("getThemeResId", new Class[0]);
            method.setAccessible(true);
            return ((Integer) method.invoke(this, new Object[0])).intValue();
        } catch (NoSuchMethodException e) {
            MFLogger.m12670d(this.TAG, "Failed to get theme resource ID");
            return 0;
        } catch (IllegalAccessException e2) {
            MFLogger.m12670d(this.TAG, "Failed to get theme resource ID");
            return 0;
        } catch (IllegalArgumentException e3) {
            MFLogger.m12670d(this.TAG, "Failed to get theme resource ID");
            return 0;
        } catch (InvocationTargetException e4) {
            MFLogger.m12670d(this.TAG, "Failed to get theme resource ID");
            return 0;
        }
    }

    protected void m6648n(String str, String str2, String str3) {
        this.cEE.m7086l(str, str2, str3);
    }

    private synchronized void afS() {
        MFLogger.m12670d(this.TAG, "needToUpdateBLEWhenUpgradeLegacy - isNeedToUpdateBLE=" + this.cEF.adn());
        if (this.cEF.adn()) {
            try {
                cnn.m7224b(this.cEF);
            } catch (Exception e) {
                MFLogger.m12671e(this.TAG, "needToUpdateBLEWhenUpgradeLegacy - e=" + e);
            }
        }
    }
}
