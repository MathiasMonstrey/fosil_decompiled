package com.fossil;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

public class wl implements uk<wk> {
    private final uk<InputStream> aDx;
    private final uk<ParcelFileDescriptor> aDy;
    private String id;

    public wl(uk<InputStream> ukVar, uk<ParcelFileDescriptor> ukVar2) {
        this.aDx = ukVar;
        this.aDy = ukVar2;
    }

    public boolean m13997a(wk wkVar, OutputStream outputStream) {
        if (wkVar.vu() != null) {
            return this.aDx.mo4420a(wkVar.vu(), outputStream);
        }
        return this.aDy.mo4420a(wkVar.vv(), outputStream);
    }

    public String getId() {
        if (this.id == null) {
            this.id = this.aDx.getId() + this.aDy.getId();
        }
        return this.id;
    }
}
