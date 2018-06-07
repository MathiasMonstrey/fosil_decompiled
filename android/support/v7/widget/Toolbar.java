package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.ActionMenuView.C1208d;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.fossil.ix;
import com.fossil.iy;
import com.fossil.jy;
import com.fossil.ke;
import com.fossil.kn;
import com.fossil.kp;
import com.fossil.ks;
import com.fossil.li;
import com.fossil.pk;
import com.fossil.pk.j;
import com.fossil.pn;
import com.fossil.pv;
import com.fossil.pz;
import com.fossil.qj;
import com.fossil.ql;
import com.fossil.qq;
import com.fossil.qq.a;
import com.fossil.qw;
import com.fossil.rb;
import com.fossil.rt;
import com.fossil.sl;
import com.fossil.sw;
import com.fossil.sx;
import com.fossil.tb;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean ahA;
    private Context ahu;
    private ActionMenuView ahv;
    private boolean ahz;
    private int aiV;
    private a aiX;
    private qj.a aiY;
    private TextView auY;
    private TextView auZ;
    private sx avA;
    private rb avB;
    private C1282a avC;
    private final Runnable avD;
    private ImageButton ava;
    private ImageView avb;
    private Drawable avc;
    private CharSequence avd;
    ImageButton ave;
    View avf;
    private int avg;
    private int avh;
    int avi;
    private int avj;
    private int avk;
    private int avl;
    private int avm;
    private int avn;
    private sl avo;
    private int avp;
    private int avq;
    private CharSequence avr;
    private CharSequence avs;
    private int avt;
    private int avu;
    private final ArrayList<View> avv;
    private final ArrayList<View> avw;
    private final int[] avx;
    C1283b avy;
    private final C1208d avz;
    private int mGravity;
    private boolean vn;

    class C02401 implements C1208d {
        final /* synthetic */ Toolbar avE;

        C02401(Toolbar toolbar) {
            this.avE = toolbar;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.avE.avy != null) {
                return this.avE.avy.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class C02412 implements Runnable {
        final /* synthetic */ Toolbar avE;

        C02412(Toolbar toolbar) {
            this.avE = toolbar;
        }

        public void run() {
            this.avE.showOverflowMenu();
        }
    }

    class C02423 implements OnClickListener {
        final /* synthetic */ Toolbar avE;

        C02423(Toolbar toolbar) {
            this.avE = toolbar;
        }

        public void onClick(View view) {
            this.avE.collapseActionView();
        }
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int avG;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.avG = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.avG = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.avG = 0;
            this.avG = layoutParams.avG;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.avG = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.avG = 0;
            m2582d(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.avG = 0;
        }

        void m2582d(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    class C1282a implements qq {
        final /* synthetic */ Toolbar avE;
        ql avF;
        qj uh;

        C1282a(Toolbar toolbar) {
            this.avE = toolbar;
        }

        public void m2583a(Context context, qj qjVar) {
            if (!(this.uh == null || this.avF == null)) {
                this.uh.f(this.avF);
            }
            this.uh = qjVar;
        }

        public void m2589g(boolean z) {
            Object obj = null;
            if (this.avF != null) {
                if (this.uh != null) {
                    int size = this.uh.size();
                    for (int i = 0; i < size; i++) {
                        if (this.uh.getItem(i) == this.avF) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    m2588b(this.uh, this.avF);
                }
            }
        }

        public void m2585a(a aVar) {
        }

        public boolean m2587a(qw qwVar) {
            return false;
        }

        public void m2584a(qj qjVar, boolean z) {
        }

        public boolean eW() {
            return false;
        }

        public boolean m2586a(qj qjVar, ql qlVar) {
            this.avE.sw();
            if (this.avE.ave.getParent() != this.avE) {
                this.avE.addView(this.avE.ave);
            }
            this.avE.avf = qlVar.getActionView();
            this.avF = qlVar;
            if (this.avE.avf.getParent() != this.avE) {
                android.view.ViewGroup.LayoutParams sz = this.avE.sz();
                sz.gravity = 8388611 | (this.avE.avi & 112);
                sz.avG = 2;
                this.avE.avf.setLayoutParams(sz);
                this.avE.addView(this.avE.avf);
            }
            this.avE.sA();
            this.avE.requestLayout();
            qlVar.ah(true);
            if (this.avE.avf instanceof pv) {
                ((pv) this.avE.avf).onActionViewExpanded();
            }
            return true;
        }

        public boolean m2588b(qj qjVar, ql qlVar) {
            if (this.avE.avf instanceof pv) {
                ((pv) this.avE.avf).onActionViewCollapsed();
            }
            this.avE.removeView(this.avE.avf);
            this.avE.removeView(this.avE.ave);
            this.avE.avf = null;
            this.avE.sB();
            this.avF = null;
            this.avE.requestLayout();
            qlVar.ah(false);
            return true;
        }

        public int getId() {
            return 0;
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    public interface C1283b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class C1285c extends jy {
        public static final Creator<C1285c> CREATOR = ix.m11854a(new C12841());
        int avH;
        boolean avI;

        static class C12841 implements iy<C1285c> {
            C12841() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2590o(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return eo(i);
            }

            public C1285c m2590o(Parcel parcel, ClassLoader classLoader) {
                return new C1285c(parcel, classLoader);
            }

            public C1285c[] eo(int i) {
                return new C1285c[i];
            }
        }

        public C1285c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.avH = parcel.readInt();
            this.avI = parcel.readInt() != 0;
        }

        public C1285c(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.avH);
            parcel.writeInt(this.avI ? 1 : 0);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return sz();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2602k(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m2601g(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, pk.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.avv = new ArrayList();
        this.avw = new ArrayList();
        this.avx = new int[2];
        this.avz = new C02401(this);
        this.avD = new C02412(this);
        sw a = sw.a(getContext(), attributeSet, j.Toolbar, i, 0);
        this.avg = a.getResourceId(j.Toolbar_titleTextAppearance, 0);
        this.avh = a.getResourceId(j.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a.getInteger(j.Toolbar_android_gravity, this.mGravity);
        this.avi = a.getInteger(j.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = a.getDimensionPixelOffset(j.Toolbar_titleMargin, 0);
        if (a.hasValue(j.Toolbar_titleMargins)) {
            dimensionPixelOffset = a.getDimensionPixelOffset(j.Toolbar_titleMargins, dimensionPixelOffset);
        }
        this.avn = dimensionPixelOffset;
        this.avm = dimensionPixelOffset;
        this.avl = dimensionPixelOffset;
        this.avk = dimensionPixelOffset;
        dimensionPixelOffset = a.getDimensionPixelOffset(j.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset >= 0) {
            this.avk = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(j.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset >= 0) {
            this.avl = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(j.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset >= 0) {
            this.avm = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(j.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset >= 0) {
            this.avn = dimensionPixelOffset;
        }
        this.avj = a.getDimensionPixelSize(j.Toolbar_maxButtonHeight, -1);
        dimensionPixelOffset = a.getDimensionPixelOffset(j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset2 = a.getDimensionPixelOffset(j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = a.getDimensionPixelSize(j.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = a.getDimensionPixelSize(j.Toolbar_contentInsetRight, 0);
        sC();
        this.avo.aM(dimensionPixelSize, dimensionPixelSize2);
        if (!(dimensionPixelOffset == Integer.MIN_VALUE && dimensionPixelOffset2 == Integer.MIN_VALUE)) {
            this.avo.aL(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.avp = a.getDimensionPixelOffset(j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.avq = a.getDimensionPixelOffset(j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.avc = a.getDrawable(j.Toolbar_collapseIcon);
        this.avd = a.getText(j.Toolbar_collapseContentDescription);
        CharSequence text = a.getText(j.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = a.getText(j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.ahu = getContext();
        setPopupTheme(a.getResourceId(j.Toolbar_popupTheme, 0));
        Drawable drawable = a.getDrawable(j.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = a.getText(j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = a.getDrawable(j.Toolbar_logo);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = a.getText(j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text)) {
            setLogoDescription(text);
        }
        if (a.hasValue(j.Toolbar_titleTextColor)) {
            setTitleTextColor(a.getColor(j.Toolbar_titleTextColor, -1));
        }
        if (a.hasValue(j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.getColor(j.Toolbar_subtitleTextColor, -1));
        }
        a.recycle();
    }

    public void setPopupTheme(int i) {
        if (this.aiV != i) {
            this.aiV = i;
            if (i == 0) {
                this.ahu = getContext();
            } else {
                this.ahu = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.aiV;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.avk = i;
        this.avm = i2;
        this.avl = i3;
        this.avn = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.avk;
    }

    public void setTitleMarginStart(int i) {
        this.avk = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.avm;
    }

    public void setTitleMarginTop(int i) {
        this.avm = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.avl;
    }

    public void setTitleMarginEnd(int i) {
        this.avl = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.avn;
    }

    public void setTitleMarginBottom(int i) {
        this.avn = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        sC();
        sl slVar = this.avo;
        if (i != 1) {
            z = false;
        }
        slVar.au(z);
    }

    public void setLogo(int i) {
        setLogo(pn.c(getContext(), i));
    }

    public boolean nI() {
        return getVisibility() == 0 && this.ahv != null && this.ahv.nO();
    }

    public boolean isOverflowMenuShowing() {
        return this.ahv != null && this.ahv.isOverflowMenuShowing();
    }

    public boolean nJ() {
        return this.ahv != null && this.ahv.nJ();
    }

    public boolean showOverflowMenu() {
        return this.ahv != null && this.ahv.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.ahv != null && this.ahv.hideOverflowMenu();
    }

    public void m2599a(qj qjVar, rb rbVar) {
        if (qjVar != null || this.ahv != null) {
            su();
            qj nR = this.ahv.nR();
            if (nR != qjVar) {
                if (nR != null) {
                    nR.b(this.avB);
                    nR.b(this.avC);
                }
                if (this.avC == null) {
                    this.avC = new C1282a(this);
                }
                rbVar.setExpandedActionViewsExclusive(true);
                if (qjVar != null) {
                    qjVar.a(rbVar, this.ahu);
                    qjVar.a(this.avC, this.ahu);
                } else {
                    rbVar.a(this.ahu, null);
                    this.avC.m2583a(this.ahu, null);
                    rbVar.g(true);
                    this.avC.m2589g(true);
                }
                this.ahv.setPopupTheme(this.aiV);
                this.ahv.setPresenter(rbVar);
                this.avB = rbVar;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.ahv != null) {
            this.ahv.dismissPopupMenus();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ss();
            if (!cG(this.avb)) {
                m2598i(this.avb, true);
            }
        } else if (this.avb != null && cG(this.avb)) {
            removeView(this.avb);
            this.avw.remove(this.avb);
        }
        if (this.avb != null) {
            this.avb.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.avb != null ? this.avb.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ss();
        }
        if (this.avb != null) {
            this.avb.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.avb != null ? this.avb.getContentDescription() : null;
    }

    private void ss() {
        if (this.avb == null) {
            this.avb = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.avC == null || this.avC.avF == null) ? false : true;
    }

    public void collapseActionView() {
        ql qlVar = this.avC == null ? null : this.avC.avF;
        if (qlVar != null) {
            qlVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.avr;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.auY == null) {
                Context context = getContext();
                this.auY = new AppCompatTextView(context);
                this.auY.setSingleLine();
                this.auY.setEllipsize(TruncateAt.END);
                if (this.avg != 0) {
                    this.auY.setTextAppearance(context, this.avg);
                }
                if (this.avt != 0) {
                    this.auY.setTextColor(this.avt);
                }
            }
            if (!cG(this.auY)) {
                m2598i(this.auY, true);
            }
        } else if (this.auY != null && cG(this.auY)) {
            removeView(this.auY);
            this.avw.remove(this.auY);
        }
        if (this.auY != null) {
            this.auY.setText(charSequence);
        }
        this.avr = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.avs;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.auZ == null) {
                Context context = getContext();
                this.auZ = new AppCompatTextView(context);
                this.auZ.setSingleLine();
                this.auZ.setEllipsize(TruncateAt.END);
                if (this.avh != 0) {
                    this.auZ.setTextAppearance(context, this.avh);
                }
                if (this.avu != 0) {
                    this.auZ.setTextColor(this.avu);
                }
            }
            if (!cG(this.auZ)) {
                m2598i(this.auZ, true);
            }
        } else if (this.auZ != null && cG(this.auZ)) {
            removeView(this.auZ);
            this.avw.remove(this.auZ);
        }
        if (this.auZ != null) {
            this.auZ.setText(charSequence);
        }
        this.avs = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.avg = i;
        if (this.auY != null) {
            this.auY.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.avh = i;
        if (this.auZ != null) {
            this.auZ.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.avt = i;
        if (this.auY != null) {
            this.auY.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.avu = i;
        if (this.auZ != null) {
            this.auZ.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.ava != null ? this.ava.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            sv();
        }
        if (this.ava != null) {
            this.ava.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(pn.c(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            sv();
            if (!cG(this.ava)) {
                m2598i(this.ava, true);
            }
        } else if (this.ava != null && cG(this.ava)) {
            removeView(this.ava);
            this.avw.remove(this.ava);
        }
        if (this.ava != null) {
            this.ava.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.ava != null ? this.ava.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        sv();
        this.ava.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        st();
        return this.ahv.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        st();
        this.ahv.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        st();
        return this.ahv.getOverflowIcon();
    }

    private void st() {
        su();
        if (this.ahv.nR() == null) {
            qj qjVar = (qj) this.ahv.getMenu();
            if (this.avC == null) {
                this.avC = new C1282a(this);
            }
            this.ahv.setExpandedActionViewsExclusive(true);
            qjVar.a(this.avC, this.ahu);
        }
    }

    private void su() {
        if (this.ahv == null) {
            this.ahv = new ActionMenuView(getContext());
            this.ahv.setPopupTheme(this.aiV);
            this.ahv.setOnMenuItemClickListener(this.avz);
            this.ahv.m2197a(this.aiX, this.aiY);
            android.view.ViewGroup.LayoutParams sz = sz();
            sz.gravity = 8388613 | (this.avi & 112);
            this.ahv.setLayoutParams(sz);
            m2598i(this.ahv, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new pz(getContext());
    }

    public void setOnMenuItemClickListener(C1283b c1283b) {
        this.avy = c1283b;
    }

    public void setContentInsetsRelative(int i, int i2) {
        sC();
        this.avo.aL(i, i2);
    }

    public int getContentInsetStart() {
        return this.avo != null ? this.avo.getStart() : 0;
    }

    public int getContentInsetEnd() {
        return this.avo != null ? this.avo.getEnd() : 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        sC();
        this.avo.aM(i, i2);
    }

    public int getContentInsetLeft() {
        return this.avo != null ? this.avo.getLeft() : 0;
    }

    public int getContentInsetRight() {
        return this.avo != null ? this.avo.getRight() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.avp != Integer.MIN_VALUE) {
            return this.avp;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.avp) {
            this.avp = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.avq != Integer.MIN_VALUE) {
            return this.avq;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.avq) {
            this.avq = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.avp, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.ahv != null) {
            qj nR = this.ahv.nR();
            i = (nR == null || !nR.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            return Math.max(getContentInsetEnd(), Math.max(this.avq, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (li.m12235S(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (li.m12235S(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void sv() {
        if (this.ava == null) {
            this.ava = new AppCompatImageButton(getContext(), null, pk.a.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams sz = sz();
            sz.gravity = 8388611 | (this.avi & 112);
            this.ava.setLayoutParams(sz);
        }
    }

    void sw() {
        if (this.ave == null) {
            this.ave = new AppCompatImageButton(getContext(), null, pk.a.toolbarNavigationButtonStyle);
            this.ave.setImageDrawable(this.avc);
            this.ave.setContentDescription(this.avd);
            android.view.ViewGroup.LayoutParams sz = sz();
            sz.gravity = 8388611 | (this.avi & 112);
            sz.avG = 2;
            this.ave.setLayoutParams(sz);
            this.ave.setOnClickListener(new C02423(this));
        }
    }

    private void m2598i(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = sz();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = m2601g(layoutParams);
        }
        layoutParams.avG = 1;
        if (!z || this.avf == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.avw.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1285c = new C1285c(super.onSaveInstanceState());
        if (!(this.avC == null || this.avC.avF == null)) {
            c1285c.avH = this.avC.avF.getItemId();
        }
        c1285c.avI = isOverflowMenuShowing();
        return c1285c;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C1285c) {
            C1285c c1285c = (C1285c) parcelable;
            super.onRestoreInstanceState(c1285c.getSuperState());
            Menu nR = this.ahv != null ? this.ahv.nR() : null;
            if (!(c1285c.avH == 0 || this.avC == null || nR == null)) {
                MenuItem findItem = nR.findItem(c1285c.avH);
                if (findItem != null) {
                    kp.m12029d(findItem);
                }
            }
            if (c1285c.avI) {
                sx();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void sx() {
        removeCallbacks(this.avD);
        post(this.avD);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.avD);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = ks.m12043a(motionEvent);
        if (a == 0) {
            this.ahz = false;
        }
        if (!this.ahz) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.ahz = true;
            }
        }
        if (a == 1 || a == 3) {
            this.ahz = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = ks.m12043a(motionEvent);
        if (a == 9) {
            this.ahA = false;
        }
        if (!this.ahA) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.ahA = true;
            }
        }
        if (a == 10 || a == 3) {
            this.ahA = false;
        }
        return true;
    }

    private void m2595a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int m2592a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean sy() {
        if (!this.vn) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (cD(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.avx;
        if (tb.cH(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (cD(this.ava)) {
            m2595a(this.ava, i, 0, i2, 0, this.avj);
            i7 = this.ava.getMeasuredWidth() + cE(this.ava);
            max = Math.max(0, this.ava.getMeasuredHeight() + cF(this.ava));
            i6 = tb.combineMeasuredStates(0, li.m12239W(this.ava));
            i5 = max;
        }
        if (cD(this.ave)) {
            m2595a(this.ave, i, 0, i2, 0, this.avj);
            i7 = this.ave.getMeasuredWidth() + cE(this.ave);
            i5 = Math.max(i5, this.ave.getMeasuredHeight() + cF(this.ave));
            i6 = tb.combineMeasuredStates(i6, li.m12239W(this.ave));
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (cD(this.ahv)) {
            m2595a(this.ahv, i, max2, i2, 0, this.avj);
            i7 = this.ahv.getMeasuredWidth() + cE(this.ahv);
            i5 = Math.max(i5, this.ahv.getMeasuredHeight() + cF(this.ahv));
            i6 = tb.combineMeasuredStates(i6, li.m12239W(this.ahv));
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (cD(this.avf)) {
            max2 += m2592a(this.avf, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.avf.getMeasuredHeight() + cF(this.avf));
            i6 = tb.combineMeasuredStates(i6, li.m12239W(this.avf));
        }
        if (cD(this.avb)) {
            max2 += m2592a(this.avb, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.avb.getMeasuredHeight() + cF(this.avb));
            i6 = tb.combineMeasuredStates(i6, li.m12239W(this.avb));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).avG != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (cD(childAt)) {
                max2 += m2592a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + cF(childAt));
                i7 = tb.combineMeasuredStates(i5, li.m12239W(childAt));
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.avm + this.avn;
        max = this.avk + this.avl;
        if (cD(this.auY)) {
            m2592a(this.auY, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = cE(this.auY) + this.auY.getMeasuredWidth();
            i7 = this.auY.getMeasuredHeight() + cF(this.auY);
            i5 = tb.combineMeasuredStates(i5, li.m12239W(this.auY));
        }
        if (cD(this.auZ)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, m2592a(this.auZ, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.auZ.getMeasuredHeight() + cF(this.auZ);
            i5 = tb.combineMeasuredStates(i5, li.m12239W(this.auZ));
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = li.resolveSizeAndState(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = li.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (sy()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int measuredHeight;
        int measuredWidth;
        if (li.m12235S(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i5 = width - paddingRight;
        int[] iArr = this.avx;
        iArr[1] = 0;
        iArr[0] = 0;
        int ad = li.ad(this);
        int min = ad >= 0 ? Math.min(ad, i4 - i2) : 0;
        if (!cD(this.ava)) {
            ad = i5;
            i5 = paddingLeft;
        } else if (obj != null) {
            ad = m2596b(this.ava, i5, iArr, min);
            i5 = paddingLeft;
        } else {
            int i6 = i5;
            i5 = m2593a(this.ava, paddingLeft, iArr, min);
            ad = i6;
        }
        if (cD(this.ave)) {
            if (obj != null) {
                ad = m2596b(this.ave, ad, iArr, min);
            } else {
                i5 = m2593a(this.ave, i5, iArr, min);
            }
        }
        if (cD(this.ahv)) {
            if (obj != null) {
                i5 = m2593a(this.ahv, i5, iArr, min);
            } else {
                ad = m2596b(this.ahv, ad, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - ad));
        i5 = Math.max(i5, currentContentInsetLeft);
        ad = Math.min(ad, (width - paddingRight) - currentContentInsetRight);
        if (cD(this.avf)) {
            if (obj != null) {
                ad = m2596b(this.avf, ad, iArr, min);
            } else {
                i5 = m2593a(this.avf, i5, iArr, min);
            }
        }
        if (!cD(this.avb)) {
            currentContentInsetLeft = ad;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = m2596b(this.avb, ad, iArr, min);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = ad;
            currentContentInsetRight = m2593a(this.avb, i5, iArr, min);
        }
        boolean cD = cD(this.auY);
        boolean cD2 = cD(this.auZ);
        i5 = 0;
        if (cD) {
            LayoutParams layoutParams = (LayoutParams) this.auY.getLayoutParams();
            i5 = 0 + (layoutParams.bottomMargin + (layoutParams.topMargin + this.auY.getMeasuredHeight()));
        }
        if (cD2) {
            layoutParams = (LayoutParams) this.auZ.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.auZ.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (cD || cD2) {
            int paddingTop2;
            layoutParams = (LayoutParams) (cD ? this.auY : this.auZ).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (cD2 ? this.auZ : this.auY).getLayoutParams();
            Object obj2 = ((!cD || this.auY.getMeasuredWidth() <= 0) && (!cD2 || this.auZ.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.mGravity & 112) {
                case 48:
                    paddingTop2 = (layoutParams.topMargin + getPaddingTop()) + this.avm;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.avn) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < layoutParams.topMargin + this.avm) {
                        ad = layoutParams.topMargin + this.avm;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < layoutParams.bottomMargin + this.avn) {
                            ad = Math.max(0, paddingTop2 - ((layoutParams2.bottomMargin + this.avn) - measuredHeight));
                        } else {
                            ad = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + ad;
                    break;
            }
            if (obj != null) {
                ad = (obj2 != null ? this.avk : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, ad);
                iArr[1] = Math.max(0, -ad);
                if (cD) {
                    layoutParams = (LayoutParams) this.auY.getLayoutParams();
                    measuredWidth = i5 - this.auY.getMeasuredWidth();
                    currentContentInsetLeft = this.auY.getMeasuredHeight() + paddingTop2;
                    this.auY.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + layoutParams.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.avl;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (cD2) {
                    layoutParams = (LayoutParams) this.auZ.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop2;
                    measuredHeight = this.auZ.getMeasuredHeight() + measuredWidth;
                    this.auZ.layout(i5 - this.auZ.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    ad = layoutParams.bottomMargin + measuredHeight;
                    ad = i5 - this.avl;
                } else {
                    ad = i5;
                }
                if (obj2 != null) {
                    ad = Math.min(currentContentInsetLeft, ad);
                } else {
                    ad = i5;
                }
                currentContentInsetLeft = ad;
            } else {
                ad = (obj2 != null ? this.avk : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, ad);
                iArr[0] = Math.max(0, -ad);
                if (cD) {
                    layoutParams = (LayoutParams) this.auY.getLayoutParams();
                    i5 = this.auY.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.auY.getMeasuredHeight() + paddingTop2;
                    this.auY.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    ad = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.avl;
                    i5 = ad;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (cD2) {
                    layoutParams = (LayoutParams) this.auZ.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop2 = this.auZ.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.auZ.getMeasuredHeight() + i5;
                    this.auZ.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    ad = layoutParams.bottomMargin + measuredHeight;
                    ad = this.avl + paddingTop2;
                } else {
                    ad = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, ad);
                }
            }
        }
        m2597b(this.avv, 3);
        int size = this.avv.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m2593a((View) this.avv.get(measuredWidth), i5, iArr, min);
        }
        m2597b(this.avv, 5);
        currentContentInsetRight = this.avv.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = m2596b((View) this.avv.get(measuredWidth), currentContentInsetLeft, iArr, min);
        }
        m2597b(this.avv, 1);
        measuredWidth = m2594a(this.avv, iArr);
        ad = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += ad;
        if (ad < i5) {
            ad = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            ad -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.avv.size();
        measuredWidth = ad;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m2593a((View) this.avv.get(i5), measuredWidth, iArr, min);
        }
        this.avv.clear();
    }

    private int m2594a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i6 = layoutParams.leftMargin - i6;
            i = layoutParams.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int m2593a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m2591D(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int m2596b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m2591D(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int m2591D(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (em(layoutParams.gravity)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i3 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int em(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.mGravity & 112;
        }
    }

    private void m2597b(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (li.m12235S(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = ke.getAbsoluteGravity(i, li.m12235S(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.avG == 0 && cD(childAt) && en(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.avG == 0 && cD(childAt2) && en(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int en(int i) {
        int S = li.m12235S(this);
        int absoluteGravity = ke.getAbsoluteGravity(i, S) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return S == 1 ? 5 : 3;
        }
    }

    private boolean cD(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int cE(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return kn.m11997c(marginLayoutParams) + kn.m11995b(marginLayoutParams);
    }

    private int cF(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public LayoutParams m2602k(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams m2601g(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected LayoutParams sz() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public rt getWrapper() {
        if (this.avA == null) {
            this.avA = new sx(this, true);
        }
        return this.avA;
    }

    void sA() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).avG == 2 || childAt == this.ahv)) {
                removeViewAt(childCount);
                this.avw.add(childAt);
            }
        }
    }

    void sB() {
        for (int size = this.avw.size() - 1; size >= 0; size--) {
            addView((View) this.avw.get(size));
        }
        this.avw.clear();
    }

    private boolean cG(View view) {
        return view.getParent() == this || this.avw.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.vn = z;
        requestLayout();
    }

    public void m2600a(a aVar, qj.a aVar2) {
        this.aiX = aVar;
        this.aiY = aVar2;
        if (this.ahv != null) {
            this.ahv.m2197a(aVar, aVar2);
        }
    }

    private void sC() {
        if (this.avo == null) {
            this.avo = new sl();
        }
    }

    rb getOuterActionMenuPresenter() {
        return this.avB;
    }

    Context getPopupContext() {
        return this.ahu;
    }
}
