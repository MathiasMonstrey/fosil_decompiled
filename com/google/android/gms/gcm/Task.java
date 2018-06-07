package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.facebook.applinks.AppLinkData;
import com.fossil.bbx;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.misfit.frameworks.common.constants.Constants;

public class Task implements ReflectedParcelable {
    private final Bundle KV;
    private final String bpr;
    private final boolean bps;
    private final boolean bpt;
    private final int bpu;
    private final boolean bpv;
    private final boolean bpw;
    private final bbx bpx;
    private final String mTag;

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.bpr = parcel.readString();
        this.mTag = parcel.readString();
        this.bps = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.bpt = z;
        this.bpu = 2;
        this.bpv = false;
        this.bpw = false;
        this.bpx = bbx.bpH;
        this.KV = null;
    }

    Task(a aVar) {
        this.bpr = aVar.bpz;
        this.mTag = aVar.tag;
        this.bps = aVar.bpA;
        this.bpt = aVar.bpB;
        this.bpu = aVar.bpy;
        this.bpv = aVar.bpC;
        this.bpw = false;
        this.KV = aVar.extras;
        this.bpx = aVar.bpD != null ? aVar.bpD : bbx.bpH;
    }

    public static void m12656q(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            if (dataSize > 10240) {
                obtain.recycle();
                String valueOf = String.valueOf("Extras exceeding maximum size(10240 bytes): ");
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(dataSize).toString());
            }
            obtain.recycle();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                dataSize = ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) ? 1 : 0;
                if (dataSize == 0) {
                    if (obj instanceof Bundle) {
                        m12656q((Bundle) obj);
                    } else {
                        throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
                    }
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getServiceName() {
        return this.bpr;
    }

    public void mo3497o(Bundle bundle) {
        bundle.putString("tag", this.mTag);
        bundle.putBoolean("update_current", this.bps);
        bundle.putBoolean("persisted", this.bpt);
        bundle.putString(Constants.SERVICE, this.bpr);
        bundle.putInt("requiredNetwork", this.bpu);
        bundle.putBoolean("requiresCharging", this.bpv);
        bundle.putBoolean("requiresIdle", false);
        bundle.putBundle("retryStrategy", this.bpx.m4822u(new Bundle()));
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, this.KV);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.bpr);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.bps ? 1 : 0);
        if (!this.bpt) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
