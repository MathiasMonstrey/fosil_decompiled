package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.fossil.pk.C3983b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class qj implements hu {
    private static final int[] ago = new int[]{1, 4, 5, 3, 2, 0};
    private final Resources Xe;
    Drawable agA;
    View agB;
    private boolean agC = false;
    private boolean agD = false;
    private boolean agE = false;
    private boolean agF = false;
    private boolean agG = false;
    private ArrayList<ql> agH = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<qq>> agI = new CopyOnWriteArrayList();
    private ql agJ;
    private boolean agK;
    private boolean agp;
    private boolean agq;
    private C3950a agr;
    private ArrayList<ql> ags;
    private boolean agt;
    private ArrayList<ql> agu;
    private ArrayList<ql> agv;
    private boolean agw;
    private int agx = 0;
    private ContextMenuInfo agy;
    CharSequence agz;
    private final Context mContext;
    private ArrayList<ql> uO;

    public interface C3950a {
        boolean mo3968a(qj qjVar, MenuItem menuItem);

        void mo3970b(qj qjVar);
    }

    public interface C4012b {
        boolean m13168b(ql qlVar);
    }

    public qj(Context context) {
        this.mContext = context;
        this.Xe = context.getResources();
        this.uO = new ArrayList();
        this.ags = new ArrayList();
        this.agt = true;
        this.agu = new ArrayList();
        this.agv = new ArrayList();
        this.agw = true;
        aa(true);
    }

    public qj cx(int i) {
        this.agx = i;
        return this;
    }

    public void m13178a(qq qqVar) {
        m13179a(qqVar, this.mContext);
    }

    public void m13179a(qq qqVar, Context context) {
        this.agI.add(new WeakReference(qqVar));
        qqVar.mo4018a(context, this);
        this.agw = true;
    }

    public void m13182b(qq qqVar) {
        Iterator it = this.agI.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            qq qqVar2 = (qq) weakReference.get();
            if (qqVar2 == null || qqVar2 == qqVar) {
                this.agI.remove(weakReference);
            }
        }
    }

    private void m13169Z(boolean z) {
        if (!this.agI.isEmpty()) {
            mS();
            Iterator it = this.agI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                qq qqVar = (qq) weakReference.get();
                if (qqVar == null) {
                    this.agI.remove(weakReference);
                } else {
                    qqVar.mo4025g(z);
                }
            }
            mT();
        }
    }

    private boolean m13172a(qw qwVar, qq qqVar) {
        boolean z = false;
        if (this.agI.isEmpty()) {
            return false;
        }
        if (qqVar != null) {
            z = qqVar.mo4022a(qwVar);
        }
        Iterator it = this.agI.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            qq qqVar2 = (qq) weakReference.get();
            if (qqVar2 == null) {
                this.agI.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = qqVar2.mo4022a(qwVar);
            }
            z2 = z;
        }
        return z2;
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        if (!this.agI.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.agI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                qq qqVar = (qq) weakReference.get();
                if (qqVar == null) {
                    this.agI.remove(weakReference);
                } else {
                    int id = qqVar.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = qqVar.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.agI.isEmpty()) {
            Iterator it = this.agI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                qq qqVar = (qq) weakReference.get();
                if (qqVar == null) {
                    this.agI.remove(weakReference);
                } else {
                    int id = qqVar.getId();
                    if (id > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(id);
                        if (parcelable != null) {
                            qqVar.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    public void m13190h(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void m13192i(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void m13194j(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View c = kp.c(item);
            if (!(c == null || c.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                c.saveHierarchyState(sparseArray);
                if (kp.e(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((qw) item.getSubMenu()).m13194j(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mO(), sparseArray);
        }
    }

    public void m13195k(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mO());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View c = kp.c(item);
                if (!(c == null || c.getId() == -1)) {
                    c.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((qw) item.getSubMenu()).m13195k(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    kp.d(item);
                }
            }
        }
    }

    protected String mO() {
        return "android:menu:actionviewstates";
    }

    public void mo4047a(C3950a c3950a) {
        this.agr = c3950a;
    }

    protected MenuItem m13176a(int i, int i2, int i3, CharSequence charSequence) {
        int cA = cA(i3);
        MenuItem a = m13170a(i, i2, i3, cA, charSequence, this.agx);
        if (this.agy != null) {
            a.a(this.agy);
        }
        this.uO.add(m13173c(this.uO, cA), a);
        m13193i(true);
        return a;
    }

    private ql m13170a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new ql(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m13176a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m13176a(0, 0, 0, this.Xe.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m13176a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m13176a(i, i2, i3, this.Xe.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.Xe.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        ql qlVar = (ql) m13176a(i, i2, i3, charSequence);
        SubMenu qwVar = new qw(this.mContext, this, qlVar);
        qlVar.b(qwVar);
        return qwVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.Xe.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m13174h(cy(i), true);
    }

    public void removeGroup(int i) {
        int cz = cz(i);
        if (cz >= 0) {
            int size = this.uO.size() - cz;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((ql) this.uO.get(cz)).getGroupId() != i) {
                    m13193i(true);
                } else {
                    m13174h(cz, false);
                    i2 = i3;
                }
            }
            m13193i(true);
        }
    }

    private void m13174h(int i, boolean z) {
        if (i >= 0 && i < this.uO.size()) {
            this.uO.remove(i);
            if (z) {
                m13193i(true);
            }
        }
    }

    public void clear() {
        if (this.agJ != null) {
            mo4050f(this.agJ);
        }
        this.uO.clear();
        m13193i(true);
    }

    void m13191h(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.uO.size();
        mS();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (ql) this.uO.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.ni() && menuItem2.isCheckable()) {
                menuItem2.ae(menuItem2 == menuItem);
            }
        }
        mT();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.uO.size();
        for (int i2 = 0; i2 < size; i2++) {
            ql qlVar = (ql) this.uO.get(i2);
            if (qlVar.getGroupId() == i) {
                qlVar.ad(z2);
                qlVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.uO.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            ql qlVar = (ql) this.uO.get(i2);
            if (qlVar.getGroupId() == i && qlVar.af(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m13193i(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.uO.size();
        for (int i2 = 0; i2 < size; i2++) {
            ql qlVar = (ql) this.uO.get(i2);
            if (qlVar.getGroupId() == i) {
                qlVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.agK) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((ql) this.uO.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            ql qlVar = (ql) this.uO.get(i2);
            if (qlVar.getItemId() == i) {
                return qlVar;
            }
            if (qlVar.hasSubMenu()) {
                MenuItem findItem = qlVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int cy(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((ql) this.uO.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int cz(int i) {
        return m13175P(i, 0);
    }

    public int m13175P(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((ql) this.uO.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.uO.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.uO.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m13183c(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.agp = z;
        m13193i(false);
    }

    private static int cA(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < ago.length) {
            return (ago[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean mP() {
        return this.agp;
    }

    private void aa(boolean z) {
        boolean z2 = true;
        if (!(z && this.Xe.getConfiguration().keyboard != 1 && this.Xe.getBoolean(C3983b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.agq = z2;
    }

    public boolean mQ() {
        return this.agq;
    }

    Resources getResources() {
        return this.Xe;
    }

    public Context getContext() {
        return this.mContext;
    }

    boolean mo4048d(qj qjVar, MenuItem menuItem) {
        return this.agr != null && this.agr.mo3968a(qjVar, menuItem);
    }

    public void mR() {
        if (this.agr != null) {
            this.agr.mo3970b(this);
        }
    }

    private static int m13173c(ArrayList<ql> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((ql) arrayList.get(size)).getOrdering() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem c = m13183c(i, keyEvent);
        boolean z = false;
        if (c != null) {
            z = m13185c(c, i2);
        }
        if ((i2 & 2) != 0) {
            ab(true);
        }
        return z;
    }

    void m13180a(List<ql> list, int i, KeyEvent keyEvent) {
        boolean mP = mP();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.uO.size();
            for (int i2 = 0; i2 < size; i2++) {
                ql qlVar = (ql) this.uO.get(i2);
                if (qlVar.hasSubMenu()) {
                    ((qj) qlVar.getSubMenu()).m13180a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = mP ? qlVar.getAlphabeticShortcut() : qlVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (mP && alphabeticShortcut == '\b' && i == 67)) && qlVar.isEnabled())) {
                    list.add(qlVar);
                }
            }
        }
    }

    ql m13183c(int i, KeyEvent keyEvent) {
        List list = this.agH;
        list.clear();
        m13180a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (ql) list.get(0);
        }
        boolean mP = mP();
        for (int i2 = 0; i2 < size; i2++) {
            char alphabeticShortcut;
            ql qlVar = (ql) list.get(i2);
            if (mP) {
                alphabeticShortcut = qlVar.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = qlVar.getNumericShortcut();
            }
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return qlVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return qlVar;
            }
            if (mP && alphabeticShortcut == '\b' && i == 67) {
                return qlVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m13185c(findItem(i), i2);
    }

    public boolean m13185c(MenuItem menuItem, int i) {
        return m13181a(menuItem, null, i);
    }

    public boolean m13181a(MenuItem menuItem, qq qqVar, int i) {
        ql qlVar = (ql) menuItem;
        if (qlVar == null || !qlVar.isEnabled()) {
            return false;
        }
        boolean z;
        boolean ne = qlVar.ne();
        kc iP = qlVar.iP();
        if (iP == null || !iP.hasSubMenu()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (qlVar.np()) {
            expandActionView = qlVar.expandActionView() | ne;
            if (!expandActionView) {
                return expandActionView;
            }
            ab(true);
            return expandActionView;
        } else if (qlVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                ab(false);
            }
            if (!qlVar.hasSubMenu()) {
                qlVar.b(new qw(getContext(), this, qlVar));
            }
            qw qwVar = (qw) qlVar.getSubMenu();
            if (z) {
                iP.onPrepareSubMenu(qwVar);
            }
            expandActionView = m13172a(qwVar, qqVar) | ne;
            if (expandActionView) {
                return expandActionView;
            }
            ab(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                ab(true);
            }
            return ne;
        }
    }

    public final void ab(boolean z) {
        if (!this.agG) {
            this.agG = true;
            Iterator it = this.agI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                qq qqVar = (qq) weakReference.get();
                if (qqVar == null) {
                    this.agI.remove(weakReference);
                } else {
                    qqVar.mo4019a(this, z);
                }
            }
            this.agG = false;
        }
    }

    public void close() {
        ab(true);
    }

    public void m13193i(boolean z) {
        if (this.agC) {
            this.agD = true;
            if (z) {
                this.agE = true;
                return;
            }
            return;
        }
        if (z) {
            this.agt = true;
            this.agw = true;
        }
        m13169Z(z);
    }

    public void mS() {
        if (!this.agC) {
            this.agC = true;
            this.agD = false;
            this.agE = false;
        }
    }

    public void mT() {
        this.agC = false;
        if (this.agD) {
            this.agD = false;
            m13193i(this.agE);
        }
    }

    void m13184c(ql qlVar) {
        this.agt = true;
        m13193i(true);
    }

    void m13186d(ql qlVar) {
        this.agw = true;
        m13193i(true);
    }

    public ArrayList<ql> mU() {
        if (!this.agt) {
            return this.ags;
        }
        this.ags.clear();
        int size = this.uO.size();
        for (int i = 0; i < size; i++) {
            ql qlVar = (ql) this.uO.get(i);
            if (qlVar.isVisible()) {
                this.ags.add(qlVar);
            }
        }
        this.agt = false;
        this.agw = true;
        return this.ags;
    }

    public void mV() {
        ArrayList mU = mU();
        if (this.agw) {
            Iterator it = this.agI.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                WeakReference weakReference = (WeakReference) it.next();
                qq qqVar = (qq) weakReference.get();
                if (qqVar == null) {
                    this.agI.remove(weakReference);
                    i2 = i;
                } else {
                    i2 = qqVar.eW() | i;
                }
                i = i2;
            }
            if (i != 0) {
                this.agu.clear();
                this.agv.clear();
                i = mU.size();
                for (int i3 = 0; i3 < i; i3++) {
                    ql qlVar = (ql) mU.get(i3);
                    if (qlVar.nl()) {
                        this.agu.add(qlVar);
                    } else {
                        this.agv.add(qlVar);
                    }
                }
            } else {
                this.agu.clear();
                this.agv.clear();
                this.agv.addAll(mU());
            }
            this.agw = false;
        }
    }

    public ArrayList<ql> mW() {
        mV();
        return this.agu;
    }

    public ArrayList<ql> mX() {
        mV();
        return this.agv;
    }

    public void clearHeader() {
        this.agA = null;
        this.agz = null;
        this.agB = null;
        m13193i(false);
    }

    private void m13171a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.agB = view;
            this.agz = null;
            this.agA = null;
        } else {
            if (i > 0) {
                this.agz = resources.getText(i);
            } else if (charSequence != null) {
                this.agz = charSequence;
            }
            if (i2 > 0) {
                this.agA = gn.c(getContext(), i2);
            } else if (drawable != null) {
                this.agA = drawable;
            }
            this.agB = null;
        }
        m13193i(false);
    }

    protected qj m13197o(CharSequence charSequence) {
        m13171a(0, charSequence, 0, null, null);
        return this;
    }

    protected qj cB(int i) {
        m13171a(i, null, 0, null, null);
        return this;
    }

    protected qj m13196n(Drawable drawable) {
        m13171a(0, null, 0, drawable, null);
        return this;
    }

    protected qj cC(int i) {
        m13171a(0, null, i, null, null);
        return this;
    }

    protected qj bq(View view) {
        m13171a(0, null, 0, null, view);
        return this;
    }

    public CharSequence mY() {
        return this.agz;
    }

    public Drawable mZ() {
        return this.agA;
    }

    public View na() {
        return this.agB;
    }

    public qj nb() {
        return this;
    }

    boolean nc() {
        return this.agF;
    }

    public boolean mo4049e(ql qlVar) {
        boolean z = false;
        if (!this.agI.isEmpty()) {
            mS();
            Iterator it = this.agI.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                qq qqVar = (qq) weakReference.get();
                if (qqVar == null) {
                    this.agI.remove(weakReference);
                    z = z2;
                } else {
                    z = qqVar.mo4021a(this, qlVar);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            mT();
            if (z) {
                this.agJ = qlVar;
            }
        }
        return z;
    }

    public boolean mo4050f(ql qlVar) {
        boolean z = false;
        if (!this.agI.isEmpty() && this.agJ == qlVar) {
            mS();
            Iterator it = this.agI.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                qq qqVar = (qq) weakReference.get();
                if (qqVar == null) {
                    this.agI.remove(weakReference);
                    z = z2;
                } else {
                    z = qqVar.mo4023b(this, qlVar);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            mT();
            if (z) {
                this.agJ = null;
            }
        }
        return z;
    }

    public ql nd() {
        return this.agJ;
    }

    public void ac(boolean z) {
        this.agK = z;
    }
}
