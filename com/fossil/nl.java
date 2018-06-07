package com.fossil;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class nl extends Filter {
    C3919a VZ;

    interface C3919a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    nl(C3919a c3919a) {
        this.VZ = c3919a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.VZ.convertToString((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.VZ.runQueryOnBackgroundThread(charSequence);
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
        Cursor cursor = this.VZ.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.VZ.changeCursor((Cursor) filterResults.values);
        }
    }
}
