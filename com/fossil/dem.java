package com.fossil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.del.C2707a;
import com.fossil.del.C2708b;
import com.fossil.drk.C2095b;
import com.fossil.drk.C3126a;
import com.fossil.wearables.fossil.R;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.HeightFormatter;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.enums.Gender;
import com.portfolio.platform.enums.Unit;
import com.portfolio.platform.helper.ImageHelper;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

public class dem extends ctm implements OnClickListener, C2708b, C2095b {
    private static final String TAG = dem.class.getSimpleName();
    ImageView cRQ;
    FlexibleTextView cRR;
    FossilCircleImageView cRS;
    FlexibleEditText cRT;
    FlexibleEditText cRU;
    FlexibleEditText cRV;
    FlexibleEditText cRW;
    FlexibleEditText cRX;
    FlexibleEditText cRY;
    FlexibleButton cRZ;
    FlexibleButton cSa;
    FlexibleButton cSb;
    MFUser cSc;
    MFUser cSd;
    private C2707a cSe;
    private boolean cSf;

    static /* synthetic */ class C27102 {
        static final /* synthetic */ int[] cSi = new int[Unit.values().length];

        static {
            cSj = new int[Gender.values().length];
            try {
                cSj[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cSj[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                cSj[Gender.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                cSi[Unit.METRIC.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                cSi[Unit.IMPERIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8432a((C2707a) obj);
    }

    public static dem ant() {
        return new dem();
    }

    public void m8432a(C2707a c2707a) {
        this.cSe = (C2707a) cco.ce(c2707a);
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edit_profile, viewGroup, false);
        this.cRQ = (ImageView) inflate.findViewById(R.id.left_icon);
        this.cRR = (FlexibleTextView) inflate.findViewById(R.id.save);
        this.cRS = (FossilCircleImageView) inflate.findViewById(R.id.avatar);
        this.cRT = (FlexibleEditText) inflate.findViewById(R.id.edit_first_name);
        this.cRU = (FlexibleEditText) inflate.findViewById(R.id.edit_last_name);
        this.cRV = (FlexibleEditText) inflate.findViewById(R.id.edit_email);
        this.cRW = (FlexibleEditText) inflate.findViewById(R.id.edit_height);
        this.cRX = (FlexibleEditText) inflate.findViewById(R.id.edit_weight);
        this.cRY = (FlexibleEditText) inflate.findViewById(R.id.edit_dob);
        this.cRY.setTextColor(PortfolioApp.ZQ().getResources().getColor(R.color.fossilCoolGray));
        this.cRV.setTextColor(PortfolioApp.ZQ().getResources().getColor(R.color.fossilCoolGray));
        this.cRZ = (FlexibleButton) inflate.findViewById(R.id.fb_male);
        this.cSa = (FlexibleButton) inflate.findViewById(R.id.fb_female);
        this.cSb = (FlexibleButton) inflate.findViewById(R.id.fb_other);
        this.cRQ.setOnClickListener(this);
        this.cRR.setOnClickListener(this);
        this.cRS.setOnClickListener(this);
        this.cRW.setOnClickListener(this);
        this.cRX.setOnClickListener(this);
        this.cRZ.setOnClickListener(this);
        this.cSa.setOnClickListener(this);
        this.cSb.setOnClickListener(this);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cSe.start();
    }

    public void onPause() {
        super.onPause();
        this.cSe.stop();
    }

    public void alF() {
        afT();
    }

    public void alG() {
        afU();
    }

    public void finish() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            getActivity().finish();
        }
    }

    public void mo2355f(MFUser mFUser) {
        if (!this.cSf) {
            this.cSd = mFUser;
            this.cSc = new MFUser(mFUser);
            this.cSf = true;
        }
        String profilePicture = this.cSd.getProfilePicture();
        if (TextUtils.isEmpty(profilePicture) || !(URLUtil.isHttpUrl(profilePicture) || URLUtil.isHttpsUrl(profilePicture))) {
            tx.t(this).a(new cmg()).bc(new cmb("", this.cSd.getFirstName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.cSd.getLastName())).b(new xq[]{new cmn(getContext())}).c(this.cRS);
            this.cRS.setBorderColor(PortfolioApp.ZQ().getResources().getColor(R.color.gray));
            this.cRS.setBorderWidth(3);
            this.cRS.setBackground(PortfolioApp.ZQ().getResources().getDrawable(R.drawable.oval_solid_light_grey));
        } else {
            this.cRS.m12733a(profilePicture, tx.t(this));
        }
        this.cRT.setText(this.cSd.getFirstName());
        this.cRU.setText(this.cSd.getLastName());
        this.cRV.setText(this.cSd.getEmail());
        String str = "";
        CharSequence charSequence = "";
        switch (C27102.cSi[this.cSd.getHeightUnit().ordinal()]) {
            case 1:
                charSequence = this.cSd.getHeightInCentimeters() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Centimeters_cm);
                break;
            case 2:
                Pair av = cmo.av((float) mFUser.getHeightInCentimeters());
                charSequence = String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.setting_units_height_imperial), new Object[]{String.valueOf(av.first), String.valueOf(av.second)});
                break;
        }
        this.cRW.setText(charSequence);
        switch (C27102.cSi[this.cSd.getWeightUnit().ordinal()]) {
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
        this.cRX.setText(charSequence);
        try {
            this.cRY.setText(new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(new SimpleDateFormat("yyyy-MM-dd").parse(this.cSd.getBirthday())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        m8433a(this.cSd.getGender());
    }

    public void m8433a(Gender gender) {
        this.cSa.setTextColor(getResources().getColor(R.color.fossilCoolGray));
        this.cRZ.setTextColor(getResources().getColor(R.color.fossilCoolGray));
        this.cSb.setTextColor(getResources().getColor(R.color.fossilCoolGray));
        this.cSa.setBackgroundResource(R.drawable.background_white_border);
        this.cRZ.setBackgroundResource(R.drawable.background_white_border);
        this.cSb.setBackgroundResource(R.drawable.background_white_border);
        switch (gender) {
            case FEMALE:
                this.cSa.setTextColor(getResources().getColor(R.color.fossilWhite));
                this.cSa.setBackgroundResource(R.drawable.background_charcoal_border);
                return;
            case MALE:
                this.cRZ.setTextColor(getResources().getColor(R.color.fossilWhite));
                this.cRZ.setBackgroundResource(R.drawable.background_charcoal_border);
                return;
            case OTHER:
                this.cSb.setTextColor(getResources().getColor(R.color.fossilWhite));
                this.cSb.setBackgroundResource(R.drawable.background_charcoal_border);
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        int heightInCentimeters;
        switch (view.getId()) {
            case R.id.save:
                anu();
                return;
            case R.id.left_icon:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    if (anv() && isActive()) {
                        dqw.m9432h(getChildFragmentManager());
                        return;
                    } else {
                        getActivity().finish();
                        return;
                    }
                }
                return;
            case R.id.avatar:
                doCameraTask();
                return;
            case R.id.edit_height:
                switch (C27102.cSi[this.cSd.getHeightUnit().ordinal()]) {
                    case 1:
                        heightInCentimeters = this.cSd.getHeightInCentimeters();
                        C3126a w = new C3126a(R.layout.edit_one_picker_dialog_fragment).lB(R.id.ftv_ok).lB(R.id.ftv_cancel).m9498w(R.id.title, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Height_Title_Height)).m9498w(R.id.description, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Height_Subtitle_In_Centimeters)).m9498w(R.id.ftv_cancel, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Height_CTA_CANCEL)).m9498w(R.id.ftv_ok, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Height_CTA_OK));
                        if (heightInCentimeters == 0) {
                            heightInCentimeters = 170;
                        }
                        w.m9499y(R.id.number_picker_one, 1, 300, heightInCentimeters).m9495c(getChildFragmentManager(), "USER_EDIT_HEIGHT_METRIC");
                        return;
                    case 2:
                        heightInCentimeters = this.cSd.getHeightInCentimeters();
                        Pair av = cmo.av(heightInCentimeters == 0 ? 170.0f : (float) heightInCentimeters);
                        new C3126a(R.layout.edit_height_imperial_dialog_fragment).lB(R.id.ftv_ok).lB(R.id.ftv_cancel).m9490a(R.id.number_picker_one, 1, 9, ((Integer) av.first).intValue(), new HeightFormatter(0)).m9490a(R.id.number_picker_two, 0, 11, ((Integer) av.second).intValue(), new HeightFormatter(1)).m9495c(getChildFragmentManager(), "USER_EDIT_HEIGHT_IMPERIAL");
                        return;
                    default:
                        return;
                }
            case R.id.edit_weight:
                switch (C27102.cSi[this.cSd.getWeightUnit().ordinal()]) {
                    case 1:
                        heightInCentimeters = this.cSd.getWeightInGrams();
                        new C3126a(R.layout.edit_one_picker_dialog_fragment).lB(R.id.ftv_ok).lB(R.id.ftv_cancel).m9498w(R.id.title, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_Title_Weight)).m9498w(R.id.description, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_Subtitle_In_Kilograms)).m9498w(R.id.ftv_cancel, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_CTA_CANCEL)).m9498w(R.id.ftv_ok, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_CTA_OK)).m9499y(R.id.number_picker_one, 22, 226, heightInCentimeters == 0 ? 68 : heightInCentimeters / 1000).m9495c(getChildFragmentManager(), "USER_EDIT_WEIGHT_METRIC");
                        return;
                    case 2:
                        heightInCentimeters = this.cSd.getWeightInGrams();
                        new C3126a(R.layout.edit_one_picker_dialog_fragment).lB(R.id.ftv_ok).lB(R.id.ftv_cancel).m9498w(R.id.title, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_Title_Weight)).m9498w(R.id.description, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_Subtitle_In_Pounds)).m9498w(R.id.ftv_cancel, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_CTA_CANCEL)).m9498w(R.id.ftv_ok, arp.m4318u(getContext(), R.string.Stats_Activity_Info_Weight_CTA_OK)).m9499y(R.id.number_picker_one, 50, MFNetworkReturnCode.INTERNAL_SERVER_ERROR, (int) cmo.aA(heightInCentimeters == 0 ? 68039.0f : (float) heightInCentimeters)).m9495c(getChildFragmentManager(), "USER_EDIT_WEIGHT_IMPERIAL");
                        return;
                    default:
                        return;
                }
            case R.id.fb_male:
                m8433a(Gender.MALE);
                this.cSd.setGender(Gender.MALE.toString());
                return;
            case R.id.fb_female:
                m8433a(Gender.FEMALE);
                this.cSd.setGender(Gender.FEMALE.toString());
                return;
            case R.id.fb_other:
                m8433a(Gender.OTHER);
                this.cSd.setGender(Gender.OTHER.toString());
                return;
            default:
                return;
        }
    }

    protected void anu() {
        this.cSd.setFirstName(this.cRT.getEditableText().toString());
        this.cSd.setLastName(this.cRU.getEditableText().toString());
        if (!TextUtils.isEmpty(this.cSd.getProfilePicture()) && this.cSd.getProfilePicture().contains(UpPlatformSdkConstants.URI_SCHEME)) {
            this.cSd.setProfilePicture("");
        }
        this.cSe.mo2358e(this.cSd);
    }

    private boolean anv() {
        return (this.cSc.getFirstName().equals(this.cRT.getEditableText().toString()) && this.cSc.getLastName().equals(this.cRU.getEditableText().toString()) && this.cSc.getHeightInCentimeters() == this.cSd.getHeightInCentimeters() && this.cSc.getWeightInGrams() == this.cSd.getWeightInGrams() && this.cSc.getGender().toString().equals(this.cSd.getGender().toString())) ? false : true;
    }

    public void mo1746a(String str, int i, Intent intent) {
        String str2 = "";
        str2 = "";
        int i2 = -1;
        switch (str.hashCode()) {
            case -2135951545:
                if (str.equals("USER_EDIT_HEIGHT_METRIC")) {
                    i2 = 0;
                    break;
                }
                break;
            case -1375614559:
                if (str.equals("UNSAVED_CHANGE")) {
                    i2 = 4;
                    break;
                }
                break;
            case 347474450:
                if (str.equals("USER_EDIT_HEIGHT_IMPERIAL")) {
                    i2 = 1;
                    break;
                }
                break;
            case 1485915105:
                if (str.equals("USER_EDIT_WEIGHT_IMPERIAL")) {
                    i2 = 3;
                    break;
                }
                break;
            case 2052937942:
                if (str.equals("USER_EDIT_WEIGHT_METRIC")) {
                    i2 = 2;
                    break;
                }
                break;
        }
        CharSequence charSequence;
        switch (i2) {
            case 0:
                switch (i) {
                    case R.id.ftv_ok:
                        i2 = ((Integer) ((HashMap) intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS")).get(Integer.valueOf(R.id.number_picker_one))).intValue();
                        Log.d(TAG, "USER_EDIT_HEIGHT_METRIC = " + i2);
                        charSequence = i2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Centimeters_cm);
                        this.cSd.setHeightInCentimeters(i2);
                        this.cRW.setText(charSequence);
                        return;
                    default:
                        return;
                }
            case 1:
                switch (i) {
                    case R.id.ftv_ok:
                        HashMap hashMap = (HashMap) intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS");
                        int intValue = ((Integer) hashMap.get(Integer.valueOf(R.id.number_picker_one))).intValue();
                        Log.d(TAG, "USER_EDIT_HEIGHT_IMPERIAL = " + intValue);
                        i2 = ((Integer) hashMap.get(Integer.valueOf(R.id.number_picker_two))).intValue();
                        Log.d(TAG, "USER_EDIT_HEIGHT_IMPERIAL = " + i2);
                        CharSequence format = String.format(arp.m4318u(PortfolioApp.ZQ(), R.string.setting_units_height_imperial), new Object[]{String.valueOf(intValue), String.valueOf(i2)});
                        this.cSd.setHeightInCentimeters((int) cmo.m7102B((float) intValue, (float) i2));
                        this.cRW.setText(format);
                        return;
                    default:
                        return;
                }
            case 2:
                switch (i) {
                    case R.id.ftv_ok:
                        i2 = ((Integer) ((HashMap) intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS")).get(Integer.valueOf(R.id.number_picker_one))).intValue();
                        Log.d(TAG, "USER_EDIT_WEIGHT_METRIC = " + i2);
                        charSequence = i2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Kilograms_kg);
                        this.cSd.setWeightInGrams(i2 * 1000);
                        this.cRX.setText(charSequence);
                        return;
                    default:
                        return;
                }
            case 3:
                switch (i) {
                    case R.id.ftv_ok:
                        i2 = ((Integer) ((HashMap) intent.getSerializableExtra("EXTRA_NUMBER_PICKER_RESULTS")).get(Integer.valueOf(R.id.number_picker_one))).intValue();
                        Log.d(TAG, "USER_EDIT_WEIGHT_IMPERIAL = " + i2);
                        charSequence = i2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + arp.m4318u(PortfolioApp.ZQ(), R.string.General_Measurement_Abbreviations_Pounds_lbs);
                        this.cSd.setWeightInGrams((int) cmo.aB((float) i2));
                        this.cRX.setText(charSequence);
                        return;
                    default:
                        return;
                }
            case 4:
                switch (i) {
                    case R.id.fb_ok:
                        finish();
                        return;
                    default:
                        return;
                }
            default:
                if (getActivity() != null) {
                    ((ctj) getActivity()).mo1746a(str, i, intent);
                    return;
                }
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
                            final /* synthetic */ dem cSh;

                            public void run() {
                                Exception exception;
                                Bitmap bitmap = null;
                                try {
                                    Bitmap bitmap2 = (Bitmap) tx.t(this.cSh).g(a).tA().a(new xq[]{new cmn(PortfolioApp.ZQ())}).a(DiskCacheStrategy.NONE).ay(true).bc(MFNetworkReturnCode.RESPONSE_OK, MFNetworkReturnCode.RESPONSE_OK).get();
                                    try {
                                        this.cSh.cSd.setProfilePicture(dqq.m9401t(bitmap2));
                                        MFLogger.m12670d(dem.TAG, "Encode base 64 image");
                                        bitmap = bitmap2;
                                    } catch (Exception e) {
                                        Exception exception2 = e;
                                        bitmap = bitmap2;
                                        exception = exception2;
                                        exception.printStackTrace();
                                        if (this.cSh.isActive()) {
                                            dqw.m9434j(this.cSh.getFragmentManager());
                                        }
                                        if (bitmap == null) {
                                            bitmap.recycle();
                                        }
                                    }
                                } catch (Exception e2) {
                                    exception = e2;
                                    exception.printStackTrace();
                                    if (this.cSh.isActive()) {
                                        dqw.m9434j(this.cSh.getFragmentManager());
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

    @euz(1222)
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
        dre.dff.m9461a((Fragment) this, 1222, strArr);
    }

    protected boolean lM() {
        if (!(getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed())) {
            if (anv() && isActive()) {
                dqw.m9432h(getChildFragmentManager());
            } else {
                getActivity().finish();
            }
        }
        return true;
    }

    public void jV(int i) {
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }
}
