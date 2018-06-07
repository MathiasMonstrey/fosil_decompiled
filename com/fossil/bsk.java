package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.AppMeasurement.e;
import com.misfit.frameworks.common.constants.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class bsk extends bqi {
    private static String[] bDz = new String[]{"firebase_"};
    private SecureRandom bDA;
    private final AtomicLong bDB = new AtomicLong(0);
    private int bDC;

    bsk(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final int m5579a(String str, Object obj, boolean z) {
        if (z) {
            int length;
            Object obj2;
            String str2 = "param";
            bnm.PP();
            if (obj instanceof Parcelable[]) {
                length = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                length = ((ArrayList) obj).size();
            } else {
                length = 1;
                if (obj2 == null) {
                    return 17;
                }
            }
            if (length > 1000) {
                super.Pf().Re().m5438a("Parameter array is too long; discarded. Value kind, name, array length", str2, str, Integer.valueOf(length));
                obj2 = null;
            } else {
                length = 1;
            }
            if (obj2 == null) {
                return 17;
            }
        }
        return eI(str) ? m5586a("param", str, bnm.PO(), obj, z) : m5586a("param", str, bnm.PN(), obj, z) ? 0 : 4;
    }

    private static Object m5580a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? m5581a(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String m5581a(String str, int i, boolean z) {
        return str.codePointCount(0, str.length()) > i ? z ? String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...") : null : str;
    }

    public static String m5582a(String str, String[] strArr, String[] strArr2) {
        awa.bO(strArr);
        awa.bO(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (ae(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private static void m5583a(Bundle bundle, Object obj) {
        awa.bO(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private static boolean m5584a(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    private final boolean m5585a(String str, int i, String str2) {
        if (str2 == null) {
            super.Pf().Rc().m5439d("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            super.Pf().Rc().m5438a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    private final boolean m5586a(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) <= i) {
                return true;
            }
            super.Pf().Re().m5438a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            int length;
            int i2;
            Object obj2;
            if ((obj instanceof Parcelable[]) && z) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                length = parcelableArr.length;
                i2 = 0;
                while (i2 < length) {
                    obj2 = parcelableArr[i2];
                    if (obj2 instanceof Bundle) {
                        i2++;
                    } else {
                        super.Pf().Re().m5437a("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                length = arrayList.size();
                i2 = 0;
                while (i2 < length) {
                    obj2 = arrayList.get(i2);
                    i2++;
                    if (!(obj2 instanceof Bundle)) {
                        super.Pf().Re().m5437a("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    private final boolean m5587a(String str, String[] strArr, String str2) {
        if (str2 == null) {
            super.Pf().Rc().m5439d("Name is required and can't be null. Type", str);
            return false;
        }
        boolean z;
        awa.bO(str2);
        for (String startsWith : bDz) {
            if (str2.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            super.Pf().Rc().m5437a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            awa.bO(strArr);
            for (String startsWith2 : strArr) {
                if (ae(str2, startsWith2)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                super.Pf().Rc().m5437a("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public static boolean m5588a(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] m5589a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public static long[] m5590a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i << 6) + i2 < bitSet.length()) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    private final boolean ac(String str, String str2) {
        if (str2 == null) {
            super.Pf().Rc().m5439d("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            super.Pf().Rc().m5439d("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        super.Pf().Rc().m5437a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            super.Pf().Rc().m5437a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    private final boolean ad(String str, String str2) {
        if (str2 == null) {
            super.Pf().Rc().m5439d("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            super.Pf().Rc().m5439d("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        super.Pf().Rc().m5437a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            super.Pf().Rc().m5437a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean ae(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static long ak(byte[] bArr) {
        long j = null;
        awa.bO(bArr);
        awa.aX(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static Bundle[] bX(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            return (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
        } else {
            if (!(obj instanceof ArrayList)) {
                return null;
            }
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public static Object bY(Object obj) {
        Throwable th;
        if (obj == null) {
            return null;
        }
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectOutputStream.close();
                    objectInputStream.close();
                    return readObject;
                } catch (IOException e) {
                    return null;
                } catch (ClassNotFoundException e2) {
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
    }

    static boolean m5591d(bnz com_fossil_bnz, bnh com_fossil_bnh) {
        awa.bO(com_fossil_bnz);
        awa.bO(com_fossil_bnh);
        if (!TextUtils.isEmpty(com_fossil_bnh.bxq)) {
            return true;
        }
        bnm.Qh();
        return false;
    }

    public static boolean m5592e(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, str), 2);
            return receiverInfo != null && receiverInfo.enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private final int eC(String str) {
        return !ac("event param", str) ? 3 : !m5587a("event param", null, str) ? 14 : m5585a("event param", bnm.PM(), str) ? 0 : 3;
    }

    private final int eD(String str) {
        return !ad("event param", str) ? 3 : !m5587a("event param", null, str) ? 14 : m5585a("event param", bnm.PM(), str) ? 0 : 3;
    }

    private static int eF(String str) {
        return "_ldl".equals(str) ? bnm.PR() : bnm.PQ();
    }

    static MessageDigest eG(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean eI(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean eK(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean eN(String str) {
        awa.df(str);
        boolean z = true;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    z = false;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    z = true;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    static boolean ex(String str) {
        awa.df(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean m5593j(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean m5594t(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private final boolean m5595v(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = bje.aQ(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e) {
            super.Pf().Rc().m5439d("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            super.Pf().Rc().m5439d("Package name not found", e2);
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void OM() {
        super.OM();
    }

    public final /* bridge */ /* synthetic */ void ON() {
        super.ON();
    }

    public final /* bridge */ /* synthetic */ void OO() {
        super.OO();
    }

    public final /* bridge */ /* synthetic */ void OP() {
        super.OP();
    }

    public final /* bridge */ /* synthetic */ bnc OQ() {
        return super.OQ();
    }

    public final /* bridge */ /* synthetic */ bnj OR() {
        return super.OR();
    }

    public final /* bridge */ /* synthetic */ bqk OS() {
        return super.OS();
    }

    public final /* bridge */ /* synthetic */ bog OT() {
        return super.OT();
    }

    public final /* bridge */ /* synthetic */ bnt OU() {
        return super.OU();
    }

    public final /* bridge */ /* synthetic */ brc OV() {
        return super.OV();
    }

    public final /* bridge */ /* synthetic */ bqy OW() {
        return super.OW();
    }

    public final /* bridge */ /* synthetic */ axm OX() {
        return super.OX();
    }

    public final /* bridge */ /* synthetic */ boh OY() {
        return super.OY();
    }

    public final /* bridge */ /* synthetic */ bnn OZ() {
        return super.OZ();
    }

    protected final void PH() {
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                super.Pf().Re().log("Utils falling back to Random for random id");
            }
        }
        this.bDB.set(nextLong);
    }

    public final /* bridge */ /* synthetic */ boj Pa() {
        return super.Pa();
    }

    public final /* bridge */ /* synthetic */ bsk Pb() {
        return super.Pb();
    }

    public final /* bridge */ /* synthetic */ bpf Pc() {
        return super.Pc();
    }

    public final /* bridge */ /* synthetic */ brz Pd() {
        return super.Pd();
    }

    public final /* bridge */ /* synthetic */ bpg Pe() {
        return super.Pe();
    }

    public final /* bridge */ /* synthetic */ bol Pf() {
        return super.Pf();
    }

    public final /* bridge */ /* synthetic */ bow Pg() {
        return super.Pg();
    }

    public final /* bridge */ /* synthetic */ bnm Ph() {
        return super.Ph();
    }

    public final long Si() {
        long nextLong;
        if (this.bDB.get() == 0) {
            synchronized (this.bDB) {
                nextLong = new Random(System.nanoTime() ^ super.OX().currentTimeMillis()).nextLong();
                int i = this.bDC + 1;
                this.bDC = i;
                nextLong += (long) i;
            }
        } else {
            synchronized (this.bDB) {
                this.bDB.compareAndSet(-1, 1);
                nextLong = this.bDB.getAndIncrement();
            }
        }
        return nextLong;
    }

    final SecureRandom Sj() {
        super.OP();
        if (this.bDA == null) {
            this.bDA = new SecureRandom();
        }
        return this.bDA;
    }

    public final Bundle m5596a(String str, Bundle bundle, List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        bnm.PJ();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int eC;
            if (list == null || !list.contains(str2)) {
                eC = z ? eC(str2) : 0;
                if (eC == 0) {
                    eC = eD(str2);
                }
            } else {
                eC = 0;
            }
            if (eC != 0) {
                if (m5584a(bundle2, eC)) {
                    bundle2.putString("_ev", m5581a(str2, bnm.PM(), true));
                    if (eC == 3) {
                        m5583a(bundle2, (Object) str2);
                    }
                }
                bundle2.remove(str2);
            } else {
                eC = m5579a(str2, bundle.get(str2), z2);
                if (eC == 0 || "_ev".equals(str2)) {
                    if (ex(str2)) {
                        i++;
                        if (i > 25) {
                            super.Pf().Rc().m5437a("Event can't contain more then 25 params", super.Pa().ef(str), super.Pa().m5431y(bundle));
                            m5584a(bundle2, 5);
                            bundle2.remove(str2);
                        }
                    }
                    i = i;
                } else {
                    if (m5584a(bundle2, eC)) {
                        bundle2.putString("_ev", m5581a(str2, bnm.PM(), true));
                        m5583a(bundle2, bundle.get(str2));
                    }
                    bundle2.remove(str2);
                }
            }
        }
        return bundle2;
    }

    final bnz m5597a(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (ez(str) != 0) {
            super.Pf().Rc().m5439d("Invalid conditional property event name", super.Pa().eh(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        return new bnz(str, new bnw(m5611z(m5596a(str, bundle2, Collections.singletonList("_o"), false, false))), str2, j);
    }

    public final void m5598a(int i, String str, String str2, int i2) {
        m5602a(null, i, str, str2, i2);
    }

    public final void m5599a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                super.Pf().Rf().m5437a("Not putting event parameter. Invalid value type. name, type", super.Pa().eg(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void m5600a(bsw com_fossil_bsw, Object obj) {
        awa.bO(obj);
        com_fossil_bsw.boy = null;
        com_fossil_bsw.bEw = null;
        com_fossil_bsw.bDx = null;
        if (obj instanceof String) {
            com_fossil_bsw.boy = (String) obj;
        } else if (obj instanceof Long) {
            com_fossil_bsw.bEw = (Long) obj;
        } else if (obj instanceof Double) {
            com_fossil_bsw.bDx = (Double) obj;
        } else {
            super.Pf().Rc().m5439d("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void m5601a(bta com_fossil_bta, Object obj) {
        awa.bO(obj);
        com_fossil_bta.boy = null;
        com_fossil_bta.bEw = null;
        com_fossil_bta.bDx = null;
        if (obj instanceof String) {
            com_fossil_bta.boy = (String) obj;
        } else if (obj instanceof Long) {
            com_fossil_bta.bEw = (Long) obj;
        } else if (obj instanceof Double) {
            com_fossil_bta.bDx = (Double) obj;
        } else {
            super.Pf().Rc().m5439d("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void m5602a(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m5584a(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        bnm.Qh();
        this.zzboe.OS().m5539a("auto", "_err", bundle);
    }

    public final byte[] ai(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            super.Pf().Rc().m5439d("Failed to gzip content", e);
            throw e;
        }
    }

    public final byte[] aj(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            super.Pf().Rc().m5439d("Failed to ungzip content", e);
            throw e;
        }
    }

    final <T extends Parcelable> T m5603b(byte[] bArr, Creator<T> creator) {
        T t;
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            t = (Parcelable) creator.createFromParcel(obtain);
            return t;
        } catch (zzc e) {
            t = super.Pf().Rc();
            t.log("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    public final byte[] m5604b(bsx com_fossil_bsx) {
        try {
            byte[] bArr = new byte[com_fossil_bsx.MW()];
            bci h = bci.m4843h(bArr, 0, bArr.length);
            com_fossil_bsx.mo1264a(h);
            h.MQ();
            return bArr;
        } catch (IOException e) {
            super.Pf().Rc().m5439d("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final boolean m5605d(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(super.OX().currentTimeMillis() - j) > j2;
    }

    public final Object m5606e(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m5580a(bnm.PO(), obj, true);
        }
        return m5580a(eI(str) ? bnm.PO() : bnm.PN(), obj, false);
    }

    public final int eA(String str) {
        return !ac("user property", str) ? 6 : !m5587a("user property", e.bJJ, str) ? 15 : m5585a("user property", bnm.PL(), str) ? 0 : 6;
    }

    public final int eB(String str) {
        return !ad("user property", str) ? 6 : !m5587a("user property", e.bJJ, str) ? 15 : m5585a("user property", bnm.PL(), str) ? 0 : 6;
    }

    public final boolean eE(String str) {
        if (TextUtils.isEmpty(str)) {
            super.Pf().Rc().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        awa.bO(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        super.Pf().Rc().m5439d("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean eH(String str) {
        super.OP();
        if (bje.aQ(super.getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        super.Pf().Rh().m5439d("Permission not granted", str);
        return false;
    }

    public final boolean eJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String QE = super.Ph().QE();
        bnm.Qh();
        return QE.equals(str);
    }

    final boolean eL(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(super.Pc().m5457Z(str, "measurement.upload.blacklist_internal"));
    }

    final boolean eM(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(super.Pc().m5457Z(str, "measurement.upload.blacklist_public"));
    }

    public final int ey(String str) {
        return !ac(Constants.EVENT, str) ? 2 : !m5587a(Constants.EVENT, a.bJF, str) ? 13 : m5585a(Constants.EVENT, bnm.PK(), str) ? 0 : 2;
    }

    public final int ez(String str) {
        return !ad(Constants.EVENT, str) ? 2 : !m5587a(Constants.EVENT, a.bJF, str) ? 13 : m5585a(Constants.EVENT, bnm.PK(), str) ? 0 : 2;
    }

    public final int m5607f(String str, Object obj) {
        return "_ldl".equals(str) ? m5586a("user property referrer", str, eF(str), obj, false) : m5586a("user property", str, eF(str), obj, false) ? 0 : 7;
    }

    public final Object m5608g(String str, Object obj) {
        return "_ldl".equals(str) ? m5580a(eF(str), obj, true) : m5580a(eF(str), obj, false);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Bundle m5609j(Uri uri) {
        Bundle bundle = null;
        if (uri != null) {
            try {
                Object queryParameter;
                Object queryParameter2;
                Object queryParameter3;
                Object queryParameter4;
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                } else {
                    queryParameter4 = null;
                    queryParameter3 = null;
                    queryParameter2 = null;
                    queryParameter = null;
                }
                if (!(TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4))) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString("campaign", queryParameter);
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString("source", queryParameter2);
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString("medium", queryParameter3);
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("gclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("term", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("content", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("aclid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("aclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("cp1");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("cp1", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("anid", queryParameter4);
                    }
                }
            } catch (UnsupportedOperationException e) {
                super.Pf().Re().m5439d("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    final long m5610u(Context context, String str) {
        super.OP();
        awa.bO(context);
        awa.df(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest eG = eG("MD5");
        if (eG == null) {
            super.Pf().Rc().log("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!m5595v(context, str)) {
                    PackageInfo packageInfo = bje.aQ(context).getPackageInfo(super.getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return ak(eG.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    super.Pf().Re().log("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                super.Pf().Rc().m5439d("Package name not found", e);
            }
        }
        return 0;
    }

    final Bundle m5611z(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object e = m5606e(str, bundle.get(str));
                if (e == null) {
                    super.Pf().Re().m5439d("Param value can't be null", super.Pa().eg(str));
                } else {
                    m5599a(bundle2, str, e);
                }
            }
        }
        return bundle2;
    }
}
