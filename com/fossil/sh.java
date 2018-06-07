package com.fossil;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class sh extends jz {
    final RecyclerView aqI;
    final jz ask = new C40751(this);

    class C40751 extends jz {
        final /* synthetic */ sh asl;

        C40751(sh shVar) {
            this.asl = shVar;
        }

        public void m13533a(View view, ml mlVar) {
            super.a(view, mlVar);
            if (!this.asl.rk() && this.asl.aqI.getLayoutManager() != null) {
                this.asl.aqI.getLayoutManager().b(view, mlVar);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.asl.rk() || this.asl.aqI.getLayoutManager() == null) {
                return false;
            }
            return this.asl.aqI.getLayoutManager().a(view, i, bundle);
        }
    }

    public sh(RecyclerView recyclerView) {
        this.aqI = recyclerView;
    }

    boolean rk() {
        return this.aqI.qu();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (rk() || this.aqI.getLayoutManager() == null) {
            return false;
        }
        return this.aqI.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public void m13534a(View view, ml mlVar) {
        super.a(view, mlVar);
        mlVar.setClassName(RecyclerView.class.getName());
        if (!rk() && this.aqI.getLayoutManager() != null) {
            this.aqI.getLayoutManager().b(mlVar);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !rk()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public jz rE() {
        return this.ask;
    }
}
