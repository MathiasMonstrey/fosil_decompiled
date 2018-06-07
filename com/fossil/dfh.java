package com.fossil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v8.renderscript.ScriptIntrinsicBLAS;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.dfg.C2718a;
import com.fossil.dfg.C2719b;
import com.fossil.drk.C2095b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.enums.AuthType;
import com.portfolio.platform.enums.Unit;
import com.portfolio.platform.helper.ImageHelper;
import com.portfolio.platform.ui.profile.changepassword.ChangePasswordActivity;
import com.portfolio.platform.ui.profile.preferences.ProfilePrefActivity;
import com.portfolio.platform.ui.profile.support.ProfileSupportActivity;
import com.portfolio.platform.ui.user.WelcomeActivity;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import com.portfolio.platform.view.FossilCircleImageView;
import java.text.NumberFormat;
import java.util.Locale;

public class dfh extends ctm implements OnClickListener, C2719b, C2095b {
    private static final String TAG = dfh.class.getSimpleName();
    private FossilCircleImageView cRS;
    private C2718a cSD;
    private TextView cSE;
    private TextView cSF;
    private TextView cSG;
    private TextView cSH;
    private TextView cSI;
    private TextView cSJ;
    private TextView cSK;
    private TextView cSL;
    private TextView cSM;
    private TextView cSN;
    private TextView cSO;
    private TextView cSP;
    private TextView cSQ;
    private Button cSR;
    private ImageView cSS;
    MFUser cSd;

