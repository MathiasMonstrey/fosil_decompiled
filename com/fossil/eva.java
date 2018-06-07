package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import com.fossil.os.a;

public class eva implements Parcelable {
    public static final Creator<eva> CREATOR = new C35501();
    private final String dEP;
    private final int dWo;
    private final String dWp;
    private final String dWq;
    private final String dWr;
    private final int dWs;
    private Object dWt;
    private Context mContext;

    static class C35501 implements Creator<eva> {
        C35501() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ck(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return pZ(i);
        }

        public eva ck(Parcel parcel) {
            return new eva(parcel);
        }

        public eva[] pZ(int i) {
            return new eva[i];
        }
    }

    private eva(Parcel parcel) {
        this.dWo = parcel.readInt();
        this.dWp = parcel.readString();
        this.dEP = parcel.readString();
        this.dWq = parcel.readString();
        this.dWr = parcel.readString();
        this.dWs = parcel.readInt();
    }

    public static eva m11252a(Intent intent, Activity activity) {
        eva com_fossil_eva = (eva) intent.getParcelableExtra("extra_app_settings");
        com_fossil_eva.dl(activity);
        return com_fossil_eva;
    }

    private void dl(Object obj) {
        this.dWt = obj;
        if (obj instanceof Activity) {
            this.mContext = (Activity) obj;
        } else if (obj instanceof Fragment) {
            this.mContext = ((Fragment) obj).getContext();
        } else if (obj instanceof android.app.Fragment) {
            this.mContext = ((android.app.Fragment) obj).getActivity();
        } else {
            throw new IllegalStateException("Unknown object: " + obj);
        }
    }

    public os m11253a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        a aVar;
        if (this.dWo > 0) {
            aVar = new a(this.mContext, this.dWo);
        } else {
            aVar = new a(this.mContext);
        }
        return aVar.R(false).l(this.dEP).m(this.dWp).a(this.dWq, onClickListener).b(this.dWr, onClickListener2).lo();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dWo);
        parcel.writeString(this.dWp);
        parcel.writeString(this.dEP);
        parcel.writeString(this.dWq);
        parcel.writeString(this.dWr);
        parcel.writeInt(this.dWs);
    }
}
