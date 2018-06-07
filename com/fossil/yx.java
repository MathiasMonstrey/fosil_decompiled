package com.fossil;

import android.graphics.Bitmap;
import java.io.OutputStream;

public class yx implements uo<yu> {
    private final uo<Bitmap> aFo;
    private final uo<yl> aFp;
    private String id;

    public yx(uo<Bitmap> uoVar, uo<yl> uoVar2) {
        this.aFo = uoVar;
        this.aFp = uoVar2;
    }

    public boolean m14121a(vh<yu> vhVar, OutputStream outputStream) {
        yu yuVar = (yu) vhVar.get();
        vh we = yuVar.we();
        if (we != null) {
            return this.aFo.mo4420a(we, outputStream);
        }
        return this.aFp.mo4420a(yuVar.wf(), outputStream);
    }

    public String getId() {
        if (this.id == null) {
            this.id = this.aFo.getId() + this.aFp.getId();
        }
        return this.id;
    }
}
