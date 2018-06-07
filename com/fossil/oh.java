package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.SearchView;

@TargetApi(14)
class oh {

    public static class C3934a extends SearchView {
        public C3934a(Context context) {
            super(context);
        }

        public void onActionViewCollapsed() {
            setQuery("", false);
            super.onActionViewCollapsed();
        }
    }
}
