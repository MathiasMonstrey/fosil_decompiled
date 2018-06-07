package com.fossil;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract.Data;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior.C1074a;
import android.support.design.widget.AppBarLayout.C1077a;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.C1092c;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FilterQueryProvider;
import com.fossil.dbv.C2637a;
import com.fossil.dcg.C2646a;
import com.fossil.dcg.C2647b;
import com.fossil.dcq.C2657a;
import com.fossil.dcr.C2658a;
import com.fossil.dcu.C2659a;
import com.fossil.drk.C2095b;
import com.fossil.drk.C2333c;
import com.fossil.dse.C3168a;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.j256.ormlite.field.FieldType;
import com.misfit.frameworks.common.enums.Action.Selfie;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.notifications.domain.model.AppWrapper;
import com.portfolio.platform.ui.notifications.domain.model.ContactWrapper;
import com.portfolio.platform.view.ClockView;
import com.portfolio.platform.view.ClockView.b;
import com.portfolio.platform.view.EditTextCustom.DrawableClickListener;
import com.portfolio.platform.view.EditTextCustom.DrawableClickListener.DrawablePosition;
import com.portfolio.platform.view.EditTextCustom.a;
import java.util.List;

public class dch extends ctm implements C1077a, OnClickListener, C2647b, C2657a, C2658a, C2659a, C2095b, C2333c, C2426a<Cursor>, b, a {
    private static final String SORT_KEY_PRIMARY = (dqr.auj() ? "sort_key" : "display_name");
    private final String TAG = getClass().getSimpleName();
    private dbv cOT;
    private cla cPc;
    private C2646a cPd;
    private dcr cPe;
    private dcq cPf;
    private dcu cPg;
    private boolean cPh = true;
    private boolean cPi;
    private boolean cPj = true;
    private int cPk = 0;
    private int cPl = 0;
    private Uri cPm = Data.CONTENT_URI;
    cnr mSharedPreferencesManager;

    class C26481 implements OnTouchListener {
        final /* synthetic */ dch cPn;

        C26481(dch com_fossil_dch) {
            this.cPn = com_fossil_dch;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            Log.d(this.cPn.TAG, "setClockOnTouchListener");
            return false;
        }
    }

    class C26536 implements FilterQueryProvider {
        final /* synthetic */ dch cPn;

        C26536(dch com_fossil_dch) {
            this.cPn = com_fossil_dch;
        }

        public Cursor runQuery(CharSequence charSequence) {
            String str;
            if (charSequence.length() == 0) {
                str = "has_phone_number!=0 AND mimetype=?";
            } else {
                str = "(display_name LIKE '%" + charSequence + "%' OR " + "display_name" + " LIKE 'N%" + charSequence + "%') AND " + "has_phone_number" + "!=0 AND " + "mimetype" + "=?";
            }
            String[] strArr = new String[]{"vnd.android.cursor.item/phone_v2"};
            String[] strArr2 = new String[7];
            strArr2[0] = "contact_id";
            strArr2[1] = "display_name";
            strArr2[2] = "data1";
            strArr2[3] = "has_phone_number";
            strArr2[4] = "starred";
            strArr2[5] = dqr.auj() ? "photo_thumb_uri" : FieldType.FOREIGN_ID_FIELD_SUFFIX;
            strArr2[6] = dch.SORT_KEY_PRIMARY;
            return PortfolioApp.ZQ().getContentResolver().query(this.cPn.cPm, strArr2, str, strArr, "display_name COLLATE LOCALIZED ASC");
        }
    }

