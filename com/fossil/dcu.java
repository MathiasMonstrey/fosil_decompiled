package com.fossil;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.notifications.domain.model.AppWrapper;
import com.portfolio.platform.ui.notifications.domain.model.ContactWrapper;
import com.portfolio.platform.view.FossilNotificationImageView;
import java.util.List;

public class dcu extends C1234a<C2674b> {
    private static final String TAG = dcu.class.getName();
    private int Bz = -1;
    private List<Object> bWZ;
    private C2659a cQt;
    private boolean cQu;
    private tz cow;
    private Context mContext;

    public interface C2659a {
        void kL(int i);
    }

    class C2674b extends C1264v implements OnClickListener {
        private AppWrapper cQA;
        final /* synthetic */ dcu cQB;
        FossilNotificationImageView cQv;
        TextView cQw;
        ImageView cQx;
        LinearLayout cQy;
        private ContactWrapper cQz;

        C2674b(dcu com_fossil_dcu, View view) {
            this.cQB = com_fossil_dcu;
            super(view);
            this.cQv = (FossilNotificationImageView) view.findViewById(R.id.avatar);
            this.cQw = (TextView) view.findViewById(R.id.name);
            this.cQx = (ImageView) view.findViewById(R.id.arrow_start);
            this.cQy = (LinearLayout) view.findViewById(R.id.main_container);
            view.setOnClickListener(this);
        }

        void m8332b(AppWrapper appWrapper) {
            if (appWrapper != null) {
                this.cQA = appWrapper;
                this.cQw.setText(this.cQA.installedApp.getTitle());
                this.cQB.cow.a(new cmf()).bc(new cma(this.cQA.installedApp)).b(new xq[]{new cmn(this.cQB.mContext)}).ty().c(this.cQv.getFossilCircleImageView());
                this.cQv.avo();
            }
        }

        void m8333b(ContactWrapper contactWrapper) {
            if (contactWrapper != null) {
                this.cQz = contactWrapper;
                this.cQw.setText(this.cQz.getContact().getFirstName());
                if (this.cQz.getContact().getContactId() == -100) {
                    this.cQv.a(R.drawable.ic_notifications_calls, this.cQB.cow);
                } else if (this.cQz.getContact().getContactId() == -200) {
                    this.cQv.a(R.drawable.ic_notifications_texts, this.cQB.cow);
                } else {
                    Uri uri = null;
                    if (!TextUtils.isEmpty(this.cQz.getContact().getPhotoThumbUri())) {
                        uri = Uri.parse(this.cQz.getContact().getPhotoThumbUri());
                    }
                    this.cQB.cow.a(new cmg()).bc(new cmb(uri, this.cQz.getContact().getDisplayName())).b(new xq[]{new cmn(this.cQB.mContext)}).ty().c(this.cQv.getFossilCircleImageView());
                }
                if (!TextUtils.isEmpty(this.cQz.getContact().getPhotoThumbUri()) || this.cQz.getContact().getContactId() == -100 || this.cQz.getContact().getContactId() == -200) {
                    this.cQv.avo();
                    this.cQv.setBackgroundResource(R.color.transparent);
                    return;
                }
                this.cQv.avn();
                this.cQv.setBackground(PortfolioApp.ZQ().getResources().getDrawable(R.drawable.oval_solid_light_grey));
            }
        }

        public void onClick(View view) {
            if (!this.cQB.cQu && this.cQB.Bz >= 0 && this.cQB.cQt != null && rm() != -1) {
                this.cQB.cQt.kL(rm());
            }
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m8344q(viewGroup, i);
    }

    public dcu(tz tzVar) {
        this.cow = tzVar;
    }

    public void amr() {
        this.Bz = -1;
    }

    public void amm() {
        notifyDataSetChanged();
        Log.d(TAG, ".Inside HorizontalListAdapter updateList fired");
    }

    public void m8339a(Context context, List<Object> list) {
        this.mContext = context;
        this.bWZ = list;
    }

    public void m8341a(C2659a c2659a) {
        this.cQt = c2659a;
    }

    public C2674b m8344q(ViewGroup viewGroup, int i) {
        return new C2674b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_notification_horizontal_list, viewGroup, false));
    }

    public void m8342a(C2674b c2674b, int i) {
        Object obj = this.bWZ.get(i);
        if (obj instanceof ContactWrapper) {
            c2674b.m8333b((ContactWrapper) obj);
        } else {
            c2674b.m8332b((AppWrapper) obj);
        }
        if (this.Bz == -1) {
            c2674b.cQx.setVisibility(4);
            c2674b.cQy.setAlpha(1.0f);
        } else if (this.Bz == i) {
            c2674b.cQx.setVisibility(0);
            c2674b.cQy.setAlpha(1.0f);
        } else {
            c2674b.cQx.setVisibility(4);
            c2674b.cQy.setAlpha(0.4f);
        }
    }

    public int getItemCount() {
        return this.bWZ != null ? this.bWZ.size() : 0;
    }

    public Object ams() {
        if (this.bWZ == null || this.bWZ.size() <= 0 || this.bWZ.get(0) == null) {
            return null;
        }
        return this.bWZ.get(0);
    }

    public void amt() {
        this.cQu = true;
    }

    public int amg() {
        return this.Bz;
    }

    public void kN(int i) {
        this.Bz = i;
    }
}
