package com.fossil;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.view.FlexibleTextView;
import java.util.List;

public class ckl extends C1234a<C1264v> {
    private final tz cow;
    private C2156a cpu;
    private int cpv;
    private int cpw;
    private Context mContext;
    private List<Widget> widgetList;

    public interface C2156a {
        void mo2663a(Widget widget);
    }

    public class C2157b extends C1264v implements OnClickListener {
        private View cpt;
        private C2156a cpx;
        private ImageView cpy;
        final /* synthetic */ ckl cpz;

        C2157b(ckl com_fossil_ckl, View view, C2156a c2156a) {
            this.cpz = com_fossil_ckl;
            super(view);
            this.cpy = (ImageView) view.findViewById(R.id.iv_widget_social);
            this.cpt = view.findViewById(R.id.widget_container);
            this.cpt.setOnClickListener(this);
            this.cpx = c2156a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.widget_container:
                    this.cpx.mo2663a((Widget) this.cpz.widgetList.get(rl()));
                    return;
                default:
                    return;
            }
        }
    }

    public class C2158c extends C1264v implements OnClickListener {
        private ImageView cpA;
        private ImageView cpB;
        private FlexibleTextView cpC;
        private FlexibleTextView cpD;
        private View cpt;
        private C2156a cpx;
        final /* synthetic */ ckl cpz;

        C2158c(ckl com_fossil_ckl, View view, C2156a c2156a) {
            this.cpz = com_fossil_ckl;
            super(view);
            this.cpA = (ImageView) view.findViewById(R.id.iv_background_widget);
            this.cpC = (FlexibleTextView) view.findViewById(R.id.ftv_title);
            this.cpD = (FlexibleTextView) view.findViewById(R.id.ftv_description);
            this.cpB = (ImageView) view.findViewById(R.id.iv_icon);
            this.cpt = view.findViewById(R.id.widget_container);
            this.cpt.setOnClickListener(this);
            this.cpx = c2156a;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.widget_container:
                    this.cpx.mo2663a((Widget) this.cpz.widgetList.get(rl()));
                    return;
                default:
                    return;
            }
        }
    }

    public ckl(C2156a c2156a, tz tzVar) {
        this.cpu = c2156a;
        this.cow = tzVar;
    }

    public void m6983P(List<Widget> list) {
        this.widgetList = list;
    }

    public C1264v mo1090c(ViewGroup viewGroup, int i) {
        this.mContext = viewGroup.getContext();
        this.cpv = this.mContext.getResources().getDimensionPixelSize(R.dimen.dp8);
        this.cpw = gn.m10634e(this.mContext, R.color.white);
        switch (i) {
            case 0:
                return new C2158c(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_widget_device, viewGroup, false), this.cpu);
            case 1:
                return new C2158c(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_widget_product, viewGroup, false), this.cpu);
            case 2:
                return new C2157b(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_widget_social, viewGroup, false), this.cpu);
            default:
                return new C2158c(this, LayoutInflater.from(this.mContext).inflate(R.layout.item_widget_product, viewGroup, false), this.cpu);
        }
    }

    public void mo1089a(C1264v c1264v, int i) {
        Widget widget = (Widget) this.widgetList.get(i);
        switch (getItemViewType(i)) {
            case 0:
            case 1:
                C2158c c2158c = (C2158c) c1264v;
                if (c2158c.cpC != null) {
                    c2158c.cpC.setText(widget.getTitle());
                }
                if (c2158c.cpD != null) {
                    c2158c.cpD.setText(widget.getDescription());
                }
                if (!(TextUtils.isEmpty(widget.getIconUrl()) || c2158c.cpB == null)) {
                    this.cow.ah(widget.getIconUrl()).tx().ba(600, 600).aA(true).c(DiskCacheStrategy.ALL).c(c2158c.cpB);
                }
                if (!TextUtils.isEmpty(widget.getBackgroundUrl())) {
                    this.cow.ah(widget.getBackgroundUrl()).c(new up[]{new cmd(this.mContext, this.cpv, this.cpw)}).c(c2158c.cpA);
                    return;
                }
                return;
            case 2:
                C2157b c2157b = (C2157b) c1264v;
                if (!TextUtils.isEmpty(widget.getBackgroundUrl())) {
                    this.cow.ah(widget.getBackgroundUrl()).c(c2157b.cpy);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        Widget widget = (Widget) this.widgetList.get(i);
        if (widget != null) {
            return widget.getLayoutType();
        }
        return 0;
    }

    public int getItemCount() {
        return this.widgetList != null ? this.widgetList.size() : 0;
    }
}