    static /* synthetic */ class C26547 {
        static final /* synthetic */ int[] cPp = new int[DrawablePosition.values().length];

        static {
            try {
                cPp[DrawablePosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    class C26558 implements DrawableClickListener {
        final /* synthetic */ dch cPn;

        C26558(dch com_fossil_dch) {
            this.cPn = com_fossil_dch;
        }

        public void m8221a(DrawablePosition drawablePosition) {
            switch (C26547.cPp[drawablePosition.ordinal()]) {
                case 1:
                    this.cPn.cPc.csu.clearFocus();
                    return;
                default:
                    return;
            }
        }
    }

    class C26569 implements TextWatcher {
        final /* synthetic */ dch cPn;

        C26569(dch com_fossil_dch) {
            this.cPn = com_fossil_dch;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.cPn.cPe != null && this.cPn.cPf != null) {
                if (this.cPn.cPh) {
                    this.cPn.cPe.ir(charSequence.toString());
                } else {
                    this.cPn.cPf.getFilter().filter(charSequence);
                }
                this.cPn.cPc.csh.setVisibility(charSequence.toString().isEmpty() ? 4 : 0);
                MFLogger.m12670d(this.cPn.TAG, "onTextChanged");
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8243a((C2646a) obj);
    }

    public static dch alQ() {
        dch com_fossil_dch = new dch();
        com_fossil_dch.setArguments(new Bundle());
        return com_fossil_dch;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        MFLogger.m12670d(this.TAG, "onCreateView - R.layout.notifications_main_fragment");
        this.cPc = (cla) C3311e.m10386a(layoutInflater, R.layout.fragment_contact_and_app, viewGroup, false, this.cEN);
        this.cPc.csh.setOnClickListener(this);
        this.cPc.csb.setOnClickListener(this);
        this.cPc.crN.setOnClickListener(this);
        this.cPc.css.setOnClickListener(this);
        this.cPc.crT.setOnClickListener(this);
        this.cPc.csp.setOnClickListener(this);
        this.cPc.csn.setOnClickListener(this);
        this.cPc.crY.setOnClickListener(this);
        this.cPc.csl.setOnClickListener(this);
        this.cPc.cso.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.cPc.csf.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.cPc.cse.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.cPc.csu.setOnTouchListener(new C26481(this));
        this.cPc.csu.setDrawableClickListener(new C26558(this));
        this.cPc.csu.addTextChangedListener(new C26569(this));
        this.cPc.csu.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ dch cPn;

            {
                this.cPn = r1;
            }

            public void onFocusChange(View view, boolean z) {
                if (this.cPn.getActivity() != null) {
                    Log.d(this.cPn.TAG, "hasFocus = " + z);
                    if (z) {
                        if (cnc.bz(this.cPn.getActivity())) {
                            this.cPn.cPc.csu.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_back_dark, 0);
                        } else {
                            this.cPn.cPc.csu.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_back_dark, 0, 0, 0);
                        }
                        this.cPn.hB("notifications_search");
                        this.cPn.cPc.crO.setExpanded(false);
                        return;
                    }
                    if (cnc.bz(this.cPn.getActivity())) {
                        this.cPn.cPc.csu.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_search_noti, 0);
                    } else {
                        this.cPn.cPc.csu.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search_noti, 0, 0, 0);
                    }
                    cmy.m7168a(this.cPn.cPc.csu, this.cPn.getActivity());
                }
            }
        });
        this.cPc.csu.setBackPressListener(this);
        this.cPc.crX.setOnAnimationListener(new ClockView.a(this) {
            final /* synthetic */ dch cPn;

            {
                this.cPn = r1;
            }

            public void onAnimationStart() {
                Log.d(this.cPn.TAG, "onAnimationEnd() called mHoriContainer.isShown() = " + this.cPn.cPc.csa.isShown());
                this.cPn.cPc.csa.setVisibility(this.cPn.cPc.csa.isShown() ? 8 : 0);
            }

            public void cG(boolean z) {
                boolean z2 = false;
                Log.d(this.cPn.TAG, "onAnimationEnd() called mHoriContainer.isShown() = " + this.cPn.cPc.csa.isShown());
                this.cPn.cPc.csa.setVisibility(this.cPn.cPc.csa.isShown() ? 8 : 0);
                AppBarLayout appBarLayout = this.cPn.cPc.crO;
                if (!z) {
                    z2 = true;
                }
                appBarLayout.setExpanded(z2);
                if (this.cPn.cPc.crX.avl() && this.cPn.cPj) {
                    this.cPn.cPd.alz();
                }
            }

            public void aD(float f) {
                Log.d(this.cPn.TAG, "onHeightChanged: " + f);
                this.cPn.cPc.crX.getLayoutParams().height = (int) f;
                this.cPn.cPc.crX.requestLayout();
            }
        });
        tx.t(this).a(Integer.valueOf(R.drawable.fs_background)).c(this.cPc.csg);
        if (!dre.dff.m9462a(getActivity(), "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.READ_SMS")) {
            dre.dff.m9461a((Fragment) this, 2, "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.READ_SMS");
        }
        int bR = dqu.bR(getActivity());
        this.cPc.csd.getLayoutParams().height = (int) (((((float) bR) - dri.m9480b(56, getActivity())) - dri.m9480b(Selfie.TAKE_BURST, getActivity())) - dri.m9480b(112, getActivity()));
        this.cOT = new dbv();
        this.cOT.ip(dch.class.getSimpleName());
        this.cPc.crN.setTextColor(PortfolioApp.ZQ().getResources().getColor(R.color.fossilCoolGray));
        alU();
        if (this.cPh) {
            alS();
        } else {
            alT();
        }
        PortfolioApp.ZQ().aam().mo1838a(this);
        return this.cPc.dz();
    }

    public void onResume() {
        MFLogger.m12670d(this.TAG, "Inside. onResume");
        super.onResume();
        this.cPd.start();
        this.cPc.crO.m1755a((C1077a) this);
    }

    public void alJ() {
        MFLogger.m12670d(this.TAG, ".Inside showPlusIcon");
        this.cPc.csl.setVisibility(0);
        this.cPc.csm.setVisibility(0);
    }

    public void alK() {
        MFLogger.m12670d(this.TAG, ".Inside hidePlusIcon");
        this.cPc.csl.setVisibility(8);
        this.cPc.csm.setVisibility(8);
        this.cPc.crP.setVisibility(8);
    }

    public void mo1747b(int i, List<String> list) {
        super.mo1747b(i, list);
        MFLogger.m12670d(this.TAG, ".Inside onPermissionsDenied");
        for (String str : list) {
            Log.d(this.TAG, "Permission Denied : " + str);
        }
        if (!evb.m11255a(this, list)) {
            getActivity().finish();
        } else if (getActivity() != null && isActive()) {
            dqw.m9429e(getChildFragmentManager());
        }
    }

    public void onPause() {
        MFLogger.m12670d(this.TAG, ".Inside onPause");
        super.onPause();
        this.cPd.stop();
        this.cPc.crO.m1757b(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_picker:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.close_picker");
                this.cPc.crR.setVisibility(8);
                return;
            case R.id.iv_close:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.iv_close");
                this.cPc.csu.setText("");
                return;
            case R.id.cancel:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.cancel");
                if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    this.cPd.onCancel();
                    hB("notifications_cancel");
                    return;
                }
                return;
            case R.id.save_text:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.save_text");
                hB("notifications_save");
                this.cPd.save();
                return;
            case R.id.plus_icon:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.plus_icon");
                this.cPd.alC();
                this.cPe.notifyDataSetChanged();
                return;
            case R.id.contact_text:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.contact_text");
                hB("notifications_contacts");
                alS();
                this.cPe.notifyDataSetChanged();
                this.cPh = true;
                alR();
                if (!TextUtils.isEmpty(this.cPc.csu.getEditableText())) {
                    this.cPe.getFilter().filter(this.cPc.csu.getEditableText());
                    return;
                }
                return;
            case R.id.app_text:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.app_text");
                hB("notifications_apps");
                alT();
                this.cPf.amm();
                this.cPh = false;
                alR();
                if (!dre.dff.auE() && isActive()) {
                    dqw.m9430f(getChildFragmentManager());
                }
                if (!TextUtils.isEmpty(this.cPc.csu.getEditableText())) {
                    this.cPf.getFilter().filter(this.cPc.csu.getEditableText());
                    return;
                }
                return;
            case R.id.remove_in_detail_layout:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.remove_in_detail_layout");
                if (this.cPi) {
                    m7519n("notifications_remove", "Item", "Contacts");
                    this.cPd.ku(this.cPg.amg());
                    return;
                }
                m7519n("notifications_remove", "Item", "Apps");
                this.cPd.kw(this.cPg.amg());
                return;
            case R.id.reassign_in_detail_layout:
                MFLogger.m12670d(this.TAG, "onClick: id = R.id.reassign_in_detail_layout");
                if (this.cPi) {
                    m7519n("notifications_reassign", "Item", "Contacts");
                    this.cPd.kx(this.cPg.amg());
                    return;
                }
                m7519n("notifications_reassign", "Item", "Apps");
                this.cPd.ky(this.cPg.amg());
                return;
            default:
                return;
        }
    }

    public void alM() {
        MFLogger.m12670d(this.TAG, ".Inside updatePlusClicked");
        this.cPc.cst.setVisibility(0);
        this.cPc.csv.setVisibility(0);
        this.cPc.csk.setVisibility(8);
        this.cPc.crP.setVisibility(8);
        this.cPc.csd.setVisibility(8);
        this.cPg.amr();
        this.cPg.amm();
        this.cPc.crW.setBackgroundResource(R.color.transparent);
        this.cPc.csa.setBackgroundResource(R.color.transparent);
        this.cPc.csl.setVisibility(8);
        this.cPc.csm.setVisibility(8);
        this.cPg.amt();
        if (this.cPg.getItemCount() <= 0) {
            return;
        }
        if (this.cPg.ams() instanceof ContactWrapper) {
            m7519n("notifications_contacts", "Screen", "Preview");
        } else {
            m7519n("notifications_apps", "Screen", "Preview");
        }
    }

    public void alL() {
        MFLogger.m12670d(this.TAG, ".Inside showPlusIconInfo");
        this.cPc.csl.setVisibility(0);
        this.cPc.csm.setVisibility(0);
        this.cPc.csk.setVisibility(0);
        this.cPc.crP.setVisibility(0);
        this.cPc.csd.setVisibility(0);
        this.cPc.csj.setVisibility(8);
        this.cPg.amm();
        this.cPc.crW.setBackgroundResource(R.color.transparent);
        this.cPc.csa.setBackgroundResource(R.color.transparent);
    }

    public void kq(int i) {
        MFLogger.m12670d(this.TAG, ".Inside onHourHandValueChange, currentHour = " + i);
        this.cPc.crX.setCurrentHour(i % 12);
    }

    public void m8243a(C2646a c2646a) {
        this.cPd = c2646a;
    }

    public void mo2281g(List<AppWrapper> list, int i) {
        MFLogger.m12670d(this.TAG, ".Inside showApp: appWrappers size = " + list.size());
        this.cPf.m8303a(getActivity(), list, i);
        this.cPf.amm();
    }

    public void ac(List<Object> list) {
        MFLogger.m12670d(this.TAG, ".Inside showHorizontalList size = " + list.size());
        this.cPg.m8339a(getActivity(), (List) list);
        this.cPg.amm();
    }

    public void alD() {
        MFLogger.m12670d(this.TAG, ".Inside showAddFlow");
        this.cPc.csl.performClick();
        this.cPc.csl.setVisibility(8);
        this.cPc.csm.setVisibility(8);
    }

    public void mo2273b(int i, Object obj) {
        MFLogger.m12670d(this.TAG, ".Inside showInfoAtPosition at selectedPosition = " + i);
        if (obj instanceof ContactWrapper) {
            m8255b((ContactWrapper) obj, i);
        } else {
            m8247a((AppWrapper) obj);
        }
        MFLogger.m12670d(this.TAG, ".Inside showInfoAtPosition - old position = " + this.cPg.amg());
        MFLogger.m12670d(this.TAG, ".Inside showInfoAtPosition - new position = " + i);
        int amg = this.cPg.amg();
        this.cPg.kN(i);
        this.cPg.dr(amg);
        this.cPg.dr(i);
    }

    public void alF() {
        afT();
    }

    public void alG() {
        afU();
    }

    public void kG(int i) {
        MFLogger.m12670d(this.TAG, ".Inside finish");
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_HAND_NUMBER", i);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public void cancel() {
        MFLogger.m12670d(this.TAG, ".Inside cancel()");
        getActivity().setResult(0);
        getActivity().finish();
    }

    public void kH(int i) {
        MFLogger.m12670d(this.TAG, ".Inside showHandNumber: handNumber = " + i);
        this.cPc.crX.setCurrentHour(i);
        this.cPc.crX.setEnabled(false);
    }

    public void alH() {
        MFLogger.m12670d(this.TAG, ".Inside showCallTooltips");
        new C3168a(this.cPc.csy).mm(40).mi(R.string.Notifications_Preview_Onboarding_Toggle_Text_Tap_the_icons_to_enable).m9610a(R.string.Stats_Activity_Onboarding_Edit_CTA_OK, new OnClickListener(this) {
            final /* synthetic */ dch cPn;

            {
                this.cPn = r1;
            }

            public void onClick(View view) {
                this.cPn.cPd.alB();
            }
        }).mj(8388611).mk(48).ml(2).show();
    }

    public void alI() {
        MFLogger.m12670d(this.TAG, ".Inside showAddTooltips");
        if (this.cPc.csl.getVisibility() == 0 && !this.mSharedPreferencesManager.acU()) {
            new C3168a(this.cPc.csl).mm(40).mi(R.string.Notifications_Preview_Onboarding_Additional_Text_You_can_assign_aditional_contacts).m9610a(R.string.Stats_Activity_Onboarding_Edit_CTA_OK, new OnClickListener(this) {
                final /* synthetic */ dch cPn;

                {
                    this.cPn = r1;
                }

                public void onClick(View view) {
                    this.cPn.cPd.alA();
                }
            }).mj(8388611).mk(48).ml(2).show();
        }
    }

    private void alR() {
        if (this.cPh) {
            this.cPc.csb.setBackgroundResource(R.drawable.background_bottom_line);
            this.cPc.crN.setBackgroundResource(R.color.transparent);
            this.cPc.crN.setTextColor(gn.m10634e(getContext(), R.color.fossilCoolGray));
            this.cPc.csb.setTextColor(gn.m10634e(getContext(), R.color.fossilCharcoal));
            return;
        }
        this.cPc.crN.setBackgroundResource(R.drawable.background_bottom_line);
        this.cPc.csb.setBackgroundResource(R.color.transparent);
        this.cPc.csb.setTextColor(gn.m10634e(getContext(), R.color.fossilCoolGray));
        this.cPc.crN.setTextColor(gn.m10634e(getContext(), R.color.fossilCharcoal));
    }

    public void cb(final int i, final int i2) {
        MFLogger.m12670d(this.TAG, ".Inside showClockContactReassign fromHand = " + i + " at position = " + i2);
        if (!this.cOT.isShowing()) {
            kM(i);
            this.cOT.m8183a(new C2637a(this) {
                final /* synthetic */ dch cPn;

                public void kr(int i) {
                    if (i != i) {
                        this.cPn.cPd.bZ(i2, i);
                    }
                    this.cPn.alx();
                }
            });
        }
    }

    public void cc(final int i, final int i2) {
        MFLogger.m12670d(this.TAG, ".Inside showClockAppReassign fromHand = " + i + " at position = " + i2);
        if (!this.cOT.isShowing()) {
            kM(i);
            this.cOT.m8183a(new C2637a(this) {
                final /* synthetic */ dch cPn;

                public void kr(int i) {
                    if (i != i) {
                        this.cPn.cPd.ca(i2, i);
                    }
                    this.cPn.alx();
                }
            });
        }
    }

    public void kE(int i) {
        MFLogger.m12670d(this.TAG, ".Inside updateReassignedContact at position = " + i);
        this.cPe.dr(i);
        this.cPc.csf.dg(this.cPg.getItemCount() - 1);
        this.cPc.cse.dg(this.cPg.getItemCount() - 1);
        this.cPg.amm();
    }

    public void kF(int i) {
        MFLogger.m12670d(this.TAG, ".Inside updateReassignedApp at position = " + i);
        this.cPf.dr(this.cPf.amo().indexOf((AppWrapper) this.cPf.amp().get(i)));
        this.cPc.csf.dg(this.cPg.getItemCount() - 1);
        this.cPc.cse.dg(this.cPg.getItemCount() - 1);
        this.cPg.amm();
    }

    public void mo2256a(ContactWrapper contactWrapper, int i, int i2, int i3) {
        MFLogger.m12670d(this.TAG, ".Inside showConfirmContactReassign");
        if (isActive()) {
            dqw.m9420a(getChildFragmentManager(), contactWrapper, i, i2, i3);
        }
    }

    public void mo2257a(String str, int i, int i2, int i3) {
        MFLogger.m12670d(this.TAG, ".Inside showConfirmAppReassign");
        if (isActive()) {
            dqw.m9422a(getChildFragmentManager(), str, i, i2, i3);
        }
    }

    public void kA(int i) {
        MFLogger.m12670d(this.TAG, ".Inside updateAddedContact at position = " + i);
        this.cPe.dr(i);
        this.cPc.csf.dg(this.cPg.getItemCount() - 1);
        this.cPc.cse.dg(this.cPg.getItemCount() - 1);
        this.cPg.amm();
    }

    public void kB(int i) {
        Log.d(this.TAG, ".Inside updateRemovedContact at position = " + i);
        this.cPe.dr(i);
        this.cPc.csf.dg(this.cPg.getItemCount());
        this.cPc.cse.dg(this.cPg.getItemCount());
        this.cPg.amm();
    }

    public void kI(int i) {
        Log.d(this.TAG, "onReassignApp at position = " + i);
        this.cPd.ky(i);
        m7519n("notifications_reassign", "Item", "Apps");
    }

    public void kJ(int i) {
        Log.d(this.TAG, ".Inside onAddApp at position = " + i);
        this.cPd.mo2295A(i, this.cPc.csu.hasFocus());
    }

    public void kC(int i) {
        Log.d(this.TAG, ".Inside updateAddedApp at position = " + i);
        this.cPf.dr(this.cPf.amo().indexOf((AppWrapper) this.cPf.amp().get(i)));
        this.cPc.csf.dg(this.cPg.getItemCount() - 1);
        this.cPc.cse.dg(this.cPg.getItemCount() - 1);
        this.cPg.amm();
    }

    public void kK(int i) {
        Log.d(this.TAG, ".Inside onRemoveApp at position = " + i);
        this.cPd.kv(i);
    }

    public void kD(int i) {
        Log.d(this.TAG, ".Inside updateRemovedApp at position = " + i);
        this.cPf.dr(this.cPf.amo().indexOf((AppWrapper) this.cPf.amp().get(i)));
        this.cPc.csf.dg(this.cPg.getItemCount());
        this.cPc.cse.dg(this.cPg.getItemCount());
        this.cPg.amm();
    }

    public void alE() {
        Log.d(this.TAG, ".Inside showMaximumItem");
        if (isActive()) {
            dqw.m9428d(getChildFragmentManager());
        }
    }

    public void m8255b(ContactWrapper contactWrapper, final int i) {
        Log.d(this.TAG, ".Inside showContactInfo: contact id = " + contactWrapper.getContact().getContactId() + " ,name=" + contactWrapper.getContact().getDisplayName() + " ,hand=" + contactWrapper.getCurrentHandGroup() + " ,rowId=" + contactWrapper.getContact().getDbRowId());
        this.cPc.csd.setVisibility(0);
        this.cPc.cst.setVisibility(8);
        this.cPc.crP.setVisibility(8);
        this.cPc.csk.setVisibility(8);
        this.cPc.csj.setVisibility(0);
        this.cPc.crW.setBackgroundResource(R.color.transparent);
        this.cPc.csa.setBackgroundResource(R.color.transparent);
        this.cPi = true;
        if (!contactWrapper.getContact().isUseCall() || contactWrapper.getContact().getContactId() == -100) {
            this.cPc.csy.setImageResource(R.drawable.ic_calls_inactive);
            this.cPk = 0;
            this.cPc.crU.setVisibility(4);
        } else {
            this.cPc.csy.setImageResource(R.drawable.ic_calls_active);
            this.cPk = 1;
            this.cPc.crU.setVisibility(0);
        }
        if (!contactWrapper.getContact().isUseSms() || contactWrapper.getContact().getContactId() == -200) {
            this.cPc.csx.setImageResource(R.drawable.ic_texts_inactive);
            this.cPl = 0;
            this.cPc.crV.setVisibility(4);
        } else {
            this.cPc.csx.setImageResource(R.drawable.ic_texts_active);
            this.cPl = 1;
            this.cPc.crV.setVisibility(0);
        }
        this.cPc.csy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ dch cPn;

            public void onClick(View view) {
                if (this.cPn.cPk == 0) {
                    this.cPn.cPc.csy.setImageResource(R.drawable.ic_calls_active);
                    this.cPn.cPk = 1;
                    this.cPn.cPd.mo2296B(i, true);
                    this.cPn.cPc.crU.setVisibility(0);
                    this.cPn.m7519n("notifications_contacts_update", "Action", String.format("%s_Calls", new Object[]{"Add"}));
                } else if (this.cPn.cPk == 1) {
                    this.cPn.cPc.csy.setImageResource(R.drawable.ic_calls_inactive);
                    this.cPn.cPk = 0;
                    this.cPn.cPd.mo2296B(i, false);
                    this.cPn.cPc.crU.setVisibility(4);
                    this.cPn.m7519n("notifications_contacts_update", "Action", String.format("%s_Calls", new Object[]{"Remove"}));
                }
            }
        });
        this.cPc.csx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ dch cPn;

            public void onClick(View view) {
                if (this.cPn.cPl == 0) {
                    this.cPn.cPc.csx.setImageResource(R.drawable.ic_texts_active);
                    this.cPn.cPl = 1;
                    this.cPn.cPd.mo2297C(i, true);
                    this.cPn.cPc.crV.setVisibility(0);
                    this.cPn.m7519n("notifications_contacts_update", "Action", String.format("%s_Texts", new Object[]{"Add"}));
                } else if (this.cPn.cPl == 1) {
                    this.cPn.cPc.csx.setImageResource(R.drawable.ic_texts_inactive);
                    this.cPn.cPl = 0;
                    this.cPn.cPd.mo2297C(i, false);
                    this.cPn.cPc.crV.setVisibility(4);
                    this.cPn.m7519n("notifications_contacts_update", "Action", String.format("%s_Texts", new Object[]{"Remove"}));
                }
            }
        });
        this.cPc.csw.setVisibility(0);
        this.cPc.crS.setVisibility(0);
        this.cPc.csy.setVisibility(0);
        this.cPc.csx.setVisibility(0);
        if (contactWrapper.getContact().getContactId() == -100 || contactWrapper.getContact().getContactId() == -200) {
            this.cPc.csw.setVisibility(8);
            this.cPc.crS.setVisibility(8);
            this.cPc.csy.setVisibility(8);
            this.cPc.csx.setVisibility(8);
        }
    }

    public void m8247a(AppWrapper appWrapper) {
        Log.d(this.TAG, ".Inside showAppInfo: app name = " + appWrapper.installedApp.getTitle());
        Log.d(this.TAG, ".Inside showAppInfo: app hand = " + appWrapper.getCurrentHandGroup());
        Log.d(this.TAG, ".Inside showAppInfo: app row id = " + appWrapper.installedApp.getDbRowId());
        this.cPc.csd.setVisibility(0);
        this.cPc.cst.setVisibility(8);
        this.cPi = false;
        this.cPc.crP.setVisibility(8);
        this.cPc.csk.setVisibility(8);
        this.cPc.csj.setVisibility(0);
        this.cPc.crW.setBackgroundResource(R.color.transparent);
        this.cPc.csa.setBackgroundResource(R.color.transparent);
        this.cPc.csw.setVisibility(8);
        this.cPc.crS.setVisibility(8);
        this.cPc.csy.setVisibility(8);
        this.cPc.csx.setVisibility(8);
        this.cPc.crU.setVisibility(4);
        this.cPc.crV.setVisibility(4);
    }

    public void kL(int i) {
        Log.d(this.TAG, "onClickedPosition: position = " + i);
        this.cPd.kt(i);
    }

    private void alS() {
        this.cPc.cso.setAdapter(this.cPe);
    }

    private void alT() {
        this.cPc.cso.setAdapter(this.cPf);
    }

    private void alU() {
        MFLogger.m12670d(this.TAG, ".Inside setupAdapters");
        this.cPg = new dcu(tx.t(this));
        this.cPg.m8341a((C2659a) this);
        this.cPc.csf.setAdapter(this.cPg);
        this.cPc.csf.setItemAnimator(null);
        this.cPc.cse.setItemAnimator(null);
        this.cPc.cse.setAdapter(this.cPg);
        this.cPf = new dcq(tx.t(this));
        this.cPf.m8305a((C2657a) this);
    }

    public void iq(String str) {
        MFLogger.m12670d(this.TAG, ".Inside showReassignMessage message" + str);
        this.cPc.crR.setVisibility(0);
        this.cPc.crQ.setText(str);
        new CountDownTimer(this, 4000, 1000) {
            final /* synthetic */ dch cPn;

            public void onTick(long j) {
            }

            public void onFinish() {
                this.cPn.cPc.crR.setVisibility(8);
            }
        }.start();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1746a(java.lang.String r7, int r8, android.content.Intent r9) {
        /*
        r6 = this;
        r1 = 0;
        r2 = 0;
        r3 = -1;
        r0 = r6.TAG;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "onDialogFragmentResult: tag = ";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r5 = ", actionId = ";
        r4 = r4.append(r5);
        r4 = r4.append(r8);
        r4 = r4.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r4);
        r0 = r7.hashCode();
        switch(r0) {
            case -2028477080: goto L_0x003b;
            case -1984760733: goto L_0x0059;
            case -1375614559: goto L_0x0045;
            case 1018078562: goto L_0x004f;
            case 1517048638: goto L_0x0031;
            default: goto L_0x002c;
        };
    L_0x002c:
        r0 = r3;
    L_0x002d:
        switch(r0) {
            case 0: goto L_0x0063;
            case 1: goto L_0x008c;
            case 2: goto L_0x009b;
            case 3: goto L_0x00c2;
            case 4: goto L_0x0116;
            default: goto L_0x0030;
        };
    L_0x0030:
        return;
    L_0x0031:
        r0 = "REQUEST_CONTACT_PERMISSION";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0039:
        r0 = r2;
        goto L_0x002d;
    L_0x003b:
        r0 = "REQUEST_NOTIFICATION_ACCESS";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0043:
        r0 = 1;
        goto L_0x002d;
    L_0x0045:
        r0 = "UNSAVED_CHANGE";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x004d:
        r0 = 2;
        goto L_0x002d;
    L_0x004f:
        r0 = "CONFIRM_REASSIGN_CONTACT";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0057:
        r0 = 3;
        goto L_0x002d;
    L_0x0059:
        r0 = "CONFIRM_REASSIGN_APP";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0061:
        r0 = 4;
        goto L_0x002d;
    L_0x0063:
        switch(r8) {
            case 2131755402: goto L_0x0067;
            default: goto L_0x0066;
        };
    L_0x0066:
        goto L_0x0030;
    L_0x0067:
        r0 = r6.getActivity();
        if (r0 == 0) goto L_0x0030;
    L_0x006d:
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = "android.settings.APPLICATION_DETAILS_SETTINGS";
        r0.setAction(r2);
        r2 = "package";
        r3 = r6.getActivity();
        r3 = r3.getPackageName();
        r1 = android.net.Uri.fromParts(r2, r3, r1);
        r0.setData(r1);
        r6.startActivity(r0);
        goto L_0x0030;
    L_0x008c:
        switch(r8) {
            case 2131755402: goto L_0x0090;
            default: goto L_0x008f;
        };
    L_0x008f:
        goto L_0x0030;
    L_0x0090:
        r0 = new android.content.Intent;
        r1 = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
        r0.<init>(r1);
        r6.startActivity(r0);
        goto L_0x0030;
    L_0x009b:
        switch(r8) {
            case 2131755302: goto L_0x009f;
            default: goto L_0x009e;
        };
    L_0x009e:
        goto L_0x0030;
    L_0x009f:
        r0 = r6.getActivity();
        if (r0 == 0) goto L_0x0030;
    L_0x00a5:
        r0 = r6.getActivity();
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x0030;
    L_0x00af:
        r0 = r6.getActivity();
        r0 = r0.isDestroyed();
        if (r0 != 0) goto L_0x0030;
    L_0x00b9:
        r0 = r6.getActivity();
        r0.finish();
        goto L_0x0030;
    L_0x00c2:
        r0 = r6.TAG;
        r4 = ".Inside onDialogFragmentResult, CONFIRM_REASSIGN_CONTACT";
        com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r4);
        r0 = r9.getExtras();
        if (r0 == 0) goto L_0x012e;
    L_0x00cf:
        r4 = "CONFIRM_REASSIGN_CONTACT_POSITION";
        r2 = r0.getInt(r4, r2);
        r4 = "CONFIRM_REASSIGN_CONTACT_CONTACT_WRAPPER";
        r0 = r0.getSerializable(r4);	 Catch:{ ClassCastException -> 0x0110 }
        r0 = (com.portfolio.platform.ui.notifications.domain.model.ContactWrapper) r0;	 Catch:{ ClassCastException -> 0x0110 }
    L_0x00dd:
        r1 = r6.TAG;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = ".Inside onDialogFragmentResult, CONFIRM_REASSIGN_CONTACT ,contactPosition =";
        r4 = r4.append(r5);
        r4 = r4.append(r2);
        r5 = "contactPosition =";
        r4 = r4.append(r5);
        r4 = r4.append(r2);
        r4 = r4.toString();
        com.misfit.frameworks.common.log.MFLogger.m12670d(r1, r4);
        r1 = r2;
    L_0x0100:
        if (r0 == 0) goto L_0x0030;
    L_0x0102:
        if (r1 == r3) goto L_0x0030;
    L_0x0104:
        switch(r8) {
            case 2131755302: goto L_0x0109;
            default: goto L_0x0107;
        };
    L_0x0107:
        goto L_0x0030;
    L_0x0109:
        r2 = r6.cPd;
        r2.mo2298a(r1, r0);
        goto L_0x0030;
    L_0x0110:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x00dd;
    L_0x0116:
        r0 = r9.getExtras();
        if (r0 == 0) goto L_0x0030;
    L_0x011c:
        r1 = "CONFIRM_REASSIGN_APP_POSITION";
        r0 = r0.getInt(r1, r2);
        switch(r8) {
            case 2131755302: goto L_0x0127;
            default: goto L_0x0125;
        };
    L_0x0125:
        goto L_0x0030;
    L_0x0127:
        r1 = r6.cPd;
        r1.kz(r0);
        goto L_0x0030;
    L_0x012e:
        r0 = r1;
        r1 = r3;
        goto L_0x0100;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dch.a(java.lang.String, int, android.content.Intent):void");
    }

    public void hJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            Object obj = -1;
            switch (str.hashCode()) {
                case 1517048638:
                    if (str.equals("REQUEST_CONTACT_PERMISSION")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    if (getActivity() != null) {
                        getActivity().finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void mo52a(AppBarLayout appBarLayout, int i) {
        boolean z = true;
        Log.d(this.TAG, "onOffsetChanged: appBarLayout= " + appBarLayout + ", offset=" + i);
        this.cPc.crX.ch(appBarLayout.getTotalScrollRange(), i);
        if (appBarLayout.getTotalScrollRange() == Math.abs(i)) {
            this.cPc.cse.setVisibility(0);
            this.cPc.crX.setShowAnimation(false);
        } else {
            this.cPc.cse.setVisibility(8);
            this.cPc.crX.setShowAnimation(true);
        }
        if (i != 0) {
            z = false;
        }
        this.cPj = z;
    }

    public void cF(final boolean z) {
        C1092c c1092c = (C1092c) this.cPc.crO.getLayoutParams();
        Behavior behavior = (AppBarLayout.Behavior) c1092c.fW();
        if (behavior == null) {
            behavior = new AppBarLayout.Behavior();
        }
        behavior.setDragCallback(new C1074a(this) {
            final /* synthetic */ dch cPn;

            public boolean mo2255a(AppBarLayout appBarLayout) {
                return !z;
            }
        });
        c1092c.m1810a(behavior);
    }

    public boolean lM() {
        MFLogger.m12670d(this.TAG, ".Inside onBackPressed");
        if (!(getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed())) {
            this.cPd.onCancel();
        }
        return true;
    }

    private void kM(int i) {
        MFLogger.m12670d(this.TAG, ".Inside showHandPicker");
        this.cOT.setCurrentHour(i);
        this.cOT.cE(true);
        this.cOT.show(getChildFragmentManager(), dbv.class.getSimpleName());
    }

    private void alx() {
        MFLogger.m12670d(this.TAG, ".Inside hideHandPicker");
        this.cOT.hide();
    }

    public void alN() {
        if (this.cPc.crX.avl()) {
            this.cPc.crX.avh();
        }
    }

    public void alO() {
        this.cPc.crX.avj();
    }

    public void alP() {
        MFLogger.m12670d(this.TAG, ".Inside showUnsavedChanges");
        if (isActive()) {
            dqw.m9431g(getChildFragmentManager());
        }
    }

    public gx<Cursor> mo2137b(int i, Bundle bundle) {
        String str = "has_phone_number!=0 AND mimetype=?";
        String[] strArr = new String[]{"vnd.android.cursor.item/phone_v2"};
        MFLogger.m12670d(this.TAG, ".Inside onCreateLoader, selection = " + str);
        String[] strArr2 = new String[7];
        strArr2[0] = "contact_id";
        strArr2[1] = "display_name";
        strArr2[2] = "data1";
        strArr2[3] = "has_phone_number";
        strArr2[4] = "starred";
        strArr2[5] = dqr.auj() ? "photo_thumb_uri" : FieldType.FOREIGN_ID_FIELD_SUFFIX;
        strArr2[6] = SORT_KEY_PRIMARY;
        return new gu(PortfolioApp.ZQ(), this.cPm, strArr2, str, strArr, "display_name COLLATE LOCALIZED ASC");
    }

    public void m8245a(gx<Cursor> gxVar, Cursor cursor) {
        MFLogger.m12670d(this.TAG, ".Inside onLoadFinished");
        this.cPe.swapCursor(cursor);
        this.cPc.cst.setVisibility(0);
        this.cPc.csv.setVisibility(0);
    }

    public void mo2129a(gx<Cursor> gxVar) {
        MFLogger.m12670d(this.TAG, ".Inside onLoaderReset");
    }

    public void mo2274c(ContactWrapper contactWrapper, int i) {
        MFLogger.m12670d(this.TAG, ".Inside onAddCursorContact");
        this.cPd.mo2300a(contactWrapper, this.cPc.csu.hasFocus(), i);
    }

    public void cd(int i, int i2) {
        MFLogger.m12670d(this.TAG, ".Inside onRemoveCursorContact, position=" + i + "contactId=" + i2);
        this.cPd.bY(i, i2);
    }

    public void mo2280d(ContactWrapper contactWrapper, int i) {
        MFLogger.m12670d(this.TAG, ".Inside onReassignCursorContact");
        this.cPd.mo2299a(contactWrapper, i);
        m7519n("notifications_reassign", "Item", "Contacts");
    }

    public void mo2258a(List<ContactGroup> list, int i, List<ContactWrapper> list2) {
        this.cPe = new dcr(null, tx.t(this), i, list, list2);
        this.cPc.cso.setAdapter(this.cPe);
        this.cPe.m8328a((C2658a) this);
        this.cPe.setFilterQueryProvider(new C26536(this));
        if (getActivity() != null) {
            if (evb.m11256b(getActivity(), "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE", "android.permission.READ_SMS")) {
                getLoaderManager().mo3100a(0, null, this);
            }
        }
    }

    public void alV() {
        MFLogger.m12670d(this.TAG, ".Inside onEditTextBackPressed");
        this.cPc.crO.setExpanded(false);
    }
}
