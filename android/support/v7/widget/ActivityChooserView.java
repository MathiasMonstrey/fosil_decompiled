package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.fossil.kc;
import com.fossil.li;
import com.fossil.pk.d;
import com.fossil.pk.f;
import com.fossil.pk.g;
import com.fossil.pk.h;
import com.fossil.pk.j;
import com.fossil.qu;
import com.fossil.rc;
import com.fossil.ry;
import com.fossil.sw;

public class ActivityChooserView extends ViewGroup {
    OnDismissListener afM;
    final C1209a ajA;
    private final C1210b ajB;
    private final LinearLayoutCompat ajC;
    private final Drawable ajD;
    final FrameLayout ajE;
    private final ImageView ajF;
    final FrameLayout ajG;
    private final ImageView ajH;
    private final int ajI;
    kc ajJ;
    final DataSetObserver ajK;
    private final OnGlobalLayoutListener ajL;
    private ListPopupWindow ajM;
    boolean ajN;
    int ajO;
    private int ajP;
    private boolean yp;

    class C01821 extends DataSetObserver {
        final /* synthetic */ ActivityChooserView ajQ;

        C01821(ActivityChooserView activityChooserView) {
            this.ajQ = activityChooserView;
        }

        public void onChanged() {
            super.onChanged();
            this.ajQ.ajA.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            this.ajQ.ajA.notifyDataSetInvalidated();
        }
    }

    class C01832 implements OnGlobalLayoutListener {
        final /* synthetic */ ActivityChooserView ajQ;

        C01832(ActivityChooserView activityChooserView) {
            this.ajQ = activityChooserView;
        }

        public void onGlobalLayout() {
            if (!this.ajQ.od()) {
                return;
            }
            if (this.ajQ.isShown()) {
                this.ajQ.getListPopupWindow().show();
                if (this.ajQ.ajJ != null) {
                    this.ajQ.ajJ.subUiVisibilityChanged(true);
                    return;
                }
                return;
            }
            this.ajQ.getListPopupWindow().dismiss();
        }
    }

    class C01854 extends DataSetObserver {
        final /* synthetic */ ActivityChooserView ajQ;

        C01854(ActivityChooserView activityChooserView) {
            this.ajQ = activityChooserView;
        }

