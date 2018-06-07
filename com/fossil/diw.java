package com.fossil;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import java.util.ArrayList;
import java.util.List;

public class diw extends C1234a<C2815b> {
    private List<SecondTimezone> cWN = new ArrayList();
    private List<SecondTimezone> cWO = new ArrayList();
    private C2814a cWP;

    public interface C2814a {
        void kh(int i);
    }

    public static class C2815b extends C1264v implements OnClickListener {
        public TextView cWQ;
        private final C2814a cWR;

        public C2815b(View view, C2814a c2814a) {
            super(view);
            this.cWQ = (TextView) view.findViewById(R.id.tv_second_timezone);
            view.setOnClickListener(this);
            this.cWR = c2814a;
        }

        public void onClick(View view) {
            if (this.cWR != null) {
                this.cWR.kh(rm());
            }
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m8789r(viewGroup, i);
    }

    public diw(Context context) {
    }

    public void am(List<SecondTimezone> list) {
        this.cWO.clear();
        this.cWN = list;
        this.cWO.addAll(list);
    }

    public List<SecondTimezone> aqb() {
        return this.cWO;
    }

    public C2815b m8789r(ViewGroup viewGroup, int i) {
        return new C2815b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_timezone_item_adapter, viewGroup, false), this.cWP);
    }

    public void m8787a(C2815b c2815b, int i) {
        SecondTimezone secondTimezone = (SecondTimezone) this.cWO.get(i);
        if (secondTimezone != null && c2815b != null) {
            c2815b.cWQ.setText(secondTimezone.getTimezoneCityName());
        }
    }

    public int getItemCount() {
        if (this.cWO != null) {
            return this.cWO.size();
        }
        return 0;
    }

    public void iO(String str) {
        if (TextUtils.isEmpty(str)) {
            am(this.cWN);
            notifyDataSetChanged();
            return;
        }
        this.cWO.clear();
        for (SecondTimezone secondTimezone : this.cWN) {
            if (secondTimezone.getTimezoneCityName().toLowerCase().contains(str.toLowerCase())) {
                this.cWO.add(secondTimezone);
            }
        }
        notifyDataSetChanged();
    }

    public List<SecondTimezone> aqc() {
        return this.cWN;
    }

    public void m8786a(C2814a c2814a) {
        this.cWP = c2814a;
    }
}
