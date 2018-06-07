package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.fossil.pu.C3965a;
import java.util.ArrayList;

@TargetApi(11)
public class py extends ActionMode {
    final pu aed;
    final Context mContext;

    public static class C4000a implements C3965a {
        final Callback aee;
        final ArrayList<py> aef = new ArrayList();
        final jv<Menu, Menu> aeg = new jv();
        final Context mContext;

        public C4000a(Context context, Callback callback) {
            this.mContext = context;
            this.aee = callback;
        }

        public boolean mo3996a(pu puVar, Menu menu) {
            return this.aee.onCreateActionMode(m13095d(puVar), m13090d(menu));
        }

        public boolean mo3998b(pu puVar, Menu menu) {
            return this.aee.onPrepareActionMode(m13095d(puVar), m13090d(menu));
        }

        public boolean mo3997a(pu puVar, MenuItem menuItem) {
            return this.aee.onActionItemClicked(m13095d(puVar), qs.m13209a(this.mContext, (hv) menuItem));
        }

        public void mo3999c(pu puVar) {
            this.aee.onDestroyActionMode(m13095d(puVar));
        }

        private Menu m13090d(Menu menu) {
            Menu menu2 = (Menu) this.aeg.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = qs.m13208a(this.mContext, (hu) menu);
            this.aeg.put(menu, menu2);
            return menu2;
        }

        public ActionMode m13095d(pu puVar) {
            int size = this.aef.size();
            for (int i = 0; i < size; i++) {
                py pyVar = (py) this.aef.get(i);
                if (pyVar != null && pyVar.aed == puVar) {
                    return pyVar;
                }
            }
            ActionMode pyVar2 = new py(this.mContext, puVar);
            this.aef.add(pyVar2);
            return pyVar2;
        }
    }

    public py(Context context, pu puVar) {
        this.mContext = context;
        this.aed = puVar;
    }

    public Object getTag() {
        return this.aed.getTag();
    }

    public void setTag(Object obj) {
        this.aed.setTag(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.aed.setTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.aed.setSubtitle(charSequence);
    }

    public void invalidate() {
        this.aed.invalidate();
    }

    public void finish() {
        this.aed.finish();
    }

    public Menu getMenu() {
        return qs.m13208a(this.mContext, (hu) this.aed.getMenu());
    }

    public CharSequence getTitle() {
        return this.aed.getTitle();
    }

    public void setTitle(int i) {
        this.aed.setTitle(i);
    }

    public CharSequence getSubtitle() {
        return this.aed.getSubtitle();
    }

    public void setSubtitle(int i) {
        this.aed.setSubtitle(i);
    }

    public View getCustomView() {
        return this.aed.getCustomView();
    }

    public void setCustomView(View view) {
        this.aed.setCustomView(view);
    }

    public MenuInflater getMenuInflater() {
        return this.aed.getMenuInflater();
    }

    public boolean getTitleOptionalHint() {
        return this.aed.getTitleOptionalHint();
    }

    public void setTitleOptionalHint(boolean z) {
        this.aed.setTitleOptionalHint(z);
    }

    public boolean isTitleOptional() {
        return this.aed.isTitleOptional();
    }
}
