package com.fossil;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;
import java.util.Collections;
import java.util.List;

public class dfc extends C1234a<C1264v> {
    private final LayoutInflater Yg;
    private List<String> bWZ;
    C2716a cSx;
    private final dfd cSy;
    private Context mContext;

    public interface C2716a {
        void m8452H(View view, int i);
    }

    public class C2717b extends C1264v implements OnClickListener {
        final /* synthetic */ dfc cSA;
        public TextView cSB;

        public C2717b(dfc com_fossil_dfc, View view) {
            this.cSA = com_fossil_dfc;
            super(view);
            this.cSB = (TextView) view.findViewById(R.id.title);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (this.cSA.cSx != null) {
                this.cSA.cSx.m8452H(view, getPosition());
            }
        }
    }

    public dfc(Context context, List<String> list, dfd com_fossil_dfd) {
        this.bWZ = list;
        this.Yg = LayoutInflater.from(context);
        this.cSy = com_fossil_dfd;
        this.mContext = context;
    }

    public C1264v mo1090c(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new C2717b(this, this.Yg.inflate(R.layout.home_config_time, viewGroup, false));
        }
        throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public void mo1089a(C1264v c1264v, int i) {
        if (c1264v instanceof C2717b) {
            final C2717b c2717b = (C2717b) c1264v;
            ((C2717b) c1264v).cSB.setText((CharSequence) this.bWZ.get(i));
            ((C2717b) c1264v).cSB.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ dfc cSA;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (ks.m12043a(motionEvent) == 0) {
                        this.cSA.cSy.ae(c2717b);
                    }
                    return false;
                }
            });
        }
    }

    public int getItemCount() {
        return this.bWZ.size();
    }

    public void kX(int i) {
        this.bWZ.remove(i);
        dt(i);
    }

    public boolean ce(int i, int i2) {
        if (i < this.bWZ.size() && i2 < this.bWZ.size()) {
            int i3;
            if (i < i2) {
                for (i3 = i; i3 < i2; i3++) {
                    Collections.swap(this.bWZ, i3, i3 + 1);
                }
            } else {
                for (i3 = i; i3 > i2; i3--) {
                    Collections.swap(this.bWZ, i3, i3 - 1);
                }
            }
            ax(i, i2);
        }
        return true;
    }
}
