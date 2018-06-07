package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.fossil.pk.C3985d;
import com.fossil.pk.C3988g;
import com.fossil.qq.C3962a;

final class qv extends qo implements OnKeyListener, OnItemClickListener, OnDismissListener, qq {
    private boolean aau;
    private int afC = 0;
    View afD;
    private C3962a afK;
    private ViewTreeObserver afL;
    private OnDismissListener afM;
    private final int aft;
    private final int afu;
    private final boolean afv;
    private final OnGlobalLayoutListener afz = new C40201(this);
    private final qi ahk;
    private final int ahl;
    final sd ahm;
    private boolean ahn;
    private boolean aho;
    private int ahp;
    private final Context mContext;
    private final qj uh;
    private View yL;

    class C40201 implements OnGlobalLayoutListener {
        final /* synthetic */ qv ahq;

        C40201(qv qvVar) {
            this.ahq = qvVar;
        }

        public void onGlobalLayout() {
            if (this.ahq.isShowing() && !this.ahq.ahm.isModal()) {
                View view = this.ahq.afD;
                if (view == null || !view.isShown()) {
                    this.ahq.dismiss();
                } else {
                    this.ahq.ahm.show();
                }
            }
        }
    }

    public qv(Context context, qj qjVar, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.uh = qjVar;
        this.afv = z;
        this.ahk = new qi(qjVar, LayoutInflater.from(context), this.afv);
        this.aft = i;
        this.afu = i2;
        Resources resources = context.getResources();
        this.ahl = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C3985d.abc_config_prefDialogWidth));
        this.yL = view;
        this.ahm = new sd(this.mContext, null, this.aft, this.afu);
        qjVar.m13179a((qq) this, context);
    }

    public void setForceShowIcon(boolean z) {
        this.ahk.setForceShowIcon(z);
    }

    public void setGravity(int i) {
        this.afC = i;
    }

    private boolean nt() {
        if (isShowing()) {
            return true;
        }
        if (this.ahn || this.yL == null) {
            return false;
        }
        this.afD = this.yL;
        this.ahm.setOnDismissListener(this);
        this.ahm.setOnItemClickListener(this);
        this.ahm.setModal(true);
        View view = this.afD;
        boolean z = this.afL == null;
        this.afL = view.getViewTreeObserver();
        if (z) {
            this.afL.addOnGlobalLayoutListener(this.afz);
        }
        this.ahm.setAnchorView(view);
        this.ahm.setDropDownGravity(this.afC);
        if (!this.aho) {
            this.ahp = qo.m13141a(this.ahk, null, this.mContext, this.ahl);
            this.aho = true;
        }
        this.ahm.setContentWidth(this.ahp);
        this.ahm.setInputMethodMode(2);
        this.ahm.h(nr());
        this.ahm.show();
        ViewGroup listView = this.ahm.getListView();
        listView.setOnKeyListener(this);
        if (this.aau && this.uh.mY() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(C3988g.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.uh.mY());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.ahm.setAdapter(this.ahk);
        this.ahm.show();
        return true;
    }

    public void show() {
        if (!nt()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void dismiss() {
        if (isShowing()) {
            this.ahm.dismiss();
        }
    }

    public void mo4031f(qj qjVar) {
    }

    public boolean isShowing() {
        return !this.ahn && this.ahm.isShowing();
    }

    public void onDismiss() {
        this.ahn = true;
        this.uh.close();
        if (this.afL != null) {
            if (!this.afL.isAlive()) {
                this.afL = this.afD.getViewTreeObserver();
            }
            this.afL.removeGlobalOnLayoutListener(this.afz);
            this.afL = null;
        }
        if (this.afM != null) {
            this.afM.onDismiss();
        }
    }

    public void mo4025g(boolean z) {
        this.aho = false;
        if (this.ahk != null) {
            this.ahk.notifyDataSetChanged();
        }
    }

    public void mo4020a(C3962a c3962a) {
        this.afK = c3962a;
    }

    public boolean mo4022a(qw qwVar) {
        if (qwVar.hasVisibleItems()) {
            qp qpVar = new qp(this.mContext, qwVar, this.afD, this.afv, this.aft, this.afu);
            qpVar.m13205c(this.afK);
            qpVar.setForceShowIcon(qo.m13143i(qwVar));
            qpVar.setOnDismissListener(this.afM);
            this.afM = null;
            this.uh.ab(false);
            if (qpVar.m13204Q(this.ahm.getHorizontalOffset(), this.ahm.getVerticalOffset())) {
                if (this.afK != null) {
                    this.afK.mo3995d(qwVar);
                }
                return true;
            }
        }
        return false;
    }

    public void mo4019a(qj qjVar, boolean z) {
        if (qjVar == this.uh) {
            dismiss();
            if (this.afK != null) {
                this.afK.mo3994a(qjVar, z);
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

    public void setAnchorView(View view) {
        this.yL = view;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.afM = onDismissListener;
    }

    public ListView getListView() {
        return this.ahm.getListView();
    }

    public void setHorizontalOffset(int i) {
        this.ahm.setHorizontalOffset(i);
    }

    public void setVerticalOffset(int i) {
        this.ahm.setVerticalOffset(i);
    }

    public void mo4029Y(boolean z) {
        this.aau = z;
    }
}