    static /* synthetic */ class C27212 {
        static final /* synthetic */ int[] cSU = new int[AuthType.values().length];
        static final /* synthetic */ int[] cSi = new int[Unit.values().length];

        static {
            try {
                cSi[Unit.METRIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cSi[Unit.IMPERIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cSU[AuthType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                cSU[AuthType.FACEBOOK.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                cSU[AuthType.GOOGLE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                cSU[AuthType.WECHAT.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                cSU[AuthType.WEIBO.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8462a((C2718a) obj);
    }

    public static dfh anH() {
        return new dfh();
    }

    public void m8462a(C2718a c2718a) {
        this.cSD = (C2718a) cco.ce(c2718a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        cR(view);
    }

    private void cR(View view) {
        this.cRS = (FossilCircleImageView) view.findViewById(R.id.avatar);
        this.cSE = (TextView) view.findViewById(R.id.user_name);
        this.cSF = (TextView) view.findViewById(R.id.member_since);
        this.cSG = (TextView) view.findViewById(R.id.email);
        this.cSH = (TextView) view.findViewById(R.id.change_pass);
        this.cSI = (TextView) view.findViewById(R.id.height_number);
        this.cSJ = (TextView) view.findViewById(R.id.weight_number);
        this.cSK = (TextView) view.findViewById(R.id.step_number);
        this.cSL = (TextView) view.findViewById(R.id.sleep_number);
        this.cSM = (TextView) view.findViewById(R.id.delete_account);
        this.cSR = (Button) view.findViewById(R.id.log_out_button);
        this.cSN = (TextView) view.findViewById(R.id.pref);
        this.cSO = (TextView) view.findViewById(R.id.support);
        this.cSP = (TextView) view.findViewById(R.id.term_of_service);
        this.cSQ = (TextView) view.findViewById(R.id.privacy_policy);
        this.cSS = (ImageView) view.findViewById(R.id.iv_auth_type);
        this.cSN.setOnClickListener(this);
        this.cSO.setOnClickListener(this);
        this.cSM.setOnClickListener(this);
        this.cSR.setOnClickListener(this);
        this.cSH.setOnClickListener(this);
        this.cSP.setOnClickListener(this);
        this.cSQ.setOnClickListener(this);
        this.cRS.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        this.cSD.start();
    }

    public void onPause() {
        super.onPause();
        this.cSD.stop();
    }

    public void alF() {
        afT();
    }

    public void alG() {
        afU();
    }

    public void mo2364f(MFUser mFUser) {
        this.cSd = mFUser;
        this.cSE.setText(this.cSd.getFirstName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.cSd.getLastName());
        if (!TextUtils.isEmpty(this.cSd.getRegisterDate())) {
            this.cSF.setText(String.format(PortfolioApp.ZQ().getResources().getString(R.string.Profile_Profile_Text_Member_since_year), new Object[]{this.cSd.getRegisterDate().substring(0, 4)}));
        }
        this.cSG.setText(this.cSd.getEmail());
        this.cSK.setText(NumberFormat.getNumberInstance(Locale.US).format((long) this.cSd.getAverageStep()));
        this.cSL.setText(cnf.m7188G(PortfolioApp.ZQ(), this.cSd.getAverageSleep()));
        String profilePicture = this.cSd.getProfilePicture();
        MFLogger.m12670d(TAG, "receiveUser profileUrl=" + profilePicture);
        if (TextUtils.isEmpty(profilePicture) || !(URLUtil.isHttpUrl(profilePicture) || URLUtil.isHttpsUrl(profilePicture))) {
            tx.t(this).a(new cmg()).bc(new cmb(this.cSd.getProfilePicture(), this.cSd.getFirstName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.cSd.getLastName())).b(new xq[]{new cmn(getContext())}).c(this.cRS);
            this.cRS.setBorderColor(PortfolioApp.ZQ().getResources().getColor(R.color.gray));
            this.cRS.setBorderWidth(3);
            this.cRS.setBackground(PortfolioApp.ZQ().getResources().getDrawable(R.drawable.oval_solid_light_grey));
        } else {
            this.cRS.m12733a(profilePicture, tx.t(this));
            this.cRS.setBorderColor(PortfolioApp.ZQ().getResources().getColor(R.color.transparent));
        }
        LayoutParams layoutParams = this.cSS.getLayoutParams();
        switch (C27212.cSU[this.cSd.getAuthType().ordinal()]) {
            case 1:
                this.cSS.setImageResource(R.drawable.ic_login_email);
                break;
            case 2:
                this.cSS.setImageResource(R.drawable.ic_fb);
                this.cSH.setVisibility(8);
                break;
            case 3:
                this.cSS.setImageResource(R.drawable.ic_login_google);
                this.cSH.setVisibility(8);
                break;
            case 4:
                this.cSS.setImageResource(R.drawable.ic_onboarding_wechat);
                layoutParams.width = PortfolioApp.ZQ().getResources().getDimensionPixelSize(R.dimen.dp70);
                this.cSH.setVisibility(8);
                break;
            case 5:
                this.cSS.setImageResource(R.drawable.ic_onboarding_weibo);
                int dimensionPixelSize = PortfolioApp.ZQ().getResources().getDimensionPixelSize(R.dimen.dp30);
                layoutParams.height = dimensionPixelSize;
                layoutParams.width = dimensionPixelSize;
                this.cSG.getLayoutParams().height = dimensionPixelSize;
                this.cSH.setVisibility(8);
                break;
        }
        String str = "";
        CharSequence charSequence = "";
        switch (C27212.cSi[this.cSd.getHeightUnit().ordinal()]) {
            case 1:
                charSequence = this.cSd.getHeightInCentimeters() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Centimeters_cm);
                break;
            case 2:
                Pair av = cmo.av((float) this.cSd.getHeightInCentimeters());
                charSequence = String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.setting_units_height_imperial), new Object[]{String.valueOf(av.first), String.valueOf(av.second)});
                break;
        }
        this.cSI.setText(charSequence);
        switch (C27212.cSi[this.cSd.getWeightUnit().ordinal()]) {
            case 1:
                charSequence = ((int) cmo.az((float) this.cSd.getWeightInGrams())) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Kilograms_kg);
                break;
            case 2:
                charSequence = ((int) cmo.aA((float) (this.cSd.getWeightInGrams() + 1))) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Pounds_lbs);
                break;
            default:
                charSequence = str;
                break;
        }
        this.cSJ.setText(charSequence);
    }

    public void anF() {
        if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
            WelcomeActivity.bJ(getActivity());
            Log.d(TAG, "onDeleteUser successfully");
        }
    }

    public void anG() {
        if (getActivity() != null && !getActivity().isDestroyed() && !getActivity().isFinishing()) {
            WelcomeActivity.bJ(getActivity());
            Log.d(TAG, "onLogOutUser successfully");
        }
    }

    public void kY(int i) {
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_button:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    getActivity().finish();
                    return;
                }
                return;
            case R.id.avatar:
                doCameraTask();
                return;
            case R.id.change_pass:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    ChangePasswordActivity.bF(getActivity());
                    return;
                }
                return;
            case R.id.pref:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    ProfilePrefActivity.bF(getActivity());
                    return;
                }
                return;
            case R.id.support:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    ProfileSupportActivity.bF(getActivity());
                    return;
                }
                return;
            case R.id.term_of_service:
                hY(URLHelper.a(StaticPage.TERMS, null));
                return;
            case R.id.privacy_policy:
                hY(URLHelper.a(StaticPage.PRIVACY, null));
                return;
            case R.id.delete_account:
                if (isActive()) {
                    dqw.m9414F(getChildFragmentManager());
                    return;
                }
                return;
            case R.id.log_out_button:
                cmj.bs(getContext()).logEvent("logout");
                if (isActive()) {
                    dqw.m9415G(getChildFragmentManager());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1234:
                    final Uri a = ImageHelper.a(intent, getActivity());
                    MFLogger.m12670d(TAG, "Inside .onActivityResult imageUri=" + a);
                    if (a != null && PortfolioApp.ZQ().m12694a(intent, a)) {
                        this.cRS.m12732a(a, tx.t(this));
                        new Thread(new Runnable(this) {
                            final /* synthetic */ dfh cST;

                            public void run() {
                                Exception exception;
                                Bitmap bitmap = null;
                                try {
                                    Bitmap bitmap2 = (Bitmap) tx.t(this.cST).g(a).tA().a(new xq[]{new cmn(this.cST.getContext())}).a(DiskCacheStrategy.NONE).ay(true).bc(MFNetworkReturnCode.RESPONSE_OK, MFNetworkReturnCode.RESPONSE_OK).get();
                                    try {
                                        this.cST.cSd.setProfilePicture(dqq.m9401t(bitmap2));
                                        MFLogger.m12670d(dfh.TAG, "Encode base 64 image");
                                        this.cST.cSD.mo2368e(this.cST.cSd);
                                        bitmap = bitmap2;
                                    } catch (Exception e) {
                                        Exception exception2 = e;
                                        bitmap = bitmap2;
                                        exception = exception2;
                                        exception.printStackTrace();
                                        if (this.cST.isActive()) {
                                            dqw.m9434j(this.cST.getFragmentManager());
                                        }
                                        if (bitmap == null) {
                                            bitmap.recycle();
                                        }
                                    }
                                } catch (Exception e2) {
                                    exception = e2;
                                    exception.printStackTrace();
                                    if (this.cST.isActive()) {
                                        dqw.m9434j(this.cST.getFragmentManager());
                                    }
                                    if (bitmap == null) {
                                        bitmap.recycle();
                                    }
                                }
                                if (bitmap == null) {
                                    bitmap.recycle();
                                }
                            }
                        }).start();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @euz(122)
    private void doCameraTask() {
        String[] strArr = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (dre.dff.m9462a(getActivity(), strArr)) {
            Intent bx = ImageHelper.bx(getActivity());
            if (bx != null) {
                startActivityForResult(bx, 1234);
                return;
            }
            return;
        }
        dre.dff.m9461a((Fragment) this, (int) ScriptIntrinsicBLAS.LOWER, strArr);
    }

    private void hY(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void mo1746a(String str, int i, Intent intent) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -292748329:
                    if (str.equals("CONFIRM_LOGOUT_ACCOUNT")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1069400824:
                    if (str.equals("CONFIRM_DELETE_ACCOUNT")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    switch (i) {
                        case R.id.fb_ok:
                            this.cSD.mo2367b(cnq.acd().ace().getCurrentUser());
                            return;
                        default:
                            return;
                    }
                case 1:
                    switch (i) {
                        case R.id.fb_ok:
                            this.cSD.anE();
                            return;
                        default:
                            return;
                    }
                default:
                    if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                        ((ctj) getActivity()).mo1746a(str, i, intent);
                        return;
                    }
                    return;
            }
        }
    }
}
