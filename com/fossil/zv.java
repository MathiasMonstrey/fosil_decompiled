package com.fossil;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v8.renderscript.Allocation;
import java.util.ArrayList;
import java.util.List;

public final class zv {
    private final Context context;

    public zv(Context context) {
        this.context = context;
    }

    public List<zu> wp() {
        List<zu> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), Allocation.USAGE_SHARED);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(ao(str));
                    }
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static zu ao(String str) {
        try {
            Object newInstance;
            try {
                newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof zu) {
                    return (zu) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e2);
            }
        } catch (Throwable e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }
}
