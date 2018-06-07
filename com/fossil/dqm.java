package com.fossil;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.ckl.C2156a;
import com.fossil.fj.C2426a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.Widget;
import com.portfolio.platform.data.source.loader.WidgetLoader;
import com.portfolio.platform.view.SpaceItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class dqm extends ctm implements C2156a, C2426a<List<Widget>> {
    private static final String TAG = dqm.class.getSimpleName();
    private fj cFC;
    private RecyclerView deI;
    private ckl deJ;
    private List<Widget> deK;
    private int deL;
    private WidgetLoader deM;

    public static dqm lw(int i) {
        dqm com_fossil_dqm = new dqm();
        Bundle bundle = new Bundle();
        bundle.putInt("ARGUMENTS_LOADER_ID", i);
        com_fossil_dqm.setArguments(bundle);
        return com_fossil_dqm;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.deL = getArguments().getInt("ARGUMENTS_LOADER_ID");
        } else {
            this.deL = 1;
        }
        this.cFC = getActivity().getSupportLoaderManager();
        this.deM = new WidgetLoader(getActivity());
        this.deK = new ArrayList();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_widget, viewGroup, false);
        this.deI = (RecyclerView) inflate.findViewById(R.id.rv_widget);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.deJ = new ckl(this, tx.t(this));
        this.deJ.m6983P(this.deK);
        this.deI.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.deI.setAdapter(this.deJ);
        this.deI.m1710a(new SpaceItemDecoration(getContext(), R.dimen.dp15, true, true));
        this.deI.setItemViewCacheSize(10);
        this.deI.setHasFixedSize(true);
    }

    public void onResume() {
        super.onResume();
        this.cFC.mo3100a(this.deL, null, this);
    }

    public void onPause() {
        super.onPause();
    }

    public void mo2663a(Widget widget) {
        m7519n("widget", "Widget", widget.getTitle());
        cnp.acc().m7227a(widget.getRedirectInternalUrl(), widget.getRedirectWebUrl(), getActivity());
    }

    public gx<List<Widget>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "Inside .onCreateLoader id=" + i);
        return this.deM;
    }

    public void m9374a(gx<List<Widget>> gxVar, List<Widget> list) {
        MFLogger.m12670d(TAG, "Inside .onLoadFinished widgetList=" + list);
        if (list == null || list.isEmpty()) {
            auh();
        } else {
            aq(list);
        }
    }

    public void mo2129a(gx<List<Widget>> gxVar) {
    }

    public void aq(List<Widget> list) {
        this.deK = list;
        this.deJ.m6983P(this.deK);
        this.deJ.notifyDataSetChanged();
    }

    private void auh() {
    }
}
