package com.fossil;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.b;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3988g;
import com.fossil.pk.C3990i;
import com.fossil.qj.C3950a;
import com.fossil.qq.C3962a;
import java.util.ArrayList;

class pg extends ActionBar {
    rt acQ;
    boolean acR;
    Callback acS;
    private boolean acT;
    private boolean acU;
    private ArrayList<a> acV = new ArrayList();
    private qh acW;
    private final Runnable acX = new C39711(this);
    private final b acY = new C39722(this);

    class C39711 implements Runnable {
        final /* synthetic */ pg acZ;

        C39711(pg pgVar) {
            this.acZ = pgVar;
        }

        public void run() {
            this.acZ.lS();
        }
    }

    class C39722 implements b {
        final /* synthetic */ pg acZ;

        C39722(pg pgVar) {
            this.acZ = pgVar;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.acZ.acS.onMenuItemSelected(0, menuItem);
        }
    }

    final class C3973a implements C3962a {
        final /* synthetic */ pg acZ;
        private boolean aca;

        C3973a(pg pgVar) {
            this.acZ = pgVar;
        }

        public boolean mo3995d(qj qjVar) {
            if (this.acZ.acS == null) {
                return false;
            }
            this.acZ.acS.onMenuOpened(108, qjVar);
            return true;
        }

        public void mo3994a(qj qjVar, boolean z) {
            if (!this.aca) {
                this.aca = true;
                this.acZ.acQ.dismissPopupMenus();
                if (this.acZ.acS != null) {
                    this.acZ.acS.onPanelClosed(108, qjVar);
                }
                this.aca = false;
            }
        }
    }

    final class C3974b implements C3950a {
        final /* synthetic */ pg acZ;

        C3974b(pg pgVar) {
            this.acZ = pgVar;
        }

        public boolean mo3968a(qj qjVar, MenuItem menuItem) {
            return false;
        }

        public void mo3970b(qj qjVar) {
            if (this.acZ.acS == null) {
                return;
            }
            if (this.acZ.acQ.isOverflowMenuShowing()) {
                this.acZ.acS.onPanelClosed(108, qjVar);
            } else if (this.acZ.acS.onPreparePanel(0, null, qjVar)) {
                this.acZ.acS.onMenuOpened(108, qjVar);
            }
        }
    }

    final class C3975c implements C3962a {
        final /* synthetic */ pg acZ;

        C3975c(pg pgVar) {
            this.acZ = pgVar;
        }

        public void mo3994a(qj qjVar, boolean z) {
            if (this.acZ.acS != null) {
                this.acZ.acS.onPanelClosed(0, qjVar);
            }
        }

        public boolean mo3995d(qj qjVar) {
            if (qjVar == null && this.acZ.acS != null) {
                this.acZ.acS.onMenuOpened(0, qjVar);
            }
            return true;
        }
    }

    class C3976d extends qb {
        final /* synthetic */ pg acZ;

        public C3976d(pg pgVar, Callback callback) {
            this.acZ = pgVar;
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !this.acZ.acR) {
                this.acZ.acQ.nK();
                this.acZ.acR = true;
            }
            return onPreparePanel;
        }

        public View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu menu = this.acZ.acQ.getMenu();
                    if (onPreparePanel(i, null, menu) && onMenuOpened(i, menu)) {
                        return this.acZ.m13055b(menu);
                    }
            }
            return super.onCreatePanelView(i);
        }
    }

    void lS() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.getMenu();
        r2 = r1 instanceof com.fossil.qj;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (com.fossil.qj) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.mS();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.acS;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.acS;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.mT();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.mT();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.pg.lS():void");
    }

    pg(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.acQ = new sx(toolbar, false);
        this.acS = new C3976d(this, callback);
        this.acQ.setWindowCallback(this.acS);
        toolbar.setOnMenuItemClickListener(this.acY);
        this.acQ.setWindowTitle(charSequence);
    }

    public Callback lR() {
        return this.acS;
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setElevation(float f) {
        li.l(this.acQ.oJ(), f);
    }

    public Context getThemedContext() {
        return this.acQ.getContext();
    }

    public void setHomeAsUpIndicator(int i) {
        this.acQ.setNavigationIcon(i);
    }

    public void m13052O(boolean z) {
    }

    public void m13053P(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.acQ.setWindowTitle(charSequence);
    }

    public boolean requestFocus() {
        ViewGroup oJ = this.acQ.oJ();
        if (oJ == null || oJ.hasFocus()) {
            return false;
        }
        oJ.requestFocus();
        return true;
    }

    public void setDisplayOptions(int i, int i2) {
        this.acQ.setDisplayOptions((this.acQ.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public CharSequence getTitle() {
        return this.acQ.getTitle();
    }

    public int getDisplayOptions() {
        return this.acQ.getDisplayOptions();
    }

    public boolean isShowing() {
        return this.acQ.getVisibility() == 0;
    }

    public boolean lj() {
        this.acQ.oJ().removeCallbacks(this.acX);
        li.b(this.acQ.oJ(), this.acX);
        return true;
    }

    public boolean collapseActionView() {
        if (!this.acQ.hasExpandedActionView()) {
            return false;
        }
        this.acQ.collapseActionView();
        return true;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            menu.setQwertyMode(z);
            menu.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    void onDestroy() {
        this.acQ.oJ().removeCallbacks(this.acX);
    }

    public void m13054Q(boolean z) {
        if (z != this.acU) {
            this.acU = z;
            int size = this.acV.size();
            for (int i = 0; i < size; i++) {
                ((a) this.acV.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    View m13055b(Menu menu) {
        m13051c(menu);
        if (menu == null || this.acW == null || this.acW.getAdapter().getCount() <= 0) {
            return null;
        }
        return (View) this.acW.m13160a(this.acQ.oJ());
    }

    private void m13051c(Menu menu) {
        if (this.acW == null && (menu instanceof qj)) {
            qj qjVar = (qj) menu;
            Context context = this.acQ.getContext();
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C3982a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C3982a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C3990i.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.acW = new qh(contextThemeWrapper, C3988g.abc_list_menu_item_layout);
            this.acW.mo4020a(new C3975c(this));
            qjVar.m13178a(this.acW);
        }
    }

    private Menu getMenu() {
        if (!this.acT) {
            this.acQ.mo4125a(new C3973a(this), new C3974b(this));
            this.acT = true;
        }
        return this.acQ.getMenu();
    }
}
