package com.fossil;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C1234a;
import android.support.v7.widget.RecyclerView.C1264v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.fossil.drs$b.a;
import com.fossil.wearables.fossil.R;
import java.util.ArrayList;

public class drs<T> extends ev {
    private ArrayList<T> dmW;
    private C2811a dmX;
    private int dmY;

    public interface C2811a {
        void apV();

        void lh(int i);

        void li(int i);
    }

    class C31411 implements OnClickListener {
        final /* synthetic */ drs dmZ;

        C31411(drs com_fossil_drs) {
            this.dmZ = com_fossil_drs;
        }

        public void onClick(View view) {
            if (!(this.dmZ.dmX == null || this.dmZ.dmY == -1)) {
                this.dmZ.dmX.li(this.dmZ.dmY);
            }
            this.dmZ.dismiss();
        }
    }

    class C31422 implements OnItemClickListener {
        final /* synthetic */ drs dmZ;

        C31422(drs com_fossil_drs) {
            this.dmZ = com_fossil_drs;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.dmZ.dmY = i;
            if (this.dmZ.dmX != null) {
                this.dmZ.dmX.lh(this.dmZ.dmY);
            }
        }
    }

    class C3145b extends C1234a<a> {
        private ArrayList<T> dmW;
        final /* synthetic */ drs dmZ;
        private int dna;
        private OnItemClickListener dnb;

        public class C3144a extends C1264v {
            final /* synthetic */ C3145b dnc;
            public View dnd;
            public TextView dne;
            public ImageView dnf;

            public C3144a(C3145b c3145b, View view) {
                this.dnc = c3145b;
                super(view);
                this.dnd = view;
                this.dne = (TextView) view.findViewById(R.id.text);
                this.dnf = (ImageView) view.findViewById(R.id.radio);
            }
        }

        public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
            return m9534s(viewGroup, i);
        }

        C3145b(drs com_fossil_drs, ArrayList<T> arrayList, int i) {
            this.dmZ = com_fossil_drs;
            this.dmW = arrayList;
            this.dna = i;
        }

        public a m9534s(ViewGroup viewGroup, int i) {
            return new C3144a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.select_control_adapter, viewGroup, false));
        }

        public void m9532a(a aVar, final int i) {
            aVar.dne.setText(this.dmW.get(i).toString());
            aVar.dnf.setSelected(i == this.dna);
            aVar.arT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C3145b dnc;

                public void onClick(View view) {
                    this.dnc.dna = i;
                    if (this.dnc.dnb != null) {
                        this.dnc.dnb.onItemClick(null, view, this.dnc.dna, (long) view.getId());
                    }
                    this.dnc.notifyDataSetChanged();
                }
            });
        }

        public int getItemCount() {
            return this.dmW.size();
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.dnb = onItemClickListener;
        }
    }

    public static <T> drs m9538e(ArrayList<T> arrayList, int i) {
        drs com_fossil_drs = new drs();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SelectControlDialogFragment_EXTRA_DATA", arrayList);
        bundle.putInt("SelectControlDialogFragment_EXTRA_POSITION", i);
        com_fossil_drs.setArguments(bundle);
        return com_fossil_drs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973830);
        if (getArguments().containsKey("SelectControlDialogFragment_EXTRA_DATA")) {
            this.dmW = (ArrayList) getArguments().getSerializable("SelectControlDialogFragment_EXTRA_DATA");
        }
        if (getArguments().containsKey("SelectControlDialogFragment_EXTRA_POSITION")) {
            this.dmY = getArguments().getInt("SelectControlDialogFragment_EXTRA_POSITION", -1);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.select_control_dialog_fragment, viewGroup);
        inflate.findViewById(R.id.save).setOnClickListener(new C31411(this));
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        C1234a c3145b = new C3145b(this, this.dmW, this.dmY);
        c3145b.setOnItemClickListener(new C31422(this));
        recyclerView.setAdapter(c3145b);
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        onCreateDialog.getWindow().setLayout(-1, -1);
        return onCreateDialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.dmX != null) {
            this.dmX.apV();
        }
    }

    public void m9539a(C2811a c2811a) {
        this.dmX = c2811a;
    }
}
