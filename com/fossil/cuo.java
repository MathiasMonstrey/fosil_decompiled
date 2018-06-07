package com.fossil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.cun.C2343a;
import com.fossil.cun.C2344b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.ui.buddychallenge.activity.BCFindOpponentActivity;
import com.portfolio.platform.view.FlexibleButton;
import com.portfolio.platform.view.FlexibleEditText;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilCircleImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.TypeCastException;

public final class cuo extends ctm implements C2344b {
    public static final C2345a cGp = new C2345a();
    private int cBQ = -1;
    private dqo<clb> cEY;
    private C2343a cGk;
    private C2350c cGl = new C2350c();
    private final int cGm = 1000;
    private C2346b cGn = new C2346b(this);
    private int cGo;
    private Handler mHandler = new Handler(this.cGn);

    public static final class C2345a {
        private C2345a() {
        }

        public final cuo bV(int i, int i2) {
            cuo com_fossil_cuo = new cuo();
            Bundle bundle = new Bundle();
            bundle.putInt("EXTRA_STEP_GOAL", i);
            bundle.putInt("CHALLENGE_TYPE", i2);
            com_fossil_cuo.setArguments(bundle);
            return com_fossil_cuo;
        }
    }

    public final class C2346b implements Callback {
        final /* synthetic */ cuo cGq;

        public C2346b(cuo com_fossil_cuo) {
            this.cGq = com_fossil_cuo;
        }

