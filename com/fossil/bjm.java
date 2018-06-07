package com.fossil;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.common.api.Scope;
import java.util.HashSet;
import java.util.Set;

public abstract class bjm<T extends IInterface> extends axg<T> {
    protected bjm(Context context, Looper looper, int i, C1898b c1898b, C1899c c1899c, awy com_fossil_awy) {
        super(context, looper, i, com_fossil_awy, c1898b, c1899c);
    }

    public abstract String Kh();

    public abstract String Ki();

    public final boolean Ky() {
        return !axo.as(getContext());
    }

    public final boolean Ln() {
        return true;
    }

    public abstract T mo1165f(IBinder iBinder);

    protected final Set<Scope> mo1363f(Set<Scope> set) {
        Set<Scope> hashSet = new HashSet(set.size());
        for (Scope scope : set) {
            Scope scope2 = scope.equals(new Scope("https://www.googleapis.com/auth/fitness.activity.read")) ? new Scope("https://www.googleapis.com/auth/fitness.activity.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.location.read")) ? new Scope("https://www.googleapis.com/auth/fitness.location.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.body.read")) ? new Scope("https://www.googleapis.com/auth/fitness.body.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.nutrition.read")) ? new Scope("https://www.googleapis.com/auth/fitness.nutrition.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.blood_pressure.read")) ? new Scope("https://www.googleapis.com/auth/fitness.blood_pressure.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.blood_glucose.read")) ? new Scope("https://www.googleapis.com/auth/fitness.blood_glucose.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.oxygen_saturation.read")) ? new Scope("https://www.googleapis.com/auth/fitness.oxygen_saturation.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.body_temperature.read")) ? new Scope("https://www.googleapis.com/auth/fitness.body_temperature.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.reproductive_health.read")) ? new Scope("https://www.googleapis.com/auth/fitness.reproductive_health.write") : scope;
            if (scope2.equals(scope) || !set.contains(scope2)) {
                hashSet.add(scope);
            }
        }
        return hashSet;
    }
}
