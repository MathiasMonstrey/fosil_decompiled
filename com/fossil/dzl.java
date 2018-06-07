package com.fossil;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public class dzl extends dzm {
    private String aWB;
    private int bai;
    private int dCc = 100;
    private Thread dCd = null;

    public dzl(Context context, int i, int i2, Throwable th, dzh com_fossil_dzh) {
        super(context, i, com_fossil_dzh);
        m10372a(i2, th);
    }

    public dzl(Context context, int i, int i2, Throwable th, Thread thread, dzh com_fossil_dzh) {
        super(context, i, com_fossil_dzh);
        m10372a(i2, th);
        this.dCd = thread;
    }

    private void m10372a(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.aWB = stringWriter.toString();
            this.bai = i;
            printWriter.close();
        }
    }

    public f aCl() {
        return f.c;
    }

    public boolean mo2793h(JSONObject jSONObject) {
        ebh.m10452a(jSONObject, "er", this.aWB);
        jSONObject.put("ea", this.bai);
        if (this.bai == 2 || this.bai == 3) {
            new eas(this.dCf).m10421a(jSONObject, this.dCd);
        }
        return true;
    }
}
