package com.fossil;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.fossil.os.C3944a;
import com.fossil.pk.C3988g;
import com.fossil.qq.C3962a;

class qk implements OnClickListener, OnDismissListener, OnKeyListener, C3962a {
    private C3962a afK;
    private os agL;
    qh agM;
    private qj uh;

    public qk(qj qjVar) {
        this.uh = qjVar;
    }

    public void m13200e(IBinder iBinder) {
        qj qjVar = this.uh;
        C3944a c3944a = new C3944a(qjVar.getContext());
        this.agM = new qh(c3944a.getContext(), C3988g.abc_list_menu_item_layout);
        this.agM.mo4020a((C3962a) this);
        this.uh.m13178a(this.agM);
        c3944a.m12938a(this.agM.getAdapter(), (OnClickListener) this);
        View na = qjVar.na();
        if (na != null) {
            c3944a.bl(na);
        } else {
            c3944a.m12942m(qjVar.mZ()).m12941l(qjVar.mY());
        }
        c3944a.m12937a(this);
        this.agL = c3944a.ln();
        this.agL.setOnDismissListener(this);
        LayoutParams attributes = this.agL.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.agL.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.agL.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.agL.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.uh.ab(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.uh.performShortcut(i, keyEvent, 0);
    }

    public void dismiss() {
        if (this.agL != null) {
            this.agL.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.agM.mo4019a(this.uh, true);
    }

    public void mo3994a(qj qjVar, boolean z) {
        if (z || qjVar == this.uh) {
            dismiss();
        }
        if (this.afK != null) {
            this.afK.mo3994a(qjVar, z);
        }
    }

    public boolean mo3995d(qj qjVar) {
        if (this.afK != null) {
            return this.afK.mo3995d(qjVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.uh.m13185c((ql) this.agM.getAdapter().getItem(i), 0);
    }
}
