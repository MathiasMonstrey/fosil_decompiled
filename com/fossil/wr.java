package com.fossil;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

public class wr<T> implements wp<Integer, T> {
    private final Resources aDJ;
    private final wp<Uri, T> aDh;

    public /* synthetic */ us mo4419c(Object obj, int i, int i2) {
        return m14006a((Integer) obj, i, i2);
    }

    public wr(Context context, wp<Uri, T> wpVar) {
        this(context.getResources(), (wp) wpVar);
    }

    public wr(Resources resources, wp<Uri, T> wpVar) {
        this.aDJ = resources;
        this.aDh = wpVar;
    }

    public us<T> m14006a(Integer num, int i, int i2) {
        Object parse;
        try {
            parse = Uri.parse("android.resource://" + this.aDJ.getResourcePackageName(num.intValue()) + '/' + this.aDJ.getResourceTypeName(num.intValue()) + '/' + this.aDJ.getResourceEntryName(num.intValue()));
        } catch (Throwable e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            parse = null;
        }
        if (parse != null) {
            return this.aDh.mo4419c(parse, i, i2);
        }
        return null;
    }
}
