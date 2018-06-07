package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.fossil.dok.C3012a;
import com.fossil.dok.C3013b;
import com.fossil.drk.C2095b;
import com.fossil.drp.C2471a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.enums.Gender;
import com.portfolio.platform.ui.device.link.PairDeviceStartActivity;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.FlexibleTextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

public class dol extends ctm implements OnClickListener, OnCheckedChangeListener, C3013b, C2095b {
    private ImageView cRQ;
    private FlexibleButton cRZ;
    private FlexibleButton cSa;
    private FlexibleButton cSb;
    private FlexibleEditText daZ;
    private FlexibleEditText dbN;
    private FlexibleEditText dbO;
    private FlexibleEditText dbP;
    private FlexibleTextView dbQ;
    private FlexibleTextView dbR;
    private FlexibleTextView dbS;
    private FlexibleTextView dbT;
    private FlexibleButton dbU;
    private CheckBox dbV;
    private CheckBox dbW;
    private C3012a dbX;
    private final SimpleDateFormat dbY = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private final SimpleDateFormat dbZ = new SimpleDateFormat("MM/dd/yy", Locale.getDefault());
    private FlexibleEditText dbm;
    private final Calendar dca = Calendar.getInstance();
    private boolean dcb;

    class C30141 implements TextWatcher {
        final /* synthetic */ dol dcc;

        C30141(dol com_fossil_dol) {
            this.dcc = com_fossil_dol;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.dcc.dbX.jb(editable.toString());
        }
    }

    class C30152 implements TextWatcher {
        final /* synthetic */ dol dcc;

        C30152(dol com_fossil_dol) {
            this.dcc = com_fossil_dol;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.dcc.dbX.jc(editable.toString());
        }
    }

    class C30163 implements TextWatcher {
        final /* synthetic */ dol dcc;

        C30163(dol com_fossil_dol) {
            this.dcc = com_fossil_dol;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.dcc.dbX.jd(editable.toString());
        }
    }

    class C30174 implements TextWatcher {
        final /* synthetic */ dol dcc;

        C30174(dol com_fossil_dol) {
            this.dcc = com_fossil_dol;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.dcc.dbX.iW(editable.toString());
        }
    }

    class C30185 implements C2471a {
        final /* synthetic */ dol dcc;

        C30185(dol com_fossil_dol) {
            this.dcc = com_fossil_dol;
        }

        public void mo2162x(Map<String, Object> map) {
            int intValue = ((Integer) map.get("month")).intValue();
            int intValue2 = ((Integer) map.get("day")).intValue();
            this.dcc.dca.set(1, ((Integer) map.get("year")).intValue());
            this.dcc.dca.set(2, intValue - 1);
            this.dcc.dca.set(5, intValue2);
            this.dcc.dbP.setText(this.dcc.dbZ.format(this.dcc.dca.getTime()));
            this.dcc.dbX.mo2627a(this.dcc.dbY.format(this.dcc.dca.getTime()), this.dcc.dca);
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m9236a((C3012a) obj);
    }

