package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;
import com.fossil.kc.b;
import com.fossil.qm.C4013a;

@TargetApi(16)
class qn extends qm {

    class C4017a extends C4013a implements VisibilityListener {
        b ahe;
        final /* synthetic */ qn ahf;

        public C4017a(qn qnVar, Context context, ActionProvider actionProvider) {
            this.ahf = qnVar;
            super(qnVar, context, actionProvider);
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.ahb.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.ahb.overridesItemVisibility();
        }

        public boolean isVisible() {
            return this.ahb.isVisible();
        }

        public void refreshVisibility() {
            this.ahb.refreshVisibility();
        }

        public void setVisibilityListener(b bVar) {
            VisibilityListener visibilityListener;
            this.ahe = bVar;
            ActionProvider actionProvider = this.ahb;
            if (bVar == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.ahe != null) {
                this.ahe.onActionProviderVisibilityChanged(z);
            }
        }
    }

    qn(Context context, hv hvVar) {
        super(context, hvVar);
    }

    C4013a mo4046a(ActionProvider actionProvider) {
        return new C4017a(this, this.mContext, actionProvider);
    }
}
