package com.fossil;

import android.content.Context;

class end implements enf {
    private final Context context;

    public end(Context context) {
        this.context = context.getApplicationContext();
    }

    boolean eq(Context context) {
        try {
            if (((Integer) Class.forName("com.fossil.atq").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public enb aFg() {
        if (eq(this.context)) {
            return new enb(aFl(), JI());
        }
        return null;
    }

    private String aFl() {
        try {
            return (String) Class.forName("com.fossil.arw$a").getMethod("getId", new Class[0]).invoke(jU(), new Object[0]);
        } catch (Exception e) {
            emm.aEU().aS("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean JI() {
        try {
            return ((Boolean) Class.forName("com.fossil.arw$a").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(jU(), new Object[0])).booleanValue();
        } catch (Exception e) {
            emm.aEU().aS("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object jU() {
        Object obj = null;
        try {
            obj = Class.forName("com.fossil.arw").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.context});
        } catch (Exception e) {
            emm.aEU().aS("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        return obj;
    }
}