        public boolean handleMessage(Message message) {
            esl.m11128j(message, Constants.MSG);
            MFLogger.m12670d(cuo.class.getSimpleName(), "receive message");
            Object obj = message.obj;
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            String str = (String) obj;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String obj2 = etd.trim(str).toString();
            if (!TextUtils.isEmpty(obj2)) {
                clb com_fossil_clb = (clb) cuo.m7600a(this.cGq).get();
                if (com_fossil_clb != null) {
                    FlexibleEditText flexibleEditText = com_fossil_clb.csD;
                    if (flexibleEditText != null) {
                        obj = flexibleEditText.getText();
                        str = String.valueOf(obj);
                        if (str != null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        } else if (esl.m11125C(obj2, etd.trim(str).toString()) && obj2.length() > 3) {
                            cmj.bs(this.cGq.getContext()).m7086l("stats_bc_register", "Step", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                            cuo.m7601b(this.cGq).hN(obj2);
                        }
                    }
                }
                obj = null;
                str = String.valueOf(obj);
                if (str != null) {
                    cmj.bs(this.cGq.getContext()).m7086l("stats_bc_register", "Step", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    cuo.m7601b(this.cGq).hN(obj2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return true;
        }
    }

    public static final class C2350c extends C1234a<C2348b> {
        private C2347a cGr;
        private ArrayList<String> suggestionList = new ArrayList();

        public interface C2347a {
            void onClick(View view);
        }

        public static final class C2348b extends C1264v {
            private FlexibleTextView cGs;

            public C2348b(View view) {
                super(view);
                View findViewById = view != null ? view.findViewById(R.id.ftvSuggestionName) : null;
                if (findViewById == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView");
                }
                this.cGs = (FlexibleTextView) findViewById;
            }

            public final FlexibleTextView ahr() {
                return this.cGs;
            }
        }

        static final class C2349c implements OnClickListener {
            final /* synthetic */ C2350c cGt;
            final /* synthetic */ C2348b cGu;

            C2349c(C2350c c2350c, C2348b c2348b) {
                this.cGt = c2350c;
                this.cGu = c2348b;
            }

            public final void onClick(View view) {
                C2347a a = C2350c.m7593a(this.cGt);
                View view2 = this.cGu.arT;
                esl.m11127i(view2, "viewHolder.itemView");
                a.onClick(view2);
            }
        }

        public static final /* synthetic */ C2347a m7593a(C2350c c2350c) {
            C2347a c2347a = c2350c.cGr;
            if (c2347a == null) {
                esl.mF("itemClickListener");
            }
            return c2347a;
        }

        public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
            return m7599k(viewGroup, i);
        }

        public C2348b m7599k(ViewGroup viewGroup, int i) {
            return new C2348b(LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null).inflate(R.layout.list_item, viewGroup, false));
        }

        public void m7596a(C2348b c2348b, int i) {
            if (c2348b != null) {
                FlexibleTextView ahr = c2348b.ahr();
                if (ahr != null) {
                    ahr.setText((CharSequence) this.suggestionList.get(i));
                }
            }
            if (c2348b != null) {
                View view = c2348b.arT;
                if (view != null) {
                    view.setOnClickListener(new C2349c(this, c2348b));
                }
            }
        }

        public int getItemCount() {
            return this.suggestionList.size();
        }

        public final void m7595a(C2347a c2347a) {
            esl.m11128j(c2347a, "listener");
            this.cGr = c2347a;
        }

        public final void m7598j(ArrayList<String> arrayList) {
            esl.m11128j(arrayList, "dataList");
            this.suggestionList.clear();
            this.suggestionList.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    static final class C2351d implements OnClickListener {
        final /* synthetic */ cuo cGq;

        C2351d(cuo com_fossil_cuo) {
            this.cGq = com_fossil_cuo;
        }

        public final void onClick(View view) {
            ew activity = this.cGq.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final class C2352e implements TextWatcher {
        final /* synthetic */ cuo cGq;
        final /* synthetic */ clb cGv;

        C2352e(cuo com_fossil_cuo, clb com_fossil_clb) {
            this.cGq = com_fossil_cuo;
            this.cGv = com_fossil_clb;
        }

        public void afterTextChanged(Editable editable) {
            esl.m11128j(editable, "s");
            MFLogger.m12670d(cuo.class.getSimpleName(), "afterTextChanged");
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            esl.m11128j(charSequence, "s");
            MFLogger.m12670d(cuo.class.getSimpleName(), "beforeTextChanged start=" + i + " after=" + i3 + " count=" + i2);
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            esl.m11128j(charSequence, "s");
            MFLogger.m12670d(cuo.class.getSimpleName(), "onTextChanged start=" + i + " before=" + i2 + " count=" + i3);
            this.cGv.csE.setVisibility(8);
            String obj = charSequence.toString();
            while (!TextUtils.isEmpty(obj) && obj.charAt(0) == ' ') {
                int length = obj.length();
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                obj = obj.substring(1, length);
                esl.m11127i(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                this.cGv.csD.setText(obj);
                this.cGv.csD.setSelection(obj.length());
            }
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (etd.trim(obj).toString().length() > 3) {
                MFLogger.m12670d(cuo.class.getSimpleName(), "Send message");
                Handler ahp = this.cGq.ahp();
                length = this.cGq.aho();
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                Message obtainMessage = ahp.obtainMessage(length, etd.trim(obj).toString());
                this.cGq.ahp().removeCallbacksAndMessages(null);
                this.cGq.ahp().sendMessageDelayed(obtainMessage, 3000);
            } else {
                this.cGq.mo2072V(new ArrayList());
            }
        }
    }

    static final class C2353f implements OnClickListener {
        final /* synthetic */ cuo cGq;
        final /* synthetic */ clb cGv;

        C2353f(cuo com_fossil_cuo, clb com_fossil_clb) {
            this.cGq = com_fossil_cuo;
            this.cGv = com_fossil_clb;
        }

        public final void onClick(View view) {
            cmj.bs(this.cGq.getContext()).m7086l("stats_bc_register", "Step", "2");
            String obj = this.cGv.csD.getText().toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            obj = etd.trim(obj).toString();
            if (obj != null && obj.length() > 3) {
                cuo.m7601b(this.cGq).mo2078E(obj, this.cGq.ahq());
            }
        }
    }

    public static final class C2354g implements C2347a {
        final /* synthetic */ clb cGv;

        C2354g(clb com_fossil_clb) {
            this.cGv = com_fossil_clb;
        }

        public void onClick(View view) {
            esl.m11128j(view, "v");
            View findViewById = view.findViewById(R.id.ftvSuggestionName);
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.view.FlexibleTextView");
            }
            CharSequence text = ((FlexibleTextView) findViewById).getText();
            this.cGv.csD.setText(text);
            this.cGv.csD.setSelection(text.length());
        }
    }

    public static final /* synthetic */ dqo m7600a(cuo com_fossil_cuo) {
        dqo com_fossil_dqo = com_fossil_cuo.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        return com_fossil_dqo;
    }

    public static final /* synthetic */ C2343a m7601b(cuo com_fossil_cuo) {
        C2343a c2343a = com_fossil_cuo.cGk;
        if (c2343a == null) {
            esl.mF("mPresenter");
        }
        return c2343a;
    }

    public /* synthetic */ void cK(Object obj) {
        m7603a((C2343a) obj);
    }

    public final int aho() {
        return this.cGm;
    }

    public final Handler ahp() {
        return this.mHandler;
    }

    public final int ahq() {
        return this.cGo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cGo = getArguments().getInt("EXTRA_STEP_GOAL");
        this.cBQ = getArguments().getInt("CHALLENGE_TYPE");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String firstName;
        String str = null;
        clb com_fossil_clb = (clb) C3311e.m10386a(layoutInflater, R.layout.fragment_create_bc_account, viewGroup, false, this.cEN);
        cpj ace = cnq.acd().ace();
        MFUser currentUser = ace != null ? ace.getCurrentUser() : null;
        FlexibleTextView flexibleTextView = com_fossil_clb.csF;
        esm com_fossil_esm = esm.dSO;
        String string = getString(R.string.Stats_BC_Search_Text_Hi_name_to_continue_you);
        esl.m11127i(string, "getString(R.string.Stats…_Hi_name_to_continue_you)");
        Object[] objArr = new Object[1];
        if (currentUser != null) {
            firstName = currentUser.getFirstName();
        } else {
            firstName = null;
        }
        objArr[0] = firstName;
        firstName = String.format(string, Arrays.copyOf(objArr, objArr.length));
        esl.m11127i(firstName, "java.lang.String.format(format, *args)");
        flexibleTextView.setText(firstName);
        com_fossil_clb.crs.setOnClickListener(new C2351d(this));
        this.cGl.m7595a((C2347a) new C2354g(com_fossil_clb));
        com_fossil_clb.csE.setVisibility(4);
        com_fossil_clb.csz.setVisibility(8);
        com_fossil_clb.csH.setLayoutManager(new LinearLayoutManager(PortfolioApp.ZQ().getApplicationContext()));
        com_fossil_clb.csH.setAdapter(this.cGl);
        if (TextUtils.isEmpty(currentUser != null ? currentUser.getProfilePicture() : null)) {
            String profilePicture;
            FossilCircleImageView fossilCircleImageView = com_fossil_clb.csJ;
            if (currentUser != null) {
                profilePicture = currentUser.getProfilePicture();
            } else {
                profilePicture = null;
            }
            StringBuilder append = new StringBuilder().append(currentUser != null ? currentUser.getFirstName() : null).append("");
            if (currentUser != null) {
                str = currentUser.getLastName();
            }
            fossilCircleImageView.m12734a(profilePicture, append.append(str).toString(), tx.t(this));
            com_fossil_clb.csJ.setBorderWidth(2);
            com_fossil_clb.csJ.setBorderColor(gn.m10634e(getContext(), R.color.coolGrey));
        } else {
            FossilCircleImageView fossilCircleImageView2 = com_fossil_clb.csJ;
            if (fossilCircleImageView2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.portfolio.platform.view.FossilCircleImageView");
            }
            if (currentUser != null) {
                str = currentUser.getProfilePicture();
            }
            fossilCircleImageView2.m12733a(str, tx.t(this));
        }
        com_fossil_clb.csD.addTextChangedListener(new C2352e(this, com_fossil_clb));
        com_fossil_clb.csC.setOnClickListener(new C2353f(this, com_fossil_clb));
        com_fossil_clb.csC.setEnabled(false);
        this.cEY = new dqo(this, com_fossil_clb);
        return com_fossil_clb.dz();
    }

    public void m7603a(C2343a c2343a) {
        esl.m11128j(c2343a, "presenter");
        this.cGk = c2343a;
    }

    public void mo2077t(int i, String str) {
        dqo com_fossil_dqo;
        clb com_fossil_clb;
        FlexibleTextView flexibleTextView;
        FlexibleTextView flexibleTextView2;
        if (i == 1) {
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clb = (clb) com_fossil_dqo.get();
            if (com_fossil_clb != null) {
                FlexibleButton flexibleButton = com_fossil_clb.csC;
                if (flexibleButton != null) {
                    flexibleButton.setEnabled(true);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clb = (clb) com_fossil_dqo.get();
            if (com_fossil_clb != null) {
                flexibleTextView = com_fossil_clb.csE;
                if (flexibleTextView != null) {
                    flexibleTextView.setVisibility(0);
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clb = (clb) com_fossil_dqo.get();
            if (com_fossil_clb != null) {
                flexibleTextView2 = com_fossil_clb.csE;
                if (flexibleTextView2 != null) {
                    flexibleTextView2.setText(arp.m4318u(getContext(), R.string.Stats_BC_Search_Label_Available));
                }
            }
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clb = (clb) com_fossil_dqo.get();
            if (com_fossil_clb != null) {
                flexibleTextView = com_fossil_clb.csE;
                if (flexibleTextView != null) {
                    flexibleTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(gn.m10632c(getContext(), R.drawable.red_checkmark), null, null, null);
                    return;
                }
                return;
            }
            return;
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clb = (clb) com_fossil_dqo.get();
        if (com_fossil_clb != null) {
            flexibleTextView = com_fossil_clb.csE;
            if (flexibleTextView != null) {
                flexibleTextView.setVisibility(0);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clb = (clb) com_fossil_dqo.get();
        if (com_fossil_clb != null) {
            flexibleTextView2 = com_fossil_clb.csE;
            if (flexibleTextView2 != null) {
                flexibleTextView2.setText(arp.m4318u(getContext(), R.string.Stats_BC_Search_Error_Username_unavailable_Try_again));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clb = (clb) com_fossil_dqo.get();
        if (com_fossil_clb != null) {
            flexibleTextView = com_fossil_clb.csE;
            if (flexibleTextView != null) {
                flexibleTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
            }
        }
    }

    public void mo2072V(List<String> list) {
        clb com_fossil_clb;
        ConstraintLayout constraintLayout;
        if (list == null || list.size() <= 0) {
            dqo com_fossil_dqo;
            com_fossil_dqo = this.cEY;
            if (com_fossil_dqo == null) {
                esl.mF("mBinding");
            }
            com_fossil_clb = (clb) com_fossil_dqo.get();
            if (com_fossil_clb != null) {
                constraintLayout = com_fossil_clb.csz;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                }
            }
            C2350c c2350c = this.cGl;
            if (list == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            }
            c2350c.m7598j((ArrayList) list);
            return;
        }
        FlexibleTextView flexibleTextView;
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clb = (clb) com_fossil_dqo.get();
        if (com_fossil_clb != null) {
            flexibleTextView = com_fossil_clb.csE;
            if (flexibleTextView != null) {
                flexibleTextView.setVisibility(0);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clb = (clb) com_fossil_dqo.get();
        if (com_fossil_clb != null) {
            FlexibleTextView flexibleTextView2 = com_fossil_clb.csE;
            if (flexibleTextView2 != null) {
                flexibleTextView2.setText(arp.m4318u(getContext(), R.string.Stats_BC_Search_Error_Username_unavailable_Try_again));
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clb = (clb) com_fossil_dqo.get();
        if (com_fossil_clb != null) {
            flexibleTextView = com_fossil_clb.csE;
            if (flexibleTextView != null) {
                flexibleTextView.setCompoundDrawables(null, null, null, null);
            }
        }
        com_fossil_dqo = this.cEY;
        if (com_fossil_dqo == null) {
            esl.mF("mBinding");
        }
        com_fossil_clb = (clb) com_fossil_dqo.get();
        if (com_fossil_clb != null) {
            constraintLayout = com_fossil_clb.csz;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
        }
        this.cGl.m7598j((ArrayList) list);
    }

    public void showDialog() {
        afT();
    }

    public void ahn() {
        afU();
    }

    public void ahm() {
        BCFindOpponentActivity.b(getContext(), this.cBQ, false);
        ew activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void jV(int i) {
        dqw.m9419a(i, getChildFragmentManager());
    }
}
