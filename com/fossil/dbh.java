package com.fossil;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.dbg.C2619a;
import com.fossil.dbg.C2620b;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.fitness.SampleDay;
import com.fossil.wearables.fsl.fitness.SampleRaw;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.LandingPage;
import com.portfolio.platform.helper.ImageHelper;
import com.portfolio.platform.helper.ImageHelper.FLIP;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.RingChart;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class dbh extends ctm implements OnDismissListener, OnAttachStateChangeListener, OnClickListener, C2620b {
    public static final String TAG = dbh.class.getSimpleName();
    private C2619a cNW;
    private RingChart cNX;
    private FlexibleTextView cNY;
    private FlexibleTextView cNZ;
    private ImageView cOa;
    doy cOb;
    private dow cOc;

    class C26211 extends aaw<Bitmap> {
        final /* synthetic */ dbh cOd;

        C26211(dbh com_fossil_dbh) {
            this.cOd = com_fossil_dbh;
        }

        public void m8124a(Bitmap bitmap, aal<? super Bitmap> com_fossil_aal__super_android_graphics_Bitmap) {
            if (PortfolioApp.ZQ().getResources().getConfiguration().getLayoutDirection() == 1) {
                bitmap = ImageHelper.a(bitmap, FLIP.HORIZONTAL);
            }
            this.cOd.cOa.setImageBitmap(bitmap);
        }
    }

    public /* synthetic */ void cK(Object obj) {
        m8127a((C2619a) obj);
    }

    public static dbh ali() {
        return new dbh();
    }

    public void m8127a(C2619a c2619a) {
        this.cNW = (C2619a) cco.ce(c2619a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home_activity, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cNX = (RingChart) view.findViewById(R.id.chart);
        this.cNZ = (FlexibleTextView) view.findViewById(R.id.ftvStepGoal);
        this.cNY = (FlexibleTextView) view.findViewById(R.id.ftvSteps);
        this.cOa = (ImageView) view.findViewById(R.id.iv_background);
        this.cOc = (dow) getChildFragmentManager().mo3086W(dow.dcC.getTAG());
        if (this.cOc == null) {
            this.cOc = dow.dcC.aty();
        }
        PortfolioApp.ZQ().aam().mo1806a(new dbj(this.cOc)).mo1778a(this);
        view.findViewById(R.id.acivEditInfo).setOnClickListener(this);
        this.cNY.setOnClickListener(this);
        this.cNZ.setOnClickListener(this);
        view.addOnAttachStateChangeListener(this);
    }

    public void onResume() {
        super.onResume();
        MFLogger.m12670d(TAG, "Inside .onResume");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cNW.start();
        }
    }

    public void onPause() {
        super.onPause();
        MFLogger.m12670d(TAG, "Inside .onPause");
        if (getView() != null && getView().isAttachedToWindow()) {
            this.cNW.stop();
        }
    }

    public void onViewAttachedToWindow(View view) {
        MFLogger.m12670d(TAG, "onViewAttachedToWindow");
        this.cNW.start();
    }

    public void onViewDetachedFromWindow(View view) {
        MFLogger.m12670d(TAG, "onViewDetachedFromWindow");
        this.cNW.stop();
    }

    public void mo2237b(SampleDay sampleDay) {
        MFLogger.m12670d(TAG, "Inside .onSampleDayChanged sampleDay=" + sampleDay);
        if (sampleDay != null) {
            this.cNX.setGoal(sampleDay.getStepGoal());
            this.cNX.XT();
            this.cNZ.setText(String.format(arp.m4318u(getContext(), R.string.Stats_Activity_Text_OF__STEPS), new Object[]{NumberFormat.getNumberInstance(Locale.US).format((long) sampleDay.getStepGoal())}));
        }
    }

    public void mo2239f(List<SampleRaw> list, int i) {
        MFLogger.m12670d(TAG, "showActivities: data = " + list);
        this.cNX.clearData();
        this.cNX.setGoal(i);
        if (list != null) {
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (SampleRaw sampleRaw : list) {
                float steps;
                switch (cmt.aC(((long) sampleRaw.getSteps()) / ((long) cmq.m7113c(sampleRaw.getStartTime(), sampleRaw.getEndTime())))) {
                    case 0:
                        steps = (float) (sampleRaw.getSteps() + ((double) f));
                        f = f2;
                        f2 = f3;
                        break;
                    case 2:
                        steps = f;
                        f = f2;
                        f2 = (float) (((double) f3) + sampleRaw.getSteps());
                        break;
                    default:
                        steps = f;
                        f = (float) (((double) f2) + sampleRaw.getSteps());
                        f2 = f3;
                        break;
                }
                f3 = f2;
                f2 = f;
                f = steps;
            }
            this.cNY.setText(NumberFormat.getNumberInstance(Locale.US).format((long) ((int) ((f + f2) + f3))));
            this.cNX.f(f, gn.m10634e(getContext(), R.color.hexFF9F84));
            this.cNX.f(f2, gn.m10634e(getContext(), R.color.fossilOrange));
            this.cNX.f(f3, gn.m10634e(getContext(), R.color.hexCD2D00));
        }
        this.cNX.XT();
        this.cNZ.setText(String.format(arp.m4318u(getContext(), R.string.Stats_Activity_Text_OF__STEPS), new Object[]{NumberFormat.getNumberInstance(Locale.US).format((long) i)}));
    }

    public void mo2238b(LandingPage landingPage) {
        if (isActive()) {
            MFLogger.m12670d(TAG, "Inside .onLandingPageReceived landingPageBackgroundUrl=" + landingPage.getBackgroundUrl());
            tx.t(this).ah(landingPage.getBackgroundUrl()).tA().a(DiskCacheStrategy.ALL).a(new C26211(this));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ftvSteps:
            case R.id.ftvStepGoal:
                cnp.acc().gu("fossilq://main/view=stats");
                m7519n("stats", "Source", "Home");
                return;
            case R.id.acivEditInfo:
                if (!this.cOc.isActive()) {
                    this.cOc.setCancelable(false);
                    this.cOc.setDimAmount(0.0f);
                    this.cOc.lc(aid());
                    this.cOc.show(getChildFragmentManager(), dow.dcC.getTAG());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private int alj() {
        Resources resources = PortfolioApp.ZQ().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    private int aid() {
        int height = getActivity().getWindow().findViewById(16908290).getHeight();
        TypedValue typedValue = new TypedValue();
        int i = 0;
        if (getContext().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, PortfolioApp.ZQ().getResources().getDisplayMetrics());
        }
        return (height - i) - alj();
    }

    public String getTAG() {
        return TAG;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.cNW.start();
    }
}
