package com.fossil;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.ListPopupWindow;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class sd extends ListPopupWindow implements sc {
    private static Method aoY;
    private sc aoZ;

    public static class C4071a extends rw {
        private sc aoZ;
        final int apa;
        final int apb;
        private MenuItem apc;

        public /* bridge */ /* synthetic */ boolean mo4097g(MotionEvent motionEvent, int i) {
            return super.mo4097g(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public C4071a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.apa = 22;
                this.apb = 21;
                return;
            }
            this.apa = 21;
            this.apb = 22;
        }

        public void setHoverListener(sc scVar) {
            this.aoZ = scVar;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.apa) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.apb) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((qi) getAdapter()).mN().ab(false);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.aoZ != null) {
                int headersCount;
                qi qiVar;
                MenuItem cw;
                MenuItem menuItem;
                qj mN;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    qiVar = (qi) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    qiVar = (qi) adapter;
                }
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        headersCount = pointToPosition - headersCount;
                        if (headersCount >= 0 && headersCount < qiVar.getCount()) {
                            cw = qiVar.cw(headersCount);
                            menuItem = this.apc;
                            if (menuItem != cw) {
                                mN = qiVar.mN();
                                if (menuItem != null) {
                                    this.aoZ.mo4027b(mN, menuItem);
                                }
                                this.apc = cw;
                                if (cw != null) {
                                    this.aoZ.mo4028c(mN, cw);
                                }
                            }
                        }
                    }
                }
                cw = null;
                menuItem = this.apc;
                if (menuItem != cw) {
                    mN = qiVar.mN();
                    if (menuItem != null) {
                        this.aoZ.mo4027b(mN, menuItem);
                    }
                    this.apc = cw;
                    if (cw != null) {
                        this.aoZ.mo4028c(mN, cw);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }

    static {
        try {
            aoY = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public sd(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    rw m13504a(Context context, boolean z) {
        rw c4071a = new C4071a(context, z);
        c4071a.setHoverListener(this);
        return c4071a;
    }

    public void setEnterTransition(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.aoN.setEnterTransition((Transition) obj);
        }
    }

    public void setExitTransition(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.aoN.setExitTransition((Transition) obj);
        }
    }

    public void setHoverListener(sc scVar) {
        this.aoZ = scVar;
    }

    public void ao(boolean z) {
        if (aoY != null) {
            try {
                aoY.invoke(this.aoN, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void mo4028c(qj qjVar, MenuItem menuItem) {
        if (this.aoZ != null) {
            this.aoZ.mo4028c(qjVar, menuItem);
        }
    }

    public void mo4027b(qj qjVar, MenuItem menuItem) {
        if (this.aoZ != null) {
            this.aoZ.mo4027b(qjVar, menuItem);
        }
    }
}
