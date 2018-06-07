package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.fossil.awa;
import com.fossil.aye;
import com.fossil.ayq;
import com.fossil.azc;
import com.fossil.azf;
import com.fossil.azg;
import com.fossil.azh;
import com.fossil.azi;
import com.fossil.azj;
import com.fossil.azk;
import com.fossil.azl;
import com.fossil.azm;
import com.fossil.azn;
import com.fossil.azo;
import com.fossil.azp;
import com.fossil.azq;
import com.fossil.azr;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    private static Boolean bjR;
    private static azo bjS;
    private static azq bjT;
    private static String bjU;
    private static final ThreadLocal<C4249a> bjV = new ThreadLocal();
    private static final azm bjW = new azf();
    public static final C4251c bjX = new azg();
    private static C4251c bjY = new azh();
    public static final C4251c bjZ = new azi();
    public static final C4251c bka = new azj();
    public static final C4251c bkb = new azk();
    private final Context bkc;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    static class C4249a {
        public Cursor bkd;

        private C4249a() {
        }
    }

    static class C4250b implements azm {
        private final int bke;
        private final int bkf = 0;

        public C4250b(int i, int i2) {
            this.bke = i;
        }

        public final int m14217b(Context context, String str, boolean z) {
            return 0;
        }

        public final int m14218q(Context context, String str) {
            return this.bke;
        }
    }

    public interface C4251c {
        azn m14219a(Context context, String str, azm com_fossil_azm) throws zzc;
    }

    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }
    }

    private DynamiteModule(Context context) {
        this.bkc = (Context) awa.bO(context);
    }

    private static Context m14220a(Context context, String str, int i, Cursor cursor, azq com_fossil_azq) {
        try {
            return (Context) azc.a(com_fossil_azq.a(azc.bQ(context), str, i, azc.bQ(cursor)));
        } catch (Exception e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static DynamiteModule m14221a(Context context, C4251c c4251c, String str) throws zzc {
        C4249a c4249a = (C4249a) bjV.get();
        C4249a c4249a2 = new C4249a();
        bjV.set(c4249a2);
        azn a;
        DynamiteModule r;
        try {
            a = c4251c.m14219a(context, str, bjW);
            Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(a.bkg).append(" and remote module ").append(str).append(":").append(a.bkh).toString());
            if (a.bki == 0 || ((a.bki == -1 && a.bkg == 0) || (a.bki == 1 && a.bkh == 0))) {
                throw new zzc("No acceptable module found. Local version is " + a.bkg + " and remote version is " + a.bkh + ".");
            } else if (a.bki == -1) {
                r = m14230r(context, str);
                if (c4249a2.bkd != null) {
                    c4249a2.bkd.close();
                }
                bjV.set(c4249a);
                return r;
            } else if (a.bki == 1) {
                r = m14222a(context, str, a.bkh);
                if (c4249a2.bkd != null) {
                    c4249a2.bkd.close();
                }
                bjV.set(c4249a);
                return r;
            } else {
                throw new zzc("VersionPolicy returned invalid code:" + a.bki);
            }
        } catch (Throwable e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to load remote module: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            if (a.bkg == 0 || c4251c.m14219a(context, str, new C4250b(a.bkg, 0)).bki != -1) {
                throw new zzc("Remote load failed. No local fallback found.", e);
            }
            r = m14230r(context, str);
            if (c4249a2.bkd != null) {
                c4249a2.bkd.close();
            }
            bjV.set(c4249a);
            return r;
        } catch (Throwable th) {
            if (c4249a2.bkd != null) {
                c4249a2.bkd.close();
            }
            bjV.set(c4249a);
        }
    }

    private static DynamiteModule m14222a(Context context, String str, int i) throws zzc {
        synchronized (DynamiteModule.class) {
            Boolean bool = bjR;
        }
        if (bool != null) {
            return bool.booleanValue() ? m14227c(context, str, i) : m14225b(context, str, i);
        } else {
            throw new zzc("Failed to determine which loading route to use.");
        }
    }

    private static void m14223a(ClassLoader classLoader) throws zzc {
        Throwable e;
        try {
            azq com_fossil_azq;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                com_fossil_azq = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof azq) {
                    com_fossil_azq = (azq) queryLocalInterface;
                } else {
                    Object com_fossil_azr = new azr(iBinder);
                }
            }
            bjT = com_fossil_azq;
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new zzc("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new zzc("Failed to instantiate dynamite loader", e);
        }
    }

    private static azo aC(Context context) {
        synchronized (DynamiteModule.class) {
            azo com_fossil_azo;
            if (bjS != null) {
                com_fossil_azo = bjS;
                return com_fossil_azo;
            } else if (aye.LN().aj(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        com_fossil_azo = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        if (queryLocalInterface instanceof azo) {
                            com_fossil_azo = (azo) queryLocalInterface;
                        } else {
                            Object com_fossil_azp = new azp(iBinder);
                        }
                    }
                    if (com_fossil_azo != null) {
                        bjS = com_fossil_azo;
                        return com_fossil_azo;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    return null;
                }
            }
        }
    }

    public static int m14224b(Context context, String str, boolean z) {
        Object e;
        synchronized (DynamiteModule.class) {
            Boolean bool = bjR;
            if (bool == null) {
                try {
                    Class loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                    Field declaredField = loadClass.getDeclaredField("sClassLoader");
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    m14223a(classLoader);
                                } catch (zzc e2) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int d = m14228d(context, str, z);
                                if (bjU == null || bjU.isEmpty()) {
                                    return d;
                                }
                                ClassLoader com_fossil_azl = new azl(bjU, ClassLoader.getSystemClassLoader());
                                m14223a(com_fossil_azl);
                                declaredField.set(null, com_fossil_azl);
                                bjR = Boolean.TRUE;
                                return d;
                            } catch (zzc e3) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                                bjR = bool;
                                if (!bool.booleanValue()) {
                                    try {
                                    } catch (zzc e4) {
                                        String str2 = "DynamiteModule";
                                        String str3 = "Failed to retrieve remote module version: ";
                                        String valueOf = String.valueOf(e4.getMessage());
                                        Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                } catch (ClassNotFoundException e5) {
                    e = e5;
                } catch (IllegalAccessException e6) {
                    e = e6;
                } catch (NoSuchFieldException e7) {
                    e = e7;
                }
            }
        }
        valueOf = String.valueOf(e);
        Log.w("DynamiteModule", new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to load module via V2: ").append(valueOf).toString());
        bool = Boolean.FALSE;
        bjR = bool;
        return !bool.booleanValue() ? m14226c(context, str, z) : m14228d(context, str, z);
    }

    private static DynamiteModule m14225b(Context context, String str, int i) throws zzc {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        azo aC = aC(context);
        if (aC == null) {
            throw new zzc("Failed to create IDynamiteLoader.");
        }
        try {
            ayq a = aC.a(azc.bQ(context), str, i);
            if (azc.a(a) != null) {
                return new DynamiteModule((Context) azc.a(a));
            }
            throw new zzc("Failed to load remote module.");
        } catch (Throwable e) {
            throw new zzc("Failed to load remote module.", e);
        }
    }

    private static int m14226c(Context context, String str, boolean z) {
        azo aC = aC(context);
        if (aC == null) {
            return 0;
        }
        try {
            return aC.a(azc.bQ(context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    private static DynamiteModule m14227c(Context context, String str, int i) throws zzc {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            azq com_fossil_azq = bjT;
        }
        if (com_fossil_azq == null) {
            throw new zzc("DynamiteLoaderV2 was not cached.");
        }
        C4249a c4249a = (C4249a) bjV.get();
        if (c4249a == null || c4249a.bkd == null) {
            throw new zzc("No result cursor");
        }
        Context a = m14220a(context.getApplicationContext(), str, i, c4249a.bkd, com_fossil_azq);
        if (a != null) {
            return new DynamiteModule(a);
        }
        throw new zzc("Failed to get module context");
    }

    private static int m14228d(Context context, String str, boolean z) throws zzc {
        String str2;
        Throwable e;
        Cursor cursor;
        if (z) {
            try {
                str2 = "api_force_staging";
            } catch (Exception e2) {
                e = e2;
                cursor = null;
                try {
                    if (e instanceof zzc) {
                        throw e;
                    }
                    throw new zzc("V2 version check failed", e);
                } catch (Throwable th) {
                    e = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw e;
            }
        }
        str2 = "api";
        String valueOf = String.valueOf("content://com.google.android.gms.chimera/");
        cursor = context.getContentResolver().query(Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str2).length()) + String.valueOf(str).length()).append(valueOf).append(str2).append("/").append(str).toString()), null, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    int i = cursor.getInt(0);
                    if (i > 0) {
                        synchronized (DynamiteModule.class) {
                            bjU = cursor.getString(2);
                        }
                        C4249a c4249a = (C4249a) bjV.get();
                        if (c4249a != null && c4249a.bkd == null) {
                            c4249a.bkd = cursor;
                            cursor = null;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return i;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
        throw new zzc("Failed to connect to dynamite module ContentResolver.");
    }

    public static int m14229q(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    private static DynamiteModule m14230r(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    public final IBinder dm(String str) throws zzc {
        Throwable e;
        String str2;
        String valueOf;
        try {
            return (IBinder) this.bkc.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            throw new zzc(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (InstantiationException e3) {
            e = e3;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zzc(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        } catch (IllegalAccessException e4) {
            e = e4;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zzc(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
        }
    }
}
