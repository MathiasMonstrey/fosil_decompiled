package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.fossil.pk.C3985d;
import com.fossil.pk.C3988g;
import com.fossil.qq.C3962a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class qg extends qo implements OnKeyListener, OnDismissListener, qq {
    private boolean aau;
    private final sc afA = new C40092(this);
    private int afB = 0;
    private int afC = 0;
    View afD;
    private int afE;
    private boolean afF;
    private boolean afG;
    private int afH;
    private int afI;
    private boolean afJ;
    private C3962a afK;
    private ViewTreeObserver afL;
    private OnDismissListener afM;
    boolean afN;
    private final int afs;
    private final int aft;
    private final int afu;
    private final boolean afv;
    final Handler afw;
    private final List<qj> afx = new LinkedList();
    final List<C4010a> afy = new ArrayList();
    private final OnGlobalLayoutListener afz = new C40071(this);
    private final Context mContext;
    private View yL;

    class C40071 implements OnGlobalLayoutListener {
        final /* synthetic */ qg afO;

        C40071(qg qgVar) {
            this.afO = qgVar;
        }

        public void onGlobalLayout() {
            if (this.afO.isShowing() && this.afO.afy.size() > 0 && !((C4010a) this.afO.afy.get(0)).afT.isModal()) {
                View view = this.afO.afD;
                if (view == null || !view.isShown()) {
                    this.afO.dismiss();
                    return;
                }
                for (C4010a c4010a : this.afO.afy) {
                    c4010a.afT.show();
                }
            }
        }
    }

    class C40092 implements sc {
        final /* synthetic */ qg afO;

        C40092(qg qgVar) {
            this.afO = qgVar;
        }

        public void mo4027b(qj qjVar, MenuItem menuItem) {
            this.afO.afw.removeCallbacksAndMessages(qjVar);
        }

        public void mo4028c(final qj qjVar, final MenuItem menuItem) {
            int i;
            this.afO.afw.removeCallbacksAndMessages(null);
            int size = this.afO.afy.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (qjVar == ((C4010a) this.afO.afy.get(i2)).acr) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                C4010a c4010a;
                i++;
                if (i < this.afO.afy.size()) {
                    c4010a = (C4010a) this.afO.afy.get(i);
                } else {
                    c4010a = null;
                }
                this.afO.afw.postAtTime(new Runnable(this) {
                    final /* synthetic */ C40092 afS;

                    public void run() {
                        if (c4010a != null) {
                            this.afS.afO.afN = true;
                            c4010a.acr.ab(false);
                            this.afS.afO.afN = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            qjVar.m13185c(menuItem, 4);
                        }
                    }
                }, qjVar, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    static class C4010a {
        public final qj acr;
        public final sd afT;
        public final int position;

        public C4010a(sd sdVar, qj qjVar, int i) {
            this.afT = sdVar;
            this.acr = qjVar;
            this.position = i;
        }

        public ListView getListView() {
            return this.afT.getListView();
        }
    }

    public qg(Context context, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.yL = view;
        this.aft = i;
        this.afu = i2;
        this.afv = z;
        this.afJ = false;
        this.afE = mH();
        Resources resources = context.getResources();
        this.afs = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C3985d.abc_config_prefDialogWidth));
        this.afw = new Handler();
    }

    public void setForceShowIcon(boolean z) {
        this.afJ = z;
    }

    private sd mG() {
        sd sdVar = new sd(this.mContext, null, this.aft, this.afu);
        sdVar.setHoverListener(this.afA);
        sdVar.setOnItemClickListener(this);
        sdVar.setOnDismissListener(this);
        sdVar.setAnchorView(this.yL);
        sdVar.setDropDownGravity(this.afC);
        sdVar.setModal(true);
        sdVar.setInputMethodMode(2);
        return sdVar;
    }

    public void show() {
        if (!isShowing()) {
            for (qj g : this.afx) {
                m13152g(g);
            }
            this.afx.clear();
            this.afD = this.yL;
            if (this.afD != null) {
                Object obj = this.afL == null ? 1 : null;
                this.afL = this.afD.getViewTreeObserver();
                if (obj != null) {
                    this.afL.addOnGlobalLayoutListener(this.afz);
                }
            }
        }
    }

    public void dismiss() {
        int size = this.afy.size();
        if (size > 0) {
            C4010a[] c4010aArr = (C4010a[]) this.afy.toArray(new C4010a[size]);
            for (size--; size >= 0; size--) {
                C4010a c4010a = c4010aArr[size];
                if (c4010a.afT.isShowing()) {
                    c4010a.afT.dismiss();
                }
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    private int mH() {
        if (li.S(this.yL) == 1) {
            return 0;
        }
        return 1;
    }

    private int cv(int i) {
        ListView listView = ((C4010a) this.afy.get(this.afy.size() - 1)).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.afD.getWindowVisibleDisplayFrame(rect);
        if (this.afE == 1) {
            if ((listView.getWidth() + iArr[0]) + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void mo4031f(qj qjVar) {
        qjVar.m13179a((qq) this, this.mContext);
        if (isShowing()) {
            m13152g(qjVar);
        } else {
            this.afx.add(qjVar);
        }
    }

    private void m13152g(qj qjVar) {
        View a;
        C4010a c4010a;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        Object qiVar = new qi(qjVar, from, this.afv);
        if (!isShowing() && this.afJ) {
            qiVar.setForceShowIcon(true);
        } else if (isShowing()) {
            qiVar.setForceShowIcon(qo.m13143i(qjVar));
        }
        int a2 = qo.m13141a(qiVar, null, this.mContext, this.afs);
        sd mG = mG();
        mG.setAdapter(qiVar);
        mG.setContentWidth(a2);
        mG.setDropDownGravity(this.afC);
        if (this.afy.size() > 0) {
            C4010a c4010a2 = (C4010a) this.afy.get(this.afy.size() - 1);
            a = m13151a(c4010a2, qjVar);
            c4010a = c4010a2;
        } else {
            a = null;
            c4010a = null;
        }
        if (a != null) {
            boolean z;
            int i;
            mG.ao(false);
            mG.setEnterTransition(null);
            int cv = cv(a2);
            if (cv == 1) {
                z = true;
            } else {
                z = false;
            }
            this.afE = cv;
            int[] iArr = new int[2];
            a.getLocationInWindow(iArr);
            int horizontalOffset = c4010a.afT.getHorizontalOffset() + iArr[0];
            int verticalOffset = iArr[1] + c4010a.afT.getVerticalOffset();
            if ((this.afC & 5) == 5) {
                if (z) {
                    i = horizontalOffset + a2;
                } else {
                    i = horizontalOffset - a.getWidth();
                }
            } else if (z) {
                i = a.getWidth() + horizontalOffset;
            } else {
                i = horizontalOffset - a2;
            }
            mG.setHorizontalOffset(i);
            mG.setVerticalOffset(verticalOffset);
        } else {
            if (this.afF) {
                mG.setHorizontalOffset(this.afH);
            }
            if (this.afG) {
                mG.setVerticalOffset(this.afI);
            }
            mG.h(nr());
        }
        this.afy.add(new C4010a(mG, qjVar, this.afE));
        mG.show();
        if (c4010a == null && this.aau && qjVar.mY() != null) {
            ViewGroup listView = mG.getListView();
            FrameLayout frameLayout = (FrameLayout) from.inflate(C3988g.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(qjVar.mY());
            listView.addHeaderView(frameLayout, null, false);
            mG.show();
        }
    }

    private MenuItem m13150a(qj qjVar, qj qjVar2) {
        int size = qjVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = qjVar.getItem(i);
            if (item.hasSubMenu() && qjVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View m13151a(C4010a c4010a, qj qjVar) {
        int i = 0;
        MenuItem a = m13150a(c4010a.acr, qjVar);
        if (a == null) {
            return null;
        }
        int headersCount;
        qi qiVar;
        int i2;
        ListView listView = c4010a.getListView();
        ListAdapter adapter = listView.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            qiVar = (qi) headerViewListAdapter.getWrappedAdapter();
        } else {
            qiVar = (qi) adapter;
            headersCount = 0;
        }
        int count = qiVar.getCount();
        while (i < count) {
            if (a == qiVar.cw(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - listView.getFirstVisiblePosition();
        if (i2 < 0 || i2 >= listView.getChildCount()) {
            return null;
        }
        return listView.getChildAt(i2);
    }

    public boolean isShowing() {
        return this.afy.size() > 0 && ((C4010a) this.afy.get(0)).afT.isShowing();
    }

    public void onDismiss() {
        C4010a c4010a;
        int size = this.afy.size();
        for (int i = 0; i < size; i++) {
            c4010a = (C4010a) this.afy.get(i);
            if (!c4010a.afT.isShowing()) {
                break;
            }
        }
        c4010a = null;
        if (c4010a != null) {
            c4010a.acr.ab(false);
        }
    }

    public void mo4025g(boolean z) {
        for (C4010a listView : this.afy) {
            qo.m13142a(listView.getListView().getAdapter()).notifyDataSetChanged();
        }
    }

    public void mo4020a(C3962a c3962a) {
        this.afK = c3962a;
    }

    public boolean mo4022a(qw qwVar) {
        for (C4010a c4010a : this.afy) {
            if (qwVar == c4010a.acr) {
                c4010a.getListView().requestFocus();
                return true;
            }
        }
        if (!qwVar.hasVisibleItems()) {
            return false;
        }
        mo4031f(qwVar);
        if (this.afK != null) {
            this.afK.mo3995d(qwVar);
        }
        return true;
    }

    private int m13153h(qj qjVar) {
        int size = this.afy.size();
        for (int i = 0; i < size; i++) {
            if (qjVar == ((C4010a) this.afy.get(i)).acr) {
                return i;
            }
        }
        return -1;
    }

    public void mo4019a(qj qjVar, boolean z) {
        int h = m13153h(qjVar);
        if (h >= 0) {
            int i = h + 1;
            if (i < this.afy.size()) {
                ((C4010a) this.afy.get(i)).acr.ab(false);
            }
            C4010a c4010a = (C4010a) this.afy.remove(h);
            c4010a.acr.m13182b(this);
            if (this.afN) {
                c4010a.afT.setExitTransition(null);
                c4010a.afT.setAnimationStyle(0);
            }
            c4010a.afT.dismiss();
            h = this.afy.size();
            if (h > 0) {
                this.afE = ((C4010a) this.afy.get(h - 1)).position;
            } else {
                this.afE = mH();
            }
            if (h == 0) {
                dismiss();
                if (this.afK != null) {
                    this.afK.mo3994a(qjVar, true);
                }
                if (this.afL != null) {
                    if (this.afL.isAlive()) {
                        this.afL.removeGlobalOnLayoutListener(this.afz);
                    }
                    this.afL = null;
                }
                this.afM.onDismiss();
            } else if (z) {
                ((C4010a) this.afy.get(0)).acr.ab(false);
            }
        }
    }

    public boolean eW() {
        return false;
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public void setGravity(int i) {
        if (this.afB != i) {
            this.afB = i;
            this.afC = ke.getAbsoluteGravity(i, li.S(this.yL));
        }
    }

    public void setAnchorView(View view) {
        if (this.yL != view) {
            this.yL = view;
            this.afC = ke.getAbsoluteGravity(this.afB, li.S(this.yL));
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.afM = onDismissListener;
    }

    public ListView getListView() {
        if (this.afy.isEmpty()) {
            return null;
        }
        return ((C4010a) this.afy.get(this.afy.size() - 1)).getListView();
    }

    public void setHorizontalOffset(int i) {
        this.afF = true;
        this.afH = i;
    }

    public void setVerticalOffset(int i) {
        this.afG = true;
        this.afI = i;
    }

    public void mo4029Y(boolean z) {
        this.aau = z;
    }

    protected boolean mI() {
        return false;
    }
}
