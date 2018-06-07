package com.fossil;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.fossil.wearables.fossil.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ckj extends ArrayAdapter<buv> implements Filterable {
    private static final CharacterStyle cpf = new StyleSpan(1);
    private ArrayList<buv> cpg;
    private atv cph;
    private LatLngBounds cpi;
    private AutocompleteFilter cpj;

    class C21521 extends Filter {
        final /* synthetic */ ckj cpk;

        C21521(ckj com_fossil_ckj) {
            this.cpk = com_fossil_ckj;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            ArrayList arrayList = new ArrayList();
            if (charSequence != null) {
                arrayList = this.cpk.m6963u(charSequence);
            }
            filterResults.values = arrayList;
            if (arrayList != null) {
                filterResults.count = arrayList.size();
            } else {
                filterResults.count = 0;
            }
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults == null || filterResults.count <= 0) {
                this.cpk.notifyDataSetInvalidated();
                return;
            }
            this.cpk.cpg = (ArrayList) filterResults.values;
            this.cpk.notifyDataSetChanged();
        }

        public CharSequence convertResultToString(Object obj) {
            if (obj instanceof buv) {
                return ((buv) obj).mo1489a(null);
            }
            return super.convertResultToString(obj);
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return jw(i);
    }

    public ckj(Context context, atv com_fossil_atv, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        super(context, R.layout.expandable_list_item, R.id.primary_tv);
        this.cph = com_fossil_atv;
        this.cpi = latLngBounds;
        this.cpj = autocompleteFilter;
    }

    public int getCount() {
        return this.cpg.size();
    }

    public buv jw(int i) {
        return (buv) this.cpg.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        buv jw = jw(i);
        FlexibleTextView flexibleTextView = (FlexibleTextView) view2.findViewById(R.id.secondary_tv);
        ((FlexibleTextView) view2.findViewById(R.id.primary_tv)).setText(jw.mo1490b(cpf));
        flexibleTextView.setText(jw.mo1491c(cpf));
        return view2;
    }

    public Filter getFilter() {
        return new C21521(this);
    }

    private ArrayList<buv> m6963u(CharSequence charSequence) {
        if (this.cph.isConnected()) {
            MFLogger.m12672i("PlaceAutocompleteAdapter", "Starting autocomplete query for: " + charSequence);
            buw com_fossil_buw = (buw) bvd.bGR.mo1492a(this.cph, charSequence.toString(), this.cpi, this.cpj).mo1167a(60, TimeUnit.SECONDS);
            Status Ka = com_fossil_buw.Ka();
            if (Ka.Kb()) {
                MFLogger.m12672i("PlaceAutocompleteAdapter", "Query completed. Received " + com_fossil_buw.getCount() + " predictions.");
                return aui.m4499a(com_fossil_buw);
            }
            MFLogger.m12671e("PlaceAutocompleteAdapter", "Error getting autocomplete prediction API call: " + Ka.toString());
            com_fossil_buw.release();
            return null;
        }
        MFLogger.m12671e("PlaceAutocompleteAdapter", "Google API client is not connected for autocomplete query.");
        return null;
    }
}
