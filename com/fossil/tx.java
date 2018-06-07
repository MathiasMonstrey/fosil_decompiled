package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.fossil.ww.C4203a;
import com.fossil.wy.C4204a;
import com.fossil.wz.C4205a;
import com.fossil.xa.C4207a;
import com.fossil.xb.C4208a;
import com.fossil.xd.C4209a;
import com.fossil.xf.C4210a;
import com.fossil.xg.C4211a;
import com.fossil.xh.C4212a;
import com.fossil.xi.C4213a;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class tx {
    private static volatile tx axY;
    private static boolean ayF = true;
    private final vl axR;
    private final DecodeFormat axT;
    private final wg ayG;
    private final va ayH;
    private final vz ayI;
    private final aav ayJ = new aav();
    private final ze ayK = new ze();
    private final zy ayL;
    private final xr ayM;
    private final yz ayN;
    private final xv ayO;
    private final yz ayP;
    private final Handler ayQ;
    private final wd ayR;

    public static tx m13751E(Context context) {
        if (axY == null) {
            synchronized (tx.class) {
                if (axY == null) {
                    Context applicationContext = context.getApplicationContext();
                    ty tyVar = new ty(applicationContext);
                    List<zu> F = m13752F(applicationContext);
                    for (zu a : F) {
                        a.m14176a(applicationContext, tyVar);
                    }
                    axY = tyVar.tO();
                    for (zu a2 : F) {
                        a2.m14175a(applicationContext, axY);
                    }
                }
            }
        }
        return axY;
    }

    private static List<zu> m13752F(Context context) {
        if (ayF) {
            return new zv(context).wp();
        }
        return Collections.emptyList();
    }

    tx(va vaVar, vz vzVar, vl vlVar, Context context, DecodeFormat decodeFormat) {
        this.ayH = vaVar;
        this.axR = vlVar;
        this.ayI = vzVar;
        this.axT = decodeFormat;
        this.ayG = new wg(context);
        this.ayQ = new Handler(Looper.getMainLooper());
        this.ayR = new wd(vzVar, vlVar, decodeFormat);
        this.ayL = new zy();
        zx yaVar = new ya(vlVar, decodeFormat);
        this.ayL.m14179a(InputStream.class, Bitmap.class, yaVar);
        zx xtVar = new xt(vlVar, decodeFormat);
        this.ayL.m14179a(ParcelFileDescriptor.class, Bitmap.class, xtVar);
        zx xzVar = new xz(yaVar, xtVar);
        this.ayL.m14179a(wk.class, Bitmap.class, xzVar);
        yaVar = new ym(context, vlVar);
        this.ayL.m14179a(InputStream.class, yl.class, yaVar);
        this.ayL.m14179a(wk.class, yu.class, new za(xzVar, yaVar, vlVar));
        this.ayL.m14179a(InputStream.class, File.class, new yj());
        m13762a(File.class, ParcelFileDescriptor.class, new C4203a());
        m13762a(File.class, InputStream.class, new C4209a());
        m13762a(Integer.TYPE, ParcelFileDescriptor.class, new C4204a());
        m13762a(Integer.TYPE, InputStream.class, new C4210a());
        m13762a(Integer.class, ParcelFileDescriptor.class, new C4204a());
        m13762a(Integer.class, InputStream.class, new C4210a());
        m13762a(String.class, ParcelFileDescriptor.class, new C4205a());
        m13762a(String.class, InputStream.class, new C4211a());
        m13762a(Uri.class, ParcelFileDescriptor.class, new C4207a());
        m13762a(Uri.class, InputStream.class, new C4212a());
        m13762a(URL.class, InputStream.class, new C4213a());
        m13762a(wh.class, InputStream.class, new C4208a());
        m13762a(byte[].class, InputStream.class, new xc$a());
        this.ayK.m14145a(Bitmap.class, xw.class, new zc(context.getResources(), vlVar));
        this.ayK.m14145a(yu.class, yf.class, new zb(new zc(context.getResources(), vlVar)));
        this.ayM = new xr(vlVar);
        this.ayN = new yz(vlVar, this.ayM);
        this.ayO = new xv(vlVar);
        this.ayP = new yz(vlVar, this.ayO);
    }

    public vl tE() {
        return this.axR;
    }

    <Z, R> zd<Z, R> m13761a(Class<Z> cls, Class<R> cls2) {
        return this.ayK.m14146g(cls, cls2);
    }

    <T, Z> zx<T, Z> m13763b(Class<T> cls, Class<Z> cls2) {
        return this.ayL.m14180h(cls, cls2);
    }

    <R> aaz<R> m13760a(ImageView imageView, Class<R> cls) {
        return this.ayJ.b(imageView, cls);
    }

    va tF() {
        return this.ayH;
    }

    xr tG() {
        return this.ayM;
    }

    xv tH() {
        return this.ayO;
    }

    yz tI() {
        return this.ayN;
    }

    yz tJ() {
        return this.ayP;
    }

    Handler tK() {
        return this.ayQ;
    }

    DecodeFormat tL() {
        return this.axT;
    }

    private wg tM() {
        return this.ayG;
    }

    public void tN() {
        abl.wX();
        this.ayI.tN();
        this.axR.tN();
    }

    public void ex(int i) {
        abl.wX();
        this.ayI.ex(i);
        this.axR.ex(i);
    }

    public static void m13758c(aaz<?> com_fossil_aaz_) {
        abl.wX();
        aad wD = com_fossil_aaz_.wD();
        if (wD != null) {
            wD.clear();
            com_fossil_aaz_.f(null);
        }
    }

    public <T, Y> void m13762a(Class<T> cls, Class<Y> cls2, wq<T, Y> wqVar) {
        wq b = this.ayG.m13992b(cls, cls2, wqVar);
        if (b != null) {
            b.vz();
        }
    }

    public static <T, Y> wp<T, Y> m13756a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return m13751E(context).tM().m13993c(cls, cls2);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static <T> wp<T, InputStream> m13755a(Class<T> cls, Context context) {
        return m13756a((Class) cls, InputStream.class, context);
    }

    public static <T> wp<T, ParcelFileDescriptor> m13757b(Class<T> cls, Context context) {
        return m13756a((Class) cls, ParcelFileDescriptor.class, context);
    }

    public static tz m13753G(Context context) {
        return zq.wm().m14162J(context);
    }

    public static tz m13754a(ew ewVar) {
        return zq.wm().m14167b(ewVar);
    }

    public static tz m13759t(Fragment fragment) {
        return zq.wm().m14169u(fragment);
    }
}
