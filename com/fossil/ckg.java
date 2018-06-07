package com.fossil;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.fossil.dy.C2143a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.ArrayList;
import java.util.List;

public class ckg extends C1234a<C2145a> {
    private static String TAG = ckg.class.getSimpleName();
    private C2146b cot;
    private short[] cou;
    private View cov;
    private final tz cow;
    private List<MicroApp> mMicroAppList;

    public class C2145a extends C1264v implements OnClickListener {
        private ImageView coC;
        private FlexibleTextView coD;
        private FlexibleTextView coE;
        private View coF;
        private MicroApp coG;
        private C2146b cot;
        final /* synthetic */ ckg coz;

        private C2145a(ckg com_fossil_ckg, View view, C2146b c2146b) {
            this.coz = com_fossil_ckg;
            super(view);
            this.coC = (ImageView) view.findViewById(R.id.feature_icon);
            this.coD = (FlexibleTextView) view.findViewById(R.id.feature_name);
            this.coE = (FlexibleTextView) view.findViewById(R.id.tag);
            this.coF = view.findViewById(R.id.icon_layout);
            this.cot = c2146b;
            this.coF.setOnClickListener(this);
        }

        public void onClick(View view) {
            MFLogger.m12670d(ckg.TAG, "onClick");
            this.cot.mo2385a(this.coG);
        }
    }

    public interface C2146b {
        void mo2385a(MicroApp microApp);
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m6911g(viewGroup, i);
    }

    public ckg(List<MicroApp> list, List<MicroAppSetting> list2, C2146b c2146b, tz tzVar) {
        if (this.mMicroAppList == null) {
            this.mMicroAppList = new ArrayList();
        }
        this.mMicroAppList.clear();
        this.mMicroAppList.addAll(list);
        this.cot = c2146b;
        m6903J(list2);
        this.cow = tzVar;
    }

    public void m6909a(List<MicroApp> list, List<MicroAppSetting> list2) {
        if (this.mMicroAppList == null) {
            this.mMicroAppList = new ArrayList();
        }
        this.mMicroAppList.clear();
        this.mMicroAppList.addAll(list);
        m6903J(list2);
    }

    private void m6903J(List<MicroAppSetting> list) {
        if (this.mMicroAppList != null && !this.mMicroAppList.isEmpty()) {
            this.cou = new short[this.mMicroAppList.size()];
            for (int i = 0; i < this.mMicroAppList.size(); i++) {
                if ((System.currentTimeMillis() - ((MicroApp) this.mMicroAppList.get(i)).getReleaseDate()) / cne.cyM > 30) {
                    this.cou[i] = (short) -1;
                } else {
                    MicroAppSetting f = m6906f(((MicroApp) this.mMicroAppList.get(i)).getAppId(), list);
                    if (f == null) {
                        this.cou[i] = (short) 0;
                    } else if (f.getFirstUsed() <= 0) {
                        this.cou[i] = (short) 0;
                    } else {
                        this.cou[i] = (short) -1;
                    }
                }
            }
        }
    }

    private MicroAppSetting m6906f(String str, List<MicroAppSetting> list) {
        for (int i = 0; i < list.size(); i++) {
            if (((MicroAppSetting) list.get(i)).getMicroAppId().equals(str)) {
                return (MicroAppSetting) list.get(i);
            }
        }
        return null;
    }

    public C2145a m6911g(ViewGroup viewGroup, int i) {
        MFLogger.m12670d(TAG, "onCreateViewHolder type=" + i);
        C2145a c2145a = new C2145a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_micro_app, viewGroup, false), this.cot);
        m6905a(c2145a);
        return c2145a;
    }

    public void m6908a(C2145a c2145a, int i) {
        MFLogger.m12670d(TAG, "onBindViewHolder position=" + i + "name=" + ((MicroApp) this.mMicroAppList.get(i)).getName());
        c2145a.coD.setText(((MicroApp) this.mMicroAppList.get(i)).getName());
        this.cow.ah(((MicroApp) this.mMicroAppList.get(i)).getIconUrl()).ew(((MicroApp) this.mMicroAppList.get(i)).getDefaultIconId()).c(c2145a.coC);
        c2145a.coG = (MicroApp) this.mMicroAppList.get(i);
        c2145a.coE.setVisibility(this.cou[i] == (short) 0 ? 0 : 4);
    }

    public int getItemCount() {
        return this.mMicroAppList.size();
    }

    private void m6905a(final C2145a c2145a) {
        MFLogger.m12670d(TAG, "setUpDraggableImage");
        C2143a c21441 = new C2143a(this) {
            private final float cox = 1.2f;
            final /* synthetic */ ckg coz;

            public boolean mo1878a(View view, final dy dyVar) {
                MFLogger.m12670d(ckg.TAG, "Drag start event received from helper.");
                cmj.bs(PortfolioApp.ZQ()).m7086l("microapp_drag", "App", c2145a.coG.getAppId());
                this.coz.cov = c2145a.coF;
                c2145a.coF.setAlpha(0.0f);
                DragShadowBuilder c21421 = new DragShadowBuilder(this, view) {
                    final /* synthetic */ C21441 coB;

                    public void onProvideShadowMetrics(Point point, Point point2) {
                        super.onProvideShadowMetrics(point, point2);
                        int width = (int) (((float) getView().getWidth()) * 1.2f);
                        int height = (int) (((float) getView().getHeight()) * 1.2f);
                        point.set(width, height);
                        point2.set(width / 2, height / 2);
                        dyVar.m10274a(point2);
                        MFLogger.m12670d(ckg.TAG, "View was touched at: " + point2);
                    }

                    public void onDrawShadow(Canvas canvas) {
                        canvas.scale(1.2f, 1.2f);
                        if (getView() != null) {
                            getView().draw(canvas);
                        }
                    }
                };
                ClipData clipData = new ClipData(new ClipDescription("MICRO_APP", new String[]{"text/plain"}), new Item(c2145a.coG.getAppId()));
                MFLogger.m12670d(ckg.TAG, "Created ClipDescription. Starting drag and drop.");
                if (VERSION.SDK_INT >= 24) {
                    return view.startDragAndDrop(clipData, c21421, null, 257);
                }
                return view.startDrag(clipData, c21421, null, 257);
            }
        };
        MFLogger.m12670d(TAG, "DragStartHelper attached to view.");
        new dy(c2145a.coF, c21441).hG();
    }

    public void abt() {
        MFLogger.m12670d(TAG, "dragStopped");
        if (this.cov != null) {
            this.cov.setAlpha(1.0f);
            this.cov.startAnimation(AnimationUtils.loadAnimation(this.cov.getContext(), R.anim.bouncing_animation));
        }
    }
}
