package com.fossil;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.ui.notifications.domain.model.AppWrapper;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilNotificationImageView;
import java.util.ArrayList;
import java.util.List;

public class dcq extends C1234a<C2668c> implements Filterable {
    private static final String TAG = dcq.class.getName();
    private C2657a cPI;
    private List<AppWrapper> cPJ;
    private List<AppWrapper> cPK;
    private final C2665b cPL = new C26661(this);
    private int cPM;
    private final tz cow;
    private Context mContext;

    public interface C2657a {
        void kI(int i);

        void kJ(int i);

        void kK(int i);
    }

    interface C2665b {
        void kJ(int i);

        void kK(int i);

        void kP(int i);
    }

    class C26661 implements C2665b {
        final /* synthetic */ dcq cPN;

        C26661(dcq com_fossil_dcq) {
            this.cPN = com_fossil_dcq;
        }

        public void kP(int i) {
            if (this.cPN.cPI != null) {
                Object obj = this.cPN.amo().get(i);
                if (obj instanceof AppWrapper) {
                    this.cPN.cPI.kI(this.cPN.cPJ.indexOf(obj));
                    MFLogger.m12670d(dcq.TAG, "onReassignApp at position = " + this.cPN.cPJ.indexOf(obj));
                }
            }
        }

        public void kJ(int i) {
            if (this.cPN.cPI != null) {
                Object obj = this.cPN.amo().get(i);
                if (obj instanceof AppWrapper) {
                    this.cPN.cPI.kJ(this.cPN.cPJ.indexOf(obj));
                }
            }
        }

        public void kK(int i) {
            if (this.cPN.cPI != null) {
                Object obj = this.cPN.amo().get(i);
                if (obj instanceof AppWrapper) {
                    this.cPN.cPI.kK(this.cPN.cPJ.indexOf(obj));
                }
            }
        }
    }

    class C26672 extends Filter {
        final /* synthetic */ dcq cPN;

        C26672(dcq com_fossil_dcq) {
            this.cPN = com_fossil_dcq;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if (TextUtils.isEmpty(charSequence)) {
                filterResults.values = this.cPN.cPJ;
                filterResults.count = this.cPN.cPJ.size();
            } else {
                List arrayList = new ArrayList();
                for (AppWrapper appWrapper : this.cPN.cPJ) {
                    if (appWrapper.installedApp.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        arrayList.add(appWrapper);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.cPN.cPK = (List) filterResults.values;
            this.cPN.notifyDataSetChanged();
        }
    }

    class C2668c extends C1264v implements OnClickListener {
        final /* synthetic */ dcq cPN;
        TextView cPO;
        FossilNotificationImageView cPP;
        ImageView cPQ;
        TextView cPR;
        ImageView cPS;
        ConstraintLayout cPT;
        private C2665b cPU;

        public C2668c(dcq com_fossil_dcq, View view, C2665b c2665b) {
            this.cPN = com_fossil_dcq;
            super(view);
            this.cPO = (TextView) view.findViewById(R.id.app_name);
            this.cPP = (FossilNotificationImageView) view.findViewById(R.id.app_icon);
            this.cPQ = (ImageView) view.findViewById(R.id.remove_app);
            this.cPR = (FlexibleTextView) view.findViewById(R.id.reassign_app);
            this.cPS = (ImageView) view.findViewById(R.id.add_app);
            this.cPT = (ConstraintLayout) view.findViewById(R.id.container);
            this.cPU = c2665b;
            this.cPQ.setOnClickListener(this);
            this.cPS.setOnClickListener(this);
            this.cPR.setOnClickListener(this);
            this.cPP.setTopRightBadge(true);
        }

        private void m8297a(AppWrapper appWrapper, int i) {
            this.cPP.avo();
            this.cPN.cow.a(new cmf()).bc(new cma(appWrapper.installedApp)).b(new xq[]{new cmn(this.cPN.mContext)}).ty().c(this.cPP.getFossilCircleImageView());
            this.cPO.setText(appWrapper.installedApp.getTitle());
            if (appWrapper.installedApp.isSelected().booleanValue()) {
                this.cPS.setVisibility(8);
                this.cPQ.setVisibility(0);
                this.cPR.setVisibility(8);
            } else {
                this.cPQ.setVisibility(8);
                this.cPS.setVisibility(0);
                this.cPR.setVisibility(8);
            }
            Log.d(dcq.TAG, "Name = " + appWrapper.installedApp.getTitle());
            Log.d(dcq.TAG, "Current hand of item = " + appWrapper.getCurrentHandGroup());
            Log.d(dcq.TAG, "mCurrentHand = " + i);
            Log.d(dcq.TAG, "--------------------------------");
            if (appWrapper.getCurrentHandGroup() == 0 || appWrapper.getCurrentHandGroup() == i) {
                this.cPP.setHandNumber(null);
                return;
            }
            this.cPP.setHandNumber(String.valueOf(appWrapper.getCurrentHandGroup()));
            this.cPS.setVisibility(8);
            this.cPQ.setVisibility(8);
            this.cPR.setVisibility(0);
        }

        public void onClick(View view) {
            if (rm() != -1) {
                switch (view.getId()) {
                    case R.id.reassign_app:
                        if (this.cPU != null) {
                            dri.cX(view);
                            this.cPU.kP(rm());
                            return;
                        }
                        return;
                    case R.id.add_app:
                        if (this.cPU != null) {
                            dri.cX(view);
                            this.cPU.kJ(rm());
                            return;
                        }
                        return;
                    case R.id.remove_app:
                        if (this.cPU != null) {
                            dri.cX(view);
                            this.cPU.kK(rm());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m8308o(viewGroup, i);
    }

    public dcq(tz tzVar) {
        this.cow = tzVar;
    }

    public void m8303a(Context context, List<AppWrapper> list, int i) {
        this.mContext = context;
        this.cPJ = list;
        this.cPK = new ArrayList(list);
        this.cPM = i;
    }

    public void amm() {
        amn();
        notifyDataSetChanged();
    }

    private void amn() {
        if (this.cPJ.size() > 0) {
            this.cPK = new ArrayList(this.cPJ);
        }
    }

    public C2668c m8308o(ViewGroup viewGroup, int i) {
        return new C2668c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notifications_search_app_adapter, viewGroup, false), this.cPL);
    }

    public void m8306a(C2668c c2668c, int i) {
        c2668c.m8297a((AppWrapper) this.cPK.get(i), this.cPM);
    }

    public int getItemCount() {
        if (this.cPK != null) {
            return this.cPK.size();
        }
        return 0;
    }

    public Filter getFilter() {
        return new C26672(this);
    }

    public void m8305a(C2657a c2657a) {
        this.cPI = c2657a;
    }

    public List amo() {
        return this.cPK;
    }

    public List amp() {
        return this.cPJ;
    }
}
