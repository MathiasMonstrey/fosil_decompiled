package com.fossil;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class dcs extends Filter {
    private C2670a cQo;

    interface C2670a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    dcs(C2670a c2670a) {
        this.cQo = c2670a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.cQo.convertToString((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.cQo.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.cQo.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.cQo.changeCursor((Cursor) filterResults.values);
        }
    }
}