        public void onChanged() {
            super.onChanged();
            this.ajQ.oe();
        }
    }

    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] afU = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            sw a = sw.a(context, attributeSet, afU);
            setBackgroundDrawable(a.getDrawable(0));
            a.recycle();
        }
    }

    class C1209a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView ajQ;
        private rc ajR;
        private int ajS = 4;
        private boolean ajT;
        private boolean ajU;
        private boolean ajV;

        C1209a(ActivityChooserView activityChooserView) {
            this.ajQ = activityChooserView;
        }

        public void m2201a(rc rcVar) {
            rc dataModel = this.ajQ.ajA.getDataModel();
            if (dataModel != null && this.ajQ.isShown()) {
                dataModel.unregisterObserver(this.ajQ.ajK);
            }
            this.ajR = rcVar;
            if (rcVar != null && this.ajQ.isShown()) {
                rcVar.registerObserver(this.ajQ.ajK);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            if (this.ajV && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int nS = this.ajR.nS();
            if (!(this.ajT || this.ajR.nT() == null)) {
                nS--;
            }
            nS = Math.min(nS, this.ajS);
            if (this.ajV) {
                return nS + 1;
            }
            return nS;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.ajT || this.ajR.nT() == null)) {
                        i++;
                    }
                    return this.ajR.cG(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != f.list_item) {
                        view = LayoutInflater.from(this.ajQ.getContext()).inflate(g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.ajQ.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.ajT && i == 0 && this.ajU) {
                        li.m12259d(view, true);
                        return view;
                    }
                    li.m12259d(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.ajQ.getContext()).inflate(g.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(f.title)).setText(this.ajQ.getContext().getString(h.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int og() {
            int i = 0;
            int i2 = this.ajS;
            this.ajS = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.ajS = i2;
            return i3;
        }

        public void cK(int i) {
            if (this.ajS != i) {
                this.ajS = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo nT() {
            return this.ajR.nT();
        }

        public void aj(boolean z) {
            if (this.ajV != z) {
                this.ajV = z;
                notifyDataSetChanged();
            }
        }

        public int nS() {
            return this.ajR.nS();
        }

        public int getHistorySize() {
            return this.ajR.getHistorySize();
        }

        public rc getDataModel() {
            return this.ajR;
        }

        public void m2202f(boolean z, boolean z2) {
            if (this.ajT != z || this.ajU != z2) {
                this.ajT = z;
                this.ajU = z2;
                notifyDataSetChanged();
            }
        }

        public boolean oh() {
            return this.ajT;
        }
    }

    class C1210b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView ajQ;

        C1210b(ActivityChooserView activityChooserView) {
            this.ajQ = activityChooserView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C1209a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.ajQ.oc();
                    if (!this.ajQ.ajN) {
                        if (!this.ajQ.ajA.oh()) {
                            i++;
                        }
                        Intent cH = this.ajQ.ajA.getDataModel().cH(i);
                        if (cH != null) {
                            cH.addFlags(524288);
                            this.ajQ.getContext().startActivity(cH);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.ajQ.ajA.getDataModel().cI(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.ajQ.cJ(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.ajQ.ajG) {
                this.ajQ.oc();
                Intent cH = this.ajQ.ajA.getDataModel().cH(this.ajQ.ajA.getDataModel().a(this.ajQ.ajA.nT()));
                if (cH != null) {
                    cH.addFlags(524288);
                    this.ajQ.getContext().startActivity(cH);
                }
            } else if (view == this.ajQ.ajE) {
                this.ajQ.ajN = false;
                this.ajQ.cJ(this.ajQ.ajO);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.ajQ.ajG) {
                if (this.ajQ.ajA.getCount() > 0) {
                    this.ajQ.ajN = true;
                    this.ajQ.cJ(this.ajQ.ajO);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            oi();
            if (this.ajQ.ajJ != null) {
                this.ajQ.ajJ.subUiVisibilityChanged(false);
            }
        }

        private void oi() {
            if (this.ajQ.afM != null) {
                this.ajQ.afM.onDismiss();
            }
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajK = new C01821(this);
        this.ajL = new C01832(this);
        this.ajO = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActivityChooserView, i, 0);
        this.ajO = obtainStyledAttributes.getInt(j.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(j.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(g.abc_activity_chooser_view, this, true);
        this.ajB = new C1210b(this);
        this.ajC = (LinearLayoutCompat) findViewById(f.activity_chooser_view_content);
        this.ajD = this.ajC.getBackground();
        this.ajG = (FrameLayout) findViewById(f.default_activity_button);
        this.ajG.setOnClickListener(this.ajB);
        this.ajG.setOnLongClickListener(this.ajB);
        this.ajH = (ImageView) this.ajG.findViewById(f.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.expand_activities_button);
        frameLayout.setOnClickListener(this.ajB);
        frameLayout.setOnTouchListener(new ry(this, frameLayout) {
            final /* synthetic */ ActivityChooserView ajQ;

            public qu mC() {
                return this.ajQ.getListPopupWindow();
            }

            protected boolean mD() {
                this.ajQ.ob();
                return true;
            }

            protected boolean nN() {
                this.ajQ.oc();
                return true;
            }
        });
        this.ajE = frameLayout;
        this.ajF = (ImageView) frameLayout.findViewById(f.image);
        this.ajF.setImageDrawable(drawable);
        this.ajA = new C1209a(this);
        this.ajA.registerDataSetObserver(new C01854(this));
        Resources resources = context.getResources();
        this.ajI = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(rc rcVar) {
        this.ajA.m2201a(rcVar);
        if (od()) {
            oc();
            ob();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.ajF.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.ajF.setContentDescription(getContext().getString(i));
    }

    public void setProvider(kc kcVar) {
        this.ajJ = kcVar;
    }

    public boolean ob() {
        if (od() || !this.yp) {
            return false;
        }
        this.ajN = false;
        cJ(this.ajO);
        return true;
    }

    void cJ(int i) {
        if (this.ajA.getDataModel() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.ajL);
        boolean z = this.ajG.getVisibility() == 0;
        int nS = this.ajA.nS();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || nS <= r3 + i) {
            this.ajA.aj(false);
            this.ajA.cK(i);
        } else {
            this.ajA.aj(true);
            this.ajA.cK(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.isShowing()) {
            if (this.ajN || !z) {
                this.ajA.m2202f(true, z);
            } else {
                this.ajA.m2202f(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.ajA.og(), this.ajI));
            listPopupWindow.show();
            if (this.ajJ != null) {
                this.ajJ.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(h.abc_activitychooserview_choose_application));
        }
    }

    public boolean oc() {
        if (od()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.ajL);
            }
        }
        return true;
    }

    public boolean od() {
        return getListPopupWindow().isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        rc dataModel = this.ajA.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.ajK);
        }
        this.yp = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rc dataModel = this.ajA.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.ajK);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.ajL);
        }
        if (od()) {
            oc();
        }
        this.yp = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.ajC;
        if (this.ajG.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.ajC.layout(0, 0, i3 - i, i4 - i2);
        if (!od()) {
            oc();
        }
    }

    public rc getDataModel() {
        return this.ajA.getDataModel();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.afM = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.ajO = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.ajP = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.ajM == null) {
            this.ajM = new ListPopupWindow(getContext());
            this.ajM.setAdapter(this.ajA);
            this.ajM.setAnchorView(this);
            this.ajM.setModal(true);
            this.ajM.setOnItemClickListener(this.ajB);
            this.ajM.setOnDismissListener(this.ajB);
        }
        return this.ajM;
    }

    void oe() {
        if (this.ajA.getCount() > 0) {
            this.ajE.setEnabled(true);
        } else {
            this.ajE.setEnabled(false);
        }
        int nS = this.ajA.nS();
        int historySize = this.ajA.getHistorySize();
        if (nS == 1 || (nS > 1 && historySize > 0)) {
            this.ajG.setVisibility(0);
            ResolveInfo nT = this.ajA.nT();
            PackageManager packageManager = getContext().getPackageManager();
            this.ajH.setImageDrawable(nT.loadIcon(packageManager));
            if (this.ajP != 0) {
                CharSequence loadLabel = nT.loadLabel(packageManager);
                this.ajG.setContentDescription(getContext().getString(this.ajP, new Object[]{loadLabel}));
            }
        } else {
            this.ajG.setVisibility(8);
        }
        if (this.ajG.getVisibility() == 0) {
            this.ajC.setBackgroundDrawable(this.ajD);
        } else {
            this.ajC.setBackgroundDrawable(null);
        }
    }
}
