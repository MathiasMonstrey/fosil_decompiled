package com.fossil;

import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Explore;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.List;

public class cki extends C1234a<C2151a> {
    private List<Explore> bWZ;
    private final tz cow;

    class C2151a extends C1264v {
        private ImageView cpb;
        private FlexibleTextView cpc;
        private FlexibleTextView cpd;
        final /* synthetic */ cki cpe;

        C2151a(cki com_fossil_cki, View view) {
            this.cpe = com_fossil_cki;
            super(view);
            this.cpb = (ImageView) view.findViewById(R.id.header_image);
            this.cpc = (FlexibleTextView) view.findViewById(R.id.title);
            this.cpd = (FlexibleTextView) view.findViewById(R.id.description);
        }

        void m6954a(Explore explore) {
            this.cpc.setText(explore.getTitle());
            this.cpd.setText(explore.getDescription());
            if (this.cpb == null) {
                return;
            }
            if (!TextUtils.isEmpty(explore.getBackground())) {
                this.cpe.cow.ah(explore.getBackground()).c(DiskCacheStrategy.ALL).ew(explore.getLocalBackground()).c(this.cpb);
            } else if (explore.getLocalBackground() > 0) {
                this.cpe.cow.a(Integer.valueOf(explore.getLocalBackground())).c(this.cpb);
            } else {
                this.cpb.setBackgroundColor(PortfolioApp.ZQ().getResources().getColor(R.color.fossilWhite));
            }
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m6960i(viewGroup, i);
    }

    public cki(List<Explore> list, tz tzVar) {
        this.bWZ = list;
        this.cow = tzVar;
    }

    public void m6956N(List<Explore> list) {
        this.bWZ = list;
    }

    public C2151a m6960i(ViewGroup viewGroup, int i) {
        int i2 = R.layout.item_explore;
        if (i == 1) {
            i2 = R.layout.item_explore_home;
        }
        return new C2151a(this, LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
    }

    public void m6958a(C2151a c2151a, int i) {
        c2151a.m6954a((Explore) this.bWZ.get(i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getItemViewType(int r8) {
        /*
        r7 = this;
        r3 = 3;
        r2 = 2;
        r1 = 1;
        r4 = 0;
        r5 = -1;
        r0 = "";
        if (r8 == r5) goto L_0x0015;
    L_0x0009:
        r0 = r7.bWZ;
        r0 = r0.get(r8);
        r0 = (com.portfolio.platform.data.model.Explore) r0;
        r0 = r0.getType();
    L_0x0015:
        r6 = r0.hashCode();
        switch(r6) {
            case -1177318867: goto L_0x002c;
            case -342500282: goto L_0x0036;
            case 3208415: goto L_0x0022;
            case 109757599: goto L_0x004a;
            case 595233003: goto L_0x0040;
            default: goto L_0x001c;
        };
    L_0x001c:
        r0 = r5;
    L_0x001d:
        switch(r0) {
            case 0: goto L_0x0054;
            case 1: goto L_0x0056;
            case 2: goto L_0x0058;
            case 3: goto L_0x005a;
            case 4: goto L_0x005c;
            default: goto L_0x0020;
        };
    L_0x0020:
        r0 = r4;
    L_0x0021:
        return r0;
    L_0x0022:
        r6 = "home";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x001c;
    L_0x002a:
        r0 = r4;
        goto L_0x001d;
    L_0x002c:
        r6 = "account";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x001c;
    L_0x0034:
        r0 = r1;
        goto L_0x001d;
    L_0x0036:
        r6 = "shortcut";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x001c;
    L_0x003e:
        r0 = r2;
        goto L_0x001d;
    L_0x0040:
        r6 = "notification";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x001c;
    L_0x0048:
        r0 = r3;
        goto L_0x001d;
    L_0x004a:
        r6 = "stats";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x001c;
    L_0x0052:
        r0 = 4;
        goto L_0x001d;
    L_0x0054:
        r0 = r1;
        goto L_0x0021;
    L_0x0056:
        r0 = 5;
        goto L_0x0021;
    L_0x0058:
        r0 = r2;
        goto L_0x0021;
    L_0x005a:
        r0 = r3;
        goto L_0x0021;
    L_0x005c:
        r0 = 4;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cki.getItemViewType(int):int");
    }

    public int getItemCount() {
        return this.bWZ != null ? this.bWZ.size() : 0;
    }
}