    public static dol m9230J(Bundle bundle) {
        dol com_fossil_dol = new dol();
        com_fossil_dol.setArguments(bundle);
        return com_fossil_dol;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getBoolean("AUTHENTICATED_BY_EMAIL", true))) {
            z = false;
        }
        this.dcb = z;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_sign_up_email, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dbN = (FlexibleEditText) view.findViewById(R.id.fet_first_name);
        this.dbO = (FlexibleEditText) view.findViewById(R.id.fet_last_name);
        this.dbm = (FlexibleEditText) view.findViewById(R.id.fet_password);
        this.daZ = (FlexibleEditText) view.findViewById(R.id.fet_email);
        this.dbP = (FlexibleEditText) view.findViewById(R.id.fet_birthday);
        this.dbR = (FlexibleTextView) view.findViewById(R.id.ftv_age_error);
        this.dbS = (FlexibleTextView) view.findViewById(R.id.ftv_email_error);
        this.dbT = (FlexibleTextView) view.findViewById(R.id.ftv_password_error);
        this.cSa = (FlexibleButton) view.findViewById(R.id.fb_female);
        this.cRZ = (FlexibleButton) view.findViewById(R.id.fb_male);
        this.cSb = (FlexibleButton) view.findViewById(R.id.fb_other);
        this.dbU = (FlexibleButton) view.findViewById(R.id.fb_sign_up);
        this.dbV = (CheckBox) view.findViewById(R.id.cb_terms_service);
        this.dbW = (CheckBox) view.findViewById(R.id.cb_data_usage);
        this.cRQ = (ImageView) view.findViewById(R.id.iv_toolbar_left);
        this.dbQ = (FlexibleTextView) view.findViewById(R.id.ftv_terms_service);
        this.dbQ.setMovementMethod(LinkMovementMethod.getInstance());
        this.dbN.addTextChangedListener(new C30141(this));
        this.dbO.addTextChangedListener(new C30152(this));
        this.dbm.addTextChangedListener(new C30163(this));
        this.daZ.addTextChangedListener(new C30174(this));
        this.dbP.setOnClickListener(this);
        this.dbP.setFocusableInTouchMode(false);
        this.cSa.setOnClickListener(this);
        this.cRZ.setOnClickListener(this);
        this.cSb.setOnClickListener(this);
        this.dbU.setOnClickListener(this);
        this.dbW.setOnCheckedChangeListener(this);
        this.dbV.setOnCheckedChangeListener(this);
        this.cRQ.setOnClickListener(this);
        this.daZ.setEnabled(this.dcb);
    }

    public void onResume() {
        super.onResume();
        this.dbX.start();
        this.dbQ.setText(Html.fromHtml(this.dbX.asX()));
    }

    public void onPause() {
        super.onPause();
        this.dbX.stop();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_toolbar_left:
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    getActivity().finish();
                    return;
                }
                return;
            case R.id.fb_sign_up:
                this.dbX.asW();
                return;
            case R.id.fb_male:
                mo2613a(Gender.MALE);
                this.dbX.mo2630b(Gender.MALE);
                return;
            case R.id.fb_female:
                mo2613a(Gender.FEMALE);
                this.dbX.mo2630b(Gender.FEMALE);
                return;
            case R.id.fb_other:
                mo2613a(Gender.OTHER);
                this.dbX.mo2630b(Gender.OTHER);
                return;
            case R.id.fet_birthday:
                drp.m9519a(getActivity(), this.dca.get(2) + 1, this.dca.get(5), this.dca.get(1), new C30185(this)).show();
                return;
            default:
                return;
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.cb_terms_service:
                this.dbX.dg(this.dbV.isChecked());
                return;
            case R.id.cb_data_usage:
                this.dbX.dh(this.dbW.isChecked());
                return;
            default:
                return;
        }
    }

    public void m9236a(C3012a c3012a) {
        this.dbX = c3012a;
    }

    public void dd(boolean z) {
        this.dbS.setVisibility(z ? 8 : 0);
        this.dbS.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Login_Error_Invalid_Text_Invalid_email_address));
    }

    public void di(boolean z) {
        this.dbT.setVisibility(z ? 8 : 0);
    }

    public void dj(boolean z) {
        this.dbR.setVisibility(z ? 8 : 0);
    }

    public void mo2625g(MFUser mFUser) {
        if (mFUser != null) {
            if (!TextUtils.isEmpty(mFUser.getFirstName())) {
                this.dbN.setText(mFUser.getFirstName());
            }
            if (!TextUtils.isEmpty(mFUser.getLastName())) {
                this.dbO.setText(mFUser.getLastName());
            }
            if (!TextUtils.isEmpty(mFUser.getEmail())) {
                this.daZ.setText(mFUser.getEmail());
            }
        }
    }

    public void mo2613a(Gender gender) {
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

    public void afL() {
        afT();
    }

    public void afM() {
        afU();
    }

    public void asY() {
        this.dbS.setVisibility(0);
        this.dbS.setText(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_SignUp_Error_Taken_Text_This_email_address_is_already));
    }

    public void jV(int i) {
        if (isActive()) {
            dqw.m9419a(i, getChildFragmentManager());
        }
    }

    public void asZ() {
        MFUser currentUser = this.dbX.getCurrentUser();
        if (currentUser != null) {
            PortfolioApp.ZQ().aao();
            PortfolioApp.ZQ().aae();
            if (isActive()) {
                dqw.m9421a(getChildFragmentManager(), currentUser.getFirstName());
            }
        } else if (isActive()) {
            dqw.m9419a((int) MFNetworkReturnCode.INTERNAL_SERVER_ERROR, getChildFragmentManager());
        }
    }

    public void ata() {
        this.dbm.setVisibility(8);
    }

    public void atb() {
        if (this.cRQ != null) {
            this.cRQ.setVisibility(4);
        }
    }

    public void dk(boolean z) {
        this.dbU.setEnabled(z);
        this.dbU.setAlpha(z ? 1.0f : 0.3f);
    }

    public void atc() {
        this.daZ.setEnabled(true);
    }

    public void mo1746a(String str, int i, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 405225031:
                if (str.equals("REGISTER_SUCCESS")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                switch (i) {
                    case R.id.fb_ok:
                        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                            PairDeviceStartActivity.bH(getActivity());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            default:
                ((ctj) getActivity()).mo1746a(str, i, intent);
                return;
        }
    }
}
